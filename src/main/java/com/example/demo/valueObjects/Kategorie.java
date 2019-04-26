package com.example.demo.valueObjects;


import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Kategorie{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String kategorieName;

    protected Kategorie() {
    }

    public Kategorie(String kategorieName) {
        this.kategorieName = kategorieName;
    }

    public String toString(){
        return this.kategorieName;
    }
}
