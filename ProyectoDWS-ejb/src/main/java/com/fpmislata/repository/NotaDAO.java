/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Nota;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class NotaDAO implements NotaDAOLocal {
    
    @PersistenceContext(unitName = "RestaurantePU")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listadoNotas() {
        return em.createNamedQuery("Nota.findAll").getResultList();
    }

    @Override
    public void addNota(Nota nota) {
        em.persist(nota);
    }

    @Override
    public void modNota(Nota nota) {
        em.merge(nota);
    }

    @Override
    public Nota encontrarPorFecha(Nota nota) {
        return em.find(Nota.class, nota.getFecha());
    }

    @Override
    public void eliminarNota(Nota nota) {
        nota = encontrarPorId(nota);
        em.remove(nota);
    }

    @Override
    public Nota encontrarPorId(Nota nota) {
        return em.find(Nota.class, nota.getId());
    }
}
