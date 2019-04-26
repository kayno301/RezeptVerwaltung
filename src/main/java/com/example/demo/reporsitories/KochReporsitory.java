package com.example.demo.reporsitories;

import com.example.demo.entities.Koch;
import org.springframework.data.repository.CrudRepository;

public interface KochReporsitory extends CrudRepository<Koch, Long> {
}
