/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaipt_server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author cmtie
 */
public class GiaiPT_server {

    /**
     * @param args the command line arguments
     */
    public GiaiPT_server() throws RemoteException{
        Registry registry= LocateRegistry.createRegistry(32);
        registry.rebind("rmiserver", (Remote) this);
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    public String giai_PT(int a, int b) throws RemoteException {
        String s = null;
        if( a == 0 ){
            if (b == 0) {
                s = "Phương trình này có vô số nghiệm.";
            } else {
                s = "Phương trình vô nghiệm.";
            } 
        }
        else{
            s = "Phương trình có nghiệm";
        }
        return s;
    }
    
}
