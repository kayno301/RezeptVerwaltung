package com.example.demo.reporsitories;

import java.util.List;

import com.example.demo.entities.Rezept;
import org.springframework.data.repository.CrudRepository;

public interface RezeptReporsitory extends CrudRepository<Rezept, Long> {
    public List<Rezept> findByRezeptName(String rezeptName);
}
