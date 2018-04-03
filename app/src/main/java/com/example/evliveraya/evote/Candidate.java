package com.example.evliveraya.evote;

/**
 * Created by EvliveRaya on 01/04/2018.
 */

public class Candidate {

    private int id;
    private String nama1;
    private String nama2;
    private int nomor;
    private int jml_vote;

    public Candidate(int id, String nama1, String nama2, int nomor, int jml_vote) {
        this.id = id;
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.nomor = nomor;
        this.jml_vote = jml_vote;
    }

    public Candidate(String nama1, String nama2, int nomor, int jml_vote) {
        this.nama1 = nama1;
        this.nama2 = nama2;
        this.nomor = nomor;
        this.jml_vote = jml_vote;
    }

    public Candidate() {}

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getNama2() {
        return nama2;
    }

    public void setNama2(String nama2) {
        this.nama2 = nama2;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }

    public int getJml_vote() {
        return jml_vote;
    }

    public void setJml_vote(int jml_vote) {
        this.jml_vote = jml_vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
