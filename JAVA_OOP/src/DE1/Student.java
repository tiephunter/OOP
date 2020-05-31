/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE1;

/**
 *
 * @author cmtie
 */
public class Student extends Person{
    private String MaSV;
    private String Email;
    private Float DTK;

    public Student(String MaSV, String Email, Float DTK, String Hoten, String NgaySinh, String DiaChi, String GioiTinh) {
        super(Hoten, NgaySinh, DiaChi, GioiTinh);
        this.MaSV = MaSV;
        this.Email = Email;
        this.DTK = DTK;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Float getDTK() {
        return DTK;
    }

    public void setDTK(Float DTK) {
        this.DTK = DTK;
    }

    public void HienThi(){
        this.Hienthi();
        System.out.println("Ma sv"+this.getMaSV());
        System.out.println("Email"+this.getMaSV());
        System.out.println("DTK"+this.getMaSV());
    }
    
    
}
