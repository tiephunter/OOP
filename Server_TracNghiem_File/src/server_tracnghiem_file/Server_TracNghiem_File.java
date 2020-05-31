/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_tracnghiem_file;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class Server_TracNghiem_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket myServer = new ServerSocket(1234);
            Socket clientSocket = myServer.accept();
            System.out.println("client was accepted");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Received mess from client ");
                String mess = in.readUTF();
                System.out.println(mess);
                System.out.println("Send back to client");
                String sendBack = sc.nextLine();
                out.writeUTF(sendBack);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        form f = new form();
        f.setVisible(true);
    }
    
}
