package xyz.northsky.shop.utils;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

    private ResponseCode responseCode;

    private Object data;

    //private ObjectMapper objectMapper = JacksonObjectMapper.getInstance();

    public ResponseMessage(){}

    public ResponseMessage code(ResponseCode responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public Object getData() {
        return data;
    }

    public ResponseMessage data(Object data) {
        this.data = data;
        return this;
    }

    /*public String toString(){
        String json = "";
        try {
            json = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }*/

}
