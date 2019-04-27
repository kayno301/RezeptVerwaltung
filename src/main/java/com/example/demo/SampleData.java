package com.example.demo;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Manager;
import com.example.demo.factories.KochFactory;
import com.example.demo.factories.ManagerFactory;
import com.example.demo.factories.RezeptFactory;
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
    private SpeisekarteReporsitory speisekarteReporsitory;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {


        Kategorie k1 = new Kategorie ("Vegan");
        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        miRep.save(koch1);
        spRep.save(new RezeptFactory().createRezept("Test", "Spaghetti", "Jaja", "Reiss", k1, koch1));

        spRep.save(new RezeptFactory().createRezept("Test", "Spaghetti", "Jaja", "Reiss", k1, koch1));
        //managerRepository.save(new ManagerFactory().createManager("Hida","Kamal",))

    }


    public SampleData() {

    }


}
