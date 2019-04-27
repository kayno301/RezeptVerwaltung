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

    public Rezept createRezept (String speisekartenNamen, String rezeptNamen, String rezeptBeschreibung, String rezeptZutaten,  String kategorieName){
        Speisekarte speisekarte1 = new Speisekarte(speisekartenNamen);
        Kategorie kategorieObj = new Kategorie(kategorieName);
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung, rezeptZutaten, speisekarte1);

        r1.setSpeisekarte(speisekarte1);



        return r1;
    }



}
