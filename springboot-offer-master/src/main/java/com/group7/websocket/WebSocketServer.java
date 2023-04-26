package com.group7.websocket;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Maps;
import com.group7.config.WebSocketConfig;
import org.springframework.stereotype.Component;
/**
 * author: Qintong
 */

@Component
@ServerEndpoint(value = "/webSocket/{userId}")
public class WebSocketServer{

    /**
     * 在线人数
     */
    public static int onlineNumber = 0;
    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebSocketServer> clients = new ConcurrentHashMap<String, WebSocketServer>();
    /**
     * 会话
     */
    private Session session;
    /**
     * 用户名称
     */
    private String userId;
    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        onlineNumber++;
        System.out.println("Open！！！！！！！！！！666");
        System.out.println("现在来连接的客户id："+session.getId()+"用户名："+userId);
        this.userId = userId;
        this.session = session;
        //  logger.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            //先给所有人发送通知，说我上线了
            Map<String,Object> map1 = Maps.newHashMap();
            map1.put("messageType",1);
            map1.put("userId",userId);
            sendMessageAll(JSON.toJSONString(map1),userId);

            //把自己的信息加入到map当中去
            clients.put(userId, this);
            System.out.println("有连接关闭！ 当前在线人数" + clients.size());
            //给自己发一条消息：告诉自己现在都有谁在线
            Map<String,Object> map2 = Maps.newHashMap();
            map2.put("messageType",3);
            //移除掉自己
            Set<String> set = clients.keySet();
            map2.put("onlineUsers",set);
            sendMessageTo(JSON.toJSONString(map2),userId);
        }
        catch (IOException e){
            System.out.println(userId+"上线的时候通知所有人发生了错误");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("服务端发生了错误"+error.getMessage());
        //error.printStackTrace();
    }
    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber--;
        //webSockets.remove(this);
        clients.remove(userId);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String,Object> map1 = Maps.newHashMap();
            map1.put("messageType",2);
            map1.put("onlineUsers",clients.keySet());
            map1.put("userId",userId);
            sendMessageAll(JSON.toJSONString(map1),userId);
        }
        catch (IOException e){
            System.out.println(userId+"下线的时候通知所有人发生了错误");
        }
        //logger.info("有连接关闭！ 当前在线人数" + onlineNumber);
        System.out.println("有连接关闭！ 当前在线人数" + clients.size());
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(byte[] message, Session session) {
        try {
            System.out.println("来自客户端消息：" + message+"客户端的id是："+session.getId());

            System.out.println("------------  :"+message);

            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String fromuserId = jsonObject.getString("userId");
            String touserId = jsonObject.getString("to");
            //如果不是发给所有，那么就发给某一个人
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String,Object> map1 = Maps.newHashMap();
            map1.put("messageType",4);
            map1.put("textMessage",textMessage);
            map1.put("fromuserId",fromuserId);
            if(touserId.equals("All")){
                map1.put("touserId","所有人");
                sendMessageAll(JSON.toJSONString(map1),fromuserId);
            }
            else{
                map1.put("touserId",touserId);
                System.out.println("开始推送消息给"+touserId);
                sendMessageTo(JSON.toJSONString(map1),touserId);
            }
        }
        catch (Exception e){

            e.printStackTrace();
            System.out.println("发生了错误了");
        }

    }


    public void sendMessageTo(String message, String TouserId) throws IOException {
        for (WebSocketServer item : clients.values()) {


            //    System.out.println("在线人员名单  ："+item.userId.toString());
            if (item.userId.equals(TouserId) ) {
                item.session.getAsyncRemote().sendText(message);

                break;
            }
        }
    }

    public void sendMessageAll(String message,String FromuserId) throws IOException {
        for (WebSocketServer item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineNumber;
    }

}
