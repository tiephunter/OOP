/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopperson;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Student extends Person {
    Student(){super();}
    private String masv;
    private String email;
    private Float DiemTK;


    public Student(String masv, String email, Float DiemTK) {
        this.masv = masv;
        this.email = email;
        this.DiemTK = DiemTK;
    }

    public Student(String hovaten, String ngaysinh, String diachi, String gioitinh,Float DiemTK, String masv, String email) {
        super(hovaten, ngaysinh, diachi, gioitinh);
        this.masv = masv;
        this.email = email;
        this.DiemTK = DiemTK;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(Float DiemTK) {
        this.DiemTK = DiemTK;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public Scanner getSc1() {
        return sc1;
    }

    public void setSc1(Scanner sc1) {
        this.sc1 = sc1;
    }


public void nhapthongtinsinhvien(){;
    this.nhapthongtin();
    System.out.println("Nhap ma sinh vien");
    this.masv = sc.nextLine();
    System.out.println("Nhap email ");
    this.email = sc.nextLine();
    System.out.println("Nhap diem tong ket");
    this.DiemTK = sc.nextFloat();
}
public void xuatthongtinsinhvien(){
    this.xuatthongtin();
    System.out.println("Ma cua sinh vien"+masv+"\nEmail :"+email+"\nDiem tong ket:"+DiemTK);
}


    
}
