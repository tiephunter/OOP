/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HongGiang
 */
public class Main {
    
    public static dsConnectDatabase connection = new dsConnectDatabase();
    public static int LuotDangNhap = 1;    
    public static String hienThiTaiKhoan = "";
    public static String hienThiMatKhauNguoiDung = "";
    public static String hienThiTenNguoiDung = "";
    
    public static void main(String[] args) {
        // TODO code application logic here
        frmDangNhap frmLogin = new frmDangNhap();
        frmLogin.show();
    }
    public static void thongBao(String noiDungThongBao,String tieuDeThongBao,int icon){
        JOptionPane.showMessageDialog(new JFrame(),noiDungThongBao,tieuDeThongBao,icon);
    }
    public static void playSound(String soundName){
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.toString());
        }
    }
}
