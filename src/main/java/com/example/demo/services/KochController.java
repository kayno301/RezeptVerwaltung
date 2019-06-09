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
import javax.websocket.server.PathParam;

import java.net.URI;
import java.util.ArrayList;
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
        System.out.println("calledALL");
        return (List<Koch>) kochReporsitory.findAll();
    }

    @GetMapping("/{id}")
    public Koch getKochId(@PathVariable("id") Long id){
        return kochReporsitory.findOne(id);
    }

    //Scenario A.1
    //todo: Rezepte müssen übergebbar gemacht werden
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody String body){
        String mitarbeitername;
        String mitarbeitervorname;
        int gehalt;

        JSONObject obj = new JSONObject(body);

        mitarbeitername = obj.getString("mitarbeitername");
        mitarbeitervorname = obj.getString("mitarbeitervorname");
        gehalt = obj.getInt("gehalt");

        Koch k = kochReporsitory.save(new Koch(mitarbeitername, mitarbeitervorname, gehalt));
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(k.getId()).toUri();
        return ResponseEntity.created(location).body(k);
    }

    //A.2
    @GetMapping("/vergleich/noResponse")
    public ResponseEntity<?> vergleichNoResponse(@RequestBody String body){
        ArrayList<Koch> koeche = (ArrayList)kochReporsitory.findAll();
        ArrayList<Koch> filtered = new ArrayList<>();
        if(koeche.isEmpty()) return ResponseEntity.notFound().build();
        
        JSONObject obj = new JSONObject(body);
        
        String attr = obj.getString("vergleichsattribut");
        String value = obj.getString("vergleichswert");

        switch(attr){
            case "gehalt":
                for (Koch k : koeche) {
                    if(k.getGehalt() > Integer.parseInt(value)){
                        filtered.add(k);
                    }
                }
                break;
            //theoretisch können hier weitere Attribute hin, aber string zu vergleichen macht kein sinn.
        }
        System.out.println("noResponse");
        return ResponseEntity.ok().build();
    }

    //A.3
    @PutMapping("/{id}")
    public ResponseEntity<?> change(@PathVariable("id") Long id, @Valid @RequestBody String body){
        Koch koch = kochReporsitory.findOne(id);
        String mitarbeitername;
        String mitarbeitervorname;
        int gehalt;

        JSONObject obj = new JSONObject(body);

        mitarbeitername = obj.getString("mitarbeitername");
        mitarbeitervorname = obj.getString("mitarbeitervorname");
        gehalt = obj.getInt("gehalt");

        koch.setMitarbeitername(mitarbeitername);
        koch.setMitarbeitervornamen(mitarbeitervorname);
        if(koch.getGehalt() > gehalt) koch.setGehalt(gehalt);

        kochReporsitory.save(koch);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(koch.getId()).toUri();
        return ResponseEntity.created(location).body(koch);
    }

    //A.4
    @GetMapping("/vergleich")
    public ResponseEntity<?> vergleich(@RequestBody String body){
        ArrayList<Koch> koeche = (ArrayList)kochReporsitory.findAll();
        ArrayList<Koch> filtered = new ArrayList<>();
        if(koeche.isEmpty()) return ResponseEntity.notFound().build();

        JSONObject obj = new JSONObject(body);

        String attr = obj.getString("vergleichsattribut");
        String value = obj.getString("vergleichswert");

        switch(attr){
            case "gehalt":
                for (Koch k : koeche) {
                    if(k.getGehalt() > Integer.parseInt(value)){
                        filtered.add(k);
                    }
                }
                break;
            //theoretisch können hier weitere Attribute hin, aber string zu vergleichen macht kein sinn.
        }

        return ResponseEntity.ok().body(filtered);
    }

    // //A.3, aber warscheinlich nicht ganz richtig
    // @PatchMapping("/{id}")
    // public ResponseEntity<?> change(@PathVariable("id") Long id, @Valid @RequestBody String body){
    //     Koch k = kochReporsitory.findOne(id);
    //     if(k == null) return ResponseEntity.notFound().build();
    //     else {
    //         JSONObject obj = new JSONObject(body);
    //         if(obj.has("mitarbeitername")){
    //             k.setMitarbeitername(obj.getString("mitarbeitername"));
    //         }
    //         if(obj.has("mitarbeitervorname")){
    //             k.setMitarbeitervornamen(obj.getString("mitarbeitervorname"));
    //         }
    //         if(obj.has("gehalt")){
    //             if(k.getGehalt() < obj.getInt("gehalt")) {
    //                 k.setGehalt(obj.getInt("gehalt"));
    //             } else {
    //                 return ResponseEntity.badRequest().build();
    //             }
    //         }
    //         kochReporsitory.save(k);
    //         return ResponseEntity.ok().body(k);
    //     }
    // }

    //A.5
    //todo: irgendwie den fehler beheben, wenn nicht möglich auch nicht schlimm
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        Koch k = kochReporsitory.findOne(id);

        if(k == null) return ResponseEntity.notFound().build();

        kochReporsitory.delete(k);

        return ResponseEntity.ok().body(k);
    }

    //A.6
    //todo: A.6 verstehen und implementieren
}