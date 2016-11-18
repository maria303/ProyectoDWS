/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Proveedor;
import java.util.ArrayList;
import java.util.Iterator;
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
        lista.add(new Proveedor(1, 46970, 961234567, "Verduras SL", "c/ Bajo 4", "Alaquàs", "València", "asdf@asd.com"));
        lista.add(new Proveedor(2, 12345, 961234569, "Frutas SL", "c/ Puerto 7", "Mislata", "València", "dfsg@fbv.com"));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public ArrayList listProveedores() {
        return lista;
    }

    @Override
    public void addProveedor(Proveedor proveedor) {
        Iterator<Proveedor> it = lista.iterator();
        boolean existe = false;
        
        while(it.hasNext()){
            if(it.next().getNombre().equals(proveedor.getNombre())){
                existe = true;
            }
        }
        
        if(existe == false){
            proveedor.setId(lastId);
            lastId++;
            lista.add(proveedor);
        }
    }

    @Override
    public void updateProveedor(Proveedor proveedor) {
        for(int i = 0; i<lista.size(); i++){
            if(lista.get(i).getId() == proveedor.getId()){
                lista.set(i, proveedor);
            }
        }
    }

    @Override
    public Proveedor findProveedorById(Proveedor proveedor) {
        Iterator<Proveedor> it = lista.iterator();
        
        while(it.hasNext()){
            Proveedor p = it.next();
            if(p.getId() == proveedor.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public void deleteProveedor(Proveedor proveedor) {
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getId() == proveedor.getId()){
                lista.remove(i);
            }
        }
    }
    
}
