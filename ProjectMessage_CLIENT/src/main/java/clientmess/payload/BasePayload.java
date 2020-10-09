package clientmess.payload;

import java.io.Serializable;

public class BasePayload implements Serializable {
    int action;

    public BasePayload(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }


}
