/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_thisinh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cmtie
 */
public class TCP_Client_ThiSinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket client_socket = new Socket("localhost", 1234);
            DataInputStream in = new DataInputStream(client_socket.getInputStream());
            DataOutputStream out = new DataOutputStream(client_socket.getOutputStream());
            //Xu ly
            Scanner sc = new Scanner(System.in);
            int chon = 0;
            String Result = "";
            while (chon != 4) {
                System.out.println("-------------MENU--------------");
                System.out.println("1. Tim kiem");
                System.out.println("2. Danh sach  nguoi trug tuyen");
                System.out.println("3. Hien thi danh sach sinh vien");
                System.out.println("4. Ket thuc !!!!!!");
                System.out.print("Moi ban chon");
                chon = sc.nextInt();
                switch (chon) {
                    case 1:
                        Result = "";
                        System.out.print("Nhap ten thi sinh can tim: ");
                        String ten = sc.nextLine();
                        out.writeUTF(ten);
                        out.flush();
                        Result = in.readUTF();
                        System.out.println(Result);
                        break;
                    case 2:
                        Result = "";
                        Result = in.readUTF();
                        System.out.println("Nguoi trung tuyen:");
                        System.out.println(Result);
                        break;

                    case 3:
                        Result = "";
                        Result = in.readUTF();
                        System.out.println("Danh sach :");
                        System.out.println(Result);
                        break;
                    case 4:
                        System.out.println("Bye");
                        break;
                    default:
                        System.out.println("Ban da nhap sai cu phap");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
