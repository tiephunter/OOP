/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class RMI_client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry= LocateRegistry.getRegistry("localhost",464);
        Caculator_interface pp= ( Caculator_interface) registry.lookup("rmiserver");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào a và b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(true){
            System.out.println("-------------MENU---------------");
            System.out.println("1.Giải phương trình bậc nhất");
            System.out.println("2.Tính tổng 2 số");
            System.out.print("Mời bạn chọn");
            int c = sc.nextInt();
            switch(c){
                case 1:
                    System.out.println(""+pp.giai_pt(a, b));
                    break;
                case 2:
                    System.out.println(""+pp.Tong(a, b));
                    break;
                default:
                    System.exit(0);
            }    
        }
    }
    
}
