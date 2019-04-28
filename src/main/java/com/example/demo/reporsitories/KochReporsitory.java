package com.example.demo.reporsitories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Rezept;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface KochReporsitory extends CrudRepository<Koch, Long> {
    List<Koch> findByMitarbeitername(String mitarbeitername);
    List<Koch> findByMitarbeitervornamen(String mitarbeitervornamen);
    List<Koch> findById(long id);
    List<Koch> findByRezepte(Set<Rezept> rezepte);
}
