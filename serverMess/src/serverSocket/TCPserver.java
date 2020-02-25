/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverSocket;

import java.net.Socket;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author cmtie
 */
public class TCPserver {
    
    
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Messenger;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";
    
    
     public static Connection getConnection(String dbURL, String userName, String password) throws Exception {
        System.out.println("getConnection");
        Connection conn = null;
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        System.out.println("connect successfully!");
        return conn;
    }
    /**
     * @param args the command line arguments
     */ 
    //cài đặt socket, serverSocket và luồng vào ra
    final static int SIGNUP_ACTION = 1;
    final static int LOGIN_ACTION = 2;
    
    private static Socket clientSocket = null;
    private static ServerSocket myServer = null;
    private static DataInputStream in = null;
    private static DataOutputStream out = null;
    
    //mo server Socket
    public static void openServer(){
        try{
            myServer = new ServerSocket(1234);
        }catch(IOException e ){
            System.err.println(e);
        }
    }

    //chap nhan ket noi va xu ly du lieu
    public static void listening(int port){

        //bắt đầu server và đợi kết nối
        try {
            System.out.println("Servet start!!!");
            System.out.println("waiting for client ...");
            clientSocket = myServer.accept();
            System.out.println("client be accepted !");

            //takes input from client socket
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            
            while (true) {
                //read messenge from client
                if(in.available() > 0) {
                    System.out.println("get a package");
                    int action = in.readInt();
                    switch(action){
                        case SIGNUP_ACTION:
                            System.out.println("go to singup action");
                            String TenTaiKhoan = in.readUTF();
                            String MatKhau = in.readUTF();
                            String HoTen = in.readUTF();
                            String NgaySinh = in.readUTF();
                            int GioiTinh = in.readInt();
                            String DiaChi = in.readUTF();
                            String QueQuan = in.readUTF();
                            String Email = in.readUTF();
                            System.out.println(TenTaiKhoan);
                            System.out.println(MatKhau);
                            System.out.println(HoTen);
                            System.out.println(NgaySinh);
                            System.out.println(GioiTinh);
                            System.out.println(DiaChi);
                            System.out.println(QueQuan);
                            System.out.println(Email);
                            break;
                    }
                }

            } 
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
            
            
            
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // connnect to database 'Messenger'
            System.out.println("3");

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            System.out.println("2");
            Statement stmt = conn.createStatement();
            
            System.out.println("2");

            // get data from table 'student'
            ResultSet rs = stmt.executeQuery("insert into User (HoTen,NgaySinh,GioiTinh,DiaChi,QueQuan,Email,TenTaiKhoan,MatKhau) "
                    + "values(N'HoTen',N'NgaySinh',GioiTinh,N'DiaChi',N'QueQuan',N'Email',N'TenTaiKhoan',N'MatKhau')");
            // show data
//            System.out.println("3");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
//                        + "  " + rs.getString(3)+rs.getInt(4));
//            }
            // close connection
            conn.close();
        } catch (Exception e) {
            System.out.println("aaassd");
            e.printStackTrace();
        }
        TCPserver.openServer();
        TCPserver.listening(1234);
    }
    
}
