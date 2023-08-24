package com.codegym.ss6_player_soccer.repository.play_soccer;

import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface IPlayerSoccerRepository extends JpaRepository<PlayerSoccer,Integer> {
    @Query(value = "SELECT * FROM player_soccer where player_name like :name and player_birth between :date_start and :data_end",nativeQuery = true)
    Page<PlayerSoccer> findAllByNameContaining(Pageable pageable,
                                               @Param("name") String name,
                                               @Param("date_start") Date dateStart,
                                               @Param("data_end") Date dateEnd);
    void deleteById(int Id);
}
