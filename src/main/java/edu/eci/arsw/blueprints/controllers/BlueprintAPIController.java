/*
 * Clase controladora que define los endpoints REST para interactuar con blueprints.
 */
package edu.eci.arsw.blueprints.controllers;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/blueprints")
public class BlueprintAPIController {

    @Autowired
    BlueprintsServices blueprintsServices;

    /**
     * Manejador para la solicitud GET de todos los blueprints.
     */
    @GetMapping
    public ResponseEntity<?> manejadorGetBlueprints() {
        return new ResponseEntity<>(blueprintsServices.getAllBlueprints(), HttpStatus.ACCEPTED);
    }

    /**
     * Manejador para la solicitud GET de blueprints por autor.
     * @param author El autor de los blueprints.
     */
    @GetMapping(path = "/{author}")
    public ResponseEntity<?> manejadorGetBlueprintsByAuthor(@PathVariable("author") String author) {
        try {
            return new ResponseEntity<>(blueprintsServices.getBlueprintsByAuthor(author), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Manejador para la solicitud GET de un blueprint específico.
     * @param author El autor del blueprint.
     * @param bpname El nombre del blueprint.
     */
    @GetMapping(path = "/{author}/{bpname}")
    public ResponseEntity<?> manejadorGetBlueprint(@PathVariable("author") String author, @PathVariable("bpname") String bpname) {
        try {
            return new ResponseEntity<>(blueprintsServices.getBlueprint(author, bpname), HttpStatus.ACCEPTED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Manejador para la solicitud POST de un nuevo blueprint.
     * @param bp El blueprint a agregar.
     */
    @PostMapping
    public ResponseEntity<?> manejadorPostBlueprint(@RequestBody Blueprint bp) {
        try {
            blueprintsServices.addNewBlueprint(bp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (BlueprintPersistenceException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    /**
     * Manejador para la solicitud PUT de actualizar un blueprint.
     * @param author El autor del blueprint.
     * @param bpname El nombre del blueprint a actualizar.
     * @param bp El blueprint actualizado.
     */
    @PutMapping(path = "/{author}/{bpname}")
    public ResponseEntity<?> manejadorPutBlueprint(@PathVariable("author") String author, @PathVariable("bpname") String bpname, @RequestBody Blueprint bp) {
        try {
            blueprintsServices.updateBlueprint(author, bpname, bp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (BlueprintNotFoundException e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
