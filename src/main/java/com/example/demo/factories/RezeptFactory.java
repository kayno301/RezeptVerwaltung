package com.example.demo.factories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Mitarbeiter;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

@Component
public class RezeptFactory {
    public RezeptFactory (){}

    public Rezept createRezept (String rezeptNamen, String rezeptBeschreibung,  Kategorie kategorieName, Koch koch1, Speisekarte speisekarte){
        Rezept r1 = new Rezept(speisekarte, rezeptNamen, rezeptBeschreibung, kategorieName);

        r1.setKoch(koch1);
        return r1;
    }
}