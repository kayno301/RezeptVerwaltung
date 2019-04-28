package com.example.demo.services;

import com.example.demo.entities.Koch;
import com.example.demo.entities.Rezept;
import com.example.demo.entities.Speisekarte;
import com.example.demo.entities.Zutat;
import com.example.demo.factories.RezeptFactory;
import com.example.demo.reporsitories.RezeptReporsitory;
import com.example.demo.valueObjects.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
public class RezeptController {

    @Autowired
    private RezeptReporsitory rezeptReporsitory;

    /**
     * Alle Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/rezept", method = RequestMethod.GET)
    public List<Rezept> getAllRezept() {
        return (List<Rezept>) rezeptReporsitory.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/rezept/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRezeptById(@PathVariable("id") Long id) {
        Rezept r1 = rezeptReporsitory.findOne(id);
        if (r1 == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(r1);
    }

    /**
     * Einen Kunden löschen
     *
     * @return
     */
    @RequestMapping(path = "/rezept/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRezept(@PathVariable("id") Long id) {
        if (rezeptReporsitory.exists(id)) {
            rezeptReporsitory.delete(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     *
     * @return
     */
    @RequestMapping(value = "/rezept", method = RequestMethod.POST)
    public ResponseEntity<?> persistPerson(
            @RequestParam("rezeptNamen") String rezeptNamen,
            @RequestParam("rezeptBeschreibung") String rezeptBeschreibung, @RequestParam("kategorieName") Kategorie kategorieName, @RequestParam("koch") Koch koch1, @RequestParam("speisekarte") Speisekarte speisekarte,
            @RequestParam("zutaten") Set<Zutat> zutaten) {
        Rezept k = rezeptReporsitory.save(new RezeptFactory().createRezept(rezeptNamen, rezeptBeschreibung, kategorieName, koch1, speisekarte, zutaten));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }

}




