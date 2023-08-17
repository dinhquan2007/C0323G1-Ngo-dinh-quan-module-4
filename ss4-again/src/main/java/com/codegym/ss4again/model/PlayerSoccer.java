package com.codegym.ss4again.model;

public class PlayerSoccer {
    private int id;
    private String code;
    private String name;
    private String birth;
    private String experience;
    private String position;
    private String image;

    public PlayerSoccer() {
    }

    public PlayerSoccer(int id, String code, String name, String birth, String experience, String position, String image) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birth = birth;
        this.experience = experience;
        this.position = position;
        this.image = image;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
