/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopperson;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Person {
    private String hovaten;
    private String ngaysinh;
    private String diachi;
    private String gioitinh;
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    public Person() {
    }

    public Person(String hovaten, String ngaysinh, String diachi, String gioitinh) {
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String setNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    public void nhapthongtin(){
        System.out.println("Nhap Ho va Ten");
        hovaten  = sc.nextLine();
        System.out.println("Nhap ngay sinh");
        ngaysinh = sc1.nextLine();
        System.out.println("NHap dia chi");
        diachi = sc.nextLine();
        System.out.println("Nhap gioi tinh");
        gioitinh = sc.nextLine();
    }
    public void xuatthongtin(){
        System.out.println("Ho va ten"+hovaten+"\nNgaysinh "+ngaysinh+"\nDia chi"+diachi+"\nGioi tinh"+gioitinh);
    }
    
}
