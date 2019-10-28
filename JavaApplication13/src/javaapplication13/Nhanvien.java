/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author admin
 */
public final class Nhanvien extends Person{
    private String phongban;
    private float hsl;
    private int thamnien;
    private float luongcoban;

    public String getPhongban() {
        return phongban;
    }

    public void setPhongban(String phongban) {
        this.phongban = phongban;
    }

    public float getHsl() {
        return hsl;
    }

    public void setHsl(float hsl) {
        this.hsl = hsl;
    }

    public int getThamnien() {
        return thamnien;
    }

    public void setThamnien(int thamnien) {
        this.thamnien = thamnien;
    }

    public float getLuongcoban() {
        return luongcoban;
    }

    public void setLuongcoban(float luongcoban) {
        this.luongcoban = luongcoban;
    }
    

    public Nhanvien(String Hoten, String ngaysinh, String diachi, String gioitinh, String phongban, float hsl, int thamnien, float luongcoban) {
        super(Hoten, ngaysinh, diachi, gioitinh);
        this.setPhongban(phongban);
        this.setHsl(hsl);
        this.setThamnien(thamnien);
        this.setPhongban(phongban);
    }
    public void hienthithongtinnv(){
        super.hienthithongtin();
        System.out.println("Phongban"+this.getPhongban());
        System.out.println("Hệ số lương "+this.getHsl());
        System.out.println("Thâm niên"+this.getThamnien());
        System.out.println("Lương cơ bản "+this.getLuongcoban());
        
    }
    public float luongthuclinh(){
        return this.luongcoban *this.getHsl()*(1+this.getThamnien()/100)
                ;
    }
    
    
}
