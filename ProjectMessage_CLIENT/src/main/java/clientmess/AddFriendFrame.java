package clientmess;

import clientmess.payload.LoadUserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int LOAD_FRIEND_LIST_ACTION =7;
    JFrame homeFrame;
    JPanel panelButton;
    JPanel panelSearchUser;
    JButton btnSearchFriendList;
    JScrollPane spLoadUser;
    JLabel labelNameFriends;
    JButton btnAdd;
    JButton signOutBtn;

    public HomeFrame(){
        homeFrame = new JFrame("Add Friend");
        homeFrame.setSize(400, 600);
        homeFrame.setLocationRelativeTo(homeFrame);
        homeFrame.setResizable(true);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setBackground(Color.gray);
        homeFrame.setForeground(Color.gray);

        //create PanelHome and panel Search Friend
        panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400,50));
        panelButton.setLayout((new FlowLayout()));
//        panelButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelButton.setBackground(Color.GRAY);
        // panel Search Friend
        panelSearchUser = new JPanel();
        panelSearchUser.setPreferredSize(new Dimension(400,50));
        panelSearchUser.setLayout(new FlowLayout(FlowLayout.LEFT));
//        panelSearchUser.setBorder(new EmptyBorder(0, 0, 400, 200));
        panelSearchUser.setBackground(Color.GRAY);

        JLabel lbMsg ;

        signOutBtn = new JButton("Sign Out");
        signOutBtn.setFocusPainted(false);
        signOutBtn.setForeground(Color.gray);
        signOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bạn có muốn đăng xuât ko?");
                homeFrame.setVisible(false);
                AppMessenger.displayLogInFrame();
            }
        });

        btnSearchFriendList = new JButton("Search Friends List");
        btnSearchFriendList.setFocusPainted(false);
        btnSearchFriendList.setForeground(Color.black);
        btnSearchFriendList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppMessenger.displaySearchFriendListFrame();
                homeFrame.setVisible(false);
            }
        });

        JTextField tfSearch = new JTextField("", 20);
//        tfSearch.setPreferredSize(new Dimension(15,15));
        JButton btnSearchUser = new JButton("Search");
        btnSearchUser.setForeground(Color.black);
        btnSearchUser.setFocusPainted(false);
        btnSearchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoadUserRequest loadUserRequest = new LoadUserRequest(LOAD_USER_lIST_ACTION,AppMessenger.idUser,tfSearch.getText());
                    ObjectMapper mapper = new ObjectMapper();
                    String json = mapper.writeValueAsString(loadUserRequest);
                    AppMessenger.out.writeUTF(json);
                    AppMessenger.out.flush();
                } catch (Exception e3) {
                    System.out.println(e3 + " Lỗi Search User");
                }
            }
        });
        //add component to panel home
        panelButton.add(signOutBtn);
        panelButton.add(btnSearchFriendList);
        panelButton.setSize(new Dimension(400,10));
//        panelSearchUser.add(panelButton);
        panelSearchUser.add(tfSearch);
        panelSearchUser.add(btnSearchUser);
        //add panel Load User to scroll panel
        spLoadUser = new JScrollPane(panelSearchUser, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spLoadUser.setPreferredSize(new Dimension(380,550));
        spLoadUser.setBackground(Color.GRAY);
        //add component to frame home
        homeFrame.add(panelButton);
        homeFrame.add(spLoadUser);
        homeFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        homeFrame.setVisible(true);
    }

    public void hide(){
        homeFrame.setVisible(false);
    }

    public static void main(String[] args) {
        HomeFrame homeFrame = new HomeFrame();
    }
}

