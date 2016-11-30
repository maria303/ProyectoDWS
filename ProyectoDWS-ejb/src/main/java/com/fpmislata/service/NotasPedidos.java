/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.NotasPedido;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class NotasPedidos implements NotasPedidosLocal {
    
    private static ArrayList<NotasPedido> listaNotas = new ArrayList<>();
    private static int lastId = 6;

    static SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    static String fecha1 = "2016-10-1";
    static String fecha2 = "2016-10-1";
    static String fecha3 = "2015-12-23";
    static String fecha4 = "2015-12-23";
    static String fecha5 = "2016-9-12";

    static {
        Date fechaF1 = null;
        Date fechaF2 = null;
        Date fechaF3 = null;
        Date fechaF4 = null;
        Date fechaF5 = null;
        try {
            fechaF1 = (Date) formatoFecha.parse(fecha1);
            fechaF2 = (Date) formatoFecha.parse(fecha2);
            fechaF3 = (Date) formatoFecha.parse(fecha3);
            fechaF4 = (Date) formatoFecha.parse(fecha4);
            fechaF5 = (Date) formatoFecha.parse(fecha5);
        } catch (ParseException ex) {
            Logger.getLogger(NotasPedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaNotas.add(new NotasPedido(1, 20, fechaF1, "21:00"));
        listaNotas.add(new NotasPedido(2, 21, fechaF2, "21:45"));
        listaNotas.add(new NotasPedido(3, 32, fechaF3, "17:00"));
        listaNotas.add(new NotasPedido(4, 20, fechaF4, "19:30"));
        listaNotas.add(new NotasPedido(5, 12, fechaF5, "00:00"));
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public ArrayList ListadoNotas() {
        return listaNotas;
    }

    @Override
    public boolean addNota(NotasPedido nota) {
        Iterator<NotasPedido> it = listaNotas.iterator();
        boolean fin = false;
        while ((it.hasNext()) && (fin == false)) {
            if (it.next().getId() == nota.getId()) {
                fin = true;
            }
        }
        if (fin == false) {
            nota.setId(lastId);
            lastId++;
            listaNotas.add(nota);
        }
        return fin;
    }

    @Override
    public boolean modNota(NotasPedido nota) {
        boolean fin = false;
        for (int i = 0; i < listaNotas.size() && fin == false; i++) {
            if (listaNotas.get(i).getId() == nota.getId()) {
                listaNotas.set(i, nota);
                fin = true;
            }
        }
        return fin;
    }

    @Override
    public NotasPedido encontrarPorFecha(Date fecha) {
        Iterator<NotasPedido> it = listaNotas.iterator();
        NotasPedido notaRet = null;
        while (it.hasNext()) {
            NotasPedido nota = it.next();
            if (nota.getFecha() == fecha) {
                notaRet = nota;
            }
        }
        return notaRet;
    }

    @Override
    public boolean eliminarNota(NotasPedido nota) {
        boolean fin = false;

        for (int i = 0; i < listaNotas.size() && fin == false; i++) {
            if (listaNotas.get(i).getId() == nota.getId()) {
                listaNotas.remove(i);
                fin = true;
            }
        }
        return false;
    }

    @Override
    public NotasPedido encontrarPorId(NotasPedido nota) {
        Iterator<NotasPedido> it = listaNotas.iterator();
        NotasPedido notaEnc=null;
        while(it.hasNext()){
            NotasPedido n = it.next();
            if(n.getId()==nota.getId()){
                notaEnc= n;
            }
        }
        return notaEnc;
    }
    
}
