package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Speisekarte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "speisekarte")
    @JsonManagedReference
    private Set<Rezept> rezepte = new HashSet<>();

    @OneToOne
    @JsonManagedReference
    private Manager manager;

    private String speisekarteNamen;

    public void addRezepte(Rezept rezept) {
        this.rezepte.add(rezept);
        if (rezept.getSpeisekarte() != this) {
            rezept.setSpeisekarte(this);
        }
    }

    public String toString() {
        String retVal = "Speisekarte Namen: " + speisekarteNamen;
        return retVal;
    }

    protected Speisekarte() {
    }

    public Speisekarte(String speisekarteNamen) {
        this.speisekarteNamen = speisekarteNamen;
    }

    public Speisekarte(Set<Rezept> rezepte, Manager manager, String speisekarteNamen) {
        this.rezepte = rezepte;
        this.manager = manager;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        if (this.manager != null)
            this.setManager(null);
        this.manager = manager;
    }
}
