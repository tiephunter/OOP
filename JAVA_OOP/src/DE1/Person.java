/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE1;

/**
 *
 * @author cmtie
 */
public class Person {
    protected String Hoten;
    protected String NgaySinh;
    protected String DiaChi;
    protected String GioiTinh;

    public Person(String Hoten, String NgaySinh, String DiaChi, String GioiTinh) {
        this.Hoten = Hoten;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
    }
    
    public void Hienthi(){
        System.out.println("Ho ten"+this.Hoten);
        System.out.println("NGay sinh"+this.NgaySinh);
        System.out.println("Dia chi"+this.DiaChi);
        System.out.println(" Gioi Tinh"+this.GioiTinh);
    }
    
}
