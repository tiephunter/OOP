/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tcp_client.nhl;

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
public class Test_TCP_clientNHL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        //Tao socket de ket noi voi server
        Socket Client_socket = new Socket("localhost", 1024);
        System.out.println("Ket noi thanh cong");
        //Tao luong du lieu nhap tu nguoi dung
        int a,b;
        String kq;
        //Tao luon du lieu nhan ve tu server
        DataInputStream recive_data = new DataInputStream(Client_socket.getInputStream());
        //Tao luon du lieu gui di server
        DataOutputStream send_data = new DataOutputStream(Client_socket.getOutputStream());
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap so a:");
            a = sc.nextInt();
            send_data.writeInt(a);
            System.out.println("Nhap so b:");
            b = sc.nextInt();
            send_data.writeInt(b);
            
        }catch(UnknownHostException e)
        {
            System.err.println("Loi"
                    + "");
            System.exit(1);
        }catch(IOException e)
        {
            System.err.println("Cannot make a connection");
            System.exit(1);
        }
        //Nhan du lieu ve tu server
        kq = recive_data.readUTF();
        //in ket qua
        System.out.println("Nghiem cua phuong trinh la:"+kq);
    }
    
}
