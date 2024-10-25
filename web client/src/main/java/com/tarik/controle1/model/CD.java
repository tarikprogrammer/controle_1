package com.tarik.controle1.model;


import jakarta.persistence.*;

@Entity
@Table(name = "cd")
public class CD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String artist;
    private boolean available;

    public CD() {
    }

    public CD(int id, String title, String artist, boolean available) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.available = available;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public boolean isAvailable() {
        return available;
    }


}
