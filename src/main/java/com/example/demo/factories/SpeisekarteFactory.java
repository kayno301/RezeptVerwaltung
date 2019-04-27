package com.example.demo.factories;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

@Component
public class SpeisekarteFactory {

    public SpeisekarteFactory (){}

    public Speisekarte createSpeisekarte (String speisekartenNamen, Rezept rezept, Manager manager){

        Speisekarte speisekarten = new Speisekarte(speisekartenNamen);
        Manager manager1 = manager ;

        speisekarten.setManager(manager1);
        return speisekarten ;
    }
}
