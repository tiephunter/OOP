/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_diem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

/**
 *
 * @author cmtie
 */
public class UDP_Server_Diem {

    /**
     * @param args the command line arguments
     */
    public static int ToTal(int a){
        int total = 0;
        for (int i = 0; i <= a; i++) {
            total = total +i;
        }
        return total;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //create Socket
            DatagramSocket my_server= new DatagramSocket(1234);
            System.out.println("Open serverSocket ");
            //receiver Data
            byte[] receive_data= new byte[1024];
            DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
            my_server.receive(receive_packet);
            //read data from client
            String s= new String(receive_packet.getData(), 0, receive_packet.getLength());
            Integer a = Integer.parseInt(s);
            //Handel data from
            int b = ToTal(a);
            //send kq to client
            String kq = String.valueOf(b);
            byte[] send_data= kq.getBytes();
            DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length, receive_packet.getAddress(), receive_packet.getPort());
            my_server.send(packet_send);
            //close server Socket
            my_server.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
