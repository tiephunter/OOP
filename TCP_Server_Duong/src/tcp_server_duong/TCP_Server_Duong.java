/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_duong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cmtie
 */
public class TCP_Server_Duong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket myServer = new ServerSocket(2811);
            System.out.println("Da khoi tao server");
            while (true) {
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                int n = 0;
                int S=0;
                for (int i = 0; i < n; i++) {
                    S=S+i;
                    dos.writeUTF("tong tu 1 toi n =" + S);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO code application logic here
    }
    
}
