package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, String producer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
