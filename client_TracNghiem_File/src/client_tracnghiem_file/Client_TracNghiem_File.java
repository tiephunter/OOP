/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_tracnghiem_file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class Client_TracNghiem_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket mySocket = new Socket("localhost", 1234);
            DataInputStream in = new DataInputStream(mySocket.getInputStream());
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {                
                System.out.println("Bat dau chat vs Server");
                String mess = sc.nextLine();
                out.writeUTF(mess);
                out.flush();
                String messServer = in.readUTF();
                System.out.println("Respone from Server");
                System.out.println(messServer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

