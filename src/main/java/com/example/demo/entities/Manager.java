package com.example.demo.entities;

import javax.persistence.OneToOne;

public class Manager extends Mitarbeiter {

    @OneToOne
    private  Speisekarte speisekarte;
    protected Manager (){}

    public Manager( String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
    }
}
