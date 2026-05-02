package com.dasom.backend_tutoring2.dto;

public class ProductResDTO {
    private int id;
    private String name;
    private int price;

    public ProductResDTO(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}