/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class ProveedorDAO implements ProveedorDAOLocal {

    @PersistenceContext(unitName = "RestaurantePU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listProveedores() {
        return em.createNamedQuery("Proveedor.findAll").getResultList();
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
        em.persist(proveedor);
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        em.merge(proveedor);
    }

    @Override
    public Proveedor findProveedorById(Proveedor proveedor) {
        return em.find(Proveedor.class, proveedor.getId());
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        proveedor = findProveedorById(proveedor);
        em.remove(proveedor);
    }
}
