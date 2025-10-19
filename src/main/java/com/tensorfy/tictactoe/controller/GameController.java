package com.tensorfy.tictactoe.controller;

import com.tensorfy.tictactoe.dto.PlayerRequest;
import com.tensorfy.tictactoe.entity.Game;
import com.tensorfy.tictactoe.entity.GameStatus;
import com.tensorfy.tictactoe.entity.Player;
import com.tensorfy.tictactoe.repository.GameRepository;
import com.tensorfy.tictactoe.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {


    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;



    public GameController(GameRepository gameRepository, PlayerRepository playerRepository){
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    // 1 Criar nova partida
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody PlayerRequest playerRequest) {
        // Cria e salva o jogador no banco
        Player player1 = new Player(playerRequest.getName(), playerRequest.getSymbol());
        playerRepository.save(player1);

        Game game = new Game();
        game.setPlayer1(player1);
        game.setStatus(GameStatus.AGUARDANDO);
        game.setCurrentTurn(player1.getId());

        Game savedGame = gameRepository.save(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }

    // 2 Jogador entra em partida existente
    @PostMapping("/{id}/join")
    public ResponseEntity<Game> joinGame(@PathVariable Long id, @RequestBody PlayerRequest playerRequest){
        Optional<Game> optionalGame = gameRepository.findById(id);

        if(optionalGame.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }

        Game game = optionalGame.get();

        // Se o jogo já tem dois jogadores, não pode entrar mais ninguém
        if (game.getPlayer2() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409
        }

        // Cria o segundo jogador e associa
        Player player2 = new Player(playerRequest.getName(), playerRequest.getSymbol().charAt(0));
        playerRepository.save(player2);

        game.setPlayer2(player2);
        game.setStatus(GameStatus.EM_ANDAMENTO);
        gameRepository.save(game);

        return ResponseEntity.ok(game);
    }

    //3 consultar estado do jogo
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        return gameRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());


    }
}
