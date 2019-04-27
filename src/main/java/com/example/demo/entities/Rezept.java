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


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Speisekarte speisekarte;

    @ManyToOne
    @JsonBackReference
    private Koch koch;

    @ManyToMany(mappedBy = "rezept", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Zutat> zutat = new HashSet<>();

    private String rezeptNamen;
    private String rezeptBeschreibung;
    private String rezeptZutaten;

    @Embedded
    private Kategorie kategorie;

    @ManyToMany(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
    private Collection<Zutat>zutats;


    protected Rezept (){}

    public Rezept(Speisekarte speisekarte, String rezeptNamen, String rezeptBeschreibung,
                  String rezeptZutaten, Kategorie kategorie, Collection<Zutat> zutats
                  ) {
        this.speisekarte = speisekarte;
        this.rezeptNamen = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
        this.rezeptZutaten = rezeptZutaten;
        this.kategorie = kategorie;
        this.zutats = zutats;

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
                   Speisekarte speisekarte
                   /*Kategorie kategorie*/){
        this.rezeptNamen = rezeptNamen;
        this.rezeptBeschreibung = rezeptBeschreibung;
        this.rezeptZutaten = rezeptZutaten;
        this.speisekarte = speisekarte;
        //this.kategorie = kategorie;

    }

    @Override
    public String toString() {
        return "Rezept{" +
                "id=" + id +
                ", speisekarte=" + speisekarte +
                ", rezeptNamen='" + rezeptNamen + '\'' +
                ", rezeptBeschreibung='" + rezeptBeschreibung + '\'' +
                ", rezeptZutaten='" + rezeptZutaten + '\'' +
                ", kategorie='" + /* kategorie + */"\'" +
                '}';
    }
}
