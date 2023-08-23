package com.codegym.ss6_player_soccer.service.position;

import com.codegym.ss6_player_soccer.model.Position;
import com.codegym.ss6_player_soccer.repository.position.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService{
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }
}
