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
public class Student {
    private String Ten;
    private String Ho;
    private String ngaysinh;
    private String lophoc;

    public Student(String Ten, String Ho, String ngaysinh, String lophoc) {
        this.Ten = Ten;
        this.Ho = Ho;
        this.ngaysinh = ngaysinh;
        this.lophoc = lophoc;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLophoc() {
        return lophoc;
    }

    public void setLophoc(String lophoc) {
        this.lophoc = lophoc;
    }
    
    
}
