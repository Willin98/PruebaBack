package com.example.factura.controller;

import com.example.factura.model.Cliente;
import com.example.factura.service.ClienteService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteservice;

    //Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(cliente));
    }

    //leer un cliente
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long id_cliente) {
        Optional<Cliente> oCliente = clienteservice.findById(id_cliente);
        if(!oCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCliente);
    }

    //Actualizar un usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "id") Long id_cliente){
        Optional<Cliente> cliente = clienteservice.findById(id_cliente);
        if(!cliente.isPresent()){
            return ResponseEntity.notFound().build();
        }
        //BeanUtils.copyProperties(clienteDetails, cliente);
        cliente.get().setNombre(clienteDetails.getNombre());
        cliente.get().setApellido(clienteDetails.getApellido());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(cliente.get()));
    }

    //Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id_cliente) {
        if(!clienteservice.findById(id_cliente).isPresent()){
            return ResponseEntity.notFound().build();
        }
        clienteservice.deleteById(id_cliente);
        return ResponseEntity.ok().build();
    }

    //Traer todos los usuarios
    @GetMapping
    public List<Cliente> readAll(){
        List<Cliente> clientes = StreamSupport.stream(clienteservice.findAll().spliterator(), false).collect(Collectors.toList());
        return clientes;
    }
}
