/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.NotasPedido;
import com.fpmislata.service.NotasPedidosLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class NotaNueva extends HttpServlet {

    @EJB
    private NotasPedidosLocal notasPedidos;

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
        
        try {
            
            int numMesa = Integer.parseInt(request.getParameter("numMesa"));
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String[] fechaNuev = request.getParameterValues("fecha");
            Date fecha = formatoFecha.parse(fechaNuev[0]);
            String hora = request.getParameter("hora");
            double cuenta = Double.parseDouble(request.getParameter("cuenta"));
            
            NotasPedido nota = new NotasPedido(numMesa, fecha, hora);
            nota.setCuenta(cuenta);
            
            ArrayList<NotasPedido> listaNotasExis = notasPedidos.ListadoNotas();
            
            try {
                boolean esta = false;
                for (int i = 0; i < listaNotasExis.size(); i++) {
                    if (listaNotasExis.get(i).getFecha().equals(nota.getFecha()) && listaNotasExis.get(i).getHora().equalsIgnoreCase(nota.getHora())) {
                        esta = true;
                    }
                }
                if (esta == false) {
                    notasPedidos.addNota(nota);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            ArrayList<NotasPedido> lista = notasPedidos.ListadoNotas();
            request.setAttribute("notas", lista);
            
            request.getRequestDispatcher("/listaNotas.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NotaNueva.class.getName()).log(Level.SEVERE, null, ex);
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
