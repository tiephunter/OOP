/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_client_tonghieu;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_client_tonghieu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DatagramSocket socketClient = new DatagramSocket(111);
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập số a ");
            int a = sc.nextInt();
            System.out.println("Nhập số b ");
            int b = sc.nextInt();
            System.out.println("Tính tổng hoặc hiệu của 2 số: 1 là tổng, 2 là hiệu");
            int c = sc.nextInt();
            System.out.println("c = "+c);
            //khai bao mang byte để chứa dữ liệu gửi đi server
            byte[] outData1 = new byte[1024];
            byte[] outData2 = new byte[1024];
            byte[] outData3 = new byte[1024];
            //Chuyển dữ liêu từ kiểu int sang String 
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            String s3 = String.valueOf(c);
            //Chuyen từ String sang byte và đưa vào mảng byte đã khai báo ở trên
            outData1 = s1.getBytes();
            outData2 = s2.getBytes();
            outData3 = s3.getBytes();
            //dia chi may chu
            InetAddress ipAddress = InetAddress.getByName("localhost");
            //so cong server
            int port = 123;
            //độ dài data
            int length1 = outData1.length;
            int length2 = outData2.length;
            int length3 = outData3.length;
            //Tạo gói để gửi đi
            DatagramPacket packet1 = new DatagramPacket(outData1,length1, ipAddress, port);
            DatagramPacket packet2 = new DatagramPacket(outData2, length2, ipAddress, port);
            DatagramPacket packet3 = new DatagramPacket(outData3, length3, ipAddress, port);
            //gửi dữ liệu qua Socket
            socketClient.send(packet1);
            socketClient.send(packet2);
            socketClient.send(packet3);
            System.out.println(c);
            
            //Tạo mảng byte để đ�?c dữ liệu
            byte[] data_byte = new byte[1024];
            //gói để lấy dữ liệu
            DatagramPacket received_Data = new DatagramPacket(data_byte, data_byte.length);
            //Client Nhận data
            socketClient.receive(received_Data);
            //Lấy String
            String data = new String(received_Data.getData(), 0,received_Data.getLength()).trim();
            System.out.println(data);
            socketClient.close();
        } catch (Exception e) {
        }
    }
    
}
