package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Mitarbeiter {
    protected Manager (){}


    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Speisekarte speisekarte;



    public Manager(String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);

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
