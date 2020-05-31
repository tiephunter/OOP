/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_client_thui;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class UDP_client_thui {

    
    public static void nhap(){
        try {
            
         DatagramSocket my_cliet= new DatagramSocket(323);
            System.out.println("Nhap a=  ");
        int a = new Scanner(System.in).nextInt();
           String s1=a+" ";
        System.out.println("Nhap b=  ");
        int b = new Scanner(System.in).nextInt();
          
                    byte[] send_data1= new byte[1024];
                    send_data1= s1.getBytes();
                    InetAddress ipaddress= InetAddress.getByName("localhost");
                    DatagramPacket send_packet1= new DatagramPacket(send_data1, send_data1.length, ipaddress, 8);
                    
                    String s2= b+"";
                    byte[] send_data2= s2.getBytes();
                    DatagramPacket send_packet2= new DatagramPacket(send_data2, send_data2.length, ipaddress, 8);
                    my_cliet.send(send_packet1);
                    my_cliet.send(send_packet2);
        } catch (IOException e) {
            e.printStackTrace();
}
        
}
    public void menu() {
        int chon=0, bien=0;
        char x;
        int soluong=0;
        do {            
            System.out.println("Chon 1. Nhap vao hai so");
            System.out.println("Chon 2. Tinh hieu hai so");
            System.out.println("Chon 3. Tinh tong hai so");
            System.out.println("Moi ban chon: ");
            chon= new Scanner(System.in).nextInt();
            switch(chon){
                case 1:
                    nhap();
                    break;
                case 2: break;
                case 3: break;
                    
            }
        } while (true);
            
    
    }
    public static void main(String[] args) {
        
    
    try{
            UDP_client_thui k= new UDP_client_thui();
            k.menu();     
            
            byte[] receive_data= new byte[1024];         
            DatagramPacket reveive_packet= new DatagramPacket(receive_data, receive_data.length);
            my_cliet.receive(reveive_packet);
            String a1= new String(reveive_packet.getData(), reveive_packet.getData().length);
            System.out.println("client nhan duoc: "+ a1);
            my_cliet.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
