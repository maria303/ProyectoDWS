/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
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
    private static int lastId = 1;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listProductos() {
        return lista;
    }

    @Override
    public void addProducto(Producto producto) {
        
        Iterator<Producto> it = lista.iterator();
        boolean existe = false;
        
        while(it.hasNext()){
            if(it.next().getNombre().equals(producto.getNombre())){
                existe = true;
            }
        }
        
        if(existe == false){
            producto.setId(lastId);
            lastId++;
            lista.add(producto);
        }
    }

    @Override
    public void updateProducto(Producto producto) {
        
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getId() == producto.getId()){
                lista.set(i, producto);
            }
        }
    }

    @Override
    public Producto findProductoById(Producto producto) {
        Iterator<Producto> it = lista.iterator();
        
        while(it.hasNext()){
            Producto p = it.next();
            if(p.getId() == producto.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteProducto(Producto producto) {
        
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getId() == producto.getId()){
                lista.remove(i);
            }
        }
    }

    @Override
    public ArrayList findProductosByProveedores(Proveedor proveedor) {
        Iterator<Producto> it = lista.iterator();
        ArrayList<Producto> listaProductosProveedores = new ArrayList();
        
        while(it.hasNext()){
            Producto p = it.next();
            if(p.getProveedor().equals(proveedor)){
                listaProductosProveedores.add(p);
            }
        }
        return listaProductosProveedores;
    }
    
    
    
}
