/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ThiSinh {
    protected String Hoten;
    protected String Ngaysinh;
    protected String Diachi;
    Scanner sc = new Scanner(System.in);

    public ThiSinh() {
    }
    

    public ThiSinh(String Hoten, String Ngaysinh, String Diachi) {
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Diachi = Diachi;
    }
    public void Nhapthongtin(){
        System.out.println("Nhap ho ten thi sinh :");
        this.Hoten= sc.nextLine();
        System.out.println("Nhap ngay sinh cua thi sinh :");
        this.Ngaysinh= sc.nextLine();
        System.out.println("Nhap dia chi thi sinh :");
        this.Diachi=sc.nextLine();
    }
    public void Xuatthongtin(){
        System.out.println("Ho ten :"+this.Hoten);
        System.out.println("Ngay Sinh :"+this.Ngaysinh);
        System.out.println("Dia chi :"+this.Diachi);
    }
}
