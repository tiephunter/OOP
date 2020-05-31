/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import static tcp_client_chat.TCP_Client_Chat.KET_THUC;
import static tcp_client_chat.TCP_Client_Chat.TIEP_TUC;
import static tcp_client_chat.TCP_Client_Chat.in;
import static tcp_client_chat.TCP_Client_Chat.ket_Thuc;
import static tcp_client_chat.TCP_Client_Chat.sendToServer;

/**
 *
 * @author cmtie
 */
public class TCP_Client_Chat {

    /**
     * @param args the command line arguments
     */
    final static int TIEP_TUC = 1;
    final static int KET_THUC = 2;
    private static String mess = null;
    private static String messServer = null;
    public static Socket mySocket = null;
    public static DataInputStream in = null;
    public static DataOutputStream out = null;
        public static void sendToServer(){
        try {
            System.out.println("Client: ");
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Client :");
            String mess1 = sc.nextLine();
            if (mess1.equalsIgnoreCase("bye")) {
                out.writeInt(KET_THUC);
                out.writeUTF(mess);
                out.flush();
            }
            else{
                out.writeInt(TIEP_TUC);
                out.writeUTF(mess);
                out.flush();
            }
            
        } catch (Exception e) {
        }
    }
       public static void ket_Thuc() {
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connection() {
        try {
            mySocket = new Socket("localhost", 1233);
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
            ThreadHandleInput threadHandleInput = new ThreadHandleInput(in);
            threadHandleInput.start();
            System.out.println("Connected !!!");

        } catch (UnknownHostException e) {
            System.err.println(e + "Lỗi ko tìm được server");
        } catch (IOException e) {
            System.err.println(e + "Ngoại lệ socket");
        }
    }
    public static void main(String[] args) throws EOFException {
        // TODO code application logic here
        try {
            connection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Bzat dau chat");
            while(true){
                System.out.println("Client: ");
                out.writeInt(TIEP_TUC);
                mess = sc.nextLine();
                out.writeUTF(mess);
                out.flush();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
class ThreadHandleInput extends Thread {
    DataInputStream in;
    DataOutputStream out;
    public ThreadHandleInput(DataInputStream in) {
        this.in = in;
    }
    public void run(){
        try {
            while (true) {                
                  if (in.available()>0) {
                    int action = in.readInt();
                    switch(action){
                        case TIEP_TUC:
                            sendToServer();
                            break;
                        case KET_THUC:
                            ket_Thuc();
                            break;     
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
