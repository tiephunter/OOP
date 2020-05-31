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
    JPanel panelTextChat;
    JButton backToHome;
    public ConversationFrame(){
        try{
            //read data from server
            int idUser = AppMessenger.in.readInt();
            int idFriend = AppMessenger.in.readInt();
            String tenTaiKhoanFriend = AppMessenger.in.readUTF();
            frameConversation = new JFrame(tenTaiKhoanFriend);
            frameConversation.setSize(350, 450);
            frameConversation.setLocationRelativeTo(frameConversation);
            frameConversation.setResizable(true);
            frameConversation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameConversation.setBackground(Color.gray);
            frameConversation.setForeground(Color.gray);
            JPanel panelCon = new JPanel();
            //create panelConversation
            panelConversation = new JPanel()  ;
            GridLayout converstationLayout = new GridLayout(0,1);
            panelConversation.setLayout(converstationLayout);
//            panelConversation.setBorder(new EmptyBorder(150, 100, 50, 100));
            panelConversation.setBackground(Color.white);
            //create panelTextChat
            panelTextChat = new JPanel();
            BoxLayout textChatBoxLayout = new BoxLayout(panelTextChat,BoxLayout.Y_AXIS);
            panelTextChat.setLayout(textChatBoxLayout);
//            panelTextChat.setBorder(new EmptyBorder(50, 150, 50, 150));
            panelTextChat.setBackground(Color.gray);
            JLabel lbMsg;
            //create button back to home
            backToHome = new JButton("Back to home");
            backToHome.setFocusPainted(false);
            backToHome.setBackground(Color.gray);
            backToHome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frameConversation.setVisible(false);
                    AppMessenger.displayLHomeFrame();
                }
            });
            //read data from server
            int sessionId = AppMessenger.in.readInt();
            int amountMessage = AppMessenger.in.readInt();
            //count Messsager
            for (int i = 0; i < amountMessage; i++) {
                int idMsg = AppMessenger.in.readInt();
                String textMsg = AppMessenger.in.readUTF();
                int idSender = AppMessenger.in.readInt();

                if (idUser == idSender) {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(10,10));
                    lbMsg.setHorizontalAlignment(SwingConstants.RIGHT);
                    panelConversation.add(lbMsg);
                    panelConversation.updateUI();
                } else {
                    lbMsg = new JLabel(textMsg);
                    lbMsg.setPreferredSize(new Dimension(10,10));
                    lbMsg.setHorizontalAlignment(JLabel.LEFT);
                    panelConversation.add(lbMsg);
                    panelConversation.updateUI();
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
            JScrollPane spChat = new JScrollPane(panelConversation, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            spChat.setPreferredSize(new Dimension(300, 400));
            JScrollBar sb = spChat.getVerticalScrollBar();
            sb.setValue( sb.getMaximum() );
            spChat.updateUI();
            panelTextChat.add(tfInputMessage);
            panelTextChat.add(btnSend);
            //panleCon add component
            panelCon.add(backToHome);
            panelCon.add(spChat);
            panelCon.add(panelTextChat);

            //frame add to component
//            frameConversation.add(backToHome);
            panelCon.setLayout(new BoxLayout(panelCon, BoxLayout.Y_AXIS));
            panelCon.setBorder(new EmptyBorder(10, 50, 50, 50));
            panelCon.setBackground(Color.GRAY);
            frameConversation.add(panelCon);
            frameConversation.setLayout(new GridLayout(1, 1));
            frameConversation.setVisible(true);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
