package com.codegym.ss6_player_soccer.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "player_soccer")
public class PlayerSoccer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int id;
    @Column(name = "player_code")
    private String code;
    @Column(name = "player_name")
    private String name;
    @Column(name = "player_birth")
    private Date birth;
    @Column(name = "player_exp")
    private int experience;
    @Column(name = "player_status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;
    @Column(name = "player_path_img")
    private String image;
    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    private Team team;

    public PlayerSoccer() {
    }

    public PlayerSoccer(int id, String code, String name, Date birth, int experience, boolean status, Position position, String image, Team team) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.experience = experience;
        this.status = status;
        this.position = position;
        this.image = image;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
