/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class DE3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList listNhanvien = new ArrayList();
        try {
            FileReader fr = new FileReader("nhanvien.dat");
            BufferedReader br = new BufferedReader(fr);
            String s = " ";
            while((s=br.readLine())!=null){
                String [] mangDL = s.split("\\$");
                NhanVien nv = new NhanVien(mangDL[0],mangDL[1],mangDL[2],mangDL[3],mangDL [4],Integer.parseInt(mangDL[5]),Integer.parseInt(mangDL[6]),
                        Float.parseFloat(mangDL[7]));
                listNhanvien.add(nv);
            }          
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        for (int i = 0; i < listNhanvien.size(); i++) {
           NhanVien nv = (NhanVien)listNhanvien.get(i);
           nv.hienthi();
         }
               
        formDE3 tb = new formDE3();
        tb.setVisible(true );
        tb.setData(listNhanvien);
 
    }
    
}
