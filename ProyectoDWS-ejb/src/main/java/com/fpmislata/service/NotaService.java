/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Nota;
import com.fpmislata.repository.NotaDAOLocal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class NotaService implements NotaServiceLocal {

    @EJB
    private NotaDAOLocal notaDAO;

    @Resource
    private SessionContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List listadoNotas() {
        try {
            return notaDAO.listadoNotas();
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addNota(Nota nota) {
        try {
            notaDAO.addNota(nota);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public void modNota(Nota nota) {
        try {
            notaDAO.modNota(nota);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Nota encontrarPorFecha(Nota nota) {
        try {
            return notaDAO.encontrarPorFecha(nota);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void eliminarNota(Nota nota) {
        try {
            notaDAO.eliminarNota(nota);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Nota encontrarPorId(Nota nota) {
        try {
            return notaDAO.encontrarPorId(nota);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List orderByNumMesa() {
        try {
            return notaDAO.orderByNumMesa();
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }
}
