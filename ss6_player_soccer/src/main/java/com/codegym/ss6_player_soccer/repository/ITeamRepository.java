package com.codegym.ss6_player_soccer.repository;

import com.codegym.ss6_player_soccer.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team,Integer> {
}
