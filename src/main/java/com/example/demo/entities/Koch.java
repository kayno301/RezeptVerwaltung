package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Koch extends Mitarbeiter {
    @OneToMany(mappedBy = "koch", cascade = CascadeType.PERSIST)
    private Set<Rezept> rezepte = new HashSet<>();

    protected Koch() {
    }
    public Koch(String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
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
