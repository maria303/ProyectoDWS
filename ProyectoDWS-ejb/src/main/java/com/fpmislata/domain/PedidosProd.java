/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class PedidosProd implements Serializable {
    
    int id, idproducto, cantidad;

    public PedidosProd(int id, int idproducto, int cantidad) {
        this.id = id;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
    }    

    public PedidosProd() {
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idproducto;
    }

    public void setIdProducto(int producto) {
        this.idproducto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
