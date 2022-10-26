/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.rest.controller;

import java.util.List;
import main.entities.Persona;
import main.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    @RequestMapping(value="/listar" )    
    public ResponseEntity<List<Persona>> listar(){
     return  new ResponseEntity<>(personaService.listar(),HttpStatus.OK);
    }
    
    @PostMapping("/personas/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona persona){

        return new ResponseEntity<>(personaService.crear(persona),HttpStatus.OK);
    }
    
}
