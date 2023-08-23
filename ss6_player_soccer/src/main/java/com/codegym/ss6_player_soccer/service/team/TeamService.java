package com.codegym.ss6_player_soccer.service.team;

import com.codegym.ss6_player_soccer.model.Team;
import com.codegym.ss6_player_soccer.repository.team.ITeamRepository;
import com.codegym.ss6_player_soccer.service.team.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;
    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }
}
