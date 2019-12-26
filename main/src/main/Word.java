/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author admin
 */
public class Word {
    private int id;
    private String en;
    private String vn;

    public Word() {
    }

    public Word(int id, String en, String vn) {
        this.id = id;
        this.en = en;
        this.vn = vn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
    
    public void hienThiThongTin(){
        System.out.println("ID :"+this.getId()+"\t|\tEn :"+this.getEn()+" \t|\tVN :"+this.getVn());
        System.out.println("-----------");
    }
}
