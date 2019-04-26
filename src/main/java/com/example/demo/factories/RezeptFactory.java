package com.example.demo.factories;

import com.example.demo.entities.Mitarbeiter;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import org.springframework.stereotype.Component;

@Component
public class RezeptFactory {

    public RezeptFactory (){}

    public Rezept createRezept (String speisekartenNamen, String rezeptNamen, String rezeptBeschreibung, String rezeptZutaten, String mitarbeiterNamen, String mitarbeiterVornamen){
        Speisekarte speisekarte1 = new Speisekarte(speisekartenNamen);
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung, rezeptZutaten, speisekarte1);

        Mitarbeiter m1 = new Mitarbeiter(mitarbeiterNamen, mitarbeiterVornamen);
        r1.setSpeisekarte(speisekarte1);



        return r1;
    }



}
