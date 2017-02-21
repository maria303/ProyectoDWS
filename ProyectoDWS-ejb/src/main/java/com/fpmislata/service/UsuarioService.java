/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import com.fpmislata.repository.UsuarioDAOLocal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {

    @EJB
    private UsuarioDAOLocal usuarioDAO;

    @Resource
    private SessionContext context;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void addUsuario(Usuario usuario) {
        try {
            usuarioDAO.addUsuario(usuario);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public List listUsuarios() {
        try {
            return usuarioDAO.listUsuarios();
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        try {
            usuarioDAO.deleteUsuario(usuario);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        try {
            List<Usuario> lista = usuarioDAO.listUsuarios();

            boolean encontrado = false;

            Usuario retorno = null;
            for (int i = 0; i < lista.size() && encontrado == false; i++) {
                if ((lista.get(i).getNombre().equals(usuario.getNombre()))
                        && (lista.get(i).getPassword().equals(usuario.getPassword()))) {
                    retorno = lista.get(i);
                    encontrado = true;
                }
            }

            return retorno;
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        try {
            return usuarioDAO.findUsuarioById(usuario);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        try {
            usuarioDAO.updateUsuario(usuario);
        } catch (Exception e) {
            context.setRollbackOnly();
            e.printStackTrace();
        }
    }
}
