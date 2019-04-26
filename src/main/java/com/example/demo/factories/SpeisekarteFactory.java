package com.example.demo.factories;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

@Component
public class SpeisekarteFactory {

    public SpeisekarteFactory (){}

    public Speisekarte createSpeisekarte (String speisekartenNamen, String rezeptNamen, String rezeptBeschreibung, String rezeptZutaten, String kategorie){
        Speisekarte speisekarte1 = new Speisekarte(speisekartenNamen);
        Kategorie k1 = new Kategorie(kategorie);
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung, rezeptZutaten, speisekarte1, k1);

        r1.setSpeisekarte(speisekarte1);
//fh


        return speisekarte1;
    }
}
