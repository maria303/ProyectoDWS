/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Proveedor;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProveedorService implements ProveedorServiceLocal {

    private static ArrayList<Proveedor> lista = new ArrayList<>();
    private static int lastId = 3;
    
    static{
        lista.add(new Proveedor(1, 46970, 961234567, "Verduras SL", "c/ Bajo 4", "Alaquàs", "València"));
        lista.add(new Proveedor(2, 12345, 961234569, "Frutas SL", "c/ Puerto 7", "Mislata", "València"));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public ArrayList listProveedores() {
        return lista;
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
    }

    @Override
    public Proveedor findProveedorById(Proveedor proveedor) {
        return null;
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
    }
    
}
