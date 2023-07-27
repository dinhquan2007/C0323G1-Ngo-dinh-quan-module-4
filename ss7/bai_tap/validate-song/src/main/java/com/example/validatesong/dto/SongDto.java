package com.example.validatesong.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongDto {
    private int id;
    @Pattern(regexp = "(([A-Z])\\w+\\s)*([A-Z])\\w+")
    private String name;
    @Pattern(regexp = "(([A-Z])\\w+\\s)*([A-Z])\\w+")
    private String singer;
    @Pattern(regexp = "(([A-Z])\\w+\\s)*([A-Z])\\w+")
    private String genre;

    public SongDto() {
    }

    public SongDto(String name, String singer, String genre,int id) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.id=id;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
