/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3at13;

import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Sinhvien {
    private String Hoten;
    private String Masv;
    private int diemhocphan;
    private int diemquatrinh;


    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getMasv() {
        return Masv;
    }

    public void setMasv(String Masv) {
        this.Masv = Masv;
    }

    public int getDiemhocphan() {
        return diemhocphan;
    }

    public void setDiemhocphan(int diemhocphan) {
        this.diemhocphan = diemhocphan;
    }

    public int getDiemquatrinh() {
        return diemquatrinh;
    }

    public void setDiemquatrinh(int diemquatrinh) {
        this.diemquatrinh = diemquatrinh;
    }

    public Sinhvien() {
    }

    public Sinhvien(String Hoten, String Masv, int diemhocphan, int diemquatrinh) {
        this.Hoten = Hoten;
        this.Masv = Masv;
        this.diemhocphan = diemhocphan;
        this.diemquatrinh = diemquatrinh;
    }
    public Float tinhdiemTB(){
        double tinhdiemTB = this.diemquatrinh *0.3 + this.diemhocphan*0.7;
        return null;
       }
    public void hienthithongtin(){
        System.out.println("ho ten"+this.Hoten);
        System.out.println("Ma sv"+this.Masv);
        System.out.println("Diem qua trinh"+this.diemquatrinh);
        System.out.println("Diem hoc phan" +this.diemhocphan);
    }
}
