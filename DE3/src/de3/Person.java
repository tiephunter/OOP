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
public class Person {
    protected String HoTen;
    protected String DiaChi;
    protected String NgaySinh;
    protected String Gioitinh;

    public Person(String HoTen, String DiaChi, String NgaySinh, String Gioitinh) {
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.Gioitinh = Gioitinh;
    }
    public void Hienthi(){
        System.out.println("Ho va Ten"+this.HoTen);
        System.out.println("Dia Chi"+this.DiaChi);
        System.out.println("Ngay Sinh"+this.NgaySinh);
        System.out.println("Gioi Tinh"+this.Gioitinh);
        
    }
    
}
