package com.example.demo;

import com.example.demo.factories.MitarbeiterFactory;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.reporsitories.MitarbeiterReporsitory;
import com.example.demo.reporsitories.RezeptReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.SpeisekarteReporsitory;

@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RezeptReporsitory spRep;

    @Autowired
    private MitarbeiterReporsitory miRep;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {


        spRep.save(new RezeptFactory().createRezept("Test", "Spaghetti", "Jaja", "Reiss", "Max", "Mustermann"));

    }


    public SampleData() {

    }


}
