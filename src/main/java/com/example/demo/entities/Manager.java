package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Mitarbeiter {
    protected Manager (){}

    @OneToOne
    private Speisekarte speisekarte;

    public Manager( String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
    }
}
