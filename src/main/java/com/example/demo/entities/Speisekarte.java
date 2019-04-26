package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Speisekarte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "speisekarte", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Rezept> rezepte = new HashSet<>();

    private String speisekarteNamen;

    public void addRezepte(Rezept rezept) {
        this.rezepte.add(rezept);
        if (rezept.getSpeisekarte() != this) {
            rezept.setSpeisekarte(this);
        }
    }

    public String toString() {
        String retVal = "Speisekarte Namen: " + speisekarteNamen ;
        for (Rezept rezept : rezepte) {
            retVal += rezept.toString();
        }
        return retVal;
    }

    protected Speisekarte(){}

    public Speisekarte(String speisekarteNamen) {
        this.speisekarteNamen = speisekarteNamen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Rezept> getRezepte() {
        return rezepte;
    }

    public void setRezepte(Set<Rezept> rezepte) {
        this.rezepte = rezepte;
    }

    public String getSpeisekarteNamen() {
        return speisekarteNamen;
    }

    public void setSpeisekarteNamen(String speisekarteNamen) {
        this.speisekarteNamen = speisekarteNamen;
    }
}
