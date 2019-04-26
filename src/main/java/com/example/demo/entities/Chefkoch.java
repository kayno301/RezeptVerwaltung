package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chefkoch extends Koch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Chefkoch() {
    }

    public Chefkoch(String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitername);
    }
}