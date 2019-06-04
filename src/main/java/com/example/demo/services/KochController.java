package com.example.demo.services;

import com.example.demo.entities.Koch;
import com.example.demo.factories.KochFactory;
import com.example.demo.reporsitories.KochReporsitory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Koch")
public class KochController {

    @Autowired
    private KochReporsitory kochReporsitory;

    /**
     * Alle Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/koch", method = RequestMethod.GET)
    public List<Koch> getAllKoch() {
        return (List<Koch>) kochReporsitory.findAll();
    }

    /**
     * Einen bestimmten Kunden auslesen
     *
     * @return
     */
    @RequestMapping(path = "/koch/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getKochById(@PathVariable("id") Long id) {
        Koch r1 = kochReporsitory.findOne(id);
        if (r1 == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok().body(r1);
    }

    /**
     * Einen Kunden löschen
     *
     * @return
     */
    @RequestMapping(path = "/koch/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteKoch(@PathVariable("id") Long id) {
        if (kochReporsitory.exists(id)) {
            kochReporsitory.delete(id);
            return ResponseEntity.ok().build();
        } else return ResponseEntity.notFound().build();
    }


    /**
     * Einen Kunden neu anlegen
     *
     * @return
     */
    @RequestMapping(value = "/koch", method = RequestMethod.POST)
    public ResponseEntity<?> persistPerson(
            @RequestParam("mitarbeiterName") String mitarbeiterName, @RequestParam("mitarbeiterVornamen") String mitarbeiterVornamen) {
        Koch k = kochReporsitory.save(new KochFactory().createKoch(mitarbeiterName, mitarbeiterVornamen));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }


    @GetMapping
    public List<Koch> getAllKoeche() {
        return (List<Koch>) kochReporsitory.findAll();
    }

    @GetMapping("/{id}")
    public Koch getKochId(@PathVariable("id") Long id){
        return kochReporsitory.findOne(id);
    }


    //Scenario A.1
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody String body){
        String mitarbeitername;
        String mitarbeitervorname;

        JSONObject obj = new JSONObject(body);

        mitarbeitername = obj.getString("mitarbeitername");
        mitarbeitervorname = obj.getString("mitarbeitervorname");

        Koch k = kochReporsitory.save(new Koch(mitarbeitername, mitarbeitervorname));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }
}




