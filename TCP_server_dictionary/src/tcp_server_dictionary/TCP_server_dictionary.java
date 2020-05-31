/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_dictionary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cmtie
 */
public class TCP_server_dictionary {

    /**
     * @param args the command line arguments
     */
    final static int ENG_VIE =1;
    final static int VIE_ENG=2;

    private static Connection conn = null;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Dictionary;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";
    public static DataOutputStream out ;
    public static DataInputStream in;

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
    
    public static void eng_vie() throws SQLException, IOException{
        String word = in.readUTF();
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                System.out.println("word :"+word);
                ResultSet rs = st.executeQuery("select Dic.english, Dic.viet  from Dic where english = N'"+ word +"'");

                if(rs.next()){
                    out.writeUTF(rs.getString(1));
                    out.writeUTF(rs.getString(2));
                    out.flush();
                }   
                else{
                    System.out.println("ko có dữ liệu");
                }
        
    }
    
    public static void viet_eng() throws IOException, SQLException {
        String word = in.readUTF();
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                System.out.println("word :"+word);
                ResultSet rs = st.executeQuery("select Dic.english, Dic.viet  from Dic where viet = N'"+ word +"'");

                if(rs.next()){
                    out.writeUTF(rs.getString(2));
                    out.writeUTF(rs.getString(1));
                    out.flush();
                }   
                else{
                    System.out.println("ko có dữ liệu");
                }
    }
    public static void main(String[] args) {
        try {
            //xử lí conect to db
            connectToDB(DB_URL, USER_NAME, PASSWORD);
            //create server socket và client Socket
            ServerSocket serverSocket = new ServerSocket(1234);
            //accept client
            Socket clientSocket = serverSocket.accept();
            System.out.println("client be accepted !");
            //declare input output
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            //handel data from client
            while (true) {               
                if (in.available()>0) {
                    System.out.println("got packet");
                    int choose = in.readInt();
                    System.out.println("action"+choose);
                    switch(choose){
                        case ENG_VIE: eng_vie();
                            break;
                        case VIE_ENG: viet_eng();
                            break;
                    }
                    
                }
            }
            

            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lỗi socket");
        }
    }
    
}
