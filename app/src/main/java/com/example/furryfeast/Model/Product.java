package com.example.furryfeast.Model;

public class Product {
    private String name;
    private String description;
    private double price;
    private int imageUrl;

    public Product(String name, String description, double price, int imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void SetImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
