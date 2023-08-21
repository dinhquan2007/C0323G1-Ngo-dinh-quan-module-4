package com.codegym.ss6_player_soccer.service;



import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPlayerSoccerService {
    Page<PlayerSoccer> getAll(Pageable pageable,String name);
    PlayerSoccer findById(int id);

    void remove(int id);

    void save(PlayerSoccer playerSoccer);
}
