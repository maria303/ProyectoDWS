/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Nota;
import com.fpmislata.service.NotaServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ControladorNota", loadOnStartup = 3, urlPatterns = {"/NotaNueva", "/NotaMod", "/Notas",
    "/EliminarNota", "/OrdenarNotaPorNumMesa"})
public class ControladorNota extends HttpServlet {

    @EJB
    private NotaServiceLocal notaService;

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
        if (url.equals("/NotaNueva")) {
            notaNueva(request, response);
        }

        if (url.equals("/NotaMod")) {
            notaMod(request, response);
        }

        if (url.equals("/Notas")) {
            notas(request, response);
        }

        if (url.equals("/EliminarNota")) {
            eliminarNota(request, response);
        }

        if (url.equals("/OrdenarNotaPorNumMesa")) {
            ordenarNotaPorNumMesa(request, response);
        }
    }

    private void notaNueva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            int numMesa = Integer.parseInt(request.getParameter("numMesa"));
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String[] fechaNuev = request.getParameterValues("fecha");
            Date fecha = formatoFecha.parse(fechaNuev[0]);
            String hora = request.getParameter("hora");
            double cuenta = Double.parseDouble(request.getParameter("cuenta"));

            Nota nota = new Nota(numMesa, fecha, hora, cuenta);

            try {
                notaService.addNota(nota);
            } catch (Exception e) {
                e.printStackTrace();
            }
            notas(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void notaMod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("editar")) {

            String ids = request.getParameter("id");
            if (ids != null) {
                int id = Integer.valueOf(ids);
                Nota nota = new Nota();
                nota.setId(id);
                try {
                    nota = notaService.encontrarPorId(nota);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.getSession().setAttribute("notaP", nota);
                request.getRequestDispatcher("/modificarNota.jsp").forward(request, response);
            }
        }
        if (accion != null && accion.equals("modificar")) {

            try {

                int id = Integer.parseInt(request.getParameter("id"));
                int numMesa = Integer.parseInt(request.getParameter("numMesa"));
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String[] fechaBorr = request.getParameterValues("fecha");
                Date fecha = formatoFecha.parse(fechaBorr[0]);
                String hora = request.getParameter("hora");
                double cuenta = Double.parseDouble(request.getParameter("cuenta"));

                Nota nota = new Nota();
                nota.setId(id);
                nota.setNum_mesa(numMesa);
                nota.setFecha(fecha);
                nota.setHora(hora);
                nota.setCuenta(cuenta);

                try {
                    notaService.modNota(nota);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                notas(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(Nota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void notas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List notas = notaService.listadoNotas();
            ArrayList<Nota> listaDeNotas = new ArrayList<>(notas);
            request.getSession().setAttribute("notas", listaDeNotas);
            RequestDispatcher rd = request.getRequestDispatcher("/listaNotas.jsp");
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

    private void eliminarNota(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Nota nota = new Nota();
        nota.setId(id);

        try {
            notaService.eliminarNota(nota);
        } catch (Exception e) {
            e.printStackTrace();
        }

        notas(request, response);
    }

    private void ordenarNotaPorNumMesa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List notas = notaService.orderByNumMesa();
            ArrayList<Nota> listaDeNotas = new ArrayList<>(notas);
            request.getSession().setAttribute("notas", listaDeNotas);
            RequestDispatcher rd = request.getRequestDispatcher("/listaNotas.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
