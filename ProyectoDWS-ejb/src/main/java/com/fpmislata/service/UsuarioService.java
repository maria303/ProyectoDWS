/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.service;

import com.fpmislata.domain.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;

/**
 *
 * @author alumno
 */
@Stateless
public class UsuarioService implements UsuarioServiceLocal {
    
    private static ArrayList<Usuario> lista = new ArrayList<>();
    private static int lastId = 2;
    
    static{
        lista.add(new Usuario(1, "Pepe", "Perez", "1234"));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void addUsuario(Usuario usuario) {
        Iterator<Usuario> it = lista.iterator();
        boolean existe = false;
        
        while(it.hasNext()){
            if(it.next().getNombre().equals(usuario.getNombre()) && 
                    it.next().getPassword().equals(usuario.getPassword())){
                existe = true;
            }
        }
        
        if(existe == false){
            usuario.setId(lastId);
            lastId++;
            lista.add(usuario);
        }
    }

    @Override
    public ArrayList listUsuarios() {
        return lista;
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getId() == usuario.getId()){
                lista.remove(i);
            }
        }
    }

    @Override
    public Usuario login(Usuario usuario) {
        boolean encontrado=false;
        
        Usuario retorno = null;
        for(int i=0;i<lista.size() && encontrado==false ;i++){
            if((lista.get(i).getNombre().equals(usuario.getNombre()))&&
              (lista.get(i).getPassword().equals(usuario.getPassword()))){
                retorno = lista.get(i);
                encontrado=true;
            }
        }
        
        return retorno;
    }
    
}
