package com.person.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
@ServerEndpoint(value = "/webSocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArrayList<WebSocket> webSockets = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        log.info("[websocket消息] 有新的连接，当前总数:{}", webSockets.size());
    }

    @OnClose
    public void onColse() {
        webSockets.remove(this);
        log.info("[websocket消息] 连接断开，当前总数:{}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("[websocket消息] 收到客户端发来的消息:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket ws : webSockets) {
            log.info("[websocket消息] 广播消息,message={}", message);
            try {
                ws.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.warn("[websocket消息] 发送消息失败,e={}", e);
            }
        }
    }

}

//@Component
//@Slf4j
//@ServerEndpoint(value = "/webSocket")
//public class WebSocket extends AbstractWebSocketHandler{
//
//    private static Map<String,WebSocketSession> sessionMap = new HashMap<>();
//
//    /**
//     * 发送消息
//     * @author
//     */
//    public void sendMessage(String message) {
//        log.info("发送消息={}",message);
//        try {
//            sendMessage(sessionMap.keySet(),message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 发送消息
//     * @author
//     */
//    public void sendMessage(String username,String message) throws IOException {
//        sendMessage(Arrays.asList(username),Arrays.asList(message));
//    }
//
////    发送消息
//    public void sendMessage(Collection<String> acceptorList, String message) throws IOException{
//        sendMessage(acceptorList, Arrays.asList(message));
//    }
//
//    /**
//     * 发送消息，p2p 群发都支持
//     * @param acceptorList
//     * @param msgList
//     * @throws Exception
//     */
//    public void sendMessage(Collection<String> acceptorList, Collection<String> msgList) throws IOException{
//        if (acceptorList != null && msgList != null){
//            for (String acceptor:acceptorList) {
//                WebSocketSession webSocketSession = sessionMap.get(acceptor);
//                if (webSocketSession != null){
//                    for (String msg : msgList){
//                        webSocketSession.sendMessage(new TextMessage(msg.getBytes()));
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessionMap.put(session.getId(),session);
//        log.info("新增加一个连接={},当前访客总数={}",session.getId(),sessionMap.size());
//        super.afterConnectionEstablished(session);
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        log.info("接收到[{}]消息={},当前一共{}位访客",session.getId(),message.getPayload(),sessionMap.size());
//        Collection<WebSocketSession> sessionCollection = sessionMap.values();
//        for (WebSocketSession ws:sessionCollection){
//            ws.sendMessage(message);
//        }
//    }
//
//    /**
//     * 二进制通讯
//     * 你可以做其他处理
//     * @param session
//     * @param message
//     */
//    @Override
//    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
//        log.info("有二进制消息过来 {}",message);
//        try {
//            session.close(CloseStatus.NOT_ACCEPTABLE.withReason("Binary messages not supported"));
//        }catch (IOException e){
//            log.error("");
//        }
//    }
//
//    /**
//     * 连接关闭
//     * @param session
//     * @param status
//     * @throws Exception
//     */
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessionMap.remove(session.getId());
//        log.info("一个连接关闭={},当前访客总数={}",session.getId(),sessionMap.size());
//        super.afterConnectionClosed(session, status);
//    }
//}
