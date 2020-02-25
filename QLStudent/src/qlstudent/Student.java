/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlstudent;

import java.util.UUID;

/**
 *
 * @author tiep4299
 */
public class Student {
    private int idStudent;
    private String ho;
    private String ten;
    private int idLop;
    private String ngaySinh;

    public Student(int idStudent, String ho, String ten, int idLop, String ngaySinh) {
        this.idStudent = idStudent;
        this.ho = ho;
        this.ten = ten;
        this.idLop = idLop;
        this.ngaySinh = ngaySinh;
    }

    
    
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

   
}
