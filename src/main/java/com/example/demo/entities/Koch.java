package com.example.demo.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Koch extends Mitarbeiter {
    @OneToMany(mappedBy = "koch", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Rezept> rezepte = new HashSet<>();



    public Koch() {
    }



    public Koch(String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
    }

    public Koch(String mitarbeitername, String mitarbeitervornamen, int gehalt){
        super(mitarbeitername, mitarbeitervornamen, gehalt);
    }

    public Set<Rezept> getRezepte() {
        return rezepte;
    }

    public void setRezepte(Set<Rezept> rezepte) {
        this.rezepte = rezepte;
    }

    @Override
    public String toString() {
        return "Koch{" +
                "rezepte=" + rezepte +
                '}';
    }
}
