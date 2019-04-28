package com.example.demo.reporsitories;

import java.util.List;

import com.example.demo.entities.Zutat;
import org.springframework.data.repository.CrudRepository;

public interface ZutatReporsitory extends CrudRepository<Zutat, Long> {
    public List<Zutat> findByZutatName(String zutatName);
}
