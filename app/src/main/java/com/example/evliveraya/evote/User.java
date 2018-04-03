package com.example.evliveraya.evote;

/**
 * Created by EvliveRaya on 01/04/2018.
 */

public class User {

    private int id;
    private String nama;
    private String nik;
    private String email;
    private String password;
    private int vote;

    public User(int id, String nama, String nik, String email, String password, int vote) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.email = email;
        this.password = password;
        this.vote = vote;
    }

    public User(String nama, String nik, String email, String password, int vote) {
        this.nama = nama;
        this.nik = nik;
        this.email = email;
        this.password = password;
        this.vote = vote;
    }

    public User() {}

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
