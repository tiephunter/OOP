package clientmess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

public class HomeFrame {
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int LOAD_FRIEND_LIST_ACTION =7;
    JFrame homeFrame;
    JPanel panelHome;
    JPanel panelSearchUser;
    JButton btnSearchFriendList;
    JScrollPane spLoadUser;
    JLabel labelNameFriends;
    JButton btnAdd;

    public HomeFrame(){
        homeFrame = new JFrame("Homer");
        homeFrame.setSize(400, 600);
        homeFrame.setLocationRelativeTo(homeFrame);
        homeFrame.setResizable(true);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setBackground(Color.gray);
        homeFrame.setForeground(Color.gray);

        //create PanelHome and panel Search Friend
        panelHome = new JPanel();
        BoxLayout LayoutpanelHome = new BoxLayout(panelHome, BoxLayout.Y_AXIS);
        panelHome.setLayout(LayoutpanelHome);
        panelHome.setBorder(new EmptyBorder(100, 100, 100, 100));
        panelHome.setBackground(Color.GRAY);
        // panel Search Friend
        panelSearchUser = new JPanel();
        BoxLayout boxPanelSearchUser = new BoxLayout(panelSearchUser, BoxLayout.Y_AXIS);
        panelSearchUser.setLayout(boxPanelSearchUser);
        panelSearchUser.setBorder(new EmptyBorder(0, 150, 150, 50));
        panelSearchUser.setBackground(Color.GRAY);

        JLabel lbMsg ;


        btnSearchFriendList = new JButton("Search Friends List");
        btnSearchFriendList.setFocusPainted(false);
        btnSearchFriendList.setBackground(Color.ORANGE);
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
        panelHome.add(btnSearchFriendList);
        panelHome.add(btnSearchUser);
        panelHome.add(tfSearch);
        //add panel Load User to scroll panel
        spLoadUser = new JScrollPane(panelSearchUser, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spLoadUser.setPreferredSize(new Dimension(300,400));
        spLoadUser.setBackground(Color.GRAY);
        //add component to frame home
        homeFrame.add(panelHome);
        homeFrame.add(spLoadUser);
        homeFrame.setLayout(new GridLayout(2,1));

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

