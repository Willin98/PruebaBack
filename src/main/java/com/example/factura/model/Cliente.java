package com.example.factura.model;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    @Column(name = "nombre", nullable = false, length = 40)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 40)
    private String apellido;
    @Column(name = "direccion", nullable = false, length = 40)
    private String direccion;
    @Column(name = "fecha_nacimiento", nullable = false, length = 40)
	private String fecha_nacimiento;
    @Column(name = "telefono", nullable = false, length = 40)
	private int telefono;
    @Column(name = "email", nullable = false, length = 40, unique = true)
	private String email;
    
    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String apellido, String direccion, String fecha_nacimiento,
            int telefono, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}
