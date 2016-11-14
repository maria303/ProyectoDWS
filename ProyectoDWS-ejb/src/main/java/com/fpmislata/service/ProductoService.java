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
        lista.add(new Producto(1, 50, "Patatas", "Patatas1", 2.5));
        lista.add(new Producto(2, 50, "Cebolla", "Cebolla1", 2));
        lista.add(new Producto(3, 50, "Tomate", "Tomate1", 3));
        lista.add(new Producto(4, 50, "Huevos", "Huevos1", 3.5));
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
        boolean existe = false;
        
        while((it.hasNext()) && (existe==false)){
            if(it.next().getId() == producto.getId()){
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
        boolean existe = false;
        int i = 0;
        
        while((i < lista.size()) && (existe == false)){
            if(lista.get(i).getId() == producto.getId()){
                existe = true;
            }else{
                i++;
            }
        }
        
        if(existe == true){
            lista.set(i, producto);
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
        boolean existe = false;
        int i = 0;
        
        while((i<lista.size())&&(existe==false)){
            if(lista.get(i).getId() == producto.getId()){
                existe = true;
            }else{
                i++;
            }
        }
        
        if(existe == true){
            lista.remove(i);
        }
    }

    

    
}
