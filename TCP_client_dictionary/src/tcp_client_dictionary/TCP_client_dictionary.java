/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client_dictionary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class TCP_client_dictionary {

    /**
     * @param args the command line arguments
     */
    final static int ENG_VIE =1;
    final static int VIE_ENG=2;

    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket mySocket = new Socket("localhost", 1234);
            //handle in out
            DataInputStream in = new DataInputStream(mySocket.getInputStream());
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            Scanner sc1 = new Scanner(System.in);
              Scanner sc = new Scanner(System.in);
            //Select word in dictionary
            while (true) {     
              System.out.println("-----Dictionary------");
              System.out.println("1, Eng-Vie");
              System.out.println("2, Vie-Eng");
              System.out.println("Mời bạn chọn !");
              int choose = sc1.nextInt();
              System.out.println("Từ cần kiếm :");
              String a = sc.nextLine();
              out.writeInt(choose);
              out.writeUTF(a);
              out.flush();
              String eng = in.readUTF();
              String viet = in.readUTF();
              System.out.println("Từ "+eng+" có nghĩa là "+viet);      
            }
  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
