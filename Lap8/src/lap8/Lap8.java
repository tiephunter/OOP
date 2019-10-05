/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Lab8 {

    /**
     * @param args the command line arguments
     * 
     */
        ArrayList<Dulieu> Thongtin = new ArrayList();
        ThuocTinh Thongtin1 = new ThuocTinh();
        Sach Thongtin2 = new Sach();
        TapChi Thongtin3 = new TapChi();
        Bao Thongtin4 = new Bao();
        Scanner sc = new Scanner(System.in);
    public void QuanLySach (){
            int chon=0;
     
        do{
        System.out.println("------MENU-------");
        System.out.println("1: Nhap thong tin cac tai lieu.");
        System.out.println("2 : Hien thi thong tin cac tai lieu");
        System.out.println("3 :Tim kiem tai lieu theo loai");
        System.out.println("Moi ban chon");
            
           
        switch(chon)
                {
            case 1: System.out.println("Nhap Thong tin ");
                Thongtin.add(Thongtin2);
                Thongtin.add(Thongtin3);
                Thongtin.add(Thongtin4);
                Thongtin1.nhapthongtin();
                Thongtin2.nhapthongtinsach();
                Thongtin3.nhapthongtintapchi();
                Thongtin4.nhapthongtinbao();
                break;
            case 2: 
                System.out.println("Hien thong tin Tai Lieu");
                Thongtin1.xuatthongtin();
                Thongtin2.xuatthongtinsach();
                Thongtin3.xuatthongtintapchi();
                Thongtin4.xuatthongtinbao();
                break;
                
                
            case 3:
        }
        
        
        }while(chon!=4);
               
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Lab7 check = new Lab7(); 
        check.QuanLySach();
    }
    
}
