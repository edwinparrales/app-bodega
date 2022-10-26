package main.rest.controller;

import main.entities.Marca;
import main.servicios.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api",method = RequestMethod.GET)
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @GetMapping("/marca/listar")
    public ResponseEntity<List<Marca>> listar(){
        return  new ResponseEntity<>(marcaService.listar(), HttpStatus.OK);
    }
}
