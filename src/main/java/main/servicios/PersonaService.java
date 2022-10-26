package main.servicios;

import main.dao.PersonaRepository;
import main.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> listar(){
        return (List<Persona>) personaRepository.findAll();
    }
    public Persona crear(Persona persona){
        try {
            return personaRepository.save(persona);
        }catch (Exception ex){
            return  new Persona();
        }

    }
}
