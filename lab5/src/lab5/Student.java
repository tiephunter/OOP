/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author admin
 */
public class Student extends Person{
    Student(){super();}
    private String Lop;

    public Student(String Lop) {
        this.Lop = Lop;
    }

    public Student(String Lop, String name, String address, String Department) {
        super(name, address, Department);
        this.Lop = Lop;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }
    
    public void nhapThongTin(){
        super.nhapThongTin();
        System.out.println("Lop cua hoc sinh do: ");
        Lop = sc.nextLine();
        
    }       
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Lop \n"+ Lop);
    }
}
