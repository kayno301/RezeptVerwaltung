package com.example.demo.factories;

import com.example.demo.entities.Zutat;

public class ZutatFactory {

    public ZutatFactory (){}

    public Zutat createZutat (String zutatNamen, int zutatMenge){
        Zutat z1 = new Zutat (zutatNamen, zutatMenge);

        return z1;
    }
}
