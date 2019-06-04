package com.example.demo.factories;

import com.example.demo.entities.Zutat;

import org.springframework.stereotype.Component;

@Component
public class ZutatFactory {

    public ZutatFactory() {
    }

    public Zutat createZutat(String zutatNamen, int zutatMenge) {
        Zutat zutat = new Zutat(zutatNamen, zutatMenge);
        zutat.setZutatName(zutatNamen);
        zutat.setZutatMenge(zutatMenge);

        return zutat;
    }
}
