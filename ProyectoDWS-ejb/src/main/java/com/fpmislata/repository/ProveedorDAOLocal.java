/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface ProveedorDAOLocal {
    
    List listProveedores();

    void addProveedor(Proveedor proveedor);

    void updateProveedor(Proveedor proveedor);

    Proveedor findProveedorById(Proveedor proveedor);

    void deleteProveedor(Proveedor proveedor);
    
}
