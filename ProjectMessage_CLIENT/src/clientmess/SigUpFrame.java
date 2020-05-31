package clientmess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SigUpFrame {
    JFrame sigUpFrame;
    JPanel panelBody;
    JTextField tfTenTK;
    JTextField tfMK;
    JTextField tfHoTen;
    JTextField tfNgaySinh;
    JTextField tfGioiTinh;
    JTextField tfDiaChi;
    JTextField tfQueQuan;
    JTextField tfEmail;
    public SigUpFrame(){
        sigUpFrame = new JFrame("Form Đăng kí Tai Khoan");
        sigUpFrame.setSize(400, 600);
        sigUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sigUpFrame.setLocationRelativeTo(null);
        sigUpFrame.setResizable(true);
        sigUpFrame.getContentPane().setBackground(Color.orange);

        //set layout for panel profile
        //set Layout for body
        panelBody = new JPanel();
        BoxLayout boxLayoutBody = new BoxLayout(panelBody, BoxLayout.Y_AXIS);
        panelBody.setLayout(boxLayoutBody);
        panelBody.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelBody.setBackground(Color.orange);

        JPanel panelPrf = new JPanel();
        BoxLayout boxPanelPrf = new BoxLayout(panelPrf, BoxLayout.Y_AXIS);
        panelPrf.setLayout(boxPanelPrf);
        panelPrf.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelPrf.setBackground(Color.gray);
        panelBody.add(panelPrf);

        JLabel labelPrf = new JLabel("        Thông tin đăng kí          ");
        JLabel labelhr = new JLabel("                         ----------              ");
        JLabel labelTenTK = new JLabel("Tên Tài Khoản", JLabel.LEFT);
        JLabel labelMK = new JLabel("Mật Khẩu", JLabel.LEFT);
        JLabel labelHoTen = new JLabel("Họ Tên", JLabel.LEFT);
        JLabel labelNgaySinh = new JLabel("Ngày Sinh", JLabel.LEFT);
        JLabel labelGioiTinh = new JLabel("Giới Tính", JLabel.LEFT);
        JLabel labelDiaChi = new JLabel("Địa Chỉ", JLabel.LEFT);
        JLabel labelQueQuan = new JLabel("Quê Quán", JLabel.LEFT);
        JLabel labelEmail = new JLabel("Email", JLabel.LEFT);
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
        tfTenTK = new JTextField("", JTextField.LEFT);
        tfMK = new JTextField("", JTextField.LEFT);
        tfHoTen = new JTextField("", JTextField.LEFT);
        tfNgaySinh = new JTextField("", JTextField.LEFT);
        tfGioiTinh = new JTextField("", JTextField.LEFT);
        JLabel sexLb = new JLabel("Notice: Male = 0; Female = 1");
        tfDiaChi = new JTextField("", JTextField.LEFT);
        tfQueQuan =  new JTextField("", JTextField.LEFT);
        tfEmail = new JTextField("", JTextField.LEFT);

        //create button Sing up
        JButton btnDky = new JButton("Đăng Kí");
        btnDky.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnDky.setBackground(Color.black);
        btnDky.setForeground(Color.white);
        btnDky.setFocusPainted(false);
        btnDky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppMessenger.out.writeInt(AppMessenger.SIGNUP_ACTION);
                    AppMessenger.out.writeUTF(tfTenTK.getText());
                    AppMessenger.out.writeUTF(tfMK.getText());
                    AppMessenger.out.writeUTF(tfHoTen.getText());
                    AppMessenger.out.writeUTF(tfNgaySinh.getText());
                    AppMessenger.out.writeInt(Integer.parseInt(tfGioiTinh.getText()));
                    AppMessenger.out.writeUTF(tfDiaChi.getText());
                    AppMessenger.out.writeUTF(tfQueQuan.getText());
                    AppMessenger.out.writeUTF(tfEmail.getText());
                    AppMessenger.out.flush();

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
                sigUpFrame.setVisible(false);
                AppMessenger.displayLogInFrame();
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
        panelPrf.add(sexLb);
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
        sigUpFrame.setLayout(new GridLayout(1, 1));
        sigUpFrame.add(panelBody);
        sigUpFrame.setVisible(true);

    }

    public void hide(){
        sigUpFrame.setVisible(false);
    }
}
