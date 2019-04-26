package com.example.demo.entities;



import javax.persistence.*;
import java.util.Collection;

@Entity
public class Zutat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zutatName;
    private int zutatMenge;

    @ManyToMany(cascade= CascadeType.MERGE,fetch= FetchType.EAGER)
    private Collection<Rezept>rezepts;

    public Zutat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZutatName() {
        return zutatName;
    }

    public void setZutatName(String zutatName) {
        this.zutatName = zutatName;
    }

    public int getZutatMenge() {
        return zutatMenge;
    }

    public void setZutatMenge(int zutatMenge) {
        this.zutatMenge = zutatMenge;
    }

    public Collection<Rezept> getRezepts() {
        return rezepts;
    }

    public void setRezepts(Collection<Rezept> rezepts) {
        this.rezepts = rezepts;
    }

    @Override
    public String toString() {
        return "Zutat{" +
                "id=" + id +
                ", zutatName='" + zutatName + '\'' +
                ", zutatMenge=" + zutatMenge +
                ", rezepts=" + rezepts +
                '}';
    }
}
