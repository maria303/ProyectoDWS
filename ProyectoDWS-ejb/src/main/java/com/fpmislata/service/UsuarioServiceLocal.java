/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author alumno
 */
@Local
public interface UsuarioServiceLocal {

    void addUsuario(Usuario usuario);

    List listUsuarios();

    void deleteUsuario(Usuario usuario);

    Usuario login(Usuario usuario);
    
    Usuario findUsuarioById(Usuario usuario);

    void updateUsuario(Usuario usuario);
    
}
