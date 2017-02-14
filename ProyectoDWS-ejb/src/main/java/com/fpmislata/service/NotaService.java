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
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class NotaService implements NotaServiceLocal {

    @EJB
    private NotaDAOLocal notaDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List listadoNotas() {
        return notaDAO.listadoNotas();
    }

    @Override
    public void addNota(Nota nota) {
        notaDAO.addNota(nota);
    }

    @Override
    public void modNota(Nota nota) {
        notaDAO.modNota(nota);
    }

    @Override
    public Nota encontrarPorFecha(Nota nota) {
        return notaDAO.encontrarPorFecha(nota);
    }

    @Override
    public void eliminarNota(Nota nota) {
        notaDAO.eliminarNota(nota);
    }

    @Override
    public Nota encontrarPorId(Nota nota) {
        return notaDAO.encontrarPorId(nota);
    }
}
