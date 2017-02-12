/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Proveedor;
import com.fpmislata.repository.ProveedorDAOLocal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class ProveedorService implements ProveedorServiceLocal {

    @EJB
    private ProveedorDAOLocal proveedorDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listProveedores() {
        return proveedorDAO.listProveedores();
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
        proveedorDAO.addProveedor(proveedor);
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        proveedorDAO.updateProveedor(proveedor);
    }

    @Override
    public Proveedor findProveedorById(Proveedor proveedor) {
        return proveedorDAO.findProveedorById(proveedor);
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        proveedorDAO.deleteProveedor(proveedor);
    }
    
}
