package com.codegym.ss6_player_soccer.repository.position;

import com.codegym.ss6_player_soccer.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
