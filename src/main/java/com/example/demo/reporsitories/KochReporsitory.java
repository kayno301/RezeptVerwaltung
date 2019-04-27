package com.example.demo.reporsitories;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KochReporsitory extends CrudRepository<Koch, Long> {

public List<Koch>findByMitarbeitername(String mitarbeitername);


}
