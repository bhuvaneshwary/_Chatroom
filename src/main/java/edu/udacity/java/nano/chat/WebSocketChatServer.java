package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint("/chat")
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(Message msg) throws IOException {
        //TODO: add send message method.
        /*pseudocode
         * For each online session {}
         * session.sendMessage(message.toJSON())
         */
           for (Map.Entry<String, Session> entry : onlineSessions.entrySet()) {
      Session session = entry.getValue();
      try {
        session.getBasicRemote().sendText(msg);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

     
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) {
        //TODO: add on open connection.
        System.out.println("On open :" + session.getId());
        onlineSessions.put(session.getId(),session);
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) throws IOException {

        //TODO : Construct a new message using json string
        //TODO: sendMessageToAll
         Message onMsg = new Message();
        onMsg.setName(session.getId());
        onMsg.setMessage(jsonStr);
        onMsg.setMessage("SPEAK");
        String message= onMsg.toString();
        sendMessageToAll(message);



    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) {
        //TODO: add close connection.
        onlineSessions.remove(session.getId(),session);
        System.out.println("On open :" + session.getId());
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
