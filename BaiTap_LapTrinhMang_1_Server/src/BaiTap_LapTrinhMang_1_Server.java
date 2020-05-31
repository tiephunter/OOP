import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class BaiTap_LapTrinhMang_1_Server {
    private static Connection conn = null;
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Person;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "sa";

    public static void connectToDB(String dbURL, String userName, String password) {
        System.out.println("Start Connect to SQL");
        try {
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            connectToDB(DB_URL,USER_NAME,PASSWORD);
            //create Socket Server
            DatagramSocket socketServer = new DatagramSocket(123);
            //Declare mang byte để nhận dữ liệu đến
            byte[] byte_Received1 = new byte[1024];
            byte[] byte_Received2 = new byte[1024];
            //Tạo gói để lấy dữ liệu ra
            DatagramPacket packet_Received1 = new DatagramPacket(byte_Received1, byte_Received1.length);
            DatagramPacket packet_Received2 = new DatagramPacket(byte_Received2, byte_Received2.length);
            //Nhận gói về Server
            socketServer.receive(packet_Received1);
            socketServer.receive(packet_Received2);
            //create variable type String take data
            String data1 = new String(packet_Received1.getData(), 0, packet_Received1.getLength()).trim();
            String data2 = new String(packet_Received2.getData(), 0, packet_Received2.getLength()).trim();
            //change frome String to int
            int a = Integer.parseInt(data1);
            if(a==1){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select *\n"
                        + "from Users\n"
                        +"where HoTen = N'"+data2+"'");
                //tạo mang byte để chứa dư liệu gửi đi
                byte[] data_Byte = new byte[1024];
                //Chuyển dữ liệu từ String sang byte và gán vào mảng byte
                data_Byte = rs.getString(2).getBytes();
                //dia chi client
                DatagramPacket data_Packet = new DatagramPacket(data_Byte, data_Byte.length, packet_Received1.getAddress(), packet_Received1.getPort());
                //gửi dữ liệu
                socketServer.send(data_Packet);
                socketServer.close();


            }
            else if (a==2){
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select *\n"
                                            + "from Users\n");
                //tạo mang byte để chứa dư liệu gửi đi
                byte[] data_Byte = new byte[1024];
                //Chuyển dữ liệu từ String sang byte và gán vào mảng byte
                data_Byte = rs.getString(2).getBytes();
                //dia chi client
                DatagramPacket data_Packet = new DatagramPacket(data_Byte, data_Byte.length, packet_Received1.getAddress(), packet_Received1.getPort());
                //gửi dữ liệu
                socketServer.send(data_Packet);
                socketServer.close();
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
