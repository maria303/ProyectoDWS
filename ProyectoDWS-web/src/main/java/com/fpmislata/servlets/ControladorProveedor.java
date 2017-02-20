/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
import com.fpmislata.domain.Usuario;
import com.fpmislata.service.ProductoServiceLocal;
import com.fpmislata.service.ProveedorServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "ControladorProveedor", loadOnStartup = 3, urlPatterns = {"/AltaProveedor", "/EliminarProveedor",
    "/ListarProveedores", "/ModificarProveedor"})
public class ControladorProveedor extends HttpServlet {

    @EJB
    private ProductoServiceLocal productoService;

    @EJB
    private ProveedorServiceLocal proveedorService;

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
        if (url.equals("/AltaProveedor")) {
            altaProveedor(request, response);
        }

        if (url.equals("/EliminarProveedor")) {
            eliminarProveedor(request, response);
        }

        if (url.equals("/ListarProveedores")) {
            listarProveedores(request, response);
        }

        if (url.equals("/ModificarProveedor")) {
            modificarProveedor(request, response);
        }
    }

    private void altaProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String provincia = request.getParameter("provincia");
        String cpString = request.getParameter("cp");
        String telefonoString = request.getParameter("telefono");
        String email = request.getParameter("email");

        if ((nombre != null && !nombre.equals("")) && (direccion != null && !direccion.equals(""))
                && (ciudad != null && !ciudad.equals("")) && (provincia != null && !provincia.equals(""))
                && (cpString != null && !cpString.equals("")) && (telefonoString != null && !telefonoString.equals(""))
                && (email != null && !email.equals(""))) {

            int cp = Integer.parseInt(cpString);
            int telefono = Integer.parseInt(telefonoString);

            Proveedor proveedor = new Proveedor();
            proveedor.setNombre(nombre);
            proveedor.setDireccion(direccion);
            proveedor.setCiudad(ciudad);
            proveedor.setProvincia(provincia);
            proveedor.setCodigoPostal(cp);
            proveedor.setTelefono(telefono);
            proveedor.setEmail(email);

            try {
                proveedorService.addProveedor(proveedor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        listarProveedores(request, response);
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idProveedor = Integer.parseInt(request.getParameter("id"));

        Proveedor proveedor = new Proveedor();
        proveedor.setId(idProveedor);

        proveedorService.deleteProveedor(proveedor);

        listarProveedores(request, response);
    }

    private void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List listaProveedores = proveedorService.listProveedores();

            ArrayList<Proveedor> listaArrayProveedores = new ArrayList<>(listaProveedores);
            request.getSession().setAttribute("proveedores", listaArrayProveedores);

            ArrayList<Producto> listaProductos = new ArrayList<>();
            request.getSession().setAttribute("productos", listaProductos);
            request.getSession().setAttribute("idProveedor", 0);
            request.getSession().setAttribute("nombreProveedor", "null");

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            request.getSession().setAttribute("usuario", usuario);

            RequestDispatcher rd = request.getRequestDispatcher("/listarProveedoresProductos.jsp");
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

    private void modificarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            String id = request.getParameter("id");

            if (id != null) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(Integer.parseInt(id));

                try {
                    proveedor = proveedorService.findProveedorById(proveedor);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.getSession().setAttribute("proveedor", proveedor);
                request.getRequestDispatcher("/modificarProveedor.jsp").forward(request, response);
            }

        } else if (accion != null && accion.equals("modificar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String ciudad = request.getParameter("ciudad");
            String provincia = request.getParameter("provincia");
            String cpString = request.getParameter("cp");
            String telefonoString = request.getParameter("telefono");
            String email = request.getParameter("email");

            if ((nombre != null && !nombre.equals("")) && (direccion != null && !direccion.equals(""))
                    && (ciudad != null && !ciudad.equals("")) && (provincia != null && !provincia.equals(""))
                    && (cpString != null && !cpString.equals("")) && (telefonoString != null && !telefonoString.equals(""))
                    && (email != null && !email.equals(""))) {

                int cp = Integer.parseInt(cpString);
                int telefono = Integer.parseInt(telefonoString);

                Proveedor proveedor = new Proveedor();
                proveedor.setId(id);
                proveedor.setNombre(nombre);
                proveedor.setDireccion(direccion);
                proveedor.setCiudad(ciudad);
                proveedor.setProvincia(provincia);
                proveedor.setCodigoPostal(cp);
                proveedor.setTelefono(telefono);
                proveedor.setEmail(email);

                try {
                    proveedorService.updateProveedor(proveedor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        listarProveedores(request, response);
    }

}
