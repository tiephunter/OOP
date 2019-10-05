/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg1;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Person {
    Scanner sc = new Scanner(System.in);
    private String name;
    private String address;
    private String department;

    public Person() {
    }

    public Person(String name, String address, String department) {
        this.name = name;
        this.address = address;
        this.department = department;
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
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void nhapthongtin(){
        System.out.println("Nhap ten : ");
        name = sc.nextLine();
        System.out.println("nhap dia chi : ");
        address = sc.nextLine();
        System.out.println("Nhap chuc vu : ");
        department = sc.nextLine();
    }
    public void xuatthongtin(){
        System.out.println("Tên "+name+"\nDia chi"+address+"\nChức vụ :" +department);
    }
    
}
