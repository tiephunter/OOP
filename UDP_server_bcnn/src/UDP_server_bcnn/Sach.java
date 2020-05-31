/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP_server_bcnn;

/**
 *
 * @author cmtie
 */
public class Sach {
        String maSach;
         String tenSach;
         String nguoiMuon;

    public Sach(String maSach, String tenSach, String nguoiMuon) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nguoiMuon = nguoiMuon;
    }
    public String hienThi(){
        
             return "Ma Sach: "+this.maSach+"\t\t"+"Ten Sach: "+this.tenSach+"\t\t"+"Nguoi muon: "+this.nguoiMuon;
    }
}
