/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import jdk.nashorn.internal.ir.CatchNode;
import jdk.nashorn.internal.ir.TryNode;

/**
 *
 * @author cmtie
 */
public class main {
    public static void main(String[] args) {
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        try {
            
            FileReader fr = new FileReader("D:\\nhanvien.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s=br.readLine())!=null) {                
                String[] a = s.split("\\$");
                NhanVien nv = new NhanVien(a[0], a[1], a[2], a[3], Float.parseFloat(a[4]), Integer.parseInt(a[5]),  Integer.parseInt(a[6]));
                listNV.add(nv);
            }
            
            br.close();
            fr.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (NhanVien nv : listNV) {
            nv.hienthi();
        }
        form3 f = new form3();
        f.setVisible(true);
        f.Setdata(listNV);
       
    }
}
