package com.hef.ws.marcopolo;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Logger;


/**
 * @Date 2019-04-29
 * @Author lifei
 */
public class MarcoHandler extends AbstractWebSocketHandler {

    private static final Logger logger = Logger.getLogger("com.hef.ws.marcopolo.MarcoHandler");

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message: " + message.getPayload());

        Thread.sleep(3000l);

        session.sendMessage(new TextMessage("Polo!"));
    }

    /**
     * 在事件发生之后响应，不能改变结果
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Connection established");
    }

    /**
     * 在事件发生之后响应，不能改变结果
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Connection close. Status: " + status);
    }
}
