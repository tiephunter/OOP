/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_tong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author cmtie
 */
public class TCP_Server_Tong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket myServer = new ServerSocket(1233); 
            Socket clientSocket = myServer.accept();
            System.out.println("client be accepted !");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                if (in.available() > 0) {
                    int a = in.readInt();
                   
                    System.out.println(a);
                    int b = in.readInt();
                    System.out.println(b);
                    double kq;
                    if (a == 0) {
                    if (b == 0) {  
                        out.writeUTF("Phuowng trinh vo so nghiem");
                        out.flush();
                    } else {
                        out.writeUTF("Phường trình vô nghiệm");
                        out.flush();
                    }
                    } else {
                        kq = (double) -b / a;  
                        out.writeUTF("PHương trình có nghiệm x  ="+kq);
                        System.out.println(kq);
                        out.flush();
                    }
                    
                   
                }
            }
            
        }
            catch (Exception e) {
            e.printStackTrace();
    }
    }
    
}
