/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_bank_server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

/**
 *
 * @author cmtie
 */
public class UDP_Bank_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Account> lichSuGiaoDich = new ArrayList<Account>();
        //Read File
        int a0 =0;
        try {
            FileReader fr = new FileReader("D:\\Account.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                Account acc = new Account(Integer.parseInt(a[0]),a[1]);
                a0 = Integer.parseInt(a[0]);
                lichSuGiaoDich.add(acc);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
        try {
            DatagramSocket my_server= new DatagramSocket(1234);
            System.out.println("Open serverSocket ");
            //receiver Data
            while(true){
                int chon =0;
                byte[] receive_data= new byte[1024];
                DatagramPacket receive_packet= new DatagramPacket(receive_data, receive_data.length);
                my_server.receive(receive_packet);
                //read data from client
                String s = new String(receive_packet.getData(), 0, receive_packet.getLength());
                String[] b = s.split("\\$");
                System.out.println("b[0] = "+b[0]+"b[1] = "+b[1]);
                chon = Integer.parseInt(b[0]);
                Integer b1 = Integer.parseInt(b[1]);
                do {
                    switch(chon){
                        case 1:
                            try {
                                FileWriter fw = new FileWriter("D:\\Account.txt");
                                BufferedWriter bw = new BufferedWriter(fw);
                                int tien = b1 + a0;
                                Account acc1 = new Account(tien, "Vua cong them "+b1);
                                bw.append(acc1.getTien()+"$"+acc1.getGiaoDich());
                                bw.newLine();
                                bw.close();
                                fw.close();
                                break;
                            } catch (Exception e) {
                            }
                        case 2:
                            try {
                                FileWriter fw = new FileWriter("D:\\Account.txt");
                                BufferedWriter bw = new BufferedWriter(fw);
                                int tien = a0 - b1;
                                if (tien<0) {
                                    bw.close();
                                    fw.close();
                                }else{
                                    Account acc1 = new Account(tien, "tru them "+b1);
                                    bw.append(acc1.getTien()+"$"+acc1.getGiaoDich());
                                    bw.newLine();
                                    bw.close();
                                    fw.close();
                                }
                                break;
                            } catch (Exception e) {
                            }
                        
                    }
                    
                } while (chon!=5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
