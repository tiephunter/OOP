/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE7;

import java.util.Scanner;

/**
 *
 * @author cmtie
 */
public class ThiSinh {
    protected String Hoten;
    protected String NgaySinh;
    protected String DiaChi;

    public ThiSinh() {
    }
    

    public ThiSinh(String Hoten, String NgaySinh, String DiaChi) {
        this.Hoten = Hoten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
    }
    
    public void NhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhapp ho ten");
        this.Hoten = sc.nextLine();
        System.out.println("NHap ngay sinh");
        this.NgaySinh = sc.nextLine();
        System.out.println("Nhap dia chi");
        this.DiaChi = sc.nextLine();
    }
    public void hienTHi(){
        System.out.println("Ho ten" +this.Hoten+"NGay sinh"+this.NgaySinh+"DIA CHI "+this.DiaChi);
    }
    
    
}
