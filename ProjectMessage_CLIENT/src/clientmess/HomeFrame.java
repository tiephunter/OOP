package clientmess;

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
        homeFrame = new JFrame("Lobby");
        homeFrame.setSize(400, 600);
        homeFrame.setLocationRelativeTo(homeFrame);
        homeFrame.setResizable(true);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setBackground(Color.gray);
        homeFrame.setForeground(Color.gray);

        //create PanelHome and panel Search Friend
        panelButton = new JPanel();
        panelButton.setLayout((new FlowLayout()));
        panelButton.setBorder(new EmptyBorder(50, 0, 50, 150));
        panelButton.setBackground(Color.GRAY);
        // panel Search Friend
        panelSearchUser = new JPanel();
        BoxLayout LayoutpanelSearchUser = new BoxLayout(panelSearchUser, BoxLayout.Y_AXIS);
        panelSearchUser.setLayout(LayoutpanelSearchUser);
        panelSearchUser.setBorder(new EmptyBorder(0, 0, 400, 200));
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
//        btnSearchFriendList.addActionListener(new SearchFriendListFrame());
        //create tfSearch and btn search
        JTextField tfSearch = new JTextField("");
//        tfSearch.setPreferredSize(new Dimension(15,15));
        JButton btnSearchUser = new JButton("Search User");
        btnSearchUser.setForeground(Color.black);
        btnSearchUser.setFocusPainted(false);
        btnSearchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AppMessenger.out.writeInt(LOAD_USER_lIST_ACTION);
                    AppMessenger.out.writeInt(AppMessenger.idUser);
                    AppMessenger.out.writeUTF(tfSearch.getText());
                    System.out.println(tfSearch.getText());
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
        panelSearchUser.add(btnSearchUser,BorderLayout.EAST);
        //add panel Load User to scroll panel
        spLoadUser = new JScrollPane(panelSearchUser, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spLoadUser.setPreferredSize(new Dimension(380,400));
        spLoadUser.setBackground(Color.GRAY);
        //add component to frame home
//        homeFrame.add(panelHome);
        homeFrame.add(panelButton);
        homeFrame.add(spLoadUser);
        homeFrame.setLayout(new FlowLayout());
        homeFrame.setVisible(true);
    }

    public void hide(){
        homeFrame.setVisible(false);
    }
}
//class SearchFriendListFrame implements ActionListener {
//    JFrame searchFriendListFrame;
//    JPanel searchFriendListPanel;
//    JLabel labelTenTkFriend;
//    JButton btnChat;
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
//    public void hide() {
//         searchFriendListFrame.setVisible(false);
//     }
//}

