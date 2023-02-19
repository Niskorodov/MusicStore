package com.company.entity;

public class Disc extends Product {

    private String album;
    private String genre;

    public Disc(String artist, int price, String album, String genre) {
        super(artist, price);
        this.album = album;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Disc{" +
                "album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
