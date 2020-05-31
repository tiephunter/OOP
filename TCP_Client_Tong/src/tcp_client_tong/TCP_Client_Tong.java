/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_tong;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_Client_Tong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket mySocket = new Socket("localhost", 1233);
            DataInputStream in = new DataInputStream(mySocket.getInputStream());
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so a");
            int a = sc.nextInt();
            System.out.println("Nhap so b ");
            int b = sc.nextInt();
            out.writeInt(a);
            out.writeInt(b);
            String kq = in.readUTF();
            System.out.println("Ket qua la :"+kq);
            
            out.flush();
            
        } catch (Exception e) {
        }
    }
    
}
