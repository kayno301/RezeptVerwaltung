package com.example.demo.entities;

import javax.persistence.Entity;

@Entity
public class Manager extends Mitarbeiter {
    protected Manager (){}

    public Manager( String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
    }
}
