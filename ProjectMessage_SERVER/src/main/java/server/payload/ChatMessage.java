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

    public int getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(int idMsg) {
        this.idMsg = idMsg;
    }

    public String getTextMsg() {
        return TextMsg;
    }

    public void setTextMsg(String textMsg) {
        TextMsg = textMsg;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }
}
