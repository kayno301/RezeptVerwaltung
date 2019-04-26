package com.example.demo.factories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerFactory {

    public ManagerFactory(){}

    public Manager createManager(String mitarbeiternamen, String mitarbeitervornamen){

        Manager m1 = new Manager(mitarbeiternamen, mitarbeitervornamen);

        return m1;
    }
}
