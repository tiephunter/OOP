/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_luu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author cmtie
 */
public class UDP_Server_Luu {

    /**
     * @param args the command line arguments
     */
    public static int TinhTong(int a){
        int total = 0;
        for (int i = 0; i <= a; i++) {
            total = total +i;
        }
        return total;
    }
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        //Tao socket
        DatagramSocket my_server= new DatagramSocket(7);
        byte[] receive_data= new byte[1024];
        //tao goi de nhan du lieu
        DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
        my_server.receive(receive_packet);
        String s= new String(receive_packet.getData(), 0, receive_packet.getLength());
        Integer a = Integer.parseInt(s);
        //xu ly tinh tong
        int b = TinhTong(a);
        //gui ket qua den client
        String kq = String.valueOf(b);
        byte[] send_data= kq.getBytes();
        // dong goi du lieu
        DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length, receive_packet.getAddress(), receive_packet.getPort());
        my_server.send(packet_send);
        my_server.close();
    }
    
}
