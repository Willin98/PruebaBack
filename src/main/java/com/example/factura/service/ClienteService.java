package com.example.factura.service;

import java.util.Optional;
import com.example.factura.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
   
    public Iterable<Cliente> findAll();
    public Page<Cliente> findAll(Pageable pageable);
    public Optional<Cliente> findById(Long id_cliente);
    public Cliente save(Cliente cliente);
    public void deleteById(Long id);
}
