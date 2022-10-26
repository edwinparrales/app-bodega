package main.servicios;

import main.dao.MarcaRepository;
import main.entities.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    MarcaRepository marcaRepository;
    public List<Marca> listar(){
        return (List<Marca>) marcaRepository.findAll();

    }
}
