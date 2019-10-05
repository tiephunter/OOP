/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.pkg1;

/**
 *
 * @author admin
 */
public class Student extends Person{
    Student(){super();}
    public String Lop;

    public Student(String Lop) {
        this.Lop = Lop;
    }

    public Student(String Lop, String name, String address, String department) {
        super(name, address, department);
        this.Lop = Lop;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public void nhapthongtin(){
        super.nhapthongtin();
        System.out.println("Nhap lop hoc ");
        Lop = sc.nextLine();
    }
    
    public void xuatthongtin(){
        super.xuatthongtin();
        System.out.println("Lop hoc " + Lop);
    }
}
