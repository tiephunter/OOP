/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Lab51 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> Thongtin = new ArrayList();
        
        Person Thongtin1 = new Person();
        Teacher Thongtin2 = new Teacher();
        Student Thongtin3 = new Student();
        int chon;
        
        do{
            System.out.println("------MENU------");
            System.out.println("1: Nhap thong tin ");
            System.out.println("2: Xuat thong tin");
            System.out.println("Moi ban chon");
            chon = sc.nextInt();
            switch(chon){
                case 1:int m; 
                        int i;
                    System.out.println("So luong nhan vien muon nhap");
                    m = sc.nextInt();
                    for(i=0;i<m;i++){
                        
                        Thongtin1 = new Teacher();
                        Thongtin1.nhapthongtin();
                        Thongtin.add(Thongtin1);
                        
                    }
                break;
                case 2:
                    System.out.println("thong tin cua nguoi dung la:");
                    Thongtin1.xuatthongtin();
                    break;
                default :
                    System.out.println("Chuc nang nay chua được them vào. Xin moi nhap lai");
                    break;
                          
                    
            }
            
        }while(chon!=3);
        
    }
    
}
