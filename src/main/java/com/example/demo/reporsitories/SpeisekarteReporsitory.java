package com.example.demo.reporsitories;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpeisekarteReporsitory extends CrudRepository<Speisekarte, Long> {

}
