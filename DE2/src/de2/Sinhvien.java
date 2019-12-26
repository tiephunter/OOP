/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de2;

/**
 *
 * @author admin
 */
public class Sinhvien extends Person{
    private String Chuyennghanh;
    private int Diemquatrinh;
    private int Diemhocphan;

    public String getChuyennghanh() {
        return Chuyennghanh;
    }

    public void setChuyennghanh(String Chuyennghanh) {
        this.Chuyennghanh = Chuyennghanh;
    }

    public int getDiemquatrinh() {
        return Diemquatrinh;
    }

    public void setDiemquatrinh(int Diemquatrinh) {
        this.Diemquatrinh = Diemquatrinh;
    }

    public int getDiemhocphan() {
        return Diemhocphan;
    }

    public void setDiemhocphan(int Diemhocphan) {
        this.Diemhocphan = Diemhocphan;
    }

    public Sinhvien(String Hoten, String Ngaysinh, String Diachi, String Gioitinh, String Chuyennganh ,int diemquatrinh, int diemhocphan) {
        super(Hoten, Ngaysinh, Diachi, Gioitinh);
        this.setChuyennghanh(Chuyennghanh);
        this.setDiemquatrinh(Diemquatrinh);
        this.setDiemhocphan(Diemhocphan);
        
    }
    public void Hienthisv(){
        super.Hienthi();
        System.out.println("diem qua trinh"+this.Diemquatrinh);
        System.out.println("diem hoc phan"+this.Diemhocphan);
    }
}
