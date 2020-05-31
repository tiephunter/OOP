/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_tracnghiem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cmtie
 */
public class TCP_server_tracNghiem {

    /**
     * @param args the command line arguments
     */
    final static int BAT_DAU =1;
    final static int KET_THUC =3;
    final static int NHAP_SAI_CU_PHAP =3;
    public static String answerCorrect =null;
    private static Connection conn = null;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Quiz;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";

    public static void connectToDB(String dbURL, String userName, String password) {
        System.out.println("Start Connect to SQL");
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception e) {
            System.out.println("Lỗi kết nối db");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            connectToDB(DB_URL, USER_NAME, PASSWORD);
            ServerSocket myServer = new ServerSocket(1234);
            Socket clientSocket = myServer.accept();
            System.out.println("client was accepted");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            while(true){
                String choose = in.readUTF();
                String s1 = "S";
                String s2 = "T";
                int kq =0;
                if(choose.equalsIgnoreCase(s1)){
                    for (int i = 1; i < 5; i++) {
                        System.out.println("select question from server");
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("select * from Question where id = "+i);
                        out.writeInt(BAT_DAU);
                        if(rs.next()){
                            answerCorrect = rs.getString(7);
                            System.out.println(answerCorrect);
                            out.writeUTF("Câu hỏi thứ "+i);
                            out.writeUTF(rs.getString(2));
                            out.writeUTF(rs.getString(3));
                            out.writeUTF(rs.getString(4));
                            out.writeUTF(rs.getString(5));
                            out.writeUTF(rs.getString(6));
                            out.flush();
                        }
                        //received answer from client 
                        String answer = in.readUTF();
                        System.out.println("answer"+answer);
                        System.out.println("answerCorrect"+answerCorrect);
                        if(answer.equalsIgnoreCase(answerCorrect)){
                            kq++;
                            out.writeUTF("Đáp án đúng");
                            out.flush();
                        }
                        else if(answer.equalsIgnoreCase(s2)){
                            out.writeUTF("Bạn trả lời được "+kq+" đáp án đúng");
                            out.flush();
                            clientSocket.close();
                        }
                        else{
                            out.writeUTF("Đáp án sai");
                            out.flush();
                       }
                        
                    }              
                }
                else if(choose.equalsIgnoreCase(s2)){
                    out.writeInt(KET_THUC);
                    out.flush();
                    in.close();
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
