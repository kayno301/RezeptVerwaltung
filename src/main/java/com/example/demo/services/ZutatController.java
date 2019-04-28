package com.example.demo.services;

import com.example.demo.entities.Rezept;
import com.example.demo.entities.Zutat;
import com.example.demo.factories.ZutatFactory;
import com.example.demo.reporsitories.ZutatReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ZutatController {

    @Autowired
    private ZutatReporsitory zutatRep;

    /**
     * Alle Kunden auslesen
     * @return
     */
    @RequestMapping(path = "/zutat", method = RequestMethod.GET)
    public List<Zutat> getAllZutat() {
        return (List<Zutat>) zutatRep.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     * @return
     */
    @RequestMapping(path="/zutat/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSpeisekarteById(@PathVariable("id") Long id ) {
        Zutat z1 = zutatRep.findOne(id);
        if ( z1 == null ) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body( z1 );
    }

    /**
     * Einen Kunden löschen
     * @return
     */
    @RequestMapping(path="/zutat/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSpeisekarte(@PathVariable("id") Long id) {
        if ( zutatRep.exists(id) ) {
            zutatRep.delete(id);
            return ResponseEntity.ok().build();
        }
        else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     * @return
     */
    @RequestMapping(value = "/zutat", method = RequestMethod.POST)
    public ResponseEntity <?> persistPerson(
            @RequestParam("zutatNamen") String zutatNamen, @RequestParam("zutatMenge") int zutatMenge)
    {
        Zutat k = zutatRep.save(new ZutatFactory().createZutat(zutatNamen, zutatMenge));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand( k.getId() ).toUri();
        return ResponseEntity.created( location ).body( k );
    }

}




