package main.servicios;


import main.dao.MarcaRepository;
import main.dao.ProductoRepository;
import main.entities.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
     MarcaRepository marcaRepository;
     //

     //Listar los productos

     public List<Producto> listar(){
         return (List<Producto>) productoRepository.findAll();
     }

     public Producto crear(Producto producto){
         return productoRepository.save(producto);
     }

     public void eliminar(Long id){
         productoRepository.deleteById(id);
     }
}
