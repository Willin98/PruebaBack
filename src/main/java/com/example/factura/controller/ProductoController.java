package com.example.factura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.factura.model.Producto;
import com.example.factura.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id_producto) {
        Optional<Producto> oProducto = productoService.findById(id_producto);
        if(!oProducto.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oProducto);
    }

    @GetMapping
    public List<Producto> readAll(){
        List<Producto> productos = StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
        return productos;
    }
}
