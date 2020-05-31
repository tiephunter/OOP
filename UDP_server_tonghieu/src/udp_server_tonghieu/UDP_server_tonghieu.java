/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_tonghieu;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author cmtie
 */
public class UDP_server_tonghieu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //create Socket Server
            DatagramSocket socketServer = new DatagramSocket(123);
            //Declare mang byte để nhận dữ liệu đến 
            byte[] byte_Received1 = new byte[1024];
            byte[] byte_Received2 = new byte[1024];
            byte[] byte_Received3 = new byte[1024];
            //Tạo gói để lấy dữ liệu ra
            DatagramPacket packet_Received1 = new DatagramPacket(byte_Received1, byte_Received1.length);
            DatagramPacket packet_Received2 = new DatagramPacket(byte_Received2, byte_Received2.length);
            DatagramPacket packet_Received3 = new DatagramPacket(byte_Received3, byte_Received3.length);
            //Nhận gói v�? Server
            socketServer.receive(packet_Received1);
            socketServer.receive(packet_Received2);
            socketServer.receive(packet_Received3);
            //create variable type String take data
            String data1 = new String(packet_Received1.getData(), 0, packet_Received1.getLength()).trim();
            String data2 = new String(packet_Received2.getData(), 0, packet_Received2.getLength()).trim();
            String data3 = new String(packet_Received3.getData(), 0, packet_Received3.getLength());
            //change frome String to int 
            int a = Integer.parseInt(data1);
            int b = Integer.parseInt(data2);
            int c = Integer.parseInt(data3);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            String kq="";
            int rs =0;
            if(c==1){
                rs = a+b;
                kq ="Tổng 2 số bằng "+rs;
            }
            else if(c==2){
                rs = a-b;
                kq ="Hiệu 2 số bằng "+rs;
            }

            
            //tạo mang byte để chứa dư liệu gửi đi
            byte[] data_Byte = new byte[1024];
            //Chuyển dữ liệu từ String sang byte và gán vào mảng byte
            data_Byte = kq.getBytes();
            //dia chi client 
            DatagramPacket data_Packet = new DatagramPacket(data_Byte, data_Byte.length, packet_Received1.getAddress(), packet_Received1.getPort());
            //gửi dữ liệu
            socketServer.send(data_Packet);
            socketServer.close();
         
        } catch (Exception e) {
        }
    }
    
}
