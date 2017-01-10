/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Usuario;
import com.fpmislata.service.UsuarioServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
@WebServlet(name="ControladorUsuario", loadOnStartup=3, urlPatterns={"/AltaUsuario", "/EliminarUsuario", 
"ListarUsuarios"})
public class ControladorUsuario extends HttpServlet {

    @EJB
    private UsuarioServiceLocal usuarioService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = request.getServletPath();
        if(url.equals("/AltaUsuario")){
            AltaUsuario(request, response);
        }
        
        if(url.equals("/EliminarUsuario")){
            EliminarUsuario(request, response);
        }
        
        if(url.equals("/ListarUsuarios")){
            ListarUsuarios(request, response);
        }
    }
    
    private void AltaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String password = request.getParameter("password");
        
        if((nombre != null && !nombre.equals("")) && (apellidos != null && !apellidos.equals(""))
                && (password != null && !password.equals(""))){
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setPassword(password);
            
            try{
                usuarioService.addUsuario(usuario);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        ArrayList<Usuario> lista = usuarioService.listUsuarios();
        request.getSession().setAttribute("usuarios", lista);
        
        request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
    }
    
    private void EliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        
        Usuario usuario = new Usuario();
        usuario.setId(id);
        
        try{
            this.usuarioService.deleteUsuario(usuario);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ArrayList<Usuario> lista = usuarioService.listUsuarios();
        request.getSession().setAttribute("usuarios", lista);
        
        request.getRequestDispatcher("/listarUsuarios.jsp").forward(request, response);
    }
    
    private void ListarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            ArrayList lista = usuarioService.listUsuarios();
            request.getSession().setAttribute("usuarios", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarUsuarios.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
