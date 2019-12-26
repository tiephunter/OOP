/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class JavaApplication18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n;
        int m;
        ArrayList svKhoiAlist= new ArrayList();
        ArrayList svKhoiClist = new ArrayList();
        int chon = 0;
        do{
            System.out.println("---------Nhap danh sach sinh vien-----------------");
            System.out.println("1:       Nhap Sinh Vien khoi A                    ");
            System.out.println("2:       Nhap Sinh Vien khoi C                    ");
            System.out.println("3:      Hien thi Danh Sach Sinh vien Trung tuyen  ");
            System.out.println("4.              Ket thuc                          ");
            chon=sc.nextInt();
            switch(chon){
                case 1:
                    System.out.println("So luong sinh vien khoi A can nhap la ");
                    n = sc.nextInt();
                    for(int i = 0; i < n; i++) {
                        ThisinhKhoiA svKhoiA = new ThisinhKhoiA();
                        System.out.println("Nhap thong tin sinh vien khoi A"+(i+1));
                        svKhoiA.NhapthongtinsinhvienkhoiA();
                        svKhoiAlist.add(svKhoiA);
                    };                                         
                    break;
                case 2:
                    System.out.println("So luong sinh vien khoi C can nhap la ");
                    m = sc.nextInt();
                    for(int i = 0; i < m; i++) 
                        {
                        ThisinhKhoiC svKhoiC = new ThisinhKhoiC();
                        System.out.println("Nhap thong tin sinh vien khoi C"+(i+1));
                        svKhoiC.NhapthongtinsinhvienkhoiC();
                        svKhoiAlist.add(svKhoiC);
                        };
                    break;
                case 3: 
                    
                    break;
            }
            
            
        }while(chon!=4);
    }
    
}
