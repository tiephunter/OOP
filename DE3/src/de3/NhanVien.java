/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3;

/**
 *
 * @author admin
 */
public class NhanVien extends Person{
    private String Phongban;
    private int HSL;
    private int thamnien;
    private Float LuongCB;



    public String getPhongban() {
        return Phongban;
    }

    public void setPhongban(String Phongban) {
        this.Phongban = Phongban;
    }

    public int getHSL() {
        return HSL;
    }

    public void setHSL(int HSL) {
        this.HSL = HSL;
    }

    public int getThamnien() {
        return thamnien;
    }

    public void setThamnien(int thamnien) {
        this.thamnien = thamnien;
    }

    public float getLuongCB() {
        return LuongCB;
    }

    public void setLuongCB(Float LuongCB) {
        this.LuongCB = LuongCB;
    }
    
    

    public NhanVien(String HoTen, String DiaChi, String NgaySinh, String Gioitinh, String Phongban, int HSL,int thamnien, Float LuongCB ) {
        super(HoTen, DiaChi, NgaySinh, Gioitinh);
        this.setPhongban(Phongban);
        this.setHSL(HSL);
        this.setThamnien(thamnien);
        this.setLuongCB(LuongCB);
       
    
    }
    public Float LuongThucLinh(){
        return this.getLuongCB()*this.getHSL()*(1+this.getThamnien()/100);
    }
    public void hienthi(){
        super.Hienthi();
        System.out.println("Phong ban la"+this.getPhongban());
        System.out.println("He So Luong"+this.getHSL());
        System.out.println("Tham nien"+this.getThamnien());
        System.out.println("Luong CB"+this.getLuongCB());
        System.out.println("----------------");
        
        
        
    }
}
