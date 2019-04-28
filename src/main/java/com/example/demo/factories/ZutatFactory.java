package com.example.demo.factories;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Zutat;

import java.util.HashSet;
import java.util.Set;

public class ZutatFactory {

    public ZutatFactory (){}

    public Zutat createZutat(String zutatNamen, int zutatMenge) {

        Zutat zutat = new Zutat(zutatNamen, zutatMenge);
        zutat.setZutatName(zutatNamen);
        zutat.setZutatMenge(zutatMenge);


        return zutat;
    }
}
