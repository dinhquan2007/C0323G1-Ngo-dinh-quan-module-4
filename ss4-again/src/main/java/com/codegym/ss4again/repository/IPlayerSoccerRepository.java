package com.codegym.ss4again.repository;

import com.codegym.ss4again.model.PlayerSoccer;

import java.util.List;

public interface IPlayerSoccerRepository {
    List<PlayerSoccer> getAll();

    PlayerSoccer findById(int id);

    void remove(PlayerSoccer playerSoccer);

    boolean update(PlayerSoccer playerSoccer, int id);

    void save(PlayerSoccer playerSoccer);
}
