/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author admin
 */
public class Person {
    protected String Hoten;
    protected String ngaysinh;
    protected String diachi;
    protected String gioitinh;

    public Person(String Hoten, String ngaysinh, String diachi, String gioitinh) {
        this.Hoten = Hoten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }
    public void hienthithongtin(){
        System.out.println("Họ tên :"+this.Hoten);
        System.out.println("Ngày sinh :" +this.ngaysinh);
        System.out.println("Địa chỉ :"+this.diachi);
        System.out.println("Giới tính : "+this.gioitinh);
    }
    
}
