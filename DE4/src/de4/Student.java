/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de4;

/**
 *
 * @author admin
 */
public class Student extends Person{
    private String maSV;
    private String email;
    private Float DTK;

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getDTK() {
        return DTK;
    }

    public void setDTK(Float DTK) {
        this.DTK = DTK;
    }

    public Student(String Hoten, String Ngaysinh, String Diachi, String Gioitinh, String maSV,String email,Float DTK) {
        super(Hoten, Ngaysinh, Diachi, Gioitinh);
        this.setMaSV(maSV);
        this.setEmail(email);
        this.setDTK(DTK);
    }

    /**
     *
     */
    public void Hienthi(){
        super.Hienthi();
        System.out.println("MaSV "+this.getMaSV());
        System.out.println("EMail "+this.getEmail());
        System.out.println("DTK "+this.getDTK());
    }
    
}
