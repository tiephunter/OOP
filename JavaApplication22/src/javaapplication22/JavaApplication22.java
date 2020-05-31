/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication22;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class JavaApplication22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        DatagramSocket my_client= new DatagramSocket(8);
        InetAddress ip_address= InetAddress.getByName("localhost");
        System.out.println("1. tim kiem "+ "\n"+"2. hien thi danh sach person");
        Scanner sc= new Scanner(System.in);
        int chon= Integer.parseInt(sc.nextLine());
        switch(chon){
            case 1:{
                System.out.println("nhap ho ten:");
                String ht= sc.nextLine();
                String s= chon+" "+ht;
                byte[] send_data= s.getBytes();
                DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length,ip_address, 7);
                my_client.send(packet_send);
                break;
            }
            case 2:{
                String s= chon+" ";
                byte[] send_data= s.getBytes();
                DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length,ip_address, 7);
                my_client.send(packet_send);
                break;
            }
        }
        byte[] receive_data= new byte[1024];
        DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
        my_client.receive(receive_packet);
        String s= new String(receive_packet.getData(),0, receive_packet.getLength());
        System.out.println("client da nhan:"+ s);
        my_client.close();
        // TODO code application logic here
    }
    
}
