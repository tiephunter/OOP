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
    
    private static String TenTaiKhoan = null;
    private static String MatKhau = null;
    private static String HoTen = null;
    private static String NgaySinh = null;
    private static int GioiTinh ;
    private static String DiaChi = null;
    private static String QueQuan = null;
    private static String Email = null;
    private static Connection conn = null;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Messenger;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";
    
    
     public static void connectToDB(String dbURL, String userName, String password) {
        System.out.println("getConnection");
         try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
    /**
     * @param args the command line arguments
     */ 
    //cài đặt socket, serverSocket và luồng vào ra
    final static int SIGNUP_ACTION = 1;
    final static int LOGIN_ACTION = 2;
    final static int LOGIN_SUCCESS = 3;
    final static int LOGIN_FALSE = 4;
    
    private static Socket clientSocket = null;
    private static ServerSocket myServer = null;
    private static DataInputStream in = null;
    private static DataOutputStream out = null;
    
    //mo server Socket
    public static void openServer(){
        try{
            myServer = new ServerSocket(1233);
        }catch(IOException e ){
            System.err.println(e);
        }
    }
    public static boolean testEmty(){
        if(TenTaiKhoan.equals("")||MatKhau.equals("")||HoTen.equals("")||NgaySinh.equals("")||DiaChi.equals("")||QueQuan.equals("")||Email.equals("")){
            return true;       
        }
        return false; 
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
                    System.out.println("Got a package");
                    
                    int action = in.readInt();
                    
                    switch(action){
                        case SIGNUP_ACTION:
                            System.out.println("go to singup action");
                            TenTaiKhoan = in.readUTF();
                            MatKhau = in.readUTF();
                            HoTen = in.readUTF();
                            NgaySinh = in.readUTF();
                            GioiTinh = in.readInt();
                            DiaChi = in.readUTF();
                            QueQuan = in.readUTF();
                            Email = in.readUTF();
                            System.out.println(TenTaiKhoan);
                            System.out.println(MatKhau);
                            System.out.println(HoTen);
                            System.out.println(NgaySinh);
                            System.out.println(GioiTinh);
                            System.out.println(DiaChi);
                            System.out.println(QueQuan);
                            System.out.println(Email);
                            // crate statement
                            if(testEmty()==true){
                                out.writeUTF("Bạn chưa điền đầy đủ thông tin");
                                out.flush();
                                return;
                            }
                            else{
                            Statement stmt = conn.createStatement();
                            // insert data to table
                            stmt.execute("INSERT INTO Users(HoTen,NgaySinh,GioiTinh,DiaChi,QueQuan,Email,TenTaiKhoan,MatKhau)"
                                + " values(N'"+HoTen+"',N'"+NgaySinh+"',"+GioiTinh+",N'"+DiaChi+"',N'"+QueQuan+"',N'"+Email+"',N'"+TenTaiKhoan+"',N'"+MatKhau+"')");
//                            ResultSet rs1 = stmt.executeQuery("Select * from User");
//                            System.out.println(rs1.getRow());
                            out.writeUTF("Đăng kí thành công");
                            out.flush();  
                            }
                            break;
                        case LOGIN_ACTION:
                            TenTaiKhoan = in.readUTF();
                            MatKhau = in.readUTF();
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery("select *\n" +
                                                            "from Users\n"
                                                            + "where TenTaiKhoan = N'"+TenTaiKhoan+"' and MatKhau = N'"+MatKhau+"'");
                                if (rs.next()) {
                                System.out.println(rs.getString(1) + "  " + rs.getString(2)+ "  "+rs.getString(3)+ "  "+rs.getInt(4)+ "  " +rs.getString(5)+ "  "+rs.getString(6)+ "  "+rs.getString(7)+ "  "+rs.getString(8)+ "  "+rs.getString(9));
                                out.writeInt(LOGIN_SUCCESS);
                                out.writeInt(rs.getInt(1));
                                out.writeUTF(rs.getString(2));
                                out.writeUTF(rs.getString(3));
                                out.writeInt(rs.getInt(4));
                                out.writeUTF(rs.getString(5));
                                out.writeUTF(rs.getString(6));
                                out.writeUTF(rs.getString(7));
                                out.writeUTF(rs.getString(8));
                                out.writeUTF(rs.getString(9));
                                
                                out.flush();
                                }
                            
                            else {
                                System.out.println("kkkldsak");
                                    System.out.println("outtttttttttttttttttttttttttttttttttttttttt");
                                out.writeInt(LOGIN_FALSE);
                                out.flush();
                            }
                            
                            
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
        TCPserver.connectToDB(DB_URL, USER_NAME, PASSWORD);
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "  " + rs.getString(2) 
//                        + "  " + rs.getString(3)+rs.getInt(4));
//            }
//         
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
        
        TCPserver.openServer();
        TCPserver.listening(1234);
    }
    
}
