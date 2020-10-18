package clientmess.payload;

//import java.util.HashMap;
//import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "idMsg",
//        "TextMsg",
//        "idSender"
//})
//public class ChatMessage {
//
//    @JsonProperty("idMsg")
//    private Integer idMsg;
//    @JsonProperty("TextMsg")
//    private String textMsg;
//    @JsonProperty("idSender")
//    private Integer idSender;
//    @JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//
//    @JsonProperty("idMsg")
//    public Integer getIdMsg() {
//        return idMsg;
//    }
//
//    @JsonProperty("idMsg")
//    public void setIdMsg(Integer idMsg) {
//        this.idMsg = idMsg;
//    }
//
//    @JsonProperty("TextMsg")
//    public String getTextMsg() {
//        return textMsg;
//    }
//
//    @JsonProperty("TextMsg")
//    public void setTextMsg(String textMsg) {
//        this.textMsg = textMsg;
//    }
//
//    @JsonProperty("idSender")
//    public Integer getIdSender() {
//        return idSender;
//    }
//
//    @JsonProperty("idSender")
//    public void setIdSender(Integer idSender) {
//        this.idSender = idSender;
//    }
//
//    @JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    @JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }
//
//}
public class ChatMessage {
    private int idMsg;
    private String TextMsg;
    private int idSender;

    public ChatMessage() {
    }

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
