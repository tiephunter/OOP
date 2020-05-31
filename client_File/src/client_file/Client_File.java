/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class Client_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws UnknownHostException, IOException{
        // TODO code application logic here
        Socket my_client = new Socket("localhost", 7);
        DataOutputStream dos= new DataOutputStream(my_client.getOutputStream());
        DataInputStream dis= new DataInputStream(my_client.getInputStream());
        //Nhap yeu cau
        System.out.println("----------MENU---------");
        System.out.println("Press 'S' if you wanna take a test");
        System.out.println("Press 'T' if you wanna finish");
        System.out.println("-----------------------------");
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();
        dos.writeUTF(request);
        //
        System.out.println("hello");
        System.out.println(dis.readUTF());
        System.out.println("hay nhap dap an:");
        dos.writeUTF(sc.nextLine());
        System.out.println("TOng so cau tra loi dung: "+dis.readInt());

    }
    
}
