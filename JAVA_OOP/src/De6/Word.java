/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6;

/**
 *
 * @author cmtie
 */
public class Word {
    private int id;
    private String Eng;
    private String Vn;

    public Word(int id, String Eng, String Vn) {
        this.id = id;
        this.Eng = Eng;
        this.Vn = Vn;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String Eng) {
        this.Eng = Eng;
    }

    public String getVn() {
        return Vn;
    }

    public void setVn(String Vn) {
        this.Vn = Vn;
    }
    
    public void hienthi(){
        System.out.println("ID "+this.id +" Eng "+this.Eng+" VN "+this.Vn);
    }
    
    
}
