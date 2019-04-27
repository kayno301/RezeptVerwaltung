package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Mitarbeiter {
    protected Manager (){}

    @OneToOne
    private Speisekarte speisekarte;

    public Manager(Speisekarte speisekarte) {
        this.speisekarte = speisekarte;
    }

    public Manager(String mitarbeitername, String mitarbeitervornamen, Speisekarte speisekarte) {
        super(mitarbeitername, mitarbeitervornamen);
        this.speisekarte = speisekarte;
    }

    public Speisekarte getSpeisekarte() {
        return speisekarte;
    }

    public void setSpeisekarte(Speisekarte speisekarte) {
        this.speisekarte = speisekarte;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "speisekarte=" + speisekarte +
                '}';
    }
}
