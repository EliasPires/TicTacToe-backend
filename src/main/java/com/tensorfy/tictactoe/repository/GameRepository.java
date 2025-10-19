package com.tensorfy.tictactoe.repository;

import com.tensorfy.tictactoe.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
