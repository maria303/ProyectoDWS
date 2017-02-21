/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n ORDER BY n.id"),
    @NamedQuery(name = "Nota.OrderByNumMesa", query = "SELECT n FROM Nota n ORDER BY n.num_mesa")
})
@Table(name = "notas")
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private int id;

    @Column(nullable = false)
    private int num_mesa;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private double cuenta;

    @Column(nullable = false, length = 5)
    private String hora;

    public Nota() {
    }

    public Nota(int num_mesa, Date fecha, String hora, double cuenta) {
        this.num_mesa = num_mesa;
        this.fecha = fecha;
        this.hora = hora;
        this.cuenta = cuenta;
    }

    public String getHora() {
        return hora;
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

    @Override
    public String toString() {
        return "Nota--> Id: " + id + ", Numero mesa: " + num_mesa + ", Fecha: " + fecha + ", Cuenta: " + cuenta;
    }

}
