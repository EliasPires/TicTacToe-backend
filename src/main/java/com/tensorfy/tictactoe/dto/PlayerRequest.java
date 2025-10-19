package com.tensorfy.tictactoe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PlayerRequest {

    @NotBlank(message ="O nome do jogador é obrigatório")
    private String name;

    @Size(min = 1, max = 1, message = "O símbolo deve ter exatamente 1 caractere (X ou O")
    private String symbol;

    public PlayerRequest() {
    }

    public PlayerRequest(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
