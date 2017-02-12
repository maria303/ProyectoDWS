/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
import com.fpmislata.repository.ProductoDAOLocal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {

    @EJB
    private ProductoDAOLocal productoDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listProductos() {
        return productoDAO.listProductos();
    }

    @Override
    public void addProducto(Producto producto) {
        productoDAO.addProducto(producto);
    }

    @Override
    public void updateProducto(Producto producto) {
        productoDAO.updateProducto(producto);
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return productoDAO.findProductoById(producto);
    }

    @Override
    public void deleteProducto(Producto producto) {
        productoDAO.deleteProducto(producto);
    }

//    @Override
//    public List findProductosByProveedores(Proveedor proveedor) {
//        
//    }
    
}
