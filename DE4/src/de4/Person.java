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
public class Person {
    protected String Hoten;
    protected String Ngaysinh;
    protected String Diachi;
    protected String Gioitinh;

    public Person(String Hoten, String Ngaysinh, String Diachi, String Gioitinh) {
        this.Hoten = Hoten;
        this.Ngaysinh = Ngaysinh;
        this.Diachi = Diachi;
        this.Gioitinh = Gioitinh;
    }
    public void Hienthi(){
        System.out.println("Ho va Ten là "+this.Hoten);
        System.out.println("Ngay Sinh "+this.Ngaysinh);
        System.out.println("Dia chi "+this.Diachi);
        System.out.println("Gioi tinh "+this.Gioitinh);
    }
    
}
