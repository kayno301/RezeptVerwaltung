package com.example.demo.services;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.factories.ManagerFactory;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.ManagerRepository;
import com.example.demo.reporsitories.RezeptReporsitory;
import com.example.demo.reporsitories.SpeisekarteReporsitory;
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

    /**
     * Alle Kunden auslesen
     * @return
     */
    @RequestMapping(path = "/manager", method = RequestMethod.GET)
    public List<Manager> getAllRezept() {
        return (List<Manager>) managerRepository.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     * @return
     */
    @RequestMapping(path="/manager/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRezeptById(@PathVariable("id") Long id ) {
        Manager r1 = managerRepository.findOne(id);
        if ( r1 == null ) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body( r1 );
    }

    /**
     * Einen Kunden löschen
     * @return
     */
    @RequestMapping(path="/manager/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRezept(@PathVariable("id") Long id) {
        if ( managerRepository.exists(id) ) {
            managerRepository.delete(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public ResponseEntity <?> persistPerson(
            @RequestParam("mitarbeiterName") String mitarbeiterName, @RequestParam("mitarbeiterVornamen") String mitarbeiterVornamen)
    {
        Manager k = managerRepository.save(new ManagerFactory().createManager(mitarbeiterName, mitarbeiterVornamen));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand( k.getId() ).toUri();
        return ResponseEntity.created( location ).body( k );
    }

}




