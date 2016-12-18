/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
import com.fpmislata.service.ProductoServiceLocal;
import com.fpmislata.service.ProveedorServiceLocal;
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
@WebServlet(name="ControladorProveedor", loadOnStartup=3, urlPatterns={"/AltaProveedor", "/EliminarProveedor", 
"ListarProveedores"})
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
        if(url.equals("/AltaProveedor")){
            AltaProveedor(request, response);
        }
        
        if(url.equals("/EliminarProveedor")){
            EliminarProveedor(request, response);
        }
        
        if(url.equals("/ListarProveedores")){
            ListarProveedores(request, response);
        }
    }
    
    private void AltaProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String ciudad = request.getParameter("ciudad");
        String provincia = request.getParameter("provincia");
        String cpString = request.getParameter("cp");
        String telefonoString = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        if((nombre != null && !nombre.equals("")) && (direccion != null && !direccion.equals(""))
                && (ciudad != null && !ciudad.equals("")) && (provincia != null && !provincia.equals(""))
                && (cpString != null && !cpString.equals("")) && (telefonoString != null && !telefonoString.equals(""))
                && (email != null && !email.equals(""))){
            
            int cp = Integer.parseInt(cpString);
            int telefono = Integer.parseInt(telefonoString);

            Proveedor proveedor = new Proveedor();
            proveedor.setNombre(nombre);
            proveedor.setDireccion(direccion);
            proveedor.setCiudad(ciudad);
            proveedor.setProvincia(provincia);
            proveedor.setCp(cp);
            proveedor.setTelefono(telefono);
            proveedor.setEmail(email);

            try{
                proveedorService.addProveedor(proveedor);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        ArrayList<Proveedor> lista = proveedorService.listProveedores();
        request.getSession().setAttribute("proveedores", lista);
        
        request.getRequestDispatcher("/listarProveedores.jsp").forward(request, response);
    }
    
    private void EliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idProveedor = Integer.parseInt(request.getParameter("id"));
        
        Proveedor proveedor = new Proveedor();
        proveedor.setId(idProveedor);
        proveedor = proveedorService.findProveedorById(proveedor);
        
        ArrayList<Producto> listaProductos = productoService.findProductosByProveedores(proveedor);
        
        try{
            for(Producto producto : listaProductos){
                this.productoService.deleteProducto(producto);
            }

            this.proveedorService.deleteProveedor(proveedor);
            
            ArrayList lista = proveedorService.listProveedores();
            request.getSession().setAttribute("proveedores", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/listarProveedores.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void ListarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            ArrayList lista = proveedorService.listProveedores();
            request.getSession().setAttribute("proveedores", lista);
            
            
            ///////////////////
            ArrayList<Producto> listaProductos = new ArrayList<>();
            request.getSession().setAttribute("productos", listaProductos);
            request.getSession().setAttribute("idProveedor", 0);
            request.getSession().setAttribute("nombreProveedor", "null");
            /////////////////////
            
            
//            RequestDispatcher rd = request.getRequestDispatcher("/listarProveedores.jsp");
RequestDispatcher rd = request.getRequestDispatcher("/prueba1.jsp");
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
