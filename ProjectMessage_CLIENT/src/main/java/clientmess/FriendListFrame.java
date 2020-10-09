package clientmess;

import clientmess.payload.ChatRequest;
import clientmess.payload.LoadFriendRequest;
import clientmess.payload.LoadFriendRespond;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FriendListFrame {
     JFrame searchFriendListFrame;
     JPanel searchFriendListPanel;
    JPanel panelButton;
    JScrollPane spLoadUser;
     JButton backToHome;
     final int LOAD_FRIEND_LIST_ACTION = 7;
     final int LOAD_FRIEND_LIST_ACTION_TO_CREATE_GROUP = 70;
     final int CHAT_ACTION = 10;
     public FriendListFrame() {

         System.out.println("search Friends");
         searchFriendListFrame = new JFrame("Friend List");
         searchFriendListFrame.setSize(400, 600);
         searchFriendListFrame.setLocationRelativeTo(searchFriendListFrame);
         searchFriendListFrame.setResizable(true);
         searchFriendListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //
         //create PanelHome and panel Search Friend
         panelButton = new JPanel();
         panelButton.setPreferredSize(new Dimension(400,50));
         panelButton.setLayout((new FlowLayout(FlowLayout.LEFT)));
         panelButton.setBackground(Color.GRAY);
         //create button back to home
         backToHome = new JButton("Back to home");
         backToHome.setFocusPainted(false);
         backToHome.setForeground(Color.gray);
         backToHome.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 searchFriendListFrame.setVisible(false);
                 AppMessenger.displayAddFriendFrame();
             }
         });
         //create panel
         searchFriendListPanel = new JPanel();
         searchFriendListPanel.setPreferredSize(new Dimension(380,50));
         searchFriendListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
         searchFriendListPanel.setBackground(Color.gray);

         //
         spLoadUser = new JScrollPane(searchFriendListPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         spLoadUser.setPreferredSize(new Dimension(380,450));
         spLoadUser.setBackground(Color.GRAY);
         //set Layout cho FrameChat
         searchFriendListFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

         //add component to panel and frame
         panelButton.add(backToHome);
         searchFriendListFrame.add(panelButton);
         searchFriendListFrame.add(spLoadUser);
         searchFriendListFrame.setVisible(true);

     }
     public void displayFriendList(List<LoadFriendRespond.LoadFriend> loadFriendList){
         for (LoadFriendRespond.LoadFriend loadFriend : loadFriendList){

            System.out.println("Amount Friends "+loadFriendList.size());
            int idFriend = loadFriend.getIdUser();
            String TenTaiKhoanFriend = loadFriend.getTenTaiKhoan();
            String HoTenFriend = loadFriend.getHoTen();
            //set label and button
            System.out.println("searchFriendListFrame" );
            System.out.println("TenTaiKhoanFriend" + TenTaiKhoanFriend);
            JLabel labelTenTkFriend = new JLabel(TenTaiKhoanFriend);
            labelTenTkFriend.setPreferredSize(new Dimension(200,50));
            JButton btnChat = new JButton("CHAT");
//            btnChat.setSize(20, 20);
            btnChat.setForeground(Color.black);
            btnChat.setFocusPainted(false);
            btnChat.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ChatRequest chatRequest = new ChatRequest(CHAT_ACTION,AppMessenger.idUser,idFriend,TenTaiKhoanFriend);
                        String json = AppMessenger.mapper.writeValueAsString(chatRequest);
                        AppMessenger.out.writeUTF(json);
                        AppMessenger.out.flush();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }

                }
            });
            //add to panelChat
             //create panel

            searchFriendListPanel.add(labelTenTkFriend);
            searchFriendListPanel.add(btnChat);
             searchFriendListPanel.updateUI();

        }
        searchFriendListPanel.updateUI();


     }
     public void hide() {
         searchFriendListFrame.setVisible(false);
     }
     public void sendData(){
         //output data
         try {
             LoadFriendRequest load_friend_request = new LoadFriendRequest(LOAD_FRIEND_LIST_ACTION,AppMessenger.idUser);
             ObjectMapper mapper = new ObjectMapper();
             String json = mapper.writeValueAsString(load_friend_request);
             AppMessenger.out.writeUTF(json);
             AppMessenger.out.flush();
         } catch (Exception e2) {
             e2.printStackTrace();
             System.out.println("Lỗi search Friend List");
         }
     }
     public void sendDataToCreateGroup(){
         //output data
         try {
             LoadFriendRequest load_friend_request = new LoadFriendRequest(LOAD_FRIEND_LIST_ACTION_TO_CREATE_GROUP,AppMessenger.idUser);
             ObjectMapper mapper = new ObjectMapper();
             String json = mapper.writeValueAsString(load_friend_request);
             AppMessenger.out.writeUTF(json);
             AppMessenger.out.flush();
         } catch (Exception e2) {
             e2.printStackTrace();
             System.out.println("Lỗi search Friend List");
         }
     }

     public static void main(String[] args) {
         FriendListFrame friendListFrame = new FriendListFrame();
         List<LoadFriendRespond.LoadFriend> loadFriendList = new ArrayList<>();

         for(int i= 0; i<100; i++){
             LoadFriendRespond.LoadFriend loadFriend = new LoadFriendRespond.LoadFriend(1,"ds","sdf");
             loadFriendList.add(loadFriend);
         }
         friendListFrame.displayFriendList(loadFriendList);
     }
 }
