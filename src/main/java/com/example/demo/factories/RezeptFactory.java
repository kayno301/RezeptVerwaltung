package com.example.demo.factories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

@Component
public class RezeptFactory {

    public RezeptFactory() {
    }

    public Rezept createRezept(String rezeptNamen, String rezeptBeschreibung, String rezeptZutaten, Kategorie kategorieName, Koch koch, Speisekarte speisekarte) {
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung, rezeptZutaten);

        r1.setSpeisekarte(speisekarte);
        r1.setKategorie(kategorieName);
        r1.setKoch(koch);

        return r1;
    }
}