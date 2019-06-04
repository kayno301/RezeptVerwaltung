package com.example.demo.factories;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Zutat;
import org.springframework.stereotype.Component;

@Component
public class ZutatFactory {

    public ZutatFactory (){}

    public Zutat createZutat (String zutatNamen, int zutatMenge, Rezept rezept){
        Zutat z1 = new Zutat (zutatNamen, zutatMenge);

        z1.setZutatName(zutatNamen);
        z1.setZutatMenge(zutatMenge);

        z1.addRezept(rezept);
        rezept.addZutat(z1);

        return z1;
    }
}
