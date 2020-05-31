/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_flie;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_server_flie {

    /**
     * @param args the command line arguments
     */
    static int TIEP_TUC = 1;
    static int KET_THUC = 2;

    private static ServerSocket myServer = null;

    public static void openServer() {
        try {
            myServer = new ServerSocket(7);
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

    public void sendToClient() {
        try {
            ArrayList QuestionList = new ArrayList();
            FileReader fr = new FileReader("D:\\trac_nghiem_toan.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            int point =0;
            while ((s = br.readLine())!= null) {
                String[] a = s.split("\\$");
                System.out.println("Question " + a[0]);
                System.out.println("answer " + a[1]);
                Question Question = new Question(a[0], a[1]);
                QuestionList.add(Question);
            }
            br.close();
            fr.close();
            for (int i = 0; i < QuestionList.size(); i++) {
                Question qs = (Question)QuestionList.get(i);
                System.out.println("Question 1"+qs.getQuestion());
                out.writeInt(TIEP_TUC);
                out.writeUTF(qs.getQuestion());
                out.flush();
               String answer = in.readUTF();
                System.out.println("answer from client" + answer);
                if (answer.equalsIgnoreCase(qs.getAnswer())) {
                    point++;
                    out.writeUTF("dap an dung");
                    out.flush();
                } else {
                    out.writeUTF("Dap an sai");
                    out.flush();
                }
            }
            out.writeInt(KET_THUC);
            out.writeInt(point);
            out.flush();
            
            
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
