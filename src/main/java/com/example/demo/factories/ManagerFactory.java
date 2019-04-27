package com.example.demo.factories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Manager;
import com.example.demo.entities.Speisekarte;
import org.springframework.stereotype.Component;

@Component
public class ManagerFactory {

    public ManagerFactory(){}

    public Manager createManager(String mitarbeiternamen, String mitarbeitervornamen, Speisekarte speisekarte){


        Manager m1 = new Manager(mitarbeiternamen, mitarbeitervornamen,speisekarte);
        m1.setMitarbeitername(mitarbeiternamen);
        m1.setMitarbeitervornamen(mitarbeitervornamen);
        Speisekarte speisekarte1=speisekarte;
        m1.setSpeisekarte(speisekarte1);



        return m1;
    }
}
