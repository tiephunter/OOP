/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_linh;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author cmtie
 */
public class Client_Linh {

    private static DataInputStream in;
    private static DataOutputStream out;
    private static BufferedReader buf;
    private static Socket client;
    public static void loginForm() throws IOException {
        in = new DataInputStream(client.getInputStream());
        out = new DataOutputStream(client.getOutputStream());
        buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Account: ");
        String account = buf.readLine();
        System.out.println("Password: ");
        String password = buf.readLine();
        String data = account + password;
        out.writeBytes(data);
        out.write(13);
        out.write(10);
    }

    public static void main(String args[]) throws Exception
    {
        client = new Socket("127.0.0.1",1000);
        System.out.println("Ket noi toi Server cong 1000.");
        loginForm();
        String inLine = in.readLine();
        if (inLine.equals("Login Success") || inLine.equals("Login failed!")) {
            System.out.println("Messes: " + inLine);
            in.close();
            out.close();
            client.close();
        } else {
            System.out.println("Messes: " + inLine);
            loginForm();
        }
    }

    
}
