/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.PedidosProd;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface PedidosPLocal {

    ArrayList listarPedidos();

    void addPedidoP(PedidosProd pedido);

    void modPedidoP(PedidosProd pedido);

    void eliminarPedidoP(PedidosProd pedido);

    PedidosProd encontrarPorID(PedidosProd pedido);
    
}
