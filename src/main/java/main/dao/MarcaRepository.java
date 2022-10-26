package main.dao;

import main.entities.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca,Long> {
}
