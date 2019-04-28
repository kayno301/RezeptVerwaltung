package com.example.demo.factories;

import com.example.demo.entities.*;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RezeptFactory {

    public RezeptFactory (){}

    public Rezept createRezept(String rezeptNamen, String rezeptBeschreibung, Kategorie kategorieName, Koch koch1, Speisekarte speisekarte, Set<Zutat> zutaten) {

        Kategorie kategorieObj = kategorieName;
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung);

        r1.setZutaten(zutaten);



        Koch koch = koch1;

        r1.setSpeisekarte(speisekarte);

        r1.setKategorie(kategorieName);

        r1.setKoch(koch1);

        return r1;
    }



}
