/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pkg1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class main {
    public static void main(String[] args) {
                ArrayList StudentList = new ArrayList();
        try {
            
            FileReader fr = new FileReader("Sinhvien.dat");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while((s=br.readLine())!=null){
                String[] a = s.split("\\$");
                Student st = new Student(a[0],a[1],a[2],a[3],a[4],a[5],Float.parseFloat(a[6]));
                StudentList.add(st);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
                    System.out.println(e);
        }
        
        jfromhienthi j1 = new jfromhienthi();
        j1.setVisible(true);
        j1.setData(StudentList);
    }                             
    }

