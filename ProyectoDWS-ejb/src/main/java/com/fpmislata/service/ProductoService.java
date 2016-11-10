/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {
    
    private static ArrayList<Producto> lista = new ArrayList<>();
    
    static{
        lista.add(new Producto(1, "Patata", 50));
        lista.add(new Producto(1, "Cebolla", 50));
        lista.add(new Producto(1, "Tomate", 50));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listProductos() {
        return lista;
    }

    @Override
    public void addProducto(Producto producto) {
        
    }

    @Override
    public void updateProducto(Producto producto) {
    }

    @Override
    public Producto findProductoById(Producto producto) {
        return null;
    }

    @Override
    public void deleteProducto(Producto producto) {
    }

    

    
}
