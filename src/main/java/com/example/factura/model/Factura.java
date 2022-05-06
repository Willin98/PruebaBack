package com.example.factura.model;

import javax.persistence.*;

@Entity
@Table(name = "FACTURA")
public class Factura {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_factura;
    @Column(name = "fecha", nullable = false, length = 40)
    private String fecha;
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
	private Cliente id_cliente;

    public Factura() {
    }

    public Factura(int num_factura, String fecha, Cliente id_cliente) {
        this.num_factura = num_factura;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
    }

    public Factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public Factura(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    
    
}
