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
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {

    @EJB
    private ProductoDAOLocal productoDAO;

    @Resource
    private SessionContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List listProductos() {
        try {
            return productoDAO.listProductos();
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addProducto(Producto producto) {
        try {
            productoDAO.addProducto(producto);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public void updateProducto(Producto producto) {
        try {
            productoDAO.updateProducto(producto);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Producto findProductoById(Producto producto) {
        try {
            return productoDAO.findProductoById(producto);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteProducto(Producto producto) {
        try {
            productoDAO.deleteProducto(producto);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Producto findProductoByNombre(Producto producto) {
        try{
            return productoDAO.findProductoByNombre(producto);
        }catch(Exception e){
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }
}
