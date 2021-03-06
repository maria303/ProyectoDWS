/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.repository;

import com.fpmislata.domain.Nota;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface NotaDAOLocal {
    
    List listadoNotas();

    void addNota(Nota nota);

    void modNota(Nota nota);

    Nota encontrarPorFecha(Nota nota);

    void eliminarNota(Nota nota);

    Nota encontrarPorId(Nota nota);

    List orderByNumMesa();
    
}
