package com.example.demo.factories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Rezept;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class KochFactory {

    public KochFactory(){}

    public Koch createKoch(String mitarbeiternamen, String mitarbeitervornamen){
        Koch m1=new Koch(mitarbeiternamen,mitarbeitervornamen);

        m1.getRezepte();




        return m1;
    }
}
