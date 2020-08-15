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
public class TaiKhoan {
    public String hoTen;
    public int STK;
    public float Sodu;

    public TaiKhoan(String hoTen, int STK, float Sodu) {
        this.hoTen = hoTen;
        this.STK = STK;
        this.Sodu = Sodu;
    }
    public String Hienthi(){
     return "Ho ten: "+hoTen+"\t|\t"
             +"STK: "+STK+"\t|\t"    
             +"Sodu: " + Sodu;
}
}
