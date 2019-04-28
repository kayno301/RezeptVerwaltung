package com.example.demo.services;

import com.example.demo.entities.Manager;
import com.example.demo.factories.ManagerFactory;
import com.example.demo.reporsitories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;

    @RequestMapping(path = "/manager", method = RequestMethod.GET)
    public List<Manager> getAllManager() {
        return (List<Manager>) managerRepository.findAll();
    }

    /**
     * Einen bestimmten Manager auslesen
     *
     * @return
     */
    @RequestMapping(path = "/manager/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMangerById(@PathVariable("id") Long id) {
        Manager m1 = managerRepository.findOne(id);
        if (m1 == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(m1);
    }

    /**
     * Einen Kunden löschen
     *
     * @return
     */
    @RequestMapping(path = "/manager/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRezept(@PathVariable("id") Long id) {
        if (managerRepository.exists(id)) {
            managerRepository.delete(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    /**
     * Einen Kunden neu anlegen
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public ResponseEntity<?> persistPerson(
            @RequestParam("mitarbeiterName") String mitarbeiterName, @RequestParam("mitarbeiterVornamen") String mitarbeiterVornamen) {
        Manager k = managerRepository.save(new ManagerFactory().createManager(mitarbeiterName, mitarbeiterVornamen));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }
}