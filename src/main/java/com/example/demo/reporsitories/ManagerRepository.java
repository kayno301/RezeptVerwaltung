package com.example.demo.reporsitories;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Speisekarte;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    List<Manager> findByMitarbeitername(String mitarbeitername);
    List<Manager> findByMitarbeitervornamen(String mitarbeitervornamen);
    List<Manager> findById(long id);
    List<Manager> findBySpeisekarte(Speisekarte speisekarte);
}
