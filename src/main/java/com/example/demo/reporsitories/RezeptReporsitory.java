package com.example.demo.reporsitories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.entities.Zutat;
import com.example.demo.valueObjects.Kategorie;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RezeptReporsitory extends CrudRepository<Rezept, Long> {
    List<Rezept> findById(long id);
    List<Rezept> findBySpeisekarte(Speisekarte speisekarte);
    List<Rezept> findByKoch(Koch koch);
    List<Rezept> findByZutaten(Set<Zutat> zutaten);
    List<Rezept> findByRezeptName(String rezeptName);
    List<Rezept> findByRezeptBeschreibung(String rezeptBeschreibung);
    List<Rezept> findByRezeptZutaten(String rezeptZutaten);
    List<Rezept> findByKategorie(Kategorie kategorie);
}