package com.example.factura.service;

import java.util.Optional;

import com.example.factura.model.Factura;
import com.example.factura.repository.FacturaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaRepositorio facturaRepositorio;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Factura> findAll() {
        return facturaRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Factura> findAll(Pageable pageable) {
        return facturaRepositorio.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> findById(Long num_factura) {
        return facturaRepositorio.findById(num_factura);
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturaRepositorio.save(factura);
    }

    @Override
    @Transactional
    public void deleteById(Long num_factura) {
        facturaRepositorio.deleteById(num_factura);
        
    }
    
}
