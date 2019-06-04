package com.example.demo.entities;

import com.example.demo.valueObjects.Kategorie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Speisekarte speisekarte;

    @ManyToOne
    @JsonBackReference
    private Koch koch;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Zutat> zutaten = new HashSet<>();

    private String rezeptName;
    private String rezeptBeschreibung;

    public void addZutat(Zutat b) {
        this.zutaten.add(b);
        b.getRezepte().add(this);
    }

    @Embedded
    private Kategorie kategorie;

    protected Rezept() {
    }

    public Rezept(Speisekarte speisekarte, String rezeptNamen, String rezeptBeschreibung, Kategorie kategorie, Set<Zutat> zutaten) {
        this.speisekarte = speisekarte;
        this.rezeptName = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;

        this.kategorie = kategorie;
        this.zutaten = zutaten;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Speisekarte getSpeisekarte() {
        return speisekarte;
    }

    public void setSpeisekarte(Speisekarte speisekarte) {
        this.speisekarte = speisekarte;
        if (!speisekarte.getRezepte().contains(this)) {
            speisekarte.getRezepte().add(this);
        }
    }

    public Koch getKoch() {
        return koch;
    }

    public void setKoch(Koch koch) {
        this.koch = koch;
    }

    public String getRezeptNamen() {
        return rezeptName;
    }

    public void setRezeptNamen(String rezeptNamen) {
        this.rezeptName = rezeptNamen;
    }

    public String getRezeptName() {
        return rezeptName;
    }

    public void setRezeptName(String rezeptName) {
        this.rezeptName = rezeptName;
    }

    public String getRezeptBeschreibung() {
        return rezeptBeschreibung;
    }

    public void setRezeptBeschreibung(String rezeptBeschreibung) {
        this.rezeptBeschreibung = rezeptBeschreibung;
    }

    public Set<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(Set<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Rezept(String rezeptNamen,
                  String rezeptBeschreibung) {
        this.rezeptName = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
    }

    @Override
    public String toString() {
        return "Rezept{" +
                "id=" + id +
                ", speisekarte=" + speisekarte +
                ", rezeptNamen='" + rezeptName + '\'' +
                ", rezeptBeschreibung='" + rezeptBeschreibung + '\'' +
                ", kategorie='" + kategorie + "\'" +
                '}';
    }
}