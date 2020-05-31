/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_client_luu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_CLient_Luu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //tao socket bang client
        DatagramSocket my_client= new DatagramSocket();
        InetAddress ip_address= InetAddress.getByName("localhost");
        System.out.println("Nhap so nguyen duong");
        Scanner sc1 = new Scanner(System.in);
        int chon = sc1.nextInt();
        //ép kiểu int sang String
        String s= String.valueOf(chon);
        byte[] send_data= s.getBytes();
        DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length,ip_address, 7);
        my_client.send(packet_send);

        //Nnhan ket qua tu server
        byte[] receive_data= new byte[1024];
        DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
        my_client.receive(receive_packet);
        String receiver= new String(receive_packet.getData(),0, receive_packet.getLength());
        System.out.println("client da nhan:"+ receiver);
        my_client.close();
    }
    
}
