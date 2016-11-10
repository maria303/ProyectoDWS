/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class ProductoService implements ProductoServiceLocal {
    
    private static ArrayList<Producto> lista = new ArrayList<>();
    private static int lastId = 6;
    
    static{
        lista.add(new Producto(1, "Patata", 50));
        lista.add(new Producto(2, "Cebolla", 50));
        lista.add(new Producto(3, "Tomate", 50));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listProductos() {
        return lista;
    }

    @Override
    public void addProducto(Producto producto) {
        Iterator<Producto> it = lista.iterator();
        boolean enc = false;
        
        while((it.hasNext()) && (enc==false)){
            if(it.next().getId() == producto.getId()){
                enc = true;
            }
        }
        
        if(enc == false){
            producto.setId(lastId);
            lastId++;
            lista.add(producto);
        }
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
