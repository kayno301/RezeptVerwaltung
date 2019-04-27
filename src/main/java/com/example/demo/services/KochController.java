package com.example.demo.services;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Manager;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.factories.KochFactory;
import com.example.demo.factories.ManagerFactory;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.KochReporsitory;
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
public class KochController {

    @Autowired
    private KochReporsitory kochReporsitory;

    /**
     * Alle Kunden auslesen
     * @return
     */
    @RequestMapping(path = "/koch", method = RequestMethod.GET)
    public List<Koch> getAllRezept() {
        return (List<Koch>) kochReporsitory.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     * @return
     */
    @RequestMapping(path="/koch/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRezeptById(@PathVariable("id") Long id ) {
        Koch r1 = kochReporsitory.findOne(id);
        if ( r1 == null ) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body( r1 );
    }

    /**
     * Einen Kunden löschen
     * @return
     */
    @RequestMapping(path="/koch/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRezept(@PathVariable("id") Long id) {
        if ( kochReporsitory.exists(id) ) {
            kochReporsitory.delete(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     * @return
     */
    @RequestMapping(value = "/koch", method = RequestMethod.POST)
    public ResponseEntity <?> persistPerson(
            @RequestParam("mitarbeiterName") String mitarbeiterName, @RequestParam("mitarbeiterVornamen") String mitarbeiterVornamen)
    {
        Koch k = kochReporsitory.save(new KochFactory().createKoch(mitarbeiterName, mitarbeiterVornamen));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand( k.getId() ).toUri();
        return ResponseEntity.created( location ).body( k );
    }

}



