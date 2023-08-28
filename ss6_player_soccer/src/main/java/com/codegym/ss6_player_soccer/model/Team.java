package com.codegym.ss6_player_soccer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "team")
    private Set<PlayerSoccer> playerSoccerSet;
    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PlayerSoccer> getPlayerSoccerSet() {
        return playerSoccerSet;
    }

    public void setPlayerSoccerSet(Set<PlayerSoccer> playerSoccerSet) {
        this.playerSoccerSet = playerSoccerSet;
    }
}
