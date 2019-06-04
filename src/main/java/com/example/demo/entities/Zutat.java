package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Zutat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zutatName;
    private int zutatMenge;

    @ManyToMany(mappedBy = "zutaten", cascade = CascadeType.ALL)
    private Set<Rezept> rezepte = new HashSet<>();

    public Zutat() {
    }

    public Zutat(String zutatName, int zutatMenge) {
        this.zutatName = zutatName;
        this.zutatMenge = zutatMenge;
    }

    public Zutat(String zutatName, int zutatMenge, Set<Rezept> rezepte) {
        this.zutatName = zutatName;
        this.zutatMenge = zutatMenge;
        this.rezepte = rezepte;
    }

    public void addRezept(Rezept b) {
        this.rezepte.add(b);
        b.getZutaten().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZutatName() {
        return zutatName;
    }

    public void setZutatName(String zutatName) {
        this.zutatName = zutatName;
    }

    public int getZutatMenge() {
        return zutatMenge;
    }

    public void setZutatMenge(int zutatMenge) {
        this.zutatMenge = zutatMenge;
    }

    public Collection<Rezept> getRezepte() {
        return rezepte;
    }

    public void setRezepte(Set<Rezept> rezept) {
        this.rezepte = rezept;
    }

    @Override
    public String toString() {
        return "Zutat{" +
                "id=" + id +
                ", zutatName='" + zutatName + '\'' +
                ", zutatMenge=" + zutatMenge +
                ", rezepts=" + rezepte +
                '}';
    }
}
