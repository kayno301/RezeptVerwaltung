package com.example.demo.services;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.RezeptReporsitory;
import com.example.demo.reporsitories.SpeisekarteReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class RezeptController {

    @Autowired
    private RezeptReporsitory rezeptReporsitory;

    /**
     * Alle Kunden auslesen
     * @return
     */
    @RequestMapping(path = "/rezept", method = RequestMethod.GET)
    public List<Rezept> getAllRezept() {
        return (List<Rezept>) rezeptReporsitory.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     * @return
     */
    @RequestMapping(path="/rezept/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRezeptById(@PathVariable("id") Long id ) {
        Rezept r1 = rezeptReporsitory.findOne(id);
        if ( r1 == null ) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body( r1 );
    }

    /**
     * Einen Kunden löschen
     * @return
     */
    @RequestMapping(path="/rezept/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRezept(@PathVariable("id") Long id) {
        if ( rezeptReporsitory.exists(id) ) {
            rezeptReporsitory.delete(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     * @return
     */
    @RequestMapping(value = "/rezept", method = RequestMethod.POST)
    public ResponseEntity <?> persistPerson(
            @RequestParam("speisekartenNamen") String speisekartenNamen, @RequestParam("rezeptNamen") String rezeptNamen,
            @RequestParam("rezeptBeschreibung") String rezeptBeschreibung, @RequestParam("rezeptZutaten") String rezeptZutaten,
            @RequestParam("mitarbeiterNamen") String mitarbeiterNamen, @RequestParam("mitarbeiterVornamen") String mitarbeiterVornamen,
            @RequestParam("kategorieName") String kategorieName)
    {
        Rezept k = rezeptReporsitory.save(new RezeptFactory().createRezept(speisekartenNamen, rezeptNamen, rezeptBeschreibung, rezeptZutaten,
                                            mitarbeiterNamen, mitarbeiterVornamen, kategorieName));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand( k.getId() ).toUri();
        return ResponseEntity.created( location ).body( k );
    }

}




