package com.example.demo.factories;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.stereotype.Component;

@Component
public class SpeisekarteFactory {

    public SpeisekarteFactory (){}

    public Speisekarte createSpeisekarte (String speisekartenNamen, Manager manager){

        Speisekarte speisekarten = new Speisekarte(speisekartenNamen);

        speisekarten.setManager(manager);

        



        return speisekarten ;
    }
}
