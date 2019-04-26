package com.example.demo.reporsitories;

import com.example.demo.entities.Mitarbeiter;
import com.example.demo.entities.Speisekarte;
import org.springframework.data.repository.CrudRepository;

public interface MitarbeiterReporsitory extends CrudRepository<Mitarbeiter, Long> {
}
