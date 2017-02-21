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
import java.util.List;
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
@WebServlet(name = "ControladorUsuario", loadOnStartup = 3, urlPatterns = {"/AltaUsuario", "/EliminarUsuario",
    "ListarUsuarios", "/Login", "/Logout", "/ModificarUsuario"})
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
        if (url.equals("/AltaUsuario")) {
            altaUsuario(request, response);
        }

        if (url.equals("/EliminarUsuario")) {
            eliminarUsuario(request, response);
        }

        if (url.equals("/ListarUsuarios")) {
            listarUsuarios(request, response);
        }

        if (url.equals("/Login")) {
            login(request, response);
        }

        if (url.equals("/Logout")) {
            logout(request, response);
        }

        if (url.equals("/ModificarUsuario")) {
            modificarUsuario(request, response);
        }
    }

    private void altaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String password = request.getParameter("password");

        if ((nombre != null && !nombre.equals("")) && (apellidos != null && !apellidos.equals(""))
                && (password != null && !password.equals(""))) {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setPassword(password);

            try {
                usuarioService.addUsuario(usuario);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        listarUsuarios(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario();
        usuario.setId(id);

        try {
            this.usuarioService.deleteUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listarUsuarios(request, response);
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List lista = usuarioService.listUsuarios();
            ArrayList<Usuario> listaArray = new ArrayList<>(lista);
            request.getSession().setAttribute("usuarios", listaArray);

            RequestDispatcher rd = request.getRequestDispatcher("/listarUsuarios.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
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

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("usuario");
        String password = request.getParameter("password");

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setPassword(password);

        usuario = usuarioService.login(usuario);

        if (usuario == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        } else {
            request.getSession().setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("ListarProveedores");
            rd.forward(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("usuario", "");

        RequestDispatcher rd = request.getRequestDispatcher("ListarProductos");
        rd.forward(request, response);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            String id = request.getParameter("id");

            if (id != null) {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(id));

                try {
                    usuario = usuarioService.findUsuarioById(usuario);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/modificarUsuario.jsp").forward(request, response);
            }

        } else if (accion != null && accion.equals("modificar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String password = request.getParameter("password");

            if ((nombre != null && !nombre.equals("")) && (apellidos != null && !apellidos.equals(""))
                    && (password != null && !password.equals(""))) {

                Usuario usuario = new Usuario();
                usuario.setId(id);
                usuario.setNombre(nombre);
                usuario.setApellidos(apellidos);
                usuario.setPassword(password);

                try {
                    usuarioService.updateUsuario(usuario);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            listarUsuarios(request, response);
        }
    }

}
