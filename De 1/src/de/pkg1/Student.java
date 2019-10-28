/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pkg1;

/**
 *
 * @author admin
 */
public class Student extends Person{
    private String maSV;
    private String email;
    private float DTK;

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

    public float getDTK() {
        return DTK;
    }

    public void setDTK(float DTK) {
        this.DTK = DTK;
    }
    

    public Student(String HoTen, String DiaChi, String NgaySinh, String Gioitinh, String maSV, String email, float DTK ){
        super(HoTen, DiaChi, NgaySinh, Gioitinh);
        this.setMaSV(maSV);
        this.setEmail(email);
        this.setDTK(DTK);
    }
    @Override
    public void Hienthi(){
        super.Hienthi();
        System.out.println("MaSv"+this.getMaSV());
        System.out.println("Email "+this.getEmail());
        System.out.println("DTK"+this.getDTK());
        
    }
    
}
