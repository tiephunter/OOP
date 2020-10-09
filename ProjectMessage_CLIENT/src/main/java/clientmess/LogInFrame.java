package clientmess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

public class LogInFrame {
    final static int LOGIN_ACTION = 2;
    JFrame logInFrame;
    protected JTextField tfTenTaiKhoan;
    protected JPasswordField tfMatKhau;
    public LogInFrame(){
        logInFrame = new JFrame("Orange Messenger");
        logInFrame.setSize(350, 350);
        logInFrame.setLocationRelativeTo(logInFrame);
        logInFrame.setResizable(true);
        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInFrame.setBackground(Color.gray);

        //set panelDangNhap
        JPanel panleLogIn = new JPanel();

        //set label, textfield and button
        JLabel labelOrangeMess = new JLabel("                  ORANGE--MESS             ", JLabel.CENTER);
        labelOrangeMess.setBackground(Color.orange);
        JLabel labelTenTaiKhoan = new JLabel("Accout", JLabel.LEFT);
        JLabel labelMatKhau = new JLabel("Password", JLabel.LEFT);

        tfTenTaiKhoan = new JTextField("", JTextField.LEFT);
        tfMatKhau = new JPasswordField("", JPasswordField.LEFT);

        JButton btnLogIn = new JButton("Đăng Nhập");
        btnLogIn.setFocusPainted(false);
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Log in action");
                    AppMessenger.out.writeInt(LOGIN_ACTION);
                    AppMessenger.out.writeUTF(tfTenTaiKhoan.getText());
                    AppMessenger.out.writeUTF(tfMatKhau.getText());
                    AppMessenger.out.flush();
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, "cath Nhập sai tài khoản hoặc mật khẩu");
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
                AppMessenger.displaySigUpFrame();
                logInFrame.setVisible(false);
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
        logInFrame.setLayout(new GridLayout(1, 1));
        logInFrame.add(panleLogIn);
        logInFrame.setVisible(true);
    }
    public void hide(){
        logInFrame.setVisible(false);
    }
}
