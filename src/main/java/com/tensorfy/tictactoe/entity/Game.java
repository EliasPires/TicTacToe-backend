package com.tensorfy.tictactoe.entity;

import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Player player1;

    @ManyToOne
    private Player player2;

    // Representa o tabuleiro no banco com uma String de 9 caracteres.
    private String board; //Ex: "XOX_O__0"

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    private Long currentTurn; // id do jogador da vez

    public Game() {
        this.board = "_________";
        this.status = GameStatus.AGUARDANDO;

    }

    // Método utilitário: transforma board (String) em matriz
    public char[][] getBoardAsMatrix() {
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 9; i++) {
            matrix[i / 3][i % 3] = board.charAt(i);
        }
        return matrix;
    }

    // Método utilitário: atualiza a String a partir de uma matriz
    public void setBoardFromMatrix(char[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(matrix[i][j]);
            }
        }
        this.board = sb.toString();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Long getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Long currentTurn) {
        this.currentTurn = currentTurn;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }
}


