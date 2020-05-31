import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class BaiTap_LapTrinhMang_1_Client {

    public static void main(String[] args) {
        try {
            DatagramSocket socketClient = new DatagramSocket();
            System.out.println("Connected to server");
            System.out.println("-----------MENU---------");
            System.out.println("Nhập 1 :Tìm kiếm 1 người ");
            System.out.println("Nhập 2 : Tìm kiếm tất cả");
            System.out.println("-------------------------");
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            int chon = sc.nextInt();
            String ten = null;
            switch (chon){
                case 1:
                    System.out.println("Nhập tên người cần kiếm");
                     ten = sc1.nextLine();
                    break;
                case 2:
                    System.out.println("Tìm kiếm tất cả");
                    ten = "ten" ;
                    break;
            }
            //khai bao mang byte để chứa dữ liệu gửi đi server
            byte[] outData1 = new byte[1024];
            byte[] outData2 = new byte[1024];
            //Chuyển dữ liêu từ kiểu int sang String
            String s1 = String.valueOf(chon);
            //Chuyen từ String sang byte và đưa vào mảng byte đã khai báo ở trên
            outData1 = s1.getBytes();
            outData2 = ten.getBytes();
            //dia chi may chu
            InetAddress ipAddress = InetAddress.getByName("localhost");
            //so cong server
            int port = 123;
            int length1 = outData1.length;
            int length2 = outData2.length;
            //Tạo gói để gửi đi
            DatagramPacket packet1 = new DatagramPacket(outData1,length1, ipAddress, port);
            DatagramPacket packet2 = new DatagramPacket(outData2, length2, ipAddress, port);
            //gửi dữ liệu qua Socket
            socketClient.send(packet1);
            socketClient.send(packet2);
            //Tạo mảng byte để đọc dữ liệu
            byte[] data_byte = new byte[1024];
            //gói để lấy dữ liệu
            DatagramPacket received_Data = new DatagramPacket(data_byte, data_byte.length);
            //Client Nhận data
            socketClient.receive(received_Data);
            //Lấy String
            String data = new String(received_Data.getData(), 0,received_Data.getLength()).trim();
            System.out.println(data);
            socketClient.close();
        }
        catch (IOException e1){
            System.out.println(e1);
        }

    }
}

