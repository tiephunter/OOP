/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_file;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author cmtie
 */
public class Server_File {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
            int point=0;
            ServerSocket server= new ServerSocket(7);
            Socket socket= server.accept();
            DataInputStream dis= new DataInputStream(socket.getInputStream());    
            DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
            String request = dis.readUTF();
        while(true){
           FileReader fr= new FileReader(new File("D:\\trac_nghiem_toan.txt"));
           BufferedReader br= new BufferedReader(fr);  
           String s= br.readLine();
           String[] a= s.split("\\$");
           System.out.println("hello"+ a[0]);
           dos.writeUTF(a[0]);
           System.out.println("server da gui "+ a[0]);
           if(dis.readUTF().equals(a[1])){
               point++;
            }   
            dos.writeInt(point);
            dos.close();
            dis.close(); 
        }
        
    }
    
}
