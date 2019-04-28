package com.example.demo;

import java.util.HashSet;
import java.util.Set;

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
        Kategorie kategorieVegan = new Kategorie("Vegan");
        Kategorie kategorieFastFood = new Kategorie("FastFood");

        Koch koch1 = new KochFactory().createKoch("Max", "Mustermann");
        Koch koch2 = new KochFactory().createKoch("Mario", "Italia");
        kochReporsitory.save(koch1);
        kochReporsitory.save(koch2);

        Zutat zutatSpaghetti = new ZutatFactory().createZutat("Spaghetti", 2);
        Zutat zutatKaese = new ZutatFactory().createZutat("Käse", 1000);
        Zutat zutatPizzateig = new ZutatFactory().createZutat("Pizzateig", 2500); 
        zutatReporsitory.save(zutatSpaghetti);
        zutatReporsitory.save(zutatKaese);
        zutatReporsitory.save(zutatPizzateig);

        Manager manager = new ManagerFactory().createManager("Hida", "Kamal");
        managerReporsitory.save(manager);

        Speisekarte speisekarte = new SpeisekarteFactory().createSpeisekarte("Restaurant", manager);
        speisekartenReporsitory.save(speisekarte);

        Rezept rezeptSpaghetti = new RezeptFactory().createRezept("Spaghetti", "Jaja", "Reiss", kategorieVegan, koch1, speisekarte);
        Rezept rezeptPizza = new RezeptFactory().createRezept("Pizza", "Magaritha", "Käse, Tomatensoße, Pizzateig", kategorieFastFood, koch2, speisekarte);
        rezeptReporsitory.save(rezeptSpaghetti);
        rezeptReporsitory.save(rezeptPizza);        
        
        System.out.println(rezeptReporsitory.findByRezeptName("Spaghetti"));
        System.out.println(rezeptReporsitory.findByRezeptName("Pizza"));
        System.out.println(speisekartenReporsitory.findByManager(managerReporsitory.findByMitarbeitername("Hida").get(0)));
    }

    public SampleData() {
    }
}