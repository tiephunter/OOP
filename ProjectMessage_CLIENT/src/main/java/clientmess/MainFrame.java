package clientmess;

import clientmess.payload.LoadGroupListRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private int idUser;

    JFrame chatListFrame;
    JPanel othersFunctionPanel;
    JPanel searchPanel;
    JPanel chatListPanel;
    JButton addFriendBtn;
    JButton createGroupBtn;
    JButton signOutBtn;
    JTextField searchChatNameTF;
    JButton searchChatNameBtn;
    JScrollPane loadSessionSP;
    JButton groupBtn;

    final static int LOAD_GROUP_ACTION = 18;
    public MainFrame(int idUser){
        this.idUser = idUser;
        chatListFrame = new JFrame("Home ");
        chatListFrame.setSize(500, 600);
        chatListFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        chatListFrame.setLocationRelativeTo(chatListFrame);
        chatListFrame.setResizable(false);
        chatListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatListFrame.setBackground(Color.gray);
        chatListFrame.setForeground(Color.gray);
        //panel text chat name
        othersFunctionPanel = new JPanel();
        othersFunctionPanel.setPreferredSize(new Dimension(500, 50));
        othersFunctionPanel.setLayout((new FlowLayout(FlowLayout.LEFT)));
        othersFunctionPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        othersFunctionPanel.setBackground(Color.blue);

        searchPanel = new JPanel();
        searchPanel.setLayout((new FlowLayout()));
        searchPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        searchPanel.setBackground(Color.GRAY);
        // panel Chat Name List
        chatListPanel = new JPanel();
        BoxLayout LayoutpanelSearchUser = new BoxLayout(chatListPanel, BoxLayout.Y_AXIS);
        chatListPanel.setLayout(LayoutpanelSearchUser);
        chatListPanel.setBorder(new EmptyBorder(0, 0, 400, 200));
        chatListPanel.setBackground(Color.GRAY);
        //create sign out button
        signOutBtn = new JButton("Sign Out");
        signOutBtn.setFocusPainted(false);
        signOutBtn.setForeground(Color.gray);
        signOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bạn có muốn đăng xuât ko?");
                chatListFrame.setVisible(false);
                AppMessenger.displayLogInFrame();
            }
        });
        //Add Friend Button
        addFriendBtn = new JButton("Add Friend");
        addFriendBtn.setFocusPainted(false);
        addFriendBtn.setForeground(Color.gray);
        addFriendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                chatListFrame.setVisible(false);
                AppMessenger.displayLHomeFrame();
            }
        });

        createGroupBtn = new JButton("Create Group");
        createGroupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppMessenger.displaySearchFriendListFrameToCreateGroup();
                chatListFrame.setVisible(false);
            }
        });
        groupBtn = new JButton("Group");
        groupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //List Group
                try {
                    LoadGroupListRequest loadGroupListRequest = new LoadGroupListRequest(LOAD_GROUP_ACTION,idUser);
                    String json = AppMessenger.mapper.writeValueAsString(loadGroupListRequest);
                    AppMessenger.out.writeUTF(json);
                    AppMessenger.out.flush();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        //create text field search chat name and Button
        searchChatNameTF = new JTextField("", 30);
        searchChatNameTF.setHorizontalAlignment(JTextField.LEFT);

        // searchChatNamePanel add component
        othersFunctionPanel.add(addFriendBtn);
        othersFunctionPanel.add(createGroupBtn);
        othersFunctionPanel.add(signOutBtn);

        searchPanel.add(searchChatNameTF);
        //add panel Load User to scroll panel
        loadSessionSP = new JScrollPane(searchPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        loadSessionSP.setPreferredSize(new Dimension(380,550));
        loadSessionSP.setBackground(Color.GRAY);

        //frame add panel
        chatListFrame.add(othersFunctionPanel);
        chatListFrame.add(searchPanel);
        chatListFrame.setVisible(true);
    }

//    public static void main(String[] args) throws InterruptedException {
//        ChatListFrame chatListFrame = new ChatListFrame();
//        Thread.sleep(5000);
//    }
}
