/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE7;

import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class Thisinhc1 extends ThiSinh{
    private float van;
    private float su;
    private float dia;

    public Thisinhc1() {
    }

    public Thisinhc1(String Hoten, String NgaySinh, String DiaChi, float van, float su, float dia) {
        super(Hoten, NgaySinh, DiaChi);
        this.van=van;
        this.su = su;
        this.dia = dia;
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getSu() {
        return su;
    }

    public void setSu(float su) {
        this.su = su;
    }

    public float getDia() {
        return dia;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    
    public void NhapThiSinhA(){
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin();
        System.out.println("diem van");
        this.setVan(sc.nextFloat());
        System.out.println("diem su");
        this.setSu(sc.nextFloat());
        System.out.println("diem dia");
        this.setDia(sc.nextFloat());
    }
    
    public void HienC(){
        super.hienTHi();
        System.out.println("diem van"+this.getVan());
        System.out.println("diem su"+this.getSu());
        System.out.println("diem dia"+this.getDia());
    }
    public void Check(){
        if (this.getVan()+this.getSu()+this.getDia()>=20) {
            HienC();
        }
    }
    
}
