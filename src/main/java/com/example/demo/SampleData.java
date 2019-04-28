package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.factories.*;
import com.example.demo.reporsitories.*;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RezeptReporsitory spRep;

    @Autowired
    private KochReporsitory miRep;

    @Autowired
    private SpeisekarteReporsitory sRep;
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ZutatReporsitory zutatReporsitory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        Kategorie k1 = new Kategorie ("Vegan");
        Kategorie k2 = new Kategorie ("Hausmannskost");
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        miRep.save(koch1);
        Koch koch2 = new KochFactory().createKoch("Maximilian", "Herrmann");
        miRep.save(koch2);




        Manager m2 = new ManagerFactory().createManager("Kamal","Hida");
        managerRepository.save(m2);
        Speisekarte s2 = new SpeisekarteFactory().createSpeisekarte("Restaurant", m2);
        sRep.save(s2);
        Rezept r1 = new RezeptFactory().createRezept( "Spaghetti", "Jaja" , k1, koch2, s2);
        spRep.save(r1);
        spRep.save(new RezeptFactory().createRezept( "Nudeln", "Kochen Sie die Nudeln", k1, koch1, s2));
        spRep.save(new RezeptFactory().createRezept( "Fleisch", "Schneiden Sie das Fleisch", k2, koch1, s2));

        Zutat z1 = new ZutatFactory().createZutat("Zitrone", 2, r1);
        //zutatReporsitory.save(z1);
        //      find method to list all workers called Kamal
        /*List<Koch>kochList=miRep.findByMitarbeitername("Kamal");
        for(Koch koch:kochList) {
            System.out.println(koch.getMitarbeitername());
        }*/
        System.out.println(spRep.findByRezeptName("Spaghetti").toString());
    }

    public SampleData() {

    }
}