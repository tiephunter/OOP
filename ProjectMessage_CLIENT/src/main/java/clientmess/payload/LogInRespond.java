package clientmess.payload;

public class LogInRespond extends BasePayload {
    private int state;
    private int idUser;

    public LogInRespond() {
    }

    public LogInRespond(int action, int state, int idUser) {
        super(action);
        this.state = state;
        this.idUser = idUser;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
