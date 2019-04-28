package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.factories.*;
import com.example.demo.reporsitories.*;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RezeptReporsitory rezeptReporsitory;

    @Autowired
    private KochReporsitory kochReporsitory;

    @Autowired
    private SpeisekarteReporsitory speisekartenReporsitory;
    @Autowired
    private ManagerRepository managerReporsitory;

    @Autowired
    private ZutatReporsitory zutatReporsitory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        Kategorie kategorie1 = new Kategorie("Vegan");
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        kochReporsitory.save(koch1);

        Zutat zutat1 = new ZutatFactory().createZutat("Zitrone", 2);
        zutatReporsitory.save(zutat1);

        Manager manager2 = new ManagerFactory().createManager("Kamal", "Hida");
        managerReporsitory.save(manager2);

        Speisekarte speisekarte2 = new SpeisekarteFactory().createSpeisekarte("Restaurant", manager2);
        speisekartenReporsitory.save(speisekarte2);

        Rezept rezept1 = new RezeptFactory().createRezept("Spaghetti", "Jaja", "Reiss", kategorie1, koch1, speisekarte2);
        rezeptReporsitory.save(rezept1);
        //spRep.save(new RezeptFactory().createRezept( "Spaghetti", "Jaja", "Reiss", k1, koch1, s2));

        //      find method to list all workers called Kamal
        /*List<Koch>kochList=miRep.findByMitarbeitername("Kamal");
        for(Koch koch:kochList) {
            System.out.println(koch.getMitarbeitername());
        }*/
        System.out.println(rezeptReporsitory.findByRezeptName("Spaghetti"));
    }

    public SampleData() {
    }
}