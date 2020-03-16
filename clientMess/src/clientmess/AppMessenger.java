/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmess;

import java.awt.BorderLayout;

import java.io.OutputStream;
import java.net.Socket;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.swing.*;
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
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int ADD_FRIEND_ACTION = 6;
    final static int ADD_FRIEND_SUCCESS = 8;
    final static int ADD_FRIEND_FAIL = 9;
    public final static int LOAD_FRIEND_LIST_ACTION = 7;
    final static int CHAT_ACTION = 10;
    final static int CHAT_ACTION_SUCESS = 11;
    final static int CHAT_ACTION_FAIL = 12;
    final static int SEND_MESSAGE_ACTION = 13;
    final static int RECEIVED_MESSAGE_ACTION = 14;
    final static int RECEIVED_MESSENGER_NOW = 15;
    final static int RECEIVED_MESSENGER_LATER = 16;
    static int idUser = 0;

    public static Socket mySocket = null;
    public static DataInputStream in = null;
    public static DataOutputStream out = null;
    public static JTextField tfTenTaiKhoan =null;
    public static JTextField tfMatKhau = null;
    public static JFrame frameLogIn = null;
    public static JPanel panelHome = null;
    public static JFrame frameChat = null;
    public static JPanel panelChat = null;
    public static JTextField tfInputMessage = null;
    public static JPanel panelConversation = null;
    public static JLabel labelNameFriends = null;
    public static JButton btnAdd = null;
    public static JPanel panelSearchUser = null;
    public static JScrollPane spLoadUser = null;
    public static JButton btnSearchFriendList =null;
    public static JFrame frameHome = null;


    public static void connection() {
        try {
            mySocket = new Socket("localhost", 1233);
            in = new DataInputStream(mySocket.getInputStream());
            out = new DataOutputStream(mySocket.getOutputStream());
            ThreadHandleInput threadHandleInput = new ThreadHandleInput(in);
            threadHandleInput.start();
            System.out.println("Connected !!!");

        } catch (UnknownHostException e) {
            System.err.println(e + "Lỗi ko tìm được server");
        } catch (IOException e) {
            System.err.println(e + "Ngoại lệ socket");
        }
    }

    public static void handleSigUpAction() throws Exception{
        String input = in.readUTF();
        System.out.println(input);
        JOptionPane.showMessageDialog(null, input);
    }

    public static void handleLogInAction() throws Exception{
        int LogInResult = in.readInt();
        if(LogInResult == LOGIN_SUCCESS){
            System.out.println("input Log in");
            idUser = in.readInt();
            String HoTenUser = in.readUTF();
            String NgaySinhUser = in.readUTF();
            int GioiTinhUser = in.readInt();
            String DiaChiUser = in.readUTF();
            String QueQuanUser = in.readUTF();
            String EmailUser = in.readUTF();
            String TenTaiKhoanUser = in.readUTF();
            String MatKhauUser = in.readUTF();
            System.out.println(idUser + "  " + HoTenUser + " " + NgaySinhUser + " " + GioiTinhUser + " " + DiaChiUser + " " + QueQuanUser + " " + EmailUser + " " + TenTaiKhoanUser + " " + MatKhauUser);
            JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
            frameHome = new JFrame("HOME");
            frameHome.setSize(400, 600);
            frameHome.setLocationRelativeTo(frameHome);
            frameHome.setResizable(false);
            frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameHome.setBackground(Color.gray);
            frameHome.setForeground(Color.gray);

            //create PanelHome and panel Search Friend
            panelHome = new JPanel();
            GridLayout girdPanelHome = new GridLayout(3, 2);
            panelHome.setLayout(girdPanelHome);
            panelHome.setBorder(new EmptyBorder(50, 250, 0, 250));
            panelHome.setBackground(Color.GRAY);
            // panel Search Friend
            panelSearchUser = new JPanel();
            BoxLayout boxPanelSearchUser = new BoxLayout(panelSearchUser, BoxLayout.Y_AXIS);
            panelSearchUser.setLayout(boxPanelSearchUser);
            panelSearchUser.setBorder(new EmptyBorder(0, 50, 50, 50));
            panelSearchUser.setBackground(Color.GRAY);

            JLabel lbMsg ;


            btnSearchFriendList = new JButton("Search Friends List");
            btnSearchFriendList.setFocusPainted(false);
            btnSearchFriendList.setBackground(Color.ORANGE);
            btnSearchFriendList.addActionListener(new MyActionListener() );

            //create tfSearch and btn search
            JTextField tfSearch = new JTextField("");
            JButton btnSearchUser = new JButton("Search User");
            btnSearchUser.setForeground(Color.black);
            btnSearchUser.setFocusPainted(false);
            btnSearchUser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeInt(LOAD_USER_lIST_ACTION);
                        out.writeInt(idUser);
                        out.writeUTF(tfSearch.getText());
                        System.out.println(tfSearch.getText());
                        out.flush();
                    } catch (Exception e3) {
                        System.out.println(e3 + "Lỗi Search");
                    }
                }
            });
            //add component to panel home
            panelHome.add(btnSearchFriendList);
            panelHome.add(btnSearchUser);
            panelHome.add(tfSearch);
            //add panel Load User to scroll panel
            spLoadUser = new JScrollPane(panelSearchUser, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            spLoadUser.setPreferredSize(new Dimension(300,400));
            spLoadUser.setBackground(Color.GRAY);
            //add component to frame home
            frameHome.add(panelHome);
            frameHome.add(spLoadUser);
            frameHome.setLayout(new FlowLayout(1,0,0));
            frameLogIn.setVisible(false);
            frameHome.setVisible(true);
        }
        else if (LogInResult == LOGIN_FALSE) {
            JOptionPane.showMessageDialog(null, "Nhập sai tài khoản hoặc mật khẩu");
            tfTenTaiKhoan.setText("");
            tfMatKhau.setText("");
        }
    }

    public static void handleLoadUserListAction() throws Exception{
        int AmountUser = in.readInt();
        System.out.println("Amount user " + AmountUser);
        for (int i = 0; i < AmountUser; i++){
            System.out.println("sucess search");;
            //revired data
            int idFriend = in.readInt();
            String TenTaiKhoanFriend = in.readUTF();
            //create label
            labelNameFriends = new JLabel(TenTaiKhoanFriend, JLabel.CENTER);
            labelNameFriends.setSize(20, 20);
            labelNameFriends.updateUI();
            panelSearchUser.updateUI();
            //set lable

            btnAdd = new JButton("Add Friend");
            btnAdd.setBackground(Color.gray);

            //set button
            btnAdd.setBackground(Color.gray);
            btnAdd.setFocusPainted(false);
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeInt(ADD_FRIEND_ACTION);
                        out.writeInt(idUser);
                        out.writeInt(idFriend);
                        out.flush();
                        labelNameFriends.setText("");
                        btnAdd.setText("");

                    } catch (Exception e4) {
                        System.out.println(e4 + "Lỗi kết bạn");
                    }
                }
            });

            panelSearchUser.add(labelNameFriends);
            panelSearchUser.add(btnAdd);
            panelSearchUser.updateUI();

        }
    }

    public static void handleAddFriendAction() throws Exception {
        int result = in.readInt();
        if (result == ADD_FRIEND_SUCCESS){
            JOptionPane.showMessageDialog(null, "Kết Bạn Thành Công!!!");
            labelNameFriends.setText("");
            btnAdd.setText("");
        }
        else if (result == ADD_FRIEND_FAIL){
            JOptionPane.showMessageDialog(null, "Kết Bạn Thất Bại !!!");

        }
    }

    public static void handleLoadFriendListAction() throws Exception{
        int AmountFriends = in.readInt();
        for (int i = 0; i < AmountFriends; i++){
            System.out.println(AmountFriends);
            int idFriend = in.readInt();
            String TenTaiKhoanFriend = in.readUTF();
            String HoTenFriend = in.readUTF();
            //set label and button
            JLabel labelTenTkFriend = new JLabel(TenTaiKhoanFriend);
            JButton btnChat = new JButton("Chat");
            btnChat.setSize(20, 20);
            btnChat.setBackground(Color.BLUE);
            btnChat.setFocusPainted(false);
            btnChat.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeInt(CHAT_ACTION);
                        out.writeInt(idUser);
                        out.writeInt(idFriend);
                        out.flush();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            });
            //add to panelChat
            panelChat.add(labelTenTkFriend);
            panelChat.add(btnChat);

        }
        panelChat.updateUI();

    }

    public static void handleChatAction() throws Exception{
        int success = in.readInt();
        if (success == CHAT_ACTION_SUCESS){
            JFrame frameConverstation = new JFrame("Converstation!!!");
            frameConverstation.setSize(400, 600);
            frameConverstation.setLocationRelativeTo(frameConverstation);
            frameConverstation.setResizable(true);
            frameConverstation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameConverstation.setForeground(Color.orange);
            frameConverstation.setBackground(Color.orange);
            //create panelConversation
            panelConversation = new JPanel()  ;
            BoxLayout boxLayOutConver = new BoxLayout(panelConversation, 1);
            panelConversation.setLayout(boxLayOutConver);
            panelConversation.setBorder(new EmptyBorder(0, 50, 0, 50));
            panelConversation.setBackground(Color.orange);
            //create panelTextChat
            JPanel panelTextChat = new JPanel();
            GridLayout textChatGrid = new GridLayout(1, 2);
            panelTextChat.setLayout(textChatGrid);
            panelTextChat.setBorder(new EmptyBorder(50, 50, 50, 50));
            panelTextChat.setBackground(Color.orange);
            JLabel lbMsg ;
            //read data from server
            int idUser = in.readInt();
            int idFriend =in.readInt();
            int sessionId = in.readInt();
            int amountMessage = in.readInt();
            //count Messsager
            for (int i = 0; i < amountMessage; i++) {
                int idMsg = in.readInt();
                String textMsg = in.readUTF();
                int idSender = in.readInt();

                if (idUser == idSender) {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(200,10));
                    lbMsg.setHorizontalAlignment(SwingConstants.RIGHT);
                    panelConversation.add(lbMsg);

                } else {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(200,10));
                    lbMsg.setHorizontalAlignment(SwingConstants.LEFT);
                    panelConversation.add(lbMsg);
                }
            }

            //create tfMessage and BtnSend

            tfInputMessage = new JTextField("",JTextField.LEFT);
            JButton btnSend = new JButton("Send");
            btnSend.setSize(20,20);
            btnSend.setFocusPainted(false);
            btnSend.setBackground(Color.WHITE);
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeInt(SEND_MESSAGE_ACTION);
                        out.writeInt(sessionId);
                        out.writeUTF(tfInputMessage.getText());
                        out.writeInt(idUser);
                        out.writeInt(idFriend);
                        out.flush();
                        JLabel lbSendMessage = new JLabel(tfInputMessage.getText(), JLabel.RIGHT);
                        lbSendMessage.setHorizontalAlignment(SwingConstants.RIGHT);
                        tfInputMessage.setText("");
                        panelConversation.add(lbSendMessage);
                        panelConversation.updateUI();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

            //panel add to component
            //create JscrollpaneChat
            JScrollPane spChat = new JScrollPane(panelConversation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            spChat.setPreferredSize(new Dimension(200, 200));
            spChat.updateUI();
            panelTextChat.add(btnSend);
            panelTextChat.add(tfInputMessage);


            //frame add to component
            frameConverstation.add(spChat,BorderLayout.CENTER);
            frameConverstation.add(panelTextChat);
            frameConverstation.setLayout(new FlowLayout(1));
            frameConverstation.setVisible(true);
            frameChat.setVisible(false);
        }

    }


    public static void handleReceiverMessage() throws Exception  {
        int Message = in.readInt();
        if (Message == RECEIVED_MESSENGER_NOW ) {
            int idMsg = in.readInt();
            int idSession = in.readInt();
            int idUser = in.readInt();
            String tfInputMsg = in.readUTF();
            JLabel lbReceivedMessage = new JLabel(tfInputMsg, JLabel.LEFT);
            lbReceivedMessage.setHorizontalAlignment(SwingConstants.LEFT);
            panelConversation.add(lbReceivedMessage);
            panelConversation.updateUI();
        }
        else{
            System.out.println("Không gửi được tin nhắn");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        AppMessenger.connection();
        frameLogIn = new JFrame("Orange Messenger");
        frameLogIn.setSize(350, 350);
        frameLogIn.setLocationRelativeTo(frameLogIn);
        frameLogIn.setResizable(true);
        frameLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogIn.setBackground(Color.gray);

        //set panelDangNhap 
        JPanel panleLogIn = new JPanel();

        //set label, textfield and button
        JLabel labelOrangeMess = new JLabel("                  ORANGE--MESS             ", JLabel.CENTER);
        labelOrangeMess.setBackground(Color.orange);
        JLabel labelTenTaiKhoan = new JLabel("Accout", JLabel.LEFT);
        JLabel labelMatKhau = new JLabel("Password", JLabel.LEFT);

        tfTenTaiKhoan = new JTextField("", JTextField.LEFT);
        tfMatKhau = new JTextField("", JTextField.LEFT);

        JButton btnLogIn = new JButton("Đăng Nhập");
        btnLogIn.setFocusPainted(false);
        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Log in action");
                    out.writeInt(LOGIN_ACTION);
                    out.writeUTF(tfTenTaiKhoan.getText());
                    out.writeUTF(tfMatKhau.getText());
                    out.flush();

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

                JFrame frameDangKy = new JFrame("Form Đăng kí Tai Khoan");
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
                JTextField tfTenTK = new JTextField("", JTextField.LEFT);
                JTextField tfMK = new JTextField("", JTextField.LEFT);
                JTextField tfHoTen = new JTextField("", JTextField.LEFT);
                JTextField tfNgaySinh = new JTextField("", JTextField.LEFT);
                JTextField tfGioiTinh = new JTextField("", JTextField.LEFT);
                JTextField tfDiaChi = new JTextField("", JTextField.LEFT);
                JTextField tfQueQuan = new JTextField("", JTextField.LEFT);
                JTextField tfEmail = new JTextField("", JTextField.LEFT);

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
                            out.writeInt(SIGNUP_ACTION);
                            out.writeUTF(tfTenTK.getText());
                            out.writeUTF(tfMK.getText());
                            out.writeUTF(tfHoTen.getText());
                            out.writeUTF(tfNgaySinh.getText());
                            out.writeInt(Integer.parseInt(tfGioiTinh.getText()));
                            out.writeUTF(tfDiaChi.getText());
                            out.writeUTF(tfQueQuan.getText());
                            out.writeUTF(tfEmail.getText());
                            out.flush();

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
                frameDangKy.setLayout(new GridLayout(1, 1));
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
        frameLogIn.setLayout(new GridLayout(1, 1));
        frameLogIn.add(panleLogIn);
        frameLogIn.setVisible(true);
    }

}

class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        try {
            System.out.println("search Friends");
            AppMessenger.frameChat = new JFrame();
            AppMessenger.frameChat.setSize(400, 600);
            AppMessenger.frameChat.setLocationRelativeTo(AppMessenger.frameChat);
            AppMessenger.frameChat.setResizable(true);
            AppMessenger.frameChat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //create panel
            AppMessenger.panelChat = new JPanel();
            BoxLayout boxlayoutChat = new BoxLayout(AppMessenger.panelChat, BoxLayout.Y_AXIS);
            AppMessenger.panelChat.setLayout(boxlayoutChat);
            AppMessenger.panelChat.setBorder(new EmptyBorder(50, 50, 470, 50));
            AppMessenger.panelChat.setBackground(Color.ORANGE);
            //output data
            AppMessenger.out.writeInt(AppMessenger.LOAD_FRIEND_LIST_ACTION);
            AppMessenger.out.writeInt(AppMessenger.idUser);
            AppMessenger.out.flush();

            //set Layout cho FrameChat
            AppMessenger.frameChat.setLayout(new GridLayout(1, 1));

            //add componetn to panel and frame
            AppMessenger.frameChat.add(AppMessenger.panelChat);
            AppMessenger.frameHome.setVisible(false);
            AppMessenger.frameChat.setVisible(true);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}


class ThreadHandleInput extends Thread {

    final static int SIGNUP_ACTION = 1;
    final static int LOGIN_ACTION = 2;
    final static int LOGIN_SUCCESS = 3;
    final static int LOGIN_FALSE = 4;
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int ADD_FRIEND_ACTION = 6;
    final static int SEARCH_ACTION_SUCCESS = 8;
    final static int SEARCH_ACTION_FAIL = 9;
    final static int LOAD_FRIEND_LIST_ACTION = 7;
    final static int CHAT_ACTION = 10;
    final static int CHAT_ACTION_SUCESS = 11;
    final static int CHAT_ACTION_FAIL = 12;
    final static int SEND_MESSAGE_ACTION = 13;
    final static int RECEIVED_MESSAGE_ACTION = 14;
    final static int RECEIVED_MESSENGER_NOW = 15;
    final static int RECEIVED_MESSENGER_LATER = 16;

    DataInputStream in;
    public ThreadHandleInput(DataInputStream in){
        this.in = in;
    }


    public void run(){
        try {
            //take input from server
            while (true){
                if (in.available() > 0) {
                    int action = in.readInt();
                    switch (action) {
                        case SIGNUP_ACTION:
                            AppMessenger.handleSigUpAction();
                            System.out.println("Handle Sig up Action");
                            break;
                        case LOGIN_ACTION:
                            AppMessenger.handleLogInAction();
                            System.out.println("Handle Log In Action");
                            break;
                        case LOAD_USER_lIST_ACTION:
                            AppMessenger.handleLoadUserListAction();
                            System.out.println("Handle Load User List Action");
                            break;
                        case ADD_FRIEND_ACTION:
                            ;
                            AppMessenger.handleAddFriendAction();
                            System.out.println("Handle Add friend Action");
                            break;
                        case LOAD_FRIEND_LIST_ACTION:
                            AppMessenger.handleLoadFriendListAction();
                            System.out.println("Handle Load Friend List Action");
                            break;
                        case CHAT_ACTION:
                            AppMessenger.handleChatAction();
                            System.out.println("Handle Chat Action");
                            break;
                        case RECEIVED_MESSAGE_ACTION:
                            AppMessenger.handleReceiverMessage();
                            System.out.println("Send and Received Message");
                            break;
                    }

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}