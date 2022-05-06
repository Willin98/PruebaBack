package com.example.factura.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.factura.model.Factura;
import com.example.factura.service.FacturaService;

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
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "http://localhost:4200/")
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Factura factura){
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long num_factura) {
        Optional<Factura> oFactura = facturaService.findById(num_factura);
        if(!oFactura.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oFactura);
    }

    @GetMapping
    public List<Factura> readAll(){
        List<Factura> facturas = StreamSupport.stream(facturaService.findAll().spliterator(), false).collect(Collectors.toList());
        return facturas;
    }
}
