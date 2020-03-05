 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmessenger;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;


import java.net.Socket;
    
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    final static int SEARCH_ACTION = 5;
    final static int FRIENDADDREQUEST_ACTION = 6;
    private static Socket mySocket = null;
    private static DataInputStream in = null;
    private static DataOutputStream osx = null;
    

    public static void connection(){
        try {
            mySocket = new Socket("localhost", 1233);
            in = new DataInputStream(mySocket.getInputStream());
            osx = new DataOutputStream(mySocket.getOutputStream());
            
            
        } catch (UnknownHostException e) {
            System.err.println(e+"Lỗi ko tìm được server");
        } catch(IOException e){
            System.err.println(e+"Ngoại lệ socket");
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
        btnLogIn.setFocusPainted(false);
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
                        int idUser = in.readInt();
                        String HoTenUser = in.readUTF();
                        String NgaySinhUser = in.readUTF();
                        int GioiTinhUser = in.readInt();
                        String DiaChiUser = in.readUTF();
                        String QueQuanUser = in.readUTF();
                        String EmailUser = in.readUTF();
                        String TenTaiKhoanUser = in.readUTF();
                        String MatKhauUser = in.readUTF();
                        System.out.println(idUser+"  "+HoTenUser+" "+NgaySinhUser+" "+GioiTinhUser+" "+DiaChiUser+" "+QueQuanUser+" "+EmailUser+" "+TenTaiKhoanUser+" "+MatKhauUser);
                        JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
                        
                        JFrame frameHome = new JFrame("HOME");
                        frameHome.setSize(400,600);
                        frameHome.setLocationRelativeTo(frameHome);
                        frameHome.setResizable(true);
                        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
                        //create PanelHome
                        JPanel panelHome = new JPanel();
                        BoxLayout boxPanelHome = new BoxLayout(panelHome, BoxLayout.Y_AXIS);
                        panelHome.setLayout(boxPanelHome);
                        panelHome.setBorder(new EmptyBorder(50, 50, 550, 50));
                        panelHome.setBackground(Color.GRAY);
                        
                        JLabel lableSearchList1 = new JLabel("",JLabel.CENTER);
                        lableSearchList1.setSize(20, 20);
                        JButton btnAdd = new JButton();
                        btnAdd.setBackground(Color.gray);
                        //create tfSearch and btn search
                        
                        JTextField tfSearch = new JTextField("");

                        JButton btnSearch = new JButton("Search");
                        btnSearch.setForeground(Color.black);
                        btnSearch.setFocusPainted(false);
                        btnSearch.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {  
                                try {
                                    osx.writeInt(SEARCH_ACTION);
                                    osx.writeUTF(tfSearch.getText());
                                    System.out.println(tfSearch.getText());
                                    osx.flush();
                                    int search = in.readInt();
                                    if (search == SEARCH_ACTION) {
                                        JOptionPane.showMessageDialog(null, " tìm tháy người dùng");
                                    
                                        int AmountUsers = in.readInt();                     
                                            int idFriend = in.readInt();
                                            String HoTenFriend = in.readUTF();
                                            String NgaySinhFriend = in.readUTF();
                                            int GioiTinhFriend = in.readInt();
                                            String DiaChiFriend = in.readUTF();
                                            String QueQuanFriend = in.readUTF();
                                            String EmailFriend = in.readUTF();
                                            String TenTaiKhoanFriend = in.readUTF();
                                            for (int i = 0; i <AmountUsers; i++) {
                                            lableSearchList1.setText(TenTaiKhoanFriend);
                                            btnAdd.setText("Add Friend");
                                            btnAdd.setFocusPainted(false);
                                            btnAdd.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {        
                                                    try {
                                                        osx.writeInt(FRIENDADDREQUEST_ACTION);
                                                        osx.writeInt(idUser);
                                                        osx.writeInt(idFriend);
                                                        osx.flush();                                                   
                                                        JOptionPane.showMessageDialog(null, "đã kết bạn");

                                                    } catch (Exception e4) {
                                                        System.out.println(e4+"Lỗi kết bạn");
                                                    }
                                                }
                                            });

                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Không tìm tháy người dùng");
                                        btnAdd.setText("Không tìm tháy người dùng");
                                    }
                                    
                                } catch (Exception e3) {
                                    System.out.println(e3+"Lỗi đăng nhập");
                                }
                            }
                        });
                        
                        panelHome.add(btnSearch);
                        panelHome.add(tfSearch);
                        panelHome.add(lableSearchList1);
                        panelHome.add(btnAdd);
                        
                        
                        
                        frameHome.add(panelHome);
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