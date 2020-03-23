package clientmess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversationFrame {
    JFrame frameConversation;
    JPanel panelConversation;
    JTextField tfInputMessage;
    JLabel lbReceivedMessage;
    public ConversationFrame(){
        try{
            frameConversation = new JFrame("Conversation!!!");
            frameConversation.setSize(400, 600);
            frameConversation.setLocationRelativeTo(frameConversation);
            frameConversation.setResizable(true);
            frameConversation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameConversation.setBackground(Color.gray);
            frameConversation.setForeground(Color.gray);
            //create panelConversation
            panelConversation = new JPanel()  ;
            panelConversation.setLayout(new BoxLayout(panelConversation,BoxLayout.Y_AXIS));
            panelConversation.setBorder(new EmptyBorder(0, 0, 0, 250));
            panelConversation.setBackground(Color.orange);
            //create panelTextChat
            JPanel panelTextChat = new JPanel();
            GridLayout textChatGrid = new GridLayout(1, 2);
            panelTextChat.setLayout(textChatGrid);
            panelTextChat.setBorder(new EmptyBorder(50, 50, 50, 50));
            panelTextChat.setBackground(Color.orange);
            JLabel lbMsg ;
            //read data from server
            int idUser = AppMessenger.in.readInt();
            int idFriend = AppMessenger.in.readInt();
            int sessionId = AppMessenger.in.readInt();
            int amountMessage = AppMessenger.in.readInt();
            //count Messsager
            for (int i = 0; i < amountMessage; i++) {
                int idMsg = AppMessenger.in.readInt();
                String textMsg = AppMessenger.in.readUTF();
                int idSender = AppMessenger.in.readInt();

                if (idUser == idSender) {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(100,10));
                    lbMsg.setAlignmentX(Component.LEFT_ALIGNMENT);
                    lbMsg.setHorizontalAlignment(SwingConstants.RIGHT);
                    panelConversation.add(lbMsg);
                } else {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(100,10));
                    lbMsg.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    lbMsg.setHorizontalAlignment(SwingConstants.LEFT);
                    panelConversation.add(lbMsg);
                }
            }

            //create tfMessage and BtnSend

            tfInputMessage = new JTextField("",JTextField.LEFT);
            JButton btnSend = new JButton("Send");
            btnSend.setSize(20,20);
            btnSend.setFocusPainted(false);
            btnSend.setBackground(Color.WHITE);
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        AppMessenger.out.writeInt(AppMessenger.SEND_MESSAGE_ACTION);
                        AppMessenger.out.writeInt(sessionId);
                        AppMessenger.out.writeUTF(tfInputMessage.getText());
                        AppMessenger.out.writeInt(idUser);
                        AppMessenger.out.writeInt(idFriend);
                        AppMessenger.out.flush();
                        JLabel lbSendMessage = new JLabel(tfInputMessage.getText(), JLabel.RIGHT);
                        tfInputMessage.setText("");
                        panelConversation.add(lbSendMessage);
                        lbSendMessage.setAlignmentX(Component.RIGHT_ALIGNMENT);
                        panelConversation.updateUI();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });

            //panel add to component
            //create JscrollpaneChat
            JScrollPane spChat = new JScrollPane(panelConversation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            spChat.setPreferredSize(new Dimension(250, 400));
            spChat.updateUI();
            panelTextChat.add(btnSend);
            panelTextChat.add(tfInputMessage);


            //frame add to component
            frameConversation.add(spChat,BorderLayout.CENTER);
            frameConversation.add(panelTextChat);
            frameConversation.setLayout(new FlowLayout(1));
            frameConversation.setVisible(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
