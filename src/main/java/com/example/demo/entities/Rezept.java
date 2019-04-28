package com.example.demo.entities;

import com.example.demo.valueObjects.Kategorie;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezept {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne() // cascade = CascadeType.ALL
    @JsonBackReference
    private Speisekarte speisekarte;

    @ManyToOne
    private Koch koch;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Zutat> zutat = new HashSet<>();

    private String rezeptName;
    private String rezeptBeschreibung;
    private String rezeptZutaten;

    @Embedded
    private Kategorie kategorie;

    protected Rezept (){}

    public Rezept(Speisekarte speisekarte, String rezeptNamen, String rezeptBeschreibung,
                  String rezeptZutaten, Kategorie kategorie, Set<Zutat> zutat) {
        this.speisekarte = speisekarte;
        this.rezeptName = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
        this.rezeptZutaten = rezeptZutaten;
        this.kategorie = kategorie;
        this.zutat= zutat;
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

    public Set<Zutat> getZutat() {
        return zutat;
    }

    public void setZutat(Set<Zutat> zutat) {
        this.zutat = zutat;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Rezept (String rezeptNamen,
                   String rezeptBeschreibung,
                   String rezeptZutaten

                   /*Kategorie kategorie*/){
        this.rezeptName = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
        this.rezeptZutaten = rezeptZutaten;

        //this.kategorie = kategorie;

    }

    @Override
    public String toString() {
        return "Rezept{" +
                "id=" + id +
                ", speisekarte=" + speisekarte +
                ", rezeptNamen='" + rezeptName + '\'' +
                ", rezeptBeschreibung='" + rezeptBeschreibung + '\'' +
                ", rezeptZutaten='" + rezeptZutaten + '\'' +
                ", kategorie='" +  kategorie + "\'" +
                '}';
    }
}
