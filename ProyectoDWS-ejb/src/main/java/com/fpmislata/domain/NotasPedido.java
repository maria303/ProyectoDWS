/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class NotasPedido {
    
    private static final long serialVersionUID = 1L;
    int id, num_mesa;
    Date fecha;
    double cuenta;
    String hora;

    public String getHora() {
        return hora;
    }

    public NotasPedido() {
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCuenta() {
        return cuenta;
    }

    public void setCuenta(double cuenta) {
        this.cuenta = cuenta;
    }

    public NotasPedido(int num_mesa, Date fecha, String hora) {
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.hora = hora;
    }

    public NotasPedido(int id, int num_mesa, Date fecha, String hora) {
        this.id = id;
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Nota--> Id: " + id + ", Numero mesa: " + num_mesa + ", Fecha: " + fecha + ", Cuenta: " + cuenta;
    }
    
}
