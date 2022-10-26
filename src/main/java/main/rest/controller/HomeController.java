package main.rest.controller;
import main.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class HomeController {
    @Autowired
    PersonaService personaService;
    @GetMapping("saludo")
    public ResponseEntity<String> saludo(){
        return new ResponseEntity<>("Hola mundo", HttpStatus.OK);
    }

//    @GetMapping("/personas/listar")
//    public ResponseEntity<List<Persona>> listar(){
//
//        return new ResponseEntity<>(personaService.listar(),HttpStatus.OK);
//    }
}
