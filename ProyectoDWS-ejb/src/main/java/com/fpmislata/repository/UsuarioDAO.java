/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Maria
 */
@Stateless
public class UsuarioDAO implements UsuarioDAOLocal {

    @PersistenceContext(unitName = "RestaurantePU")
    EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public List listUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public void addUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuario = findUsuarioById(usuario);
        em.remove(usuario);
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getId());
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }
}
