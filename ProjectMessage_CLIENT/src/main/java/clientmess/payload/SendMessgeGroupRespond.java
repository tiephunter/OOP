package clientmess.payload;

public class SendMessgeGroupRespond extends BasePayload {
    private int idMsg;
    private int idSession;
    private int idUser;
    private String tfInputMsg;

    public SendMessgeGroupRespond() {
    }

    public SendMessgeGroupRespond(int action, int idMsg, int idSession, int idUser, String tfInputMsg) {
        super(action);
        this.idMsg = idMsg;
        this.idSession = idSession;
        this.idUser = idUser;
        this.tfInputMsg = tfInputMsg;
    }

    public int getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(int idMsg) {
        this.idMsg = idMsg;
    }

    public int getIdSession() {
        return idSession;
    }

    public void setIdSession(int idSession) {
        this.idSession = idSession;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTfInputMsg() {
        return tfInputMsg;
    }

    public void setTfInputMsg(String tfInputMsg) {
        this.tfInputMsg = tfInputMsg;
    }
}
