package org.marianaduarte.tema15;

public class Request {
    private String msg;
    private RequestType type;

    public Request(String msg, RequestType type){
        this.msg = msg;
        this.type = type;
    }
    public String getMsg() {
        return msg;
    }

    public RequestType getType() {
        return type;
    }
}
