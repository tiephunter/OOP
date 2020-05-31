/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tcp_server.nhl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author cmtie
 */
public class Test_TCP_serverNHL {

    /**
     * @param args the command line arguments
     * 
     */
    public static String giaiPT(int a, int b){
        double nghiem = 0;
        System.out.println("PhÆ°Æ¡ng trÃ¬nh báº¡n vá»«a nháº­p vÃ o lÃ : " + a + "x + " + b + " = 0.");
        if (a == 0) {
            if (b == 0) {
                return "PhÆ°Æ¡ng trÃ¬nh nÃ y cÃ³ vÃ´ sá»‘ nghiá»‡m.";
            } else {
                return "PhÆ°Æ¡ng trÃ¬nh vÃ´ nghiá»‡m.";
            }
        } else {
            nghiem = (double) -b / a;
            return "PhÆ°Æ¡ng trÃ¬nh cÃ³ nghiá»‡m x = " + nghiem;
        }
    }    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            int so1,so2;
            String so3;
      
        // tao server socket
        ServerSocket server = new ServerSocket(1024);
        System.out.println("Server san sang");
        //tao 1 socket do ket noi tu client toi server
        Socket connectionSocket = server.accept();
        //tao luong nhan du lieu tu client
        DataInputStream recive_client = new DataInputStream(connectionSocket.getInputStream());
        // tao luong gui du lieu toi client
        DataOutputStream send_client = new DataOutputStream(connectionSocket.getOutputStream());
        // truyen du lieu tu client vao 2 bien so1 va so2
        so1 = recive_client.readInt();
        so2 = recive_client.readInt();

        so3 = giaiPT(so1, so2);;
        //gui so3 ve client
        send_client.writeUTF(so3+'\n');
        send_client.flush();
        //dong luong nhan du lieu tu client
        recive_client.close();
        //dong luong gui du lieu ve client
        send_client.close();
        //dong server socket
        server.close();
        } catch (Exception e) {
        }
    }
    
}
