package clientmess;

import clientmess.payload.CreateGroupRequest;
import clientmess.payload.LoadFriendGroupRespond;
import clientmess.payload.LoadFriendRequest;
import clientmess.payload.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateGroupFrame {

    JFrame CreateGroupFrame;
    JPanel btnPanel;
    JButton backToHome;
    JPanel friendListPanel;
    JLabel labelTenTkFriend;
    JButton btnAddToGroup;
    JScrollPane friendGroupSp;
    JButton btnCreateGroup;

    final int LOAD_FRIEND_LIST_ACTION = 7;
    final int LOAD_FRIEND_LIST_ACTION_TO_CREATE_GROUP = 70;
    final static int CREATE_GROUP_ACTION = 17;

    public CreateGroupFrame() {

        System.out.println("");
        //create Frame
        CreateGroupFrame = new JFrame("Create Group ");
        CreateGroupFrame.setSize(400, 600);
        CreateGroupFrame.setLocationRelativeTo(CreateGroupFrame);
        CreateGroupFrame.setResizable(true);
        CreateGroupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Layout cho FrameChat
        CreateGroupFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        //create panel
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnPanel.setPreferredSize(new Dimension(400, 50));
        btnPanel.setBorder(new EmptyBorder(0,0,0,20));
        btnPanel.setBackground(Color.white);
        //
        friendListPanel = new JPanel();
//        friendListPanel.setPreferredSize(new Dimension(380,500));
        friendListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        friendListPanel.setBackground(Color.white);
        //
        friendGroupSp = new JScrollPane(friendListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        friendGroupSp.setPreferredSize(new Dimension(380, 500));
        friendGroupSp.setBackground(Color.white);
        //create button back to home
        backToHome = new JButton("< Back");
        backToHome.setFocusPainted(false);
        backToHome.setBackground(Color.white);
        backToHome.setForeground(new java.awt.Color(0 ,191 ,255));
        backToHome.setBorder(new RoundedBorder(10));
        backToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateGroupFrame.setVisible(false);
                AppMessenger.displayLMainFrame();
            }
        });

        //add component to panel and frame
        btnPanel.add(backToHome);
//        friendListPanel.add(btnCreateGroup);
        CreateGroupFrame.add(btnPanel);
        CreateGroupFrame.add(friendListPanel);
        CreateGroupFrame.setVisible(true);

    }

    public void hide() {
        CreateGroupFrame.setVisible(false);
    }

    public void sendDataToCreateGroup() {
        //output data
        try {
            LoadFriendRequest load_friend_request = new LoadFriendRequest(LOAD_FRIEND_LIST_ACTION_TO_CREATE_GROUP, AppMessenger.idUser);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(load_friend_request);
            AppMessenger.out.writeUTF(json);
            AppMessenger.out.flush();
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("Lỗi search Friend List");
        }
    }

    public void displayCreate(LoadFriendGroupRespond loadFriendGroupRespond) {
        //fetch data
//            JButton btnCreateGroup;
//            friendListPanel.removeAll();
        int idUser = loadFriendGroupRespond.getIdUser();
        String UserName = loadFriendGroupRespond.getAccountName();
        ArrayList<Member> memberList = new ArrayList<>();
        Member member = new Member(idUser, UserName);
        memberList.add(member);
        List<LoadFriendGroupRespond.LoadFriend> loadFriendList = loadFriendGroupRespond.getLoadFriendList();
        int width = 380;
        int height = 250;
        for (LoadFriendGroupRespond.LoadFriend loadFriend : loadFriendList) {
            //
            height += 50;
            System.out.println("Amount Friends " + loadFriendList.size());
            int idFriend = loadFriend.getIdFriend();
            String TenTaiKhoanFriend = loadFriend.getAccountName();
            String HoTenFriend = loadFriend.getFriendName();
            //
            JPanel friendPanel = new JPanel();
            friendPanel.setPreferredSize(new Dimension(380, 50));
            friendPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            friendPanel.setBackground(Color.white);
            //set label and button
            System.out.println("Create Group");
            System.out.println("TenTaiKhoanFriend" + TenTaiKhoanFriend);
            labelTenTkFriend = new JLabel(TenTaiKhoanFriend);
            labelTenTkFriend.setBackground(Color.white);
            labelTenTkFriend.setForeground(new java.awt.Color(0 ,191 ,255));
            labelTenTkFriend.setBorder(new RoundedBorder(10));
            //action create group button
            btnAddToGroup = new JButton("Add to Gr");
            btnAddToGroup.setSize(20, 20);
            btnAddToGroup.setBackground(new java.awt.Color(0 ,191 ,255));
            btnAddToGroup.setForeground(Color.black);
            btnAddToGroup.setBorder(new RoundedBorder(10));
            btnAddToGroup.setFocusPainted(false);
            btnAddToGroup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Member member = new Member(idFriend, TenTaiKhoanFriend);
                        memberList.add(member);
                        btnAddToGroup.setEnabled(false);

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            });
            friendPanel.add(labelTenTkFriend);
            friendPanel.add(btnAddToGroup);
            friendListPanel.add(friendPanel);
        }
        friendListPanel.setPreferredSize(new Dimension(width, height));
        friendListPanel.revalidate();
        friendListPanel.repaint();

        btnCreateGroup = new JButton("Create Group");
        btnCreateGroup.setBackground( new java.awt.Color (185 ,211 ,238));
        btnCreateGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CreateGroupRequest createGroupRequest = new CreateGroupRequest(CREATE_GROUP_ACTION, memberList);
                    String json = AppMessenger.mapper.writeValueAsString(createGroupRequest);
                    AppMessenger.out.writeUTF(json);
                    AppMessenger.out.flush();
                    System.out.println("gửi yêu cầu add gr");
                } catch (Exception e1) {
                    System.out.println("Exception chat group");
                    e1.printStackTrace();
                }
            }
        });

        friendListPanel.add(btnCreateGroup);
//            friendListPanel.updateUI();
//            CreateGroupFrame.add(friendListPanel);
        CreateGroupFrame.setVisible(true);

    }
    public static void main(String[] args) {

        LoadFriendGroupRespond loadFriendGroupRespond = new LoadFriendGroupRespond();
        loadFriendGroupRespond.setIdUser(1);
        loadFriendGroupRespond.setAccountName("sf");
        loadFriendGroupRespond.setLoadFriendList(new ArrayList<>());
        for (int i=0; i<10; i++){
            LoadFriendGroupRespond.LoadFriend loadFriend = new LoadFriendGroupRespond.LoadFriend(1,"sfdsgfdsgfdsgsfd","dsf");
            loadFriendGroupRespond.getLoadFriendList().add(loadFriend);
        }

        CreateGroupFrame createGroupFrame = new CreateGroupFrame();
        createGroupFrame.displayCreate(loadFriendGroupRespond);
    }
    class RoundedBorder implements Border {
        int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        public boolean isBorderOpaque() {
            return true;
        }
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }
}