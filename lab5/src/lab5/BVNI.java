/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bvni;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Nam Duong
 */
public class BVNI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> Thongtin2 = new ArrayList<>();

        Person Thongtinchung = new Person();
        Teacher Thongtingiaovien = new Teacher();
        Student Thongtinhocsinh = new Student();

        boolean cont = true;
        do {

            System.out.println("====MENU====");
            System.out.println("Chá»©c nÄƒng 1 : Nháº­p thÃ´ng tin  ");
            System.out.println("Chá»©c nÄƒng 2 : In ra thÃ´ng tin ");

            int chon;
            System.out.print("Nháº­p vÃ o chá»©c nÄƒng báº¡n muá»‘n chá»�n : ");
            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    System.out.println("Chá»©c nÄƒng nháº­p vÃ o thÃ´ng tin ");

                    int m = 0;
                    System.out.print("Nháº­p vÃ o sá»‘ nhÃ¢n sá»± cáº§n nháº­p :");
                    m = sc.nextInt();

                    for (int i = 1; i <= m; i++) {
                        Thongtinchung = new Teacher();
                        Thongtinchung = new Student();
                        Thongtinchung.Nhapthongtin(sc1);
                        Thongtin2.add(Thongtinchung);
                    }
                    break;
                case 2:
                    System.out.println("Chá»©c nÄƒng in thÃ´ng tin:");
                    Thongtinchung.Inthongtin();
                    break;

                default:
                    System.out.println("Chá»©c nÄƒng nÃ y chÆ°a Ä‘c thÃªm vÃ o.....yÃªu cáº§u thá»­ láº¡i !!!!!");
                    break;
            }
        } while (cont);

    }

    private static class Teacher {

        public Teacher() {
        }
    }

    private static class Student {

        public Student() {
        }
    }

    private static class Person {

        public Person() {
        }
    }

}
