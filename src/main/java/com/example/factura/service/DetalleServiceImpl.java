package com.example.factura.service;

import java.util.Optional;
import com.example.factura.model.Detalle;
import com.example.factura.repository.DetalleRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    private DetalleRepositorio detalleRepositorio;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Detalle> findAll() {
        return detalleRepositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Detalle> findAll(Pageable pageable) {
        return detalleRepositorio.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Detalle> findById(Long num_Detalle) {
        return detalleRepositorio.findById(num_Detalle);
    }

    @Override
    @Transactional
    public Detalle save(Detalle detalle) {
        return detalleRepositorio.save(detalle);
    }

    @Override
    @Transactional
    public void deleteById(Long num_Detalle) { 
        detalleRepositorio.deleteById(num_Detalle);
    }
    
}
