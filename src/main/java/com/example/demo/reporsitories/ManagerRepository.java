package com.example.demo.reporsitories;

import com.example.demo.entities.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager, Long> {
}
