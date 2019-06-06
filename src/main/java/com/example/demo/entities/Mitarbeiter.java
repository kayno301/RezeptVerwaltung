package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Mitarbeiter {
    @Id
    @GeneratedValue
    private Long id;

    private String mitarbeitername;
    private String mitarbeitervornamen;

    private int gehalt;

    protected Mitarbeiter() {
    }

    public Mitarbeiter(String mitarbeitername, String mitarbeitervornamen) {
        this.mitarbeitername = mitarbeitername;
        this.mitarbeitervornamen = mitarbeitervornamen;
        this.gehalt = 1000;
    }

    public Mitarbeiter(String mitarbeitername, String mitarbeitervornamen, int gehalt) {
        this.mitarbeitername = mitarbeitername;
        this.mitarbeitervornamen = mitarbeitervornamen;
        this.gehalt = gehalt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGehalt(int gehalt) {
        this.gehalt = gehalt;
    }

    public int getGehalt() {
        return gehalt;
    }

    public String getMitarbeitername() {
        return mitarbeitername;
    }

    public void setMitarbeitername(String mitarbeitername) {
        this.mitarbeitername = mitarbeitername;
    }

    public String getMitarbeitervornamen() {
        return mitarbeitervornamen;
    }

    public void setMitarbeitervornamen(String mitarbeitervornamen) {
        this.mitarbeitervornamen = mitarbeitervornamen;
    }

    public String toString() {
        return this.mitarbeitername + " " + this.mitarbeitervornamen;
    }
}