package com.example.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Koch extends Mitarbeiter{


    protected Koch (){}

    public Koch( String mitarbeitername, String mitarbeitervornamen) {
        super(mitarbeitername, mitarbeitervornamen);
    }
}
