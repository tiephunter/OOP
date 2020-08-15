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
public class ThiSinhA extends ThiSinh{
    private float toan;
    private float ly;
    private float hoa;

    public ThiSinhA(){
        
    }
    public ThiSinhA(String Hoten, String NgaySinh, String DiaChi, float toan, float ly, float hoa) {
        super(Hoten, NgaySinh, DiaChi);
        this.toan=toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public ThiSinhA(String Hoten, String NgaySinh, String DiaChi) {
        super(Hoten, NgaySinh, DiaChi);
    }

    

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }
    
    public void NhapThiSinhA(){
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin();
        System.out.println("diem toan");
        this.setToan(sc.nextFloat());
        System.out.println("diem ly");
        this.setLy(sc.nextFloat());
        System.out.println("diem hoa");
        this.setHoa(sc.nextFloat());
    }
    
    public void HienA(){
        super.hienTHi();
        System.out.println("diem toan"+this.getToan());
        System.out.println("diem ly"+this.getLy());
        System.out.println("diem hoa"+this.getHoa());
    }
    public float Check(){
        float diem =0;
        diem = this.getToan()+this.getLy()+this.getHoa();
        System.out.println("diem"+diem);
        return diem;
    }
}
