/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javade8;

/**
 *
 * @author admin
 */
public class ThisinhKhoiC extends ThiSinh{
    private int diemvan;
    private int diemsu;
    private int diemdia;

    public int getDiemtvan() {
        return diemvan;
    }

    public void setDiemtvan(int diemtvan) {
        this.diemvan = diemtvan;
    }

    public int getDiemsu() {
        return diemsu;
    }

    public void setDiemsu(int diemsu) {
        this.diemsu = diemsu;
    }

    public int getDiemdia() {
        return diemdia;
    }

    public void setDiemdia(int diemdia) {
        this.diemdia = diemdia;
    }

    public ThisinhKhoiC() {
    }
    
 
    public void NhapthongtinsinhvienkhoiC(){
        super.Nhapthongtin();
        System.out.println("Nhap diem van :");
        this.diemvan= sc.nextInt();
        System.out.println("NHap diem su :");
        this.diemsu= sc.nextInt();
        System.out.println("NHap diem dia :");
        this.diemdia= sc.nextInt();
    }
    
    public void XuatthongtinsinhvienkhoiC(){
        super.Xuatthongtin();
        System.out.println("Diem van la"+this.getDiemtvan());
        System.out.println("Diem su la : "+this.getDiemsu());
        System.out.println("Diem dia la "+this.getDiemdia());
    }
    
    public int TinhtongdiemkhoiC(){
        int TinhtongC= this.getDiemtvan()+this.getDiemsu()+this.getDiemdia();
        return TinhtongC;
    }
}
