/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_thui;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author cmtie
 */
public class UDP_server_thui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DatagramSocket my_server= new DatagramSocket(8);
            //
            byte[] receiver_data1= new byte[1024];
            DatagramPacket receive_packet1= new DatagramPacket(receiver_data1, receiver_data1.length);
            my_server.receive(receive_packet1);
            String s= new String(receive_packet1.getData(),0, receive_packet1.getLength()).trim();
            //
            byte[] receiver_data2= new byte[1024];
            DatagramPacket receive_packet2= new DatagramPacket(receiver_data2, receiver_data2.length);
            my_server.receive(receive_packet2);
            String s1= new String(receive_packet2.getData(),0, receive_packet2.getLength()).trim();
            //
            byte[] receiver_data3= new byte[1024];
            DatagramPacket receive_packet3= new DatagramPacket(receiver_data3, receiver_data3.length);
            my_server.receive(receive_packet2);
            String s2= new String(receive_packet3.getData(),0, receive_packet3.getLength()).trim();
            
            int a= Integer.parseInt(s);
            int b= Integer.parseInt(s1);
            int c= Integer.parseInt(s2);
            String kq="";
            int rs =0;
            if(c==2){
                rs = a+b;
                kq = "Hiá»‡u 2 sá»‘ báº±ng"+rs;
            }
            else if(c==3){
                rs = a-b;
                kq ="Tá»•ng 2 sá»‘ báº±ng"+rs;
            }

            byte[] b1= new byte[1024];
            b1=kq.getBytes();
            DatagramPacket send_packet= new DatagramPacket(b1, b1.length, receive_packet1.getAddress(), receive_packet1.getPort());
            my_server.send(send_packet);
            my_server.close();
        }
        catch(IOException i){
            i.printStackTrace();
        }
    }
    
}
