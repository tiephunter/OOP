/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinhA> listSta = new ArrayList<ThiSinhA>();
        ArrayList<Thisinhc1> listStc = new ArrayList<Thisinhc1>();
        int chon = 0;
        do {
            System.out.println("Nhap Thi sinh ban muon them");
            System.out.println("1. Thi Sinh a");
            System.out.println("2. Thi Sinh c");
            System.out.println("3. hien danh sach dau");
            System.out.println("4.kt");
            System.out.println("bye");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    System.out.println("nhap so thi sinh a ban muon");
                    int a = sc.nextInt();
                    for (int i = 0; i < a; i++) {
                        System.out.println("nhap thi sinh thu" + (i + 1));
                        ThiSinhA tsa = new ThiSinhA();
                        tsa.NhapThiSinhA();
                        listSta.add(tsa);
                    }
                    break;
                case 2:
                        System.out.println("nhap so thi sinh a ban muon");
                    int b = sc.nextInt();
                    for (int i = 0; i < b; i++) {
                        System.out.println("nhap thi sinh thu" + (i + 1));
                        Thisinhc1 tsc1 = new Thisinhc1();
                        tsc1.NhapThiSinhA();
                        listStc.add(tsc1);
                    }
                    break;
                case 3:
                    System.out.println("Danh sách thi sinh a trung tuyen");
                    for (ThiSinhA tsaa : listSta) {
                        if (tsaa.Check() >= 20) {
                            tsaa.HienA();
                        }
                    }
                    System.out.println("Danh sách thi sinh c trung tuyen");
                    for (Thisinhc1 tsc111 : listStc) {
                        tsc111.Check();
                    }
                    break;
                default:
                    break;
            }
        } while (chon != 4);

    }
}
