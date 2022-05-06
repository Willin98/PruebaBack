package com.example.factura.service;

import java.util.Optional;

import com.example.factura.model.Detalle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DetalleService {
    public Iterable<Detalle> findAll();
    public Page<Detalle> findAll(Pageable pageable);
    public Optional<Detalle> findById(Long num_Detalle);
    public Detalle save(Detalle detalle);
    public void deleteById(Long num_Detalle);   
}
