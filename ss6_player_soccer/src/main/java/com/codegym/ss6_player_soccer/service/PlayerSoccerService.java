package com.codegym.ss6_player_soccer.service;

import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.repository.IPlayerSoccerRepository;
import com.codegym.ss6_player_soccer.model.PlayerSoccer;
import com.codegym.ss6_player_soccer.repository.IPlayerSoccerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerSoccerService implements IPlayerSoccerService{
    @Autowired
    private IPlayerSoccerRepository playerSoccerRepository;
    @Override
    public Page<PlayerSoccer> getAll(Pageable pageable,String name) {
        return playerSoccerRepository.findAllByNameContaining(pageable,name);
    }

    @Override
    public PlayerSoccer findById(int id) {
        return  playerSoccerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
       playerSoccerRepository.deleteById(id);
    }

    @Override
    public void save(PlayerSoccer playerSoccer) {
        playerSoccerRepository.save(playerSoccer);
    }
}
