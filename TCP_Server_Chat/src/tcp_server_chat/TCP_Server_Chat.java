/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_Server_Chat {

    /**
     * @param args the command line arguments
     */
    private static ServerSocket myServer = null;

    public static void openServer() {
        try {
            myServer = new ServerSocket(1233);
            System.out.println("Mở server");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void startServer() {
        try {
            while (true) {
                HandleConnection();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void HandleConnection() {
        try {
            Socket clientSocket = myServer.accept();
            System.out.println("client be accepted !");
            HandleClientThread clientthread = new HandleClientThread(clientSocket);
            clientthread.start();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        openServer();
        startServer();
    }
}

class HandleClientThread extends Thread {

    final static int TIEP_TUC = 1;
    final static int KET_THUC = 2;

    Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;

    public HandleClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public  void sendToClient() {
        try {
            String messFromClient = in.readUTF();
            System.out.println("client"+messFromClient);
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Server :");
            String messToClient = sc.nextLine();
            if (messToClient.equalsIgnoreCase("bye")) {
                out.writeInt(KET_THUC);
                out.flush();
            } else {
                out.writeInt(TIEP_TUC);
                out.writeUTF(messToClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ket_Thuc() {
        try {
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                if (in.available() > 0) {
                    int action = in.readInt();
                    switch (action) {
                        case TIEP_TUC:
                            sendToClient();
                            break;
                        case KET_THUC:
                            ket_Thuc();
                            break;
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
