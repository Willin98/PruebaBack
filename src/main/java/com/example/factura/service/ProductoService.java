package com.example.factura.service;

import java.util.Optional;

import com.example.factura.model.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    public Iterable<Producto> findAll();
    public Page<Producto> findAll(Pageable pageable);
    public Optional<Producto> findById(Long id_Producto);
    public Producto save(Producto producto);
    public void deleteById(Long id);
}
