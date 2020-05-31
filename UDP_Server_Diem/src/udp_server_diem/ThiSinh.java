/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server_diem;

/**
 *
 * @author cmtie
 */
public class ThiSinh {

    private String Hoten;
    private int CMND;
    private String DiaChi;
    private int NamSinh;
    private int DiemMon1;
    private int DiemMon2;
    private int DiemMon3;

    public ThiSinh() {
    }

    public ThiSinh(String Hoten, int CMND, String DiaChi, int NamSinh, int DiemMon1, int DiemMon2, int DiemMon3) {
        this.Hoten = Hoten;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        this.NamSinh = NamSinh;
        this.DiemMon1 = DiemMon1;
        this.DiemMon2 = DiemMon2;
        this.DiemMon3 = DiemMon3;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public int getCMND() {
        return CMND;
    }

    public void setCMND(int CMND) {
        this.CMND = CMND;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(int NamSinh) {
        this.NamSinh = NamSinh;
    }

    public int getDiemMon1() {
        return DiemMon1;
    }

    public void setDiemMon1(int DiemMon1) {
        this.DiemMon1 = DiemMon1;
    }

    public int getDiemMon2() {
        return DiemMon2;
    }

    public void setDiemMon2(int DiemMon2) {
        this.DiemMon2 = DiemMon2;
    }

    public int getDiemMon3() {
        return DiemMon3;
    }

    public void setDiemMon3(int DiemMon3) {
        this.DiemMon3 = DiemMon3;
    }

    
}
