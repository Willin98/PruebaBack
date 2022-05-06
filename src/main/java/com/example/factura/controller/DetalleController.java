package com.example.factura.controller;

import com.example.factura.model.Detalle;
import com.example.factura.service.DetalleService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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
@RequestMapping("/api/detalles")
@CrossOrigin(origins = "http://localhost:4200/")
public class DetalleController {

    @Autowired
    private DetalleService detalleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Detalle detalle){
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleService.save(detalle));
    } 
    
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long num_detalle) {
        Optional<Detalle> oDetalle = detalleService.findById(num_detalle);
        if(!oDetalle.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oDetalle);
    }

    @GetMapping
    public List<Detalle> readAll(){
        List<Detalle> detalles = StreamSupport.stream(detalleService.findAll().spliterator(), false).collect(Collectors.toList());
        return detalles;
    }
}
