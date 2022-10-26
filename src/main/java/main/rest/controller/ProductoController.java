package main.rest.controller;

import main.entities.Producto;
import main.servicios.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api",method = RequestMethod.GET)
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @GetMapping("producto/listar")
    public ResponseEntity<List<Producto>> listar(){
        return new ResponseEntity<>(productoService.listar(), HttpStatus.OK);
    }
    @PostMapping("producto/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
      Producto nuevoProducto = productoService.crear(producto);
      return new ResponseEntity<>(nuevoProducto,HttpStatus.CREATED);

    }

    @DeleteMapping("producto/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable(value = "id") Long id){
        productoService.eliminar(id);
        return new ResponseEntity(HttpStatus.OK);

    }


}
