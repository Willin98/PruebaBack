package com.example.factura.model;

import javax.persistence.*;

@Entity
@Table(name = "DETALLE")
public class Detalle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num_detalle;
    @Column(name = "cantidad", nullable = false, length = 40)
    private int cantidad;
    @Column(name = "precio", nullable = false, length = 40)
    private int precio;
    @ManyToOne
    @JoinColumn(name = "num_factura", nullable = false)
    private Factura num_factura;
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto id_producto;

    public Detalle(int num_detalle, int cantidad, int precio, Factura num_factura, Producto id_producto) {
        this.num_detalle = num_detalle;
        this.cantidad = cantidad;
        this.precio = precio;
        this.num_factura = num_factura;
        this.id_producto = id_producto;
    }
    public Detalle() {
    }
    
    public Detalle(int num_detalle) {
        this.num_detalle = num_detalle;
    }
    
    public Detalle(Factura num_factura) {
        this.num_factura = num_factura;
    }
    
    public Detalle(Producto id_producto) {
        this.id_producto = id_producto;
    }
    public Factura getNum_factura() {
        return num_factura;
    }
    public void setNum_factura(Factura num_factura) {
        this.num_factura = num_factura;
    }
    public Producto getId_producto() {
        return id_producto;
    }
    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }
    public int getNum_detalle() {
        return num_detalle;
    }
    public void setNum_detalle(int num_detalle) {
        this.num_detalle = num_detalle;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    } 
    
    
}
