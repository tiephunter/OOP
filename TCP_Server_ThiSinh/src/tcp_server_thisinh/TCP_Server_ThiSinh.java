/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_thisinh;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_Server_ThiSinh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<ThiSinh> listTS = new ArrayList<ThiSinh>();
        //Read File
        try {
            FileReader fr = new FileReader("D:\\ThiSinh.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                ThiSinh ts = new ThiSinh(a[0],Integer.parseInt(a[1]),a[2],Integer.parseInt(a[3]),Integer.parseInt(a[4]),Integer.parseInt(a[5]),Integer.parseInt(a[6]) );
                listTS.add(ts);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }

        try {
            //Open Server
            ServerSocket Server = new ServerSocket(1234);
            System.out.println("Open server Socket");
            while (true) {
                Socket client_socket = Server.accept();
                System.out.println("Acepted ");
                DataInputStream dis = new DataInputStream(client_socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(client_socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                int chon = 0;
                String mess = "";
                while (chon != 4) {
                    chon = dis.readInt();
                    switch (chon) {
                        case 1:
                            mess = "";
                            String Hoten = "";
                            Hoten = dis.readUTF();
                            int count = 0;
                            for (ThiSinh TS2 : listTS) {
                                if (Hoten.equalsIgnoreCase(TS2.Hoten)) {
                                    mess += TS2.Hien_thi();
                                    count++;
                                }
                            }
                            if (count == 0) {
                                mess += "Khong ton tai thi Sinh ban muon tim kiem";
                            } 
                            dos.writeUTF(mess);
                            dos.flush();
                            break;
                        case 2:
                            mess = "";
                            int count1 = 0;
                            for (ThiSinh TS3 : listTS) {
                                if (TS3.Tinh_diem() >= 30 ) {
                                    mess += TS3.Hien_thi();
                                    count1++;
                                }
                            }
                            if (count1 == 0) {
                                mess += "Khong co thi sinh trung tuyen";
                            }
                            dos.writeUTF(mess);
                            dos.flush();
                            break;
                        case 3:
                            mess = "";
                            for (ThiSinh TS1 : listTS) {
                                mess += TS1.Hien_thi() + "\n";
                            }
                            dos.writeUTF(mess);
                            dos.flush();
                            break;
                        case 4:
                            System.out.println("Done");
                            break;
                        default:
                            System.out.println("Nhap sai cu phap ");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
}
