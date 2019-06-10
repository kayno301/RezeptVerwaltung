package com.example.demo.reporsitories;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface SpeisekarteReporsitory extends CrudRepository<Speisekarte, Long> {
    public Speisekarte findById(int id);
    List<Speisekarte> findById(long id);
    List<Speisekarte> findByManager(Manager manager);
    List<Speisekarte> findBySpeisekarteNamen(String speisekarteNamen);
    List<Speisekarte> findByRezepte(Set<Rezept> rezepte);
}