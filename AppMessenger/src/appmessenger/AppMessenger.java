 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmessenger;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.net.Socket;
    
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author cmtie
 */
    



public class AppMessenger {
    
    final static int SIGNUP_ACTION = 1;
    final static int LOGIN_ACTION = 2;
    final static int LOGIN_SUCCESS = 3;
    final static int LOGIN_FALSE = 4;
    
    private static Socket mySocket = null;
    private static DataInputStream in = null;
    private static DataOutputStream osx = null;
    

    public static void connection(){
        try {
            mySocket = new Socket("localhost", 1233);
            in = new DataInputStream(mySocket.getInputStream());
            osx = new DataOutputStream(mySocket.getOutputStream());
            
            
        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch(IOException e){
            System.err.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        AppMessenger.connection();
        JFrame frameLogIn= new JFrame("OrangeMESS");
        frameLogIn.setSize(350, 350);
        frameLogIn.setLocationRelativeTo(frameLogIn);
        frameLogIn.setResizable(true);
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.setBackground(Color.gray);
        
        //set panelDangNhap 
        JPanel panleLogIn = new JPanel();
        
        //set label, textfield and button
        JLabel labelOrangeMess = new JLabel("                  ORANGE--MESS             ",JLabel.CENTER);
        labelOrangeMess.setBackground(Color.orange);
        JLabel labelTenTaiKhoan = new JLabel("Accout",JLabel.LEFT);
        JLabel labelMatKhau = new JLabel("Password",JLabel.LEFT);
        
        JTextField tfTenTaiKhoan = new JTextField("",JTextField.LEFT);
        JTextField tfMatKhau = new JTextField("",JTextField.LEFT);
        
        JButton btnLogIn = new JButton("Đăng Nhập");
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    osx.writeInt(LOGIN_ACTION);
                    osx.writeUTF(tfTenTaiKhoan.getText());
                    osx.writeUTF(tfMatKhau.getText());
                    osx.flush();
                    int result = in.readInt();
                    if(result==LOGIN_SUCCESS){
                        int id = in.readInt();
                        String HoTen = in.readUTF();
                        String NgaySinh = in.readUTF();
                        int GioiTinh = in.readInt();
                        String DiaChi = in.readUTF();
                        String QueQuan = in.readUTF();
                        String Email = in.readUTF();
                        String TenTaiKhoan = in.readUTF();
                        String MatKhau = in.readUTF();
                        System.out.println(id+"  "+HoTen+" "+NgaySinh+" "+GioiTinh+" "+DiaChi+" "+QueQuan+" "+Email+" "+TenTaiKhoan+" "+MatKhau);
                        JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
                        JFrame frameHome = new JFrame("HOME");
                        frameHome.setSize(400,600);
                        frameHome.setLocationRelativeTo(frameHome);
                        frameHome.setResizable(true);
                        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        
                        frameLogIn.setVisible(false);
                        frameHome.setVisible(true);
                        
                    }
                    else if (result == LOGIN_FALSE){
                         JOptionPane.showMessageDialog(null,"Nhập sai tài khoản hoặc mật khẩu");
                         tfTenTaiKhoan.setText("");
                         tfMatKhau.setText("");
                    }
                    
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null,"cath Nhập sai tài khoản hoặc mật khẩu");
                    System.out.println("Nhập lại đeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    System.out.println("loi day");
                    System.out.println(e2);
                }
                
            }
        });
        
  
        JButton btnSignUp = new JButton("Đăng Kí");
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
        JFrame frameDangKy = new JFrame("Form Đăng kí");
        frameDangKy.setSize(400, 600);
        frameDangKy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDangKy.setLocationRelativeTo(null);
        frameDangKy.setResizable(true);
        frameDangKy.getContentPane().setBackground(Color.orange);
        
        //set layout for panel profile
        //set Layout for body
        JPanel panelBody = new JPanel();
        BoxLayout boxLayoutBody = new BoxLayout(panelBody, BoxLayout.Y_AXIS);
        panelBody.setLayout(boxLayoutBody);
        panelBody.setBorder(new EmptyBorder(50,50, 50, 50));
        panelBody.setBackground(Color.orange);
        
        JPanel panelPrf = new JPanel();
        BoxLayout boxPanelPrf = new BoxLayout(panelPrf, BoxLayout.Y_AXIS);
        panelPrf.setLayout(boxPanelPrf);
        panelPrf.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelPrf.setBackground(Color.gray);
        panelBody.add(panelPrf);
        
        JLabel labelPrf = new JLabel("        Thông tin đăng kí          ");
        JLabel labelhr = new JLabel("                         ----------              ");
        JLabel labelTenTK = new JLabel("Tên Tài Khoản",JLabel.LEFT);
        JLabel labelMK = new JLabel("Mật Khẩu",JLabel.LEFT);
        JLabel labelHoTen = new JLabel("Họ Tên",JLabel.LEFT);
        JLabel labelNgaySinh = new JLabel("Ngày Sinh",JLabel.LEFT);
        JLabel labelGioiTinh = new JLabel("Giới Tính",JLabel.LEFT);
        JLabel labelDiaChi = new JLabel("Địa Chỉ",JLabel.LEFT);
        JLabel labelQueQuan = new JLabel("Quê Quán",JLabel.LEFT);
        JLabel labelEmail = new JLabel("Email",JLabel.LEFT);
        labelPrf.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelTenTK.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelMK.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelHoTen.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelQueQuan.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        //set text field
        JTextField tfTenTK = new JTextField("",JTextField.LEFT);
        JTextField tfMK = new JTextField("",JTextField.LEFT);
        JTextField tfHoTen = new JTextField("",JTextField.LEFT);
        JTextField tfNgaySinh = new JTextField("",JTextField.LEFT);
        JTextField tfGioiTinh = new JTextField("",JTextField.LEFT);
        JTextField tfDiaChi = new JTextField("",JTextField.LEFT);
        JTextField tfQueQuan = new JTextField("",JTextField.LEFT);
        JTextField tfEmail = new JTextField("",JTextField.LEFT);
        
        //create button Sing up
        JButton btnDky = new JButton("Đăng Kí");
        btnDky.setFont(new Font("Tahoma",Font.BOLD , 24));
        btnDky.setBackground(Color.black);
        btnDky.setForeground(Color.white);
        btnDky.setFocusPainted(false);
        btnDky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        osx.writeInt(SIGNUP_ACTION);
                        osx.writeUTF(tfTenTK.getText());
                        osx.writeUTF(tfMK.getText());
                        osx.writeUTF(tfHoTen.getText());
                        osx.writeUTF(tfNgaySinh.getText());
                        osx.writeInt(Integer.parseInt(tfGioiTinh.getText()));
                        osx.writeUTF(tfDiaChi.getText());
                        osx.writeUTF(tfQueQuan.getText());
                        osx.writeUTF(tfEmail.getText());
                        osx.flush();
                        String input = in.readUTF();
                        System.out.println(input);
                        JOptionPane.showMessageDialog(null, input);
                        
                } catch (IOException e1) {
                    System.err.println(e1);
                    System.out.println("ko đọc hết đc");
                }
                
                
            }
        });
        
        //create button back to menu
        JButton btnBack = new JButton("Back To MeNu");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameDangKy.setVisible(false);
                frameLogIn.setVisible(true);
            }
        });
        //panelPrf add label and textfield
        panelPrf.add(labelPrf);
        panelPrf.add(labelhr);
        panelPrf.add(labelTenTK);
        panelPrf.add(tfTenTK);
        panelPrf.add(labelMK);
        panelPrf.add(tfMK);
        panelPrf.add(labelHoTen);
        panelPrf.add(tfHoTen);
        panelPrf.add(labelNgaySinh);
        panelPrf.add(tfNgaySinh);
        panelPrf.add(labelGioiTinh);
        panelPrf.add(tfGioiTinh);
        panelPrf.add(labelDiaChi);
        panelPrf.add(tfDiaChi);
        panelPrf.add(labelQueQuan);
        panelPrf.add(tfQueQuan);
        panelPrf.add(labelEmail);
        panelPrf.add(tfEmail);
        panelPrf.add(btnDky);
        panelPrf.add(btnBack);
        
        
       //set Layout for panel
        panelPrf.setLayout(new BoxLayout(panelPrf, BoxLayout.Y_AXIS));
        //frame add content
        frameDangKy.setLayout(new GridLayout(1,1));
        frameDangKy.add(panelBody);
        frameDangKy.setVisible(true);
                
            }
        });
        
        //add component to panel
        
        panleLogIn.add(labelOrangeMess);
        panleLogIn.add(labelTenTaiKhoan);
        panleLogIn.add(tfTenTaiKhoan);
        panleLogIn.add(labelMatKhau);
        panleLogIn.add(tfMatKhau);
        panleLogIn.add(btnLogIn);
        panleLogIn.add(btnSignUp);
        
        //set Layout for panel;
        panleLogIn.setLayout(new BoxLayout(panleLogIn, BoxLayout.Y_AXIS));
        panleLogIn.setBorder(new EmptyBorder(50, 50, 100, 70));
        panleLogIn.setBackground(Color.GRAY);
        
        //add to Frame
        frameLogIn.setLayout(new GridLayout(1,1));
        frameLogIn.add(panleLogIn);
        frameLogIn.setVisible(true);
    }
    
}