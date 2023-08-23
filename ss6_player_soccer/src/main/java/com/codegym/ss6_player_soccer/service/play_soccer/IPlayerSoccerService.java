package com.codegym.ss6_player_soccer.service.play_soccer;



import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;


public interface IPlayerSoccerService {
    Page<PlayerSoccer> getAll(Pageable pageable, String name, Date dateStart,Date dateEnd);
    PlayerSoccer findById(int id);

    void remove(int id);

    void save(PlayerSoccer playerSoccer);
}
