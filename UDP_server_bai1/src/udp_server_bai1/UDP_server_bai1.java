/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_bai1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;

/**
 *
 * @author cmtie
 */
public class UDP_server_bai1 {

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
            //Tạo gói để lấy dữ liệu ra
            DatagramPacket packet_Received1 = new DatagramPacket(byte_Received1, byte_Received1.length);
            DatagramPacket packet_Received2 = new DatagramPacket(byte_Received2, byte_Received2.length);
            //Nhận gói về Server
            socketServer.receive(packet_Received1);
            socketServer.receive(packet_Received2);
            //create variable type String take data
            String data1 = new String(packet_Received1.getData(), 0, packet_Received1.getLength()).trim();
            String data2 = new String(packet_Received2.getData(), 0, packet_Received2.getLength()).trim();
            //change frome String to int 
            int a = Integer.parseInt(data1);
            int b = Integer.parseInt(data2);
            String kq="";
            if(a==0){
                if(b==0){
                    kq="phuong trinh co vo so nghiem";
                }
                else{
                    kq="phuong trinh vo nghiem"; 
                }
                   
            }
            else{
                kq="phuong trinh co nghiem duy nhat:"+((float)-a/(float)b);
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
