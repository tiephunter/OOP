/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_bank_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_Bank_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DatagramSocket my_client= new DatagramSocket();
            System.out.println("open client Socket");
            InetAddress ip_address= InetAddress.getByName("localhost");
            //Xu ly
            Scanner sc = new Scanner(System.in);
            int chon = 0;
            while (chon != 5) {
                System.out.println("-------------MENU--------------");
                System.out.println("1. Chuyển tiền");
                System.out.println("2. Rút tiền");
                System.out.println("3. Xem số dư");
                System.out.println("4. Xem lịch sử giao dịch");
                System.out.println("5. Ket thuc");
                System.out.println("Moi ban chon");
                chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        System.out.print("Cộng thêm tiền vào tài khoản ");
                        int congTien = sc.nextInt();
                        String s = String.valueOf(1+"$"+congTien);
                        byte[] send_data= s.getBytes();
                        DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length,ip_address, 1234);
                        //send data to Server
                        my_client.send(packet_send);
                        break;
                    case 2:
                        System.out.print("Rút tiền từ tài khoản ");
                        int truTien = sc.nextInt();
                        String s1 = String.valueOf(2+"$"+truTien);
                        byte[] send_data1= s1.getBytes();
                        DatagramPacket packet_send1= new DatagramPacket(send_data1, send_data1.length,ip_address, 1234);
                        //send data to Server
                        my_client.send(packet_send1);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Ban da nhap sai cu phap");

                }
            }
//            System.out.println("Nhap so nguyen duong");
//            Scanner sc1 = new Scanner(System.in);
//            int chon = sc1.nextInt();
//            //int to String
//            String s= String.valueOf(chon);
//            //String to byte
//            byte[] send_data= s.getBytes();
//            DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length,ip_address, 1234);
//            //send data to Server
//            my_client.send(packet_send);
//
//            //Receiver data from Server
//            byte[] receive_data= new byte[1024];
//            DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
//            my_client.receive(receive_packet);
//            String receiver= new String(receive_packet.getData(),0, receive_packet.getLength());
//            System.out.println("client da nhan:"+ receiver);
//            //close socket
//            my_client.close();
        } catch (Exception e) {
        }
    }
    
}
