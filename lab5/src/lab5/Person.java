/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Person {
    Scanner sc = new Scanner(System.in);
    private String name;
    private String address;
    private String Department;

    public Person() {
    }

    public Person(String name, String address, String Department) {
        this.name = name;
        this.address = address;
        this.Department = Department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
    public void nhapThongTin(){
        System.out.println("Nhap ten :");
        name = sc.nextLine();
        System.out.println("Nhap dia chi");
        address = sc.nextLine();
        System.out.println("Nhap vao chuc vu");
        Department = sc.nextLine();        
    }
    
    public void xuatThongTin(){
        System.out.println("Ho ten: "+name+"\nDia chi:"+address+"\nChuc vu:"+ Department);
    }
    
}
