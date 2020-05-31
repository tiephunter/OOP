/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author cmtie
 */
public interface Caculator_interface extends Remote{
    public String giai_pt(int a,int b) throws RemoteException;
    public String Tong(int a, int b) throws RemoteException;
}
