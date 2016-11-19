/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.service.ProductoServiceLocal;
import com.fpmislata.domain.Producto;
import com.fpmislata.domain.Proveedor;
import com.fpmislata.service.ProveedorServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
public class AltaProducto extends HttpServlet {

    @EJB
    private ProveedorServiceLocal proveedorService;

    @EJB
    private ProductoServiceLocal productoService;

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
        
//        String accion = request.getParameter("accion");
//        if(accion != null && accion.equals("1")){
//            int idProveedor = Integer.parseInt(request.getParameter("id"));
//            Proveedor proveedor = new Proveedor();
//            proveedor.setId(idProveedor);
//            
//            try{
//                proveedor = this.proveedorService.findProveedorById(proveedor);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            
//            request.setAttribute("proveedor", proveedor);
//            request.getRequestDispatcher("/agregarProducto.jsp").forward(request, response);
//            
//            
//        }
//            Proveedor proveedor = new Proveedor();
            
            
            
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String stockString = request.getParameter("stock");
        String precioString = request.getParameter("precio");
        String idProveedorString = request.getParameter("idProveedor");
        
        if(stockString == null || stockString.equals("")){
            stockString = "0";
        }
        if(precioString == null || precioString.equals("")){
            precioString = "0";
        }
        if(idProveedorString == null || idProveedorString.equals("")){
            precioString = "0";
        }
        
        int stock = Integer.parseInt(stockString);
        double precio = Double.parseDouble(precioString);
        int idProveedor = Integer.parseInt(idProveedorString);
        
        if(nombre != null && !nombre.equals("")){

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setStock(stock);
            producto.setPrecio(precio);
            producto.setIdProveedor(idProveedor);
            
//proveedor.setProducto(producto);
            try{
                productoService.addProducto(producto);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        
        ArrayList<Producto> lista = productoService.findProductosByIdProveedores(idProveedor);
        request.getSession().setAttribute("productos", lista);
        
        request.getRequestDispatcher("/listarProductosProveedores.jsp").forward(request, response);
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
