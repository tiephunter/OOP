/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_linh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author cmtie
 */
public class Server_Linh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(1000);
        System.out.println("Server cho o cong 1000");
        Socket client = server.accept();
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        String inLine = in.readLine();
        int index = 0;
        if (inLine.equals("tinhtinh")) {
            out.writeBytes("Login Success");
        } else {
            out.writeBytes("Login again!");
            index++;
            if (index==2) {
                out.writeBytes("Login failed!");
            }
        }
        out.write(13);
        out.write(10);
        in.close();
        out.close();
        client.close();
        server.close();
    }
}
