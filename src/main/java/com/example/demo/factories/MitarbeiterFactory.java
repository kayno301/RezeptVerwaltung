package com.example.demo.factories;

import com.example.demo.entities.Mitarbeiter;
import org.springframework.stereotype.Component;

@Component
public class MitarbeiterFactory {

    public MitarbeiterFactory (){}

    public Mitarbeiter createMitarbeiter(String mitarbeiternamen, String mitarbeitervornamen){

        Mitarbeiter m1 = new Mitarbeiter(mitarbeiternamen, mitarbeitervornamen);





        return m1;
    }
}
