/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.so;

/**
 *
 * @author admin
 */
public class Nhanvien extends Person{
    private String Manv;
    private Float HSL;
    private String Donvi;

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public Float getHSL() {
        return HSL;
    }

    public void setHSL(Float HSL) {
        this.HSL = HSL;
    }

    public String getDonvi() {
        return Donvi;
    }

    public void setDonvi(String Donvi) {
        this.Donvi = Donvi;
    }

    
    public Nhanvien() {
    }

    public Nhanvien(String Manv, Float HSL, String Donvi) {
        this.Manv = Manv;
        this.HSL = HSL;
        this.Donvi = Donvi;
    }

    public Nhanvien( String Hoten, String Ngaysinh, String Diachi, String Gioitinh,String Manv, Float HSL, String Donvi) {
        super(Hoten, Ngaysinh, Diachi, Gioitinh);
        this.Manv = Manv;
        this.HSL = HSL;
        this.Donvi = Donvi;
    }
    
    public void hienthithongtin(){
        super.hienthithongtin();
        System.out.println("Ma nhan vien "+this.Manv);
        System.out.println("He so luong "+this.HSL);
        System.out.println("Don vi"+this.Donvi);
        System.out.println("-----------------");
    }
    
}
