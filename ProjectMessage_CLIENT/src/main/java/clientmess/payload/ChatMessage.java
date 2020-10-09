package server.payload;

public class ChatMessage {
    private int idMsg;
    private String TextMsg;
    private int idSender;

    public ChatMessage(int idMsg, String textMsg, int idSender) {
        this.idMsg = idMsg;
        TextMsg = textMsg;
        this.idSender = idSender;
    }
}
