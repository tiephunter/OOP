/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_bank_server;

/**
 *
 * @author cmtie
 */
public class Account {
    private int Tien;
    private String GiaoDich;

    public Account(int Tien, String GiaoDich) {
        this.Tien = Tien;
        this.GiaoDich = GiaoDich;
    }

    public int getTien() {
        return Tien;
    }

    public void setTien(int Tien) {
        this.Tien = Tien;
    }

    public String getGiaoDich() {
        return GiaoDich;
    }

    public void setGiaoDich(String GiaoDich) {
        this.GiaoDich = GiaoDich;
    }
    
    
    
}
