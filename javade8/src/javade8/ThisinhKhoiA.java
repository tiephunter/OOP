/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

/**
 *
 * @author admin
 */
public class ThisinhKhoiA extends ThiSinh{
    private int diemtoan;
    private int diemly;
    private int diemhoa;

    public int getDiemtoan() {
        return diemtoan;
    }

    public void setDiemtoan(int diemtoan) {
        this.diemtoan = diemtoan;
    }

    public int getDiemly() {
        return diemly;
    }

    public void setDiemly(int diemly) {
        this.diemly = diemly;
    }

    public int getDiemhoa() {
        return diemhoa;
    }

    public void setDiemhoa(int diemhoa) {
        this.diemhoa = diemhoa;
    }

    public ThisinhKhoiA() {
    }
    
    public void NhapthongtinsinhvienkhoiA(){
        super.Nhapthongtin();
        System.out.println("Nhap diem toan :");
        this.diemtoan= sc.nextInt();
        System.out.println("NHap diem ly :");
        this.diemly= sc.nextInt();
        System.out.println("NHap diem hoa :");
        this.diemhoa= sc.nextInt();
    }
    
    
    public int TinhtongdiemkhoiA(){       
        int TinhtongA = this.getDiemtoan()+this.getDiemly()+this.getDiemly();
        return TinhtongA;
    }
    
    
    public void XuatthongtinsinhvienkhoiAdau(){
        if(TinhtongdiemkhoiA() >= 20){
            super.Xuatthongtin();
            System.out.println("Diem toan la: "+this.getDiemtoan());
            System.out.println("Diem ly la : "+this.getDiemly());
            System.out.println("Diem hoa la "+this.getDiemhoa());
        };
    }
    
}
