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
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        miRep.save(koch1);
        

        Zutat z1 = new ZutatFactory().createZutat("Zitrone", 2);
        zutatReporsitory.save(z1);


        Manager m2 = new ManagerFactory().createManager("Kamal","Hida");
        managerRepository.save(m2);
        Speisekarte s2 = new SpeisekarteFactory().createSpeisekarte("Restaurant", m2);
        sRep.save(s2);
        Rezept r1 = new RezeptFactory().createRezept( "Spaghetti", "Jaja", "Reiss", k1, koch1, s2);
        spRep.save(r1);
        //spRep.save(new RezeptFactory().createRezept( "Spaghetti", "Jaja", "Reiss", k1, koch1, s2));

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