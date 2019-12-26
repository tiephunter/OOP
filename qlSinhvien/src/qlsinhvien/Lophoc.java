/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsinhvien;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 *
 * @author tiep4299
 */
public class Lophoc {
    private int idLop ;
    private String tenLop;
    private String khoi;
    private int soLuong;
    private String ghiChu;

    public Lophoc(int idLop, String tenLop, String khoi, int soLuong, String ghiChu) {
        this.idLop = idLop;
        this.tenLop = tenLop;
        this.khoi = khoi;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoi() {
        return khoi;
    }

    public void setKhoi(String khoi) {
        this.khoi = khoi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    @Override
    public String toString(){
        return this.getTenLop();
    }
    
}
