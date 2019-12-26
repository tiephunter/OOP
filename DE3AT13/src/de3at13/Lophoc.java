/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de3at13;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Lophoc {
    ArrayList<Sinhvien> DSSV = new ArrayList<>();    
    private int sisolop;
    private String tenlop;

    public ArrayList<Sinhvien> getDSSV() {
        return DSSV;
    }

    public void setDSSV(ArrayList<Sinhvien> DSSV) {
        this.DSSV = DSSV;
    }

    public int getSisolop() {
        return sisolop;
    }

    public void setSisolop(int sisolop) {
        this.sisolop = sisolop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    
    public Lophoc() {
    }

    public Lophoc(int sisolop, String tenlop) {
        this.sisolop = sisolop;
        this.tenlop = tenlop;
    }
    public void hienthilp(){
        System.out.println("si so lp"+this.sisolop);
        System.out.println("ten lop "+this.tenlop);
    }
    
}
