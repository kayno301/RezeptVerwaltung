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

    public Rezept createRezept ( String rezeptNamen, String rezeptBeschreibung, String rezeptZutaten,  Kategorie kategorieName, Koch koch1){

        Kategorie kategorieObj = kategorieName;
        Rezept r1 = new Rezept(rezeptNamen, rezeptBeschreibung, rezeptZutaten);





        Koch koch = koch1;

        r1.setKategorie(kategorieName);

        r1.setKoch(koch1);

        return r1;
    }



}
