/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_server_bcnn;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_server_bcnn {

    public static void main(String[] args) {
        ArrayList<Sach> listDS = new ArrayList<Sach>();
        //DOC FILE
        try {
            FileReader fr = new FileReader("D:\\Sach.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            while (s != null) {
                String a[] = s.split("\\$");
                Sach sach = new Sach(a[0], a[1], a[2]);
                listDS.add(sach);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.err.println("Loi doc file");
        }

        try {
            DatagramSocket my_server = new DatagramSocket(7);

            Scanner sc = new Scanner(System.in);
            byte[] receive = new byte[1024];
                DatagramPacket receive_packet = new DatagramPacket(receive, receive.length);
                my_server.receive(receive_packet);
                String s = new String(receive_packet.getData(), 0, receive_packet.getData().length).trim();
                int k = Integer.parseInt(s);
            String mess = "";
            while (k != 2) {
                switch (k) {
                    case 1:
                        for (Sach listSach : listDS) {
                            mess += listSach.hienThi() + "\n";
                            byte[] send = new byte[1024];
                            send = mess.getBytes();
                            DatagramPacket send_packet = new DatagramPacket(send, send.length, receive_packet.getAddress(), receive_packet.getPort());
                            my_server.send(send_packet);
                            System.out.println(mess);
                        }   
                        
                        break;
                    case 2:
                        int dem = 0;
                        byte[] receive2 = new byte[1024];
                        DatagramPacket receive_packet2 = new DatagramPacket(receive2, receive2.length);
                        my_server.receive(receive_packet2);
                        String s2 = new String(receive_packet2.getData(), 0, receive_packet2.getData().length).trim();
                        for (Sach listSach : listDS) {
                            if (s2.equals(listSach.tenSach)) {
                                mess += listSach.hienThi() + "\n";
                                dem++;
                            }
                        }
                        if (dem == 0) {
                            mess += "sach nay khong co trong thu vien";
                        }
                        //gui
                        byte[] send1 = new byte[1024];
                        send1 = mess.getBytes();
                        DatagramPacket send_packet1 = new DatagramPacket(send1, send1.length, receive_packet.getAddress(), receive_packet.getPort());
                        my_server.send(send_packet1);
                        //nhan
                        int dem1 = 0;
                        byte[] receive3 = new byte[1024];
                        DatagramPacket receive_packet3 = new DatagramPacket(receive3, receive3.length);
                        my_server.receive(receive_packet3);
                        String s3 = new String(receive_packet3.getData(), 0, receive_packet3.getData().length).trim();
                        for (Sach listSach : listDS) {
                            if (listSach.nguoiMuon.equals("chua muon") && listSach.tenSach.equals(s3)) {
                                listSach.nguoiMuon = s3;
                                mess += listSach.hienThi() + "\n";
                                dem1++;
                            }
                        }
                        if (dem1 == 0) {
                            mess += "Sach nay da co nguoi muon";
                        }
                        byte[] send2 = new byte[1024];
                        send2 = mess.getBytes();
                        DatagramPacket send_packet2 = new DatagramPacket(send2, send2.length, receive_packet.getAddress(), receive_packet.getPort());
                        my_server.send(send_packet2);
                        break;
                }
            }

        } catch (IOException e) {
            System.err.println("Loi server");
        }
    }
}
