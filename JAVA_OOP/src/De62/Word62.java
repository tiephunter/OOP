/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De62;

/**
 *
 * @author cmtie
 */
public class Word62 {
    private int id;
    private String eng;
    private String vn;

    public Word62() {
    }
    
    

    public Word62(int id, String eng, String vn) {
        this.id = id;
        this.eng = eng;
        this.vn = vn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }
            
    public void Hienthi(){
        System.out.println("id: "+this.getId()  +" eng: "+this.getEng()+ " vn: "+ this.getVn());
    }
            
}
