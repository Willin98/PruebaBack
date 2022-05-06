package com.example.factura.service;

import java.util.Optional;

import com.example.factura.model.Producto;
import com.example.factura.repository.ProductoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Producto> findAll() {
        return productoRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return productoRepositorio.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(Long id_Producto) {
        return productoRepositorio.findById(id_Producto);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepositorio.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoRepositorio.deleteById(id);
    }
}
