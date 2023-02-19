package com.company.entity;

public class Product {

    private String artist;
    private int price;

    public Product(String artist, int price) {
        this.artist = artist;
        this.price = price;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
