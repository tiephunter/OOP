/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_client_bcnn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_client_bcnn {
    public static void main(String[] args) {
        try {
            DatagramSocket my_client = new DatagramSocket(3232);
            System.out.println("HELLO CLIENT");
            Scanner sc = new Scanner(System.in);
            int chon = 0;
            InetAddress ipAddress = InetAddress.getByName("Localhost");
            while (chon != 2) {
                System.out.println("========MENU==========");
                System.out.println("Chon 1. Hien thi thong tin sach");
                System.out.println("Chon 2. Muon sach");
                System.out.println("Moi ban chon: ");
                chon = sc.nextInt();
                //gui
                byte[] send = new byte[1024];
                send = String.valueOf(chon).getBytes();
                DatagramPacket send_packet = new DatagramPacket(send, send.length, ipAddress, 7);
                my_client.send(send_packet);
                switch (chon) {
                    case 1:
                        //nhan
                        byte[] receive = new byte[1024];
                        DatagramPacket receive_packet = new DatagramPacket(receive, receive.length);
                        my_client.receive(receive_packet);
                        String s = new String(receive_packet.getData(), receive_packet.getData().length).trim();
                        System.out.println("Thong tin ve sach: " );
                            System.out.println(s);
                        break;
                    case 2:
                        System.out.println("Moi ban nhap ten sach can tim: ");
                        String ten = sc.nextLine();
                        //gui ten
                        byte[] send1 = new byte[1024];
                        send1 = ten.getBytes();
                        DatagramPacket send_packet1 = new DatagramPacket(send1, send1.length, ipAddress, 7);
                        my_client.send(send_packet1);
                        //Nhan ten
                        byte[] receive1 = new byte[1024];
                        DatagramPacket receive_packet1 = new DatagramPacket(receive1, receive1.length);
                        my_client.receive(receive_packet1);
                        String s1 = new String(receive_packet1.getData(), receive_packet1.getData().length).trim();
                        System.out.println(s1);
                        //Nhap ten nguoi muon de luu vao thuoc tinh nguoi muon
                        if (s1.equals("sach nay khong co trong thu vien")) {
                            System.out.println("Moi ban nhap ten nguoi muon: ");
                            String nguoiMuon = sc.nextLine();
                            //gui nguoi muon
                            byte[] send2 = new byte[1024];
                            send2 = nguoiMuon.getBytes();
                            DatagramPacket send_packet2 = new DatagramPacket(send2, send2.length, ipAddress, 7);
                            my_client.send(send_packet2);
                        }
                        //nhan nguoi muon
                        byte[] receive2 = new byte[1024];
                        DatagramPacket receive_packet2 = new DatagramPacket(receive2, receive2.length);
                        my_client.receive(receive_packet2);
                        String s2 = new String(receive_packet2.getData(), receive_packet2.getData().length).trim();
                        System.out.println(s2);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Loi phia client");
        }
    }
    
}
