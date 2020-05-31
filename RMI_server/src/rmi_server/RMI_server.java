/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author cmtie
 */

public class RMI_server extends UnicastRemoteObject implements Caculator_interface {

    public RMI_server() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(464);
        registry.bind("rmiserver", this);
    }

    public String giai_pt(int a, int b) {

        if (a == 0 && b == 0) {
            return "Phương trình có vô số nghiệm";
        } else if (a == 0 && b != 0) {
            return "Phương trình vô nghiệm";
        } else {
            float x = (float) -b / a;
            return "Có nghiệm x = " + (float) x;
            
        }
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMI_server s = new RMI_server();
    }

    @Override
    public String Tong(int a, int b) throws RemoteException {
        return "Tổng = "+(int)(a+b);
    }

}
