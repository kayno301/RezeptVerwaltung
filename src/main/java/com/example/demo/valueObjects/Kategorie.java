package com.example.demo.valueObjects;


import javax.persistence.*;

@Embeddable
public class Kategorie{


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
