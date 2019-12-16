package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.
   // public Object setName;


    private String type;
    private int onlineCount;
    private String message;
    private String Username;

    public Message() {


    }

    public Message(String text){
        this.Username = text;
    }

    public Message(String msg, String username, int onlineCount, String type) {
        this.message = msg;
        this.Username = username;
        this.onlineCount = onlineCount;

        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return Username;
    }

    public void setName(String Username) {
        this.Username = Username;
    }


}

     
