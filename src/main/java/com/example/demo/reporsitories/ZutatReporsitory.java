package com.example.demo.reporsitories;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Zutat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface ZutatReporsitory extends CrudRepository<Zutat, Long> {
    List<Zutat> findById(long id);
    List<Zutat> findByZutatName(String zutatName);
    List<Zutat> findByZutatMenge(int zutatMenge);
    List<Zutat> findByRezepte(Set<Rezept> rezepte);
    List<Zutat> findAll();
}
