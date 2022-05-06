package com.example.factura.service;

import com.example.factura.model.Factura;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacturaService {
    public Iterable<Factura> findAll();
    public Page<Factura> findAll(Pageable pageable);
    public Optional<Factura> findById(Long num_factura);
    public Factura save(Factura factura);
    public void deleteById(Long num_factura);
}
