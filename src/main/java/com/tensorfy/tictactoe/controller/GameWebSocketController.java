package com.tensorfy.tictactoe.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.tensorfy.tictactoe.entity.Game;

@Controller
public class GameWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public GameWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Recebe jogada de um jogador
    @MessageMapping("/move")
    public void receiveMove(@Payload Game game) {
        // Lógica pra atualizar o estado do jogo (faremos depois)
        // Envia o jogo atualizado para todos os inscritos no tópico
        messagingTemplate.convertAndSend("/topic/game/" + game.getId(), game);
    }
}
