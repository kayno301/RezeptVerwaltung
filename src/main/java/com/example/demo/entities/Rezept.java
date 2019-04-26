package com.example.demo.entities;

import com.example.demo.valueObjects.Kategorie;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Speisekarte speisekarte;



    private String rezeptNamen;
    private String rezeptBeschreibung;
    private String rezeptZutaten;

    @Embedded
    private Kategorie kategorie;


    protected Rezept (){}

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

    }

    public String getRezeptNamen() {
        return rezeptNamen;
    }

    public void setRezeptNamen(String rezeptNamen) {
        this.rezeptNamen = rezeptNamen;
    }

    public String getRezeptBeschreibung() {
        return rezeptBeschreibung;
    }

    public void setRezeptBeschreibung(String rezeptBeschreibung) {
        this.rezeptBeschreibung = rezeptBeschreibung;
    }

    public String getRezeptZutaten() {
        return rezeptZutaten;
    }

    public void setRezeptZutaten(String rezeptZutaten) {
        this.rezeptZutaten = rezeptZutaten;
    }

    public Rezept (String rezeptNamen,
                   String rezeptBeschreibung,
                   String rezeptZutaten,
                   Speisekarte speisekarte,
                   Kategorie kategorie){
        this.rezeptNamen = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
        this.rezeptZutaten = rezeptZutaten;
        this.speisekarte = speisekarte;
        this.kategorie = kategorie;

    }

    @Override
    public String toString() {
        return "Rezept{" +
                "id=" + id +
                ", speisekarte=" + speisekarte +
                ", rezeptNamen='" + rezeptNamen + '\'' +
                ", rezeptBeschreibung='" + rezeptBeschreibung + '\'' +
                ", rezeptZutaten='" + rezeptZutaten + '\'' +
                ", kategorie='" + kategorie + "\'" +
                '}';
    }
}
