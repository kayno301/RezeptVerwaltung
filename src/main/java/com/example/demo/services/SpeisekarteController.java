package com.example.demo.services;

import com.example.demo.entities.Manager;
import com.example.demo.entities.Speisekarte;
import com.example.demo.factories.SpeisekarteFactory;
import com.example.demo.reporsitories.SpeisekarteReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SpeisekarteController {
    @Autowired
    private SpeisekarteReporsitory speisekarteRepository;

    /**
     * Alle Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/speisekarte", method = RequestMethod.GET)
    public List<Speisekarte> getAllSpeisekarten() {
        return (List<Speisekarte>) speisekarteRepository.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/speisekarte/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpeisekarteById(@PathVariable("id") Long id) {
        Speisekarte sp1 = speisekarteRepository.findOne(id);
        if (sp1 == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(sp1);
    }

    /**
     * Einen Kunden löschen
     *
     * @return
     */
    @RequestMapping(path = "/speisekarte/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSpeisekarte(@PathVariable("id") Long id) {
        if (speisekarteRepository.exists(id)) {
            speisekarteRepository.delete(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }

    /**
     * Einen Kunden neu anlegen
     *
     * @return
     */
    @RequestMapping(value = "/speisekarte", method = RequestMethod.POST)
    public ResponseEntity<?> persistPerson(@RequestParam("speisekartenNamen") String speisekartenNamen, @RequestParam("manager") Manager manager
    ) {
        Speisekarte k = speisekarteRepository.save(new SpeisekarteFactory().createSpeisekarte(speisekartenNamen, manager));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }
}