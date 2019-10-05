/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopperson;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */



public class OOPperson {

    /**
     * @param args the command line arguments
     */
    ArrayList<Student> StudentList = new ArrayList();
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    public void nhap(){
        int m;
        System.out.println("Nhap so luong sinh vien can nhap 123");
        m = sc.nextInt();
        for(int i = 0; i<m; i++){
        Student newStudent = new Student();
        System.out.println("Nhap thong tin cua sinh vien "+(i+1));
        newStudent.nhapthongtinsinhvien();
        StudentList.add(newStudent);
        }
    }
    public void xuat(){
        System.out.println("Hien thi thong tin cua sinh vien");
        StudentList.forEach(student ->{
            student.xuatthongtinsinhvien();
                            }
        );
        
    }
    public void quanlisinhvien(){
        int chon = 0;
        do{
            System.out.println(" -------------------MENU--------------------");
            System.out.println(" |   1 : Nhập thông tin sinh vien    .      |");
            System.out.println(" |   2 : Hiện thị thông tin của sinh vien . |");
            System.out.println(" |   3 : Ket thuc                           |");
            System.out.println(" |______________Mời bạn chọn!_______________|");
            chon = sc.nextInt();
            switch(chon){
                case 1: nhap();
                case 2: xuat();
            }
        } while(chon!=3);
        
        }
   
    public static void main(String[] args) {
        // TODO code application logic here
        OOPperson check = new OOPperson();
        check.quanlisinhvien();
    }
    
}
