/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE3;

/**
 *
 * @author cmtie
 */
public class NhanVien extends Person{
    private String PhongBan;
    private float HSL;
    private int thamnien;
    private int LuongCB;
    
    public NhanVien(String Hoten, String NgaySinh, String GioiTinh, String PhongBan, float HSL, int thamnien, int LuongCB) {
        super(Hoten, NgaySinh, GioiTinh);
        this.PhongBan = PhongBan;
        this.HSL = HSL;
        this.thamnien = thamnien;
        this.LuongCB = LuongCB;
    }

    public String getPhongBan() {
        return PhongBan;
    }

    public void setPhongBan(String PhongBan) {
        this.PhongBan = PhongBan;
    }

    public float getHSL() {
        return HSL;
    }

    public void setHSL(float HSL) {
        this.HSL = HSL;
    }

    public int getThamnien() {
        return thamnien;
    }

    public void setThamnien(int thamnien) {
        this.thamnien = thamnien;
    }

    public int getLuongCB() {
        return LuongCB;
    }

    public void setLuongCB(int LuongCB) {
        this.LuongCB = LuongCB;
    }
    
    public void hienthi(){
        this.Hienthi();
        System.out.println("PHONG BAN"+this.PhongBan);
        System.out.println("HSL"+this.HSL);
        System.out.println("Tham nien"+this.thamnien);
        System.out.println("LUong Cb"+this.LuongCB);
    }
    public float LUONGTHuclinh(){
        return this.LuongCB*this.HSL*(1+this.thamnien/100);
    }
    
    
}
