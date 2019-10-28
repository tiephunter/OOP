/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList listNhanvien = new ArrayList();
        try {
             FileReader fw = new FileReader("nhanvien.dat");
             BufferedReader br = new BufferedReader(fw);
             String s = " ";
             while((s=br.readLine())!=null){
                 String[] mangDL= s.split("\\$");
                 Nhanvien nv;
                 nv = new Nhanvien(mangDL[0],mangDL[1],mangDL[2],mangDL[3],mangDL[4],Float.parseFloat(mangDL[5]),Integer.parseInt(mangDL[6]),Float.parseFloat(mangDL[7]));
                 listNhanvien.add(nv);
             }
             br.close();
             fw.close();
        } catch (Exception e) {
        }
        for(int i=0;i<listNhanvien.size();i++){
            Nhanvien nv = (Nhanvien)listNhanvien.get(i);
            nv.hienthithongtinnv();
    }
    
}
}
