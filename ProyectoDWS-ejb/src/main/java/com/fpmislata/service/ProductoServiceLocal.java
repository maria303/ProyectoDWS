/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface ProductoServiceLocal {

    ArrayList listProductos();

    void addProducto(Producto producto);

    void updateProducto(Producto producto);

    Producto findProductoById(Producto producto);

    void deleteProducto(Producto producto);

    ArrayList findProductosByProveedores(Proveedor proveedor);
    
}
