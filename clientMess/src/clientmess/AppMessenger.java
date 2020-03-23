/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmess;

import java.awt.*;
import java.net.Socket;

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
//    public static JFrame frameLogIn = null;
//    public static JFrame chatFrame = null;
//    public static JPanel chatPanel = null;
//    public static JTextField tfInputMessage = null;
//    public static JPanel panelConversation = null;
//    public static JFrame frameHome = null;
//    public static JTextField tfTenTK = null;
//    public static JTextField tfMK = null;
//    public static JTextField tfHoTen = null;
//    public static JTextField tfNgaySinh = null;
//    public static JTextField tfGioiTinh = null;
//    public static JTextField tfDiaChi = null;
//    public static JTextField tfQueQuan = null;
//    public static JTextField tfEmail= null;
//    public static JFrame frameConversation =null;
    private static HomeFrame homeFrame;
    private static LogInFrame logInFrame;
    private static ConversationFrame conversationFrame;
    private static  SigUpFrame sigUpFrame;
    private static SearchFriendListFrame searchFriendListFrame;

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
        sigUpFrame.tfTenTK.setText("");
        sigUpFrame.tfMK.setText("");
        sigUpFrame.tfHoTen.setText("");
        sigUpFrame.tfNgaySinh.setText("");
        sigUpFrame.tfGioiTinh.setText("");
        sigUpFrame.tfDiaChi.setText("");
        sigUpFrame.tfQueQuan.setText("");
        sigUpFrame.tfEmail.setText("");
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
            //display home frame and hide login Frame
            homeFrame = new HomeFrame();
            logInFrame.hide();
            //
        }
        else if (LogInResult == LOGIN_FALSE) {
            JOptionPane.showMessageDialog(null, "Nhập sai tài khoản hoặc mật khẩu");
            logInFrame.tfTenTaiKhoan.setText("");
            logInFrame.tfMatKhau.setText("");
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
            homeFrame.labelNameFriends = new JLabel(TenTaiKhoanFriend, JLabel.CENTER);
            homeFrame.labelNameFriends.setSize(20, 20);
            homeFrame.labelNameFriends.updateUI();
            homeFrame.panelSearchUser.updateUI();
            //set lable

            homeFrame.btnAdd = new JButton("Add Friend");
            homeFrame.btnAdd.setBackground(Color.gray);

            //set button
            homeFrame.btnAdd.setBackground(Color.gray);
            homeFrame.btnAdd.setFocusPainted(false);
            homeFrame.btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        out.writeInt(ADD_FRIEND_ACTION);
                        out.writeInt(idUser);
                        out.writeInt(idFriend);
                        out.flush();
                        homeFrame.labelNameFriends.setText("");
                        homeFrame.btnAdd.setText("");

                    } catch (Exception e4) {
                        System.out.println(e4 + "Lỗi kết bạn");
                    }
                }
            });

            homeFrame.panelSearchUser.add(homeFrame.labelNameFriends);
            homeFrame.panelSearchUser.add(homeFrame.btnAdd);
            homeFrame.panelSearchUser.updateUI();

        }
    }

    public static void handleAddFriendAction() throws Exception {
        int result = in.readInt();
        if (result == ADD_FRIEND_SUCCESS){
            JOptionPane.showMessageDialog(null, "Kết Bạn Thành Công!!!");
            homeFrame.labelNameFriends.setText("");
            homeFrame.btnAdd.setText("");
        }
        else if (result == ADD_FRIEND_FAIL){
            JOptionPane.showMessageDialog(null, "Kết Bạn Thất Bại !!!");

        }
    }

    public static void handleLoadFriendListAction() throws Exception{
        int AmountFriends = in.readInt();
        for (int i = 0; i < AmountFriends; i++){
            System.out.println("Amount Friends "+AmountFriends);
            int idFriend = in.readInt();
            String TenTaiKhoanFriend = in.readUTF();
            String HoTenFriend = in.readUTF();
            //set label and button
            searchFriendListFrame.labelTenTkFriend = new JLabel(TenTaiKhoanFriend);
            searchFriendListFrame.btnChat = new JButton("Chat");
            searchFriendListFrame.btnChat.setSize(20, 20);
            searchFriendListFrame. btnChat.setBackground(Color.BLUE);
            searchFriendListFrame.btnChat.setFocusPainted(false);
            searchFriendListFrame.btnChat.addActionListener(new ActionListener() {
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
            searchFriendListFrame.searchFriendListPanel.add(searchFriendListFrame.labelTenTkFriend);
            searchFriendListFrame.searchFriendListPanel.add(searchFriendListFrame.btnChat);

        }
        searchFriendListFrame.searchFriendListPanel.updateUI();
    }

    public static void handleChatAction() throws Exception{
        int success = in.readInt();
        if (success == CHAT_ACTION_SUCESS){
            conversationFrame = new ConversationFrame();
            searchFriendListFrame.hide();
        }
        else {
            JOptionPane.showMessageDialog(null,"Can not Chat");
        }

    }

    public static void handleReceiverMessage() throws Exception  {
        int Message = in.readInt();
        if (Message == RECEIVED_MESSENGER_NOW ) {
            int idMsg = in.readInt();
            int idSession = in.readInt();
            int idUser = in.readInt();
            String tfInputMsg = in.readUTF();
            conversationFrame.lbReceivedMessage = new JLabel(tfInputMsg, JLabel.LEFT);
            conversationFrame.panelConversation.add(conversationFrame.lbReceivedMessage);
            conversationFrame.lbReceivedMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
            conversationFrame.panelConversation.updateUI();
        }
        else{
            System.out.println("Không nhan được tin nhắn");
        }
    }

    public static void displaySigUpFrame(){
        sigUpFrame = new SigUpFrame();
    }
    public static void displayLogInFrame(){
        logInFrame = new LogInFrame();
    }
    public static void displayLHomeFrame(){
        homeFrame = new HomeFrame();
    }
    public static void displaySearchFriendListFrame(){
        searchFriendListFrame = new SearchFriendListFrame();
    }
    public static void displayConversationFrame(){
        conversationFrame = new ConversationFrame();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        AppMessenger.connection();
        logInFrame = new LogInFrame();

    }

}
//here another way to use ActionListener when your code so length
//class SearchFriendListFrame implements ActionListener {
//    JFrame searchFriendListFrame;
//    JPanel searchFriendListPanel;
//    JLabel labelTenTkFriend;
//         JButton btnChat;
//    final int LOAD_FRIEND_LIST_ACTION = 7;
//    public void actionPerformed(ActionEvent e) {
//        try {
//            System.out.println("search Friends");
//            searchFriendListFrame = new JFrame("Friend List");
//            searchFriendListFrame.setSize(400, 600);
//            searchFriendListFrame.setLocationRelativeTo(searchFriendListFrame);
//            searchFriendListFrame.setResizable(true);
//            searchFriendListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            //create panel
//            searchFriendListPanel = new JPanel();
//            BoxLayout boxlayoutChat = new BoxLayout(searchFriendListPanel, BoxLayout.Y_AXIS);
//            searchFriendListPanel.setLayout(boxlayoutChat);
//            searchFriendListPanel.setBorder(new EmptyBorder(50, 50, 470, 50));
//            searchFriendListPanel.setBackground(Color.ORANGE);
//            //output data
//            AppMessenger.out.writeInt(LOAD_FRIEND_LIST_ACTION);
//            AppMessenger.out.writeInt(AppMessenger.idUser);
//            AppMessenger.out.flush();
//
//            //set Layout cho FrameChat
//            searchFriendListFrame.setLayout(new GridLayout(1, 1));
//
//            //add componetn to panel and frame
//            searchFriendListFrame.add(searchFriendListPanel);
//            searchFriendListFrame.setVisible(true);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    public void hide() {
//        searchFriendListFrame.setVisible(false);
//    }
//}


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
                            System.out.println("Handle Sig up Action");
                            AppMessenger.handleSigUpAction();
                            break;
                        case LOGIN_ACTION:
                            System.out.println("Handle Log In Action");
                            AppMessenger.handleLogInAction();
                            break;
                        case LOAD_USER_lIST_ACTION:
                            System.out.println("Handle Load User List Action");
                            AppMessenger.handleLoadUserListAction();
                            break;
                        case ADD_FRIEND_ACTION:
                            System.out.println("Handle Add friend Action");
                            AppMessenger.handleAddFriendAction();
                            break;
                        case LOAD_FRIEND_LIST_ACTION:
                            System.out.println("Handle Load Friend List Action");
                            AppMessenger.handleLoadFriendListAction();
                            break;
                        case CHAT_ACTION:
                            System.out.println("Handle Chat Action");
                            AppMessenger.handleChatAction();
                            break;
                        case RECEIVED_MESSAGE_ACTION:
                            System.out.println("Send and Received Message");
                            AppMessenger.handleReceiverMessage();
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