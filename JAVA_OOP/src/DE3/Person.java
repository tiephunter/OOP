/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DE3;

/**
 *
 * @author cmtie
 */
public class Person {
    protected String Hoten;
    protected String NgaySinh;
    protected String GioiTinh;

    public Person(String Hoten, String NgaySinh, String GioiTinh) {
        this.Hoten = Hoten;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
    }
    
    public void Hienthi(){
        System.out.println("Ho ten"+this.Hoten);
        System.out.println("NgaySinh"+this.NgaySinh);
        System.out.println("GioiTinh"+this.GioiTinh);
    }
    
}
