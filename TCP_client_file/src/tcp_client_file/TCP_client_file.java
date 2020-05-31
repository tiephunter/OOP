/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_client_file {

    /**
     * @param args the command line arguments
     */
    static int TIEP_TUC = 1;
    static int KET_THUC = 2;
    public static void main(String[] args) {
//        // TODO code application logic here
//        Socket my_client = new Socket("localhost", 7);
//        DataOutputStream dos= new DataOutputStream(my_client.getOutputStream());
//       
//        System.out.println("hello");
//        DataInputStream dis= new DataInputStream(my_client.getInputStream());
//        System.out.println(dis.readUTF());
//        System.out.println("hay nhap dap an:");
//        Scanner sc= new Scanner(System.in);
//        dos.writeUTF(sc.nextLine());
//        System.out.println("TOng so cau tra loi dung: "+dis.readInt());
//        dos.close();
//        dis.close();
        //create Socket 
        try {
            Socket mySocket = new Socket("localhost", 7);
            DataInputStream in = new DataInputStream(mySocket.getInputStream());
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            //create menu
            System.out.println("------------menu--------");
                System.out.println("1. Lam kiem tra");
                System.out.println("2. ket thuc");
                System.out.println("Moi chon");
                Scanner sc = new Scanner(System.in);
                Scanner sc1 = new Scanner(System.in);
                int chon = sc.nextInt();
                out.writeInt(chon);
                out.flush();
            while (true) {                
                
                //receiver notice from server
                int action = in.readInt();
                if(action == TIEP_TUC){
                    String question = in.readUTF();
                    System.out.println(question);
                    System.out.println("Moi ban nhap dap an");
                    String answer = sc1.nextLine();
                    out.writeUTF(answer);
                    out.flush();
                    //result from server
                    String result = in.readUTF();
                    System.out.println(result);
                }
                else{
                    System.out.println("Co "+in.readInt()+"dap an dung");
                    in.close();
                    out.close();
                }
            
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
