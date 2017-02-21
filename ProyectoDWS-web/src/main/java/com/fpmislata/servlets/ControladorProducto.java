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
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
@WebServlet(name = "ControladorProducto", loadOnStartup = 3, urlPatterns = {"/AltaProducto",
    "/ModificarProducto", "/ListarProductos", "/EliminarProducto", "/ListarProductosPorProveedores",
    "/ModificarProductoProveedor", "/BuscarProductoPorNombre", "/BuscarProductosPorStock"})
public class ControladorProducto extends HttpServlet {

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
        String url = request.getServletPath();

        if (url.equals("/AltaProducto")) {
            altaProducto(request, response);
        }

        if (url.equals("/ModificarProducto")) {
            modificarProducto(request, response);
        }

        if (url.equals("/ListarProductos")) {
            listarProductos(request, response);
        }

        if (url.equals("/EliminarProducto")) {
            eliminarProducto(request, response);
        }

        if (url.equals("/ListarProductosPorProveedores")) {
            listarProductosPorProveedores(request, response);
        }

        if (url.equals("/ModificarProductoProveedor")) {
            modificarProductoProveedor(request, response);
        }

        if (url.equals("/BuscarProductoPorNombre")) {
            buscarProductoPorNombre(request, response);
        }

        if (url.equals("/BuscarProductosPorStock")) {
            buscarProductosPorStock(request, response);
        }
    }

    private void altaProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        int idProveedor = (Integer) request.getSession().getAttribute("idProveedor");

        Producto producto = new Producto(nombre, descripcion, stock, precio);

        Proveedor proveedor = new Proveedor();
        proveedor.setId(idProveedor);
        proveedor = proveedorService.findProveedorById(proveedor);

        producto.setProveedor(proveedor);
        proveedor.getProductos().add(producto);

        try {
            productoService.addProducto(producto);
            proveedorService.updateProveedor(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Producto> listaProductos = new ArrayList<>(proveedor.getProductos());
        request.getSession().setAttribute("productos", listaProductos);

        RequestDispatcher rd = request.getRequestDispatcher("/listarProveedoresProductos.jsp");
        rd.forward(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            String id = request.getParameter("id");

            if (id != null) {
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(id));

                try {
                    producto = productoService.findProductoById(producto);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.getSession().setAttribute("producto", producto);
                request.getRequestDispatcher("/modificarProducto.jsp").forward(request, response);
            }

        } else if (accion != null && accion.equals("modificar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String stockString = request.getParameter("stock");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int idProveedor = Integer.parseInt(request.getParameter("idProveedor"));

            if (stockString == null || stockString.equals("")) {
                stockString = "0";
            }

            int stock = Integer.parseInt(stockString);

            if (nombre != null && !nombre.equals("")) {

                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setStock(stock);
                producto.setPrecio(precio);

                Proveedor proveedor = new Proveedor();
                proveedor.setId(idProveedor);
                proveedor = proveedorService.findProveedorById(proveedor);
                producto.setProveedor(proveedor);

                try {
                    productoService.updateProducto(producto);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listarProductos(request, response);

            }
        }
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List listaProductos = productoService.listProductos();

            ArrayList<Producto> listaArrayProductos = new ArrayList<>(listaProductos);
            request.getSession().setAttribute("productos", listaArrayProductos);

            RequestDispatcher rd = request.getRequestDispatcher("/listarProductos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Producto producto = new Producto();
        producto.setId(id);
        producto = productoService.findProductoById(producto);

        Proveedor proveedor = producto.getProveedor();
        producto.getProveedor().getProductos().remove(producto);

        try {
            productoService.deleteProducto(producto);
            proveedorService.updateProveedor(proveedor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int idProveedor = (Integer) request.getSession().getAttribute("idProveedor");
        Proveedor prov = new Proveedor();
        prov.setId(idProveedor);
        prov = proveedorService.findProveedorById(prov);
        ArrayList<Producto> listaProductos = new ArrayList<>(prov.getProductos());

        request.getSession().setAttribute("productos", listaProductos);

        RequestDispatcher rd = request.getRequestDispatcher("/listarProveedoresProductos.jsp");
        rd.forward(request, response);
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

    private void listarProductosPorProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int idProveedor = Integer.parseInt(request.getParameter("id"));

            Proveedor proveedor = new Proveedor();
            proveedor.setId(idProveedor);
            proveedor = proveedorService.findProveedorById(proveedor);

            String nombreProveedor = proveedor.getNombre();
            request.getSession().setAttribute("nombreProveedor", nombreProveedor);
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            request.getSession().setAttribute("usuario", usuario);

            ArrayList<Producto> listaProductos = new ArrayList<>(proveedor.getProductos());

            request.getSession().setAttribute("productos", listaProductos);
            request.getSession().setAttribute("idProveedor", idProveedor);

            RequestDispatcher rd = request.getRequestDispatcher("/listarProveedoresProductos.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void modificarProductoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {
            String id = request.getParameter("id");

            if (id != null) {
                Producto producto = new Producto();
                producto.setId(Integer.parseInt(id));

                try {
                    producto = productoService.findProductoById(producto);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("producto", producto);
                request.getRequestDispatcher("/modificarProductoProveedor.jsp").forward(request, response);
            }

        } else if (accion != null && accion.equals("modificar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String stockString = request.getParameter("stock");
            String precioString = request.getParameter("precio");

            if (stockString == null || stockString.equals("")) {
                stockString = "0";
            }
            if (precioString == null || precioString.equals("")) {
                precioString = "0";
            }

            int stock = Integer.parseInt(stockString);
            double precio = Double.parseDouble(precioString);
            int idProveedor = (Integer) request.getSession().getAttribute("idProveedor");

            Proveedor proveedor = new Proveedor();
            proveedor.setId(idProveedor);
            proveedor = proveedorService.findProveedorById(proveedor);

            if (nombre != null && !nombre.equals("")) {

                Producto producto = new Producto();
                producto.setId(id);
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setStock(stock);
                producto.setPrecio(precio);
                producto.setProveedor(proveedor);

                try {
                    productoService.updateProducto(producto);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            Proveedor prov = new Proveedor();
            prov.setId(idProveedor);
            prov = proveedorService.findProveedorById(prov);
            ArrayList<Producto> listaProductos = new ArrayList<>(prov.getProductos());

            request.getSession().setAttribute("productos", listaProductos);

            RequestDispatcher rd = request.getRequestDispatcher("/listarProveedoresProductos.jsp");
            rd.forward(request, response);
        }
    }

    private void buscarProductoPorNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        Producto producto = new Producto();
        producto.setNombre(nombre);

        producto = productoService.findProductoByNombre(producto);

        request.getSession().setAttribute("producto", producto);
        RequestDispatcher rd = request.getRequestDispatcher("/mostrarProducto.jsp");
        rd.forward(request, response);
    }

    private void buscarProductosPorStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stock = Integer.parseInt(request.getParameter("stock"));

        Producto producto = new Producto();
        producto.setStock(stock);

        List listaProductos = productoService.findProductosByStock(producto);

        ArrayList<Producto> listaArrayProductos = new ArrayList<>(listaProductos);

        request.getSession().setAttribute("productos", listaArrayProductos);
        RequestDispatcher rd = request.getRequestDispatcher("/listarProductos.jsp");
        rd.forward(request, response);
    }
}
