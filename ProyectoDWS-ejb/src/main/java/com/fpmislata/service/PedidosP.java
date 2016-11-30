/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.PedidosProd;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class PedidosP implements PedidosPLocal {
    
    private static ArrayList<PedidosProd> listaPedidos = new ArrayList<>();
    private static int lastId = 6;
    
    static {
        listaPedidos.add(new PedidosProd(1, 12, 100));
        listaPedidos.add(new PedidosProd(2, 21, 12));
        listaPedidos.add(new PedidosProd(3, 32, 50));
        listaPedidos.add(new PedidosProd(4, 20, 25));
        listaPedidos.add(new PedidosProd(5, 12, 43));
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList listarPedidos() {
        return listaPedidos;
    }

    @Override
    public void addPedidoP(PedidosProd pedido) {
        Iterator<PedidosProd> it = listaPedidos.iterator();
        boolean fin = false;
        while ((it.hasNext()) && (fin == false)) {
            if (it.next().getId() == pedido.getId()) {
                fin = true;
            }
        }
        if (fin == false) {
            pedido.setId(lastId);
            lastId++;
            listaPedidos.add(pedido);
        }
    }

    @Override
    public void modPedidoP(PedidosProd pedido) {
        boolean fin = false;
        for (int i = 0; i < listaPedidos.size() && fin == false; i++) {
            if (listaPedidos.get(i).getId() == pedido.getId()) {
                listaPedidos.set(i, pedido);
                fin = true;
            }
        }
    }

    @Override
    public void eliminarPedidoP(PedidosProd pedido) {
        boolean fin = false;
        for (int i = 0; i < listaPedidos.size() && fin == false; i++) {
            if (listaPedidos.get(i).getId() == pedido.getId()) {
                listaPedidos.remove(i);
                fin = true;
            }
        }
    }

    @Override
    public PedidosProd encontrarPorID(PedidosProd pedido) {
        Iterator<PedidosProd> it = listaPedidos.iterator();
        PedidosProd pedidoEnc=null;
        while(it.hasNext()){
            PedidosProd p = it.next();
            if(p.getId()==pedido.getId()){
                pedidoEnc= p;
            }
        }
        return pedidoEnc;
    }
    
}
