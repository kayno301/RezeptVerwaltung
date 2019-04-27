package com.example.demo;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.factories.KochFactory;
import com.example.demo.factories.ManagerFactory;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.KochReporsitory;
import com.example.demo.reporsitories.ManagerRepository;
import com.example.demo.reporsitories.RezeptReporsitory;
import com.example.demo.reporsitories.SpeisekarteReporsitory;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {



        Speisekarte s1 = new SpeisekarteFactory().createSpeisekarte("Restaurant");


        sRep.save(s1);
        Kategorie k1 = new Kategorie ("Vegan");
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        miRep.save(koch1);
        Rezept r1 = new RezeptFactory().createRezept( "Spaghetti", "Jaja", "Reiss", k1, koch1);
        spRep.save(r1);

        spRep.save(new RezeptFactory().createRezept( "Spaghetti", "Jaja", "Reiss", k1, koch1));
        Manager m2=new ManagerFactory().createManager("Kamal","Hida",s1);
        managerRepository.save(m2);

    }


    public SampleData() {

    }


}
