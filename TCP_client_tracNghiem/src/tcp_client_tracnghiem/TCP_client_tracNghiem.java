/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_tracnghiem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_client_tracNghiem {

    /**
     * @param args the command line arguments
     */
    final static int BAT_DAU =1;
    final static int KET_THUC =2;
    final static int NHAP_SAI_CU_PHAP =3;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            Socket mySocket = new Socket("localhost", 1234);
            DataInputStream in = new DataInputStream(mySocket.getInputStream());
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            //Declare Scanner
            Scanner sc = new Scanner(System.in);
            System.out.println("----------MENU---------");
            System.out.println("Press 'S' if you wanna take a test");
            System.out.println("Press 'T' if you wanna finish");
            System.out.println("-----------------------------");
            String choose = sc.nextLine();
            out.writeUTF(choose);
            out.flush();
            //Menu
            while(true){          
                //client received data
                int noti = in.readInt();
                if(noti == BAT_DAU){
                    String id = in.readUTF();
                    String question = in.readUTF();
                    String answerA = in.readUTF();
                    String answerB = in.readUTF();
                    String answerC = in.readUTF();
                    String answerD = in.readUTF();
                    System.out.println(id);
                    System.out.println(question);
                    System.out.println(answerA);
                    System.out.println(answerB);
                    System.out.println(answerC);
                    System.out.println(answerD);
                    //client enter answer
                    System.out.println("Enter from the keyboard your answer");
                    // client received from server
                    String answer = sc.nextLine();
                    out.writeUTF(answer);
                    out.flush();
                    // answer from server
                    String result = in.readUTF();
                    System.out.println(result);
                }
                else {
                    in.close();
                    out.close();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi này");
        }
    }
    
}
