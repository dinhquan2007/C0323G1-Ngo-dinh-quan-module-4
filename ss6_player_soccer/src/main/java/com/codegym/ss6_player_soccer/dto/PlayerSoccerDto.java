package com.codegym.ss6_player_soccer.dto;

import com.codegym.ss6_player_soccer.model.Position;
import com.codegym.ss6_player_soccer.model.Team;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

public class PlayerSoccerDto implements Validator {
    private int id;
    private String code;
    private String name;
    private Date birth;
    private int experience;
    private Position position;
    private Team team;
    private String image;

    public PlayerSoccerDto() {
    }

    public PlayerSoccerDto(int id, String code, String name, Date birth, int experience, Position position, Team team, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.experience = experience;
        this.position = position;
        this.team = team;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PlayerSoccerDto playerSoccerDto = (PlayerSoccerDto) target;
        if (playerSoccerDto.getName().equals("")) {
            errors.rejectValue("name", null, "không được để trống");
        } else if (playerSoccerDto.getName().length() < 5 || playerSoccerDto.getName().length() > 100) {
            errors.rejectValue("name", null, "ít nhất 5 kí tự,nhiều nhất 100");
        }
        System.out.println(playerSoccerDto.getBirth());
        if (playerSoccerDto.getBirth() == null) {
            errors.rejectValue("birth", null, "vui lòng chọn đúng ngày");
        }
//        else if (LocalDate.now().getYear() - playerSoccerDto.getBirth().getYear() < 18
//                || LocalDate.now().getYear() - playerSoccerDto.getBirth().getYear() > 100) {
//            errors.rejectValue("birth", null, "tuổi phải lớn hơn 18 hoặc nhỏ hơn 100");
//        }
        if (playerSoccerDto.experience<0){
            errors.rejectValue("experience",null,"phải lớn hơn 0");
        }
    }
}
