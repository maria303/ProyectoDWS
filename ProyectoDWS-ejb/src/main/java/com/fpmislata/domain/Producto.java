/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;

/**
 *
 * @author Maria
 */
public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id, stock;
    private String nombre, descripcion;

    public Producto(int id, int stock, String nombre, String descripcion) {
        this.id = id;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
