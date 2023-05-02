package com.group7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author:
 * @Explain: 开启webSocket
 * @Params:
 * @Return
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
//        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * 添加这个Endpoint，这样在网页中就可以通过websocket连接上服务,也就是我们配置websocket的服务地址,并且可以指定是否使用socketjs
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        String defaultWebsocketEndpointPath = "/webSocket/*";
        String defaultSockJsEndpointPath = "/webSocket/*";
        /**
         * 看了下源码，它的实现类是WebMvcStompEndpointRegistry,addEndpoint是添加到WebMvcStompWebSocketEndpointRegistration的集合中，所以可以添加多个端点
         * 1、addEndpoint：将 “serviceName/server/*”路径,注册STOMP协议的端点。这个HTTP URL是供WebSocket或SockJS客户端访问的地址,用户连接了这个端点后就可以进行websocket通讯，支持socketJs
         */
        StompWebSocketEndpointRegistration webSockedEndpoint = registry.addEndpoint(defaultWebsocketEndpointPath);
        StompWebSocketEndpointRegistration sockJsEndpoint = registry.addEndpoint(defaultSockJsEndpointPath);
        /**
         * 2、withSockJS()指定端点使用SockJS协议
         */
        sockJsEndpoint.withSockJS();
        /**
         * 3、setAllowedOrigins("*") 添加允许跨域访问
         */
//        webSockedEndpoint.setAllowedOriginPatte
        webSockedEndpoint.setAllowedOrigins("*");
        sockJsEndpoint.setAllowedOrigins("*");
    }


}



