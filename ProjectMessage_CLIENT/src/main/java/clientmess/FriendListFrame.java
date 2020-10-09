package clientmess;

import clientmess.payload.LoadFriendRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 public class FriendListFrame {
     JFrame searchFriendListFrame;
     JPanel searchFriendListPanel;
     JLabel labelTenTkFriend;
     JButton btnChat;
     JButton backToHome;
     final int LOAD_FRIEND_LIST_ACTION = 7;
     final int LOAD_FRIEND_LIST_ACTION_TO_CREATE_GROUP = 70;

     public FriendListFrame() {

         System.out.println("search Friends");
         searchFriendListFrame = new JFrame("Friend List");
         searchFriendListFrame.setSize(400, 600);
         searchFriendListFrame.setLocationRelativeTo(searchFriendListFrame);
         searchFriendListFrame.setResizable(true);
         searchFriendListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //create button back to home
         backToHome = new JButton("Back to home");
         backToHome.setFocusPainted(false);
         backToHome.setForeground(Color.gray);
         backToHome.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 searchFriendListFrame.setVisible(false);
                 AppMessenger.displayLHomeFrame();
             }
         });
         //create panel
         searchFriendListPanel = new JPanel();
         BoxLayout boxlayoutChat = new BoxLayout(searchFriendListPanel, BoxLayout.Y_AXIS);
         searchFriendListPanel.setLayout(boxlayoutChat);
         searchFriendListPanel.setBorder(new EmptyBorder(50, 50, 470, 50));
         searchFriendListPanel.setBackground(Color.gray);

         //set Layout cho FrameChat
         searchFriendListFrame.setLayout(new GridLayout(1, 1));

         //add component to panel and frame
         searchFriendListPanel.add(backToHome);
         searchFriendListFrame.add(searchFriendListPanel);
         searchFriendListFrame.setVisible(true);

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
     }
 }
