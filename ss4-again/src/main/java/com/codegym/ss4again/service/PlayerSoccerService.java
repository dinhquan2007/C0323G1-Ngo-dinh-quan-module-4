package com.codegym.ss4again.service;

import com.codegym.ss4again.model.PlayerSoccer;
import com.codegym.ss4again.repository.IPlayerSoccerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerSoccerService implements IPlayerSoccerService{
    @Autowired
    private IPlayerSoccerRepository playerSoccerRepository;
    @Override
    public List<PlayerSoccer> getAll() {
        return playerSoccerRepository.getAll();
    }

    @Override
    public PlayerSoccer findById(int id) {
        return playerSoccerRepository.findById(id);
    }

    @Override
    public void remove(PlayerSoccer playerSoccer) {
        playerSoccerRepository.remove(playerSoccer);
    }
}
