package com.example.demo.reporsitories;

import java.util.List;

import com.example.demo.entities.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
    public List<Manager> findByMitarbeitername(String mitarbeitername); 
}
