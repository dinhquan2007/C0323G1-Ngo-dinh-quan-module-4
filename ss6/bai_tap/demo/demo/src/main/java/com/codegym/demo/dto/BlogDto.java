package com.codegym.demo.dto;

public class BlogDto {
    private int id;
    private String name;
    private String url;
    private String timePost;

    public BlogDto() {
    }

    public BlogDto(int id, String name, String url, String timePost) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.timePost = timePost;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }
}
