/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author cmtie
 */
public class UDP_Server_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
   
        DatagramSocket my_server= new DatagramSocket(7);
        String kq= null;
        byte[] receive_data= new byte[1024];
        DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
        my_server.receive(receive_packet);
        String s= new String(receive_packet.getData(), 0, receive_packet.getLength());
        String[] s_cut= s.split(" ");
        if(s_cut[0].equals("1")){
            FileReader fr= new FileReader(new File("D:\\Person.txt"));
            BufferedReader br= new BufferedReader(fr);
            String b= br.readLine();
            int check=0;
            while(b!=null){
                String[] k= b.split(" ");
                if(k[0].equals(s_cut[1])){
                    kq=b;
                    check =1;
                    break;
                }
                b= br.readLine();
                
            }
            if(check==0){
                kq="khong ton tai trong co so du lieu";
            }
            br.close();
        }
        else{
            kq="doc toan bo du lieu";
        }
        byte[] send_data= kq.getBytes();
        DatagramPacket packet_send= new DatagramPacket(send_data, send_data.length, receive_packet.getAddress(), receive_packet.getPort());
        my_server.send(packet_send);
    }
    
}
