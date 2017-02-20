/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface UsuarioDAOLocal {

    List listUsuarios();

    void addUsuario(Usuario usuario);

    void deleteUsuario(Usuario usuario);

    Usuario findUsuarioById(Usuario usuario);

    void updateUsuario(Usuario usuario);
    
}
