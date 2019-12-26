/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

/**
 *
 * @author admin
 */
public class Lophoc {
    private String tenlop;
    private String khoi;
    private String ghichu;
    private int soluong;

    public Lophoc(String tenlop, String khoi, String ghichu, int soluong) {
        this.tenlop = tenlop;
        this.khoi = khoi;
        this.ghichu = ghichu;
        this.soluong = soluong;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getKhoi() {
        return khoi;
    }

    public void setKhoi(String khoi) {
        this.khoi = khoi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    
    
}
