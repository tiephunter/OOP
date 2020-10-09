package clientmess;

import clientmess.payload.ChatGroupRequest;
import clientmess.payload.LoadGroupListRespond;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GroupFrame {
    JFrame groupListFrame;
    JPanel groupListPanel;
    JPanel btnPanel;
    JButton sessionNameBtn;
    JButton backToHome;
    List<LoadGroupListRespond.Group> groupList;
    final static int CHAT_GROUP_ACTION = 19;

    public GroupFrame(List<LoadGroupListRespond.Group> groupList1){
        this.groupList = groupList1;

        System.out.println("Group Frame");
        groupListFrame = new JFrame("Group List");
        groupListFrame.setSize(400, 600);
        groupListFrame.setLocationRelativeTo(groupListFrame);
        groupListFrame.setResizable(true);
        groupListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create groupList panel
        groupListPanel = new JPanel();
        groupListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        groupListPanel.setBackground(Color.gray);
        //create BtnPanel
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        btnPanel.setBackground(Color.gray);
        //create button back to home
        backToHome = new JButton("Back to home");
        backToHome.setFocusPainted(false);
        backToHome.setForeground(Color.gray);
        backToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupListFrame.setVisible(false);
                AppMessenger.displayLMainFrame();

            }
        });
        //create session name button
        for (LoadGroupListRespond.Group group : groupList){
            String sessionName = group.getSessionName();
            sessionNameBtn = new JButton(sessionName);
            System.out.println("session name"+sessionName);
            sessionNameBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ChatGroupRequest chatGroupRequest = new ChatGroupRequest(CHAT_GROUP_ACTION,group.getIdUser(),group.getIdSession(),group.getSessionName());
                        String json = AppMessenger.mapper.writeValueAsString(chatGroupRequest);
                        AppMessenger.out.writeUTF(json);
                        AppMessenger.out.flush();

                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            });
            groupListPanel.add(sessionNameBtn);
        }



        //set Layout cho FrameChat
        groupListFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        //add component to panel and frame
        btnPanel.add(backToHome);
        groupListPanel.add(btnPanel);
        groupListFrame.add(groupListPanel);
        groupListFrame.setVisible(true);
        System.out.println("End Group Frame");
    }
    public void hide(){
        groupListFrame.setVisible(false);
    }
}
