package com.tensorfy.tictactoe.repository;

import com.tensorfy.tictactoe.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
        // Aqui você pode criar métodos customizados depois, exemplo:
        // Optional<Player> findByName(String name);
}
