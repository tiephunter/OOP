package clientmess;

import clientmess.payload.ChatMessage;
import clientmess.payload.ChatRespond;
import clientmess.payload.SendMessageRequest;
import clientmess.payload.SendMessageRespond;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConversationFrame {
    JFrame frameConversation;
    JPanel panelBackBtn;
    JPanel panelConversation;
    JTextField tfInputMessage;
    JScrollPane spChat;
    JLabel lbReceivedMessage;
    JPanel panelTextChat;
    JButton btnSend;
    JButton backToHome;
    JFileChooser fileDialog;
    Mess message;
      int height = 0;
      int width = 380;

    public ConversationFrame(ChatRespond chatRespond) {
        try {

            //read data from server
            int idUser = chatRespond.getIdUser();
            int idFriend = chatRespond.getIdFriend();
            String tenTaiKhoanFriend = chatRespond.getTenTaiKhoanFriend();
            frameConversation = new JFrame(tenTaiKhoanFriend);
            frameConversation.setSize(400, 600);
            frameConversation.setLocationRelativeTo(frameConversation);
            frameConversation.setResizable(true);
            frameConversation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameConversation.setBackground(Color.gray);
            frameConversation.setForeground(Color.gray);
            //
            panelBackBtn = new JPanel();
            panelBackBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelBackBtn.setPreferredSize(new Dimension(400, 50));
            panelBackBtn.setBackground(Color.white);
            //create panelConversation
            panelConversation = new JPanel();
            panelConversation.setLayout(new FlowLayout());
            panelConversation.setBackground(Color.white);
            //create panelTextChat
            panelTextChat = new JPanel();
            panelTextChat.setLayout(new FlowLayout());
            panelTextChat.setPreferredSize(new Dimension(380, 50));
            panelTextChat.setBackground(Color.white);
            //scroll pane
            spChat = new JScrollPane(panelConversation, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            spChat.setPreferredSize(new Dimension(380, 450));

//            JLabel lbMsg;
            //create button back to home
            backToHome = new JButton("< Back");
            backToHome.setFocusPainted(false);
            backToHome.setBackground(Color.white);
            backToHome.setForeground(new java.awt.Color(0 ,191 ,255));
            backToHome.setBorder(new RoundedBorder(10));
            backToHome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frameConversation.setVisible(false);
                    AppMessenger.displayAddFriendFrame();
                }
            });
            panelBackBtn.add(backToHome);
            //read data from server
            int sessionId = chatRespond.getSessionId();
            int amountMessage = chatRespond.getMessageList().size();
            List<ChatMessage> listMessage = chatRespond.getMessageList();
            System.out.println("List Message" + listMessage);
            //count Messsager
//             int height = 0;
//             int width = 380;
            for (int i = 0; i < amountMessage; i++) {
                height += 55;
                ChatMessage chatMessage = listMessage.get(i);
                int idMsg = chatMessage.getIdMsg();
                String textMsg = chatMessage.getTextMsg();
                int idSender = chatMessage.getIdSender();

                if (idUser == idSender) {
                    //create panel
                    JPanel panelText = new JPanel();
                    panelText.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    panelText.setPreferredSize(new Dimension(380, 50));
                    panelText.setBorder(new EmptyBorder(0, 0, 0, 15));
                    panelText.setBackground(Color.white);
                    //
                    JButton lbMsg = new JButton(textMsg);
                    lbMsg.setPreferredSize(new Dimension(200, 30));
                    lbMsg.setFocusPainted(false);
//                    lbMsg.setEnabled(false);
                    lbMsg.setBackground(new java.awt.Color(30 ,144 ,255));
                    lbMsg.setForeground(Color.black);
                    lbMsg.setBorder(new RoundedBorder(20));

//                  add to panel;
                    panelText.add(lbMsg);
                    panelConversation.add(panelText);
                } else {

                    //
                    JPanel panelText = new JPanel();
                    panelText.setLayout(new FlowLayout(FlowLayout.LEFT));
                    panelText.setPreferredSize(new Dimension(380, 50));
                    panelText.setBackground(Color.white);
                    panelText.setBorder(new EmptyBorder(0, 0, 0, 0));
//                    panelText.setForeground(Color.blue);
                    //
                    JButton msgBtn = new JButton(textMsg);
                    msgBtn.setPreferredSize(new Dimension(200, 30));
                    msgBtn.setFocusPainted(false);
//                    msgBtn.setEnabled(false);
                    msgBtn.setBackground(new java.awt.Color(30 ,144 ,255));
                    msgBtn.setForeground(Color.black);
                    msgBtn.setBorder(new RoundedBorder(10));

//                    msgBtn.setHorizontalAlignment(JLabel.LEFT);
                    panelText.add(msgBtn);
                    panelConversation.add(panelText);
                }
            }
            panelConversation.setPreferredSize(new Dimension(width, height));
            panelConversation.revalidate();
            panelConversation.repaint();
            Rectangle viewBounds = spChat.getViewportBorderBounds();
            panelConversation.scrollRectToVisible(new Rectangle(0, height, viewBounds.width, viewBounds.height));

            //create tfMessage and BtnSend

            tfInputMessage = new JTextField("", 25);
            btnSend = new JButton("Send");
            btnSend.setFocusPainted(false);
            btnSend.setBackground(Color.WHITE);
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (checkEmpty(tfInputMessage.getText()) == true) {
                            //create panel
                            JPanel panelText = new JPanel();
                            panelText.setLayout(new FlowLayout(FlowLayout.RIGHT));
                            panelText.setPreferredSize(new Dimension(380, 50));
                            panelText.setBorder(new EmptyBorder(0, 0, 0, 15));
                            panelText.setBackground(Color.white);
                            //
                            System.out.println("tin nhan " + tfInputMessage.getText());
                            SendMessageRequest sendMessageRequest = new SendMessageRequest(AppMessenger.SEND_MESSAGE_ACTION, sessionId,
                                                                        tfInputMessage.getText(), idUser, idFriend);
                            String json = AppMessenger.mapper.writeValueAsString(sendMessageRequest);
                            AppMessenger.out.writeUTF(json);
                            AppMessenger.out.flush();
                            //creatte button to hold text
                            JButton msgBtn = new JButton(tfInputMessage.getText());
                            msgBtn.setPreferredSize(new Dimension(200, 30));
                            msgBtn.setFocusPainted(false);
                            msgBtn.setBackground(new java.awt.Color(30 ,144 ,255));
                            msgBtn.setForeground(Color.black);
                            msgBtn.setBorder(new RoundedBorder(20));
                            //addcomponent
                            panelText.add(msgBtn);
                            panelConversation.add(panelText);
                            //
                            tfInputMessage.setText("");
                            Rectangle viewBounds = spChat.getViewportBorderBounds();
                            panelConversation.setPreferredSize(new Dimension(width, height += 55));
                            panelConversation.revalidate();
                            panelConversation.repaint();
                            panelConversation.scrollRectToVisible(new Rectangle(0, height, viewBounds.width, viewBounds.height));
                        } else {
                            System.out.println("nhạp trong");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

            //
            panelTextChat.add(tfInputMessage);
            panelTextChat.add(btnSend);
            //panleCon add component
            //frame add to component
//            frameConversation.add(backToHome);

            frameConversation.add(panelBackBtn);
            frameConversation.add(spChat);
            frameConversation.add(panelTextChat);
            frameConversation.setLayout(new FlowLayout());
            frameConversation.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkEmpty(String tf) {
        if (tf.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public void displayOnlMessage(SendMessageRespond sendMessageRespond) {
        System.out.println("nhan dc message luc onl");
        int Message = sendMessageRespond.getUserState();
        if (Message == AppMessenger.RECEIVED_MESSENGER_NOW) {
            //create panel
            JPanel panelText = new JPanel();
            panelText.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelText.setPreferredSize(new Dimension(380, 50));
            panelText.setBorder(new EmptyBorder(0, 0, 0, 15));
            panelText.setBackground(Color.white);
            int idMsg = sendMessageRespond.getIdMsg();
            int idSession = sendMessageRespond.getIdSession();
            int idUser = sendMessageRespond.getIdUser();
            String messageTxt = sendMessageRespond.getTfInputMsg();
            //creatte button to hold text
            JButton msgBtn = new JButton(messageTxt);
            msgBtn.setPreferredSize(new Dimension(200, 30));
            msgBtn.setFocusPainted(false);
//                    msgBtn.setEnabled(false);
            msgBtn.setBackground(new java.awt.Color(30 ,144 ,255));
            msgBtn.setForeground(Color.black);
            msgBtn.setBorder(new RoundedBorder(20));

//                    msgBtn.setHorizontalAlignment(JLabel.LEFT);
            panelText.add(msgBtn);
            panelConversation.add(panelText);
            panelConversation.setPreferredSize(new Dimension(width, height += 55));
            panelConversation.revalidate();
            panelConversation.repaint();

            Rectangle viewBounds = spChat.getViewportBorderBounds();
            panelConversation.scrollRectToVisible(new Rectangle(0, height, viewBounds.width, viewBounds.height));
            //
//            conversationFrame.lbReceivedMessage = new JLabel(tfInputMsg, JLabel.LEFT);
//            conversationFrame.panelConversation.add(conversationFrame.lbReceivedMessage);
//            conversationFrame.lbReceivedMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
//            conversationFrame.panelConversation.updateUI();
            System.out.println("Nhận được lúc onl");
        } else {
            System.out.println("Không nhan được tin nhắn");
        }
    }

    public static void main(String[] args) {
        ChatRespond chatRespond = new ChatRespond();
        chatRespond.setMessageList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            ChatMessage chatMessage = new ChatMessage(i, "cnvnbc ", i);
            chatRespond.getMessageList().add(chatMessage);
        }
        ConversationFrame conversationFrame = new ConversationFrame(chatRespond);

        conversationFrame.displayOnlMessage(
                new SendMessageRespond(1, AppMessenger.RECEIVED_MESSENGER_NOW, 1, 1, 1, "Ahaaahaa"));


        conversationFrame.displayOnlMessage(
                new SendMessageRespond(1, AppMessenger.RECEIVED_MESSENGER_NOW, 1, 1, 1, "Ahaaahaa"));


        conversationFrame.displayOnlMessage(
                new SendMessageRespond(1, AppMessenger.RECEIVED_MESSENGER_NOW, 1, 1, 1, "Ahaaahaa"));


        conversationFrame.displayOnlMessage(
                new SendMessageRespond(1, AppMessenger.RECEIVED_MESSENGER_NOW, 1, 1, 1, "Ahaaahaa"));
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
