package clientmess;

import clientmess.payload.AddFriendRequest;
import clientmess.payload.LoadUserRequest;
import clientmess.payload.LoadUserRespond;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static clientmess.AppMessenger.ADD_FRIEND_ACTION;
import static clientmess.AppMessenger.idUser;

public class AddFriendFrame {
    final static int LOAD_USER_lIST_ACTION = 5;
    final static int LOAD_FRIEND_LIST_ACTION =7;
    JFrame AddFriendFrame;
    JPanel panelButton;
    JPanel panelSearchUser;
    JButton btnSearchFriendList;
    JScrollPane spLoadUser;
    JButton signOutBtn;


    public AddFriendFrame(){
        AddFriendFrame = new JFrame("Add Friend");
        AddFriendFrame.setSize(400, 600);
        AddFriendFrame.setLocationRelativeTo(AddFriendFrame);
        AddFriendFrame.setResizable(true);
        AddFriendFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddFriendFrame.setBackground(Color.gray);
        AddFriendFrame.setForeground(Color.gray);

        //create PanelHome and panel Search Friend
        panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(400,100));
        panelButton.setLayout((new FlowLayout()));
        panelButton.setBackground(Color.GRAY);
        // panel Search Friend
        panelSearchUser = new JPanel();
        panelSearchUser.setPreferredSize(new Dimension(400,50));
        panelSearchUser.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelSearchUser.setBackground(Color.GRAY);

        JLabel lbMsg ;

        signOutBtn = new JButton("Back to home");
        signOutBtn.setFocusPainted(false);
        signOutBtn.setForeground(Color.gray);
        signOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFriendFrame.setVisible(false);
                AppMessenger.displayLMainFrame();
            }
        });

        btnSearchFriendList = new JButton("Search Friends List");
        btnSearchFriendList.setFocusPainted(false);
        btnSearchFriendList.setForeground(Color.black);
        btnSearchFriendList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppMessenger.displaySearchFriendListFrame();
                AddFriendFrame.setVisible(false);
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
//        panelSearchUser.add(panelButton);
        panelButton.add(tfSearch);
        panelButton.add(btnSearchUser);
        //add panel Load User to scroll panel
        spLoadUser = new JScrollPane(panelSearchUser, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spLoadUser.setPreferredSize(new Dimension(380,450));
        spLoadUser.setBackground(Color.GRAY);
        //add component to frame home
        AddFriendFrame.add(panelButton);
        AddFriendFrame.add(spLoadUser);
        AddFriendFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        AddFriendFrame.setVisible(true);
    }

    public void displayUserList(List<LoadUserRespond.LoadUser> loadUserList) {
        panelSearchUser.removeAll();

        for (LoadUserRespond.LoadUser loadUser: loadUserList){
            JPanel userPanel = new JPanel();
            userPanel.setPreferredSize(new Dimension(400, 50));
            JLabel userNameLabel = new JLabel(loadUser.getNameFriend());
            userNameLabel.setPreferredSize(new Dimension(200, 50));

            JButton btnAdd = new JButton("Add Friend");
            btnAdd.setBackground(Color.gray);

            //set button
            btnAdd.setFocusPainted(false);
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        AddFriendRequest addFriendRequest = new AddFriendRequest(ADD_FRIEND_ACTION, idUser, loadUser.getIdFriend(), loadUser.getNameFriend());
                        String json = AppMessenger.mapper.writeValueAsString(addFriendRequest);
                        AppMessenger.out.writeUTF(json);
                        AppMessenger.out.flush();
                        btnAdd.setEnabled(false);
                    } catch (Exception e4) {
                        System.out.println(e4 + "Lỗi kết bạn");
                    }
                }
            });

            userPanel.add(userNameLabel);
            userPanel.add(btnAdd);
            panelSearchUser.add(userPanel);
            panelSearchUser.updateUI();
        }

    }

    public void hide(){
        AddFriendFrame.setVisible(false);
    }

    public static void main(String[] args) {
        AddFriendFrame addFriendFrame = new AddFriendFrame();
        List<LoadUserRespond.LoadUser> loadUsers = new ArrayList<>();
        loadUsers.add(new LoadUserRespond.LoadUser(1, "ahahahaa"));
        addFriendFrame.displayUserList(loadUsers);


    }
}

