package com.tensorfy.tictactoe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-game")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS(); // para fallback caso o navegador não suporte WebSocket puro
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // “/app” → mensagens enviadas do cliente para o servidor
        registry.setApplicationDestinationPrefixes("/app");
        // “/topic” → mensagens do servidor para os clientes
        registry.enableSimpleBroker("/topic");
    }
}

