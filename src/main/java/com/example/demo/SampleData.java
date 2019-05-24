package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.factories.*;
import com.example.demo.reporsitories.*;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
        Kategorie k1 = new Kategorie("Vegan");
        Kategorie k2 = new Kategorie("Hausmannskost");
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        miRep.save(koch1);
        Koch koch2 = new KochFactory().createKoch("Maximilian", "Herrmann");
        miRep.save(koch2);

        Manager m2 = new ManagerFactory().createManager("Kamal", "Hida");
        managerRepository.save(m2);
        Speisekarte s2 = new SpeisekarteFactory().createSpeisekarte("Restaurant", m2);


        Zutat z1 = new ZutatFactory().createZutat("Zitrone", 2);
        Set<Zutat> zutaten1 = new HashSet<Zutat>();
        zutaten1.add(z1);
        zutatReporsitory.save(zutaten1);
        sRep.save(s2);
        Rezept r1 = new RezeptFactory().createRezept("Spaghetti", "Jaja", k1, koch2, s2, zutaten1);
        spRep.save(r1);
        spRep.save(new RezeptFactory().createRezept("Nudeln", "Kochen Sie die Nudeln", k1, koch1, s2, zutaten1));
        spRep.save(new RezeptFactory().createRezept("Fleisch", "Schneiden Sie das Fleisch", k2, koch1, s2, zutaten1));

        System.out.println(spRep.findByRezeptName("Spaghetti").toString());

    }

    public SampleData() {
    }
}