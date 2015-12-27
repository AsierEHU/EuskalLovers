/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Aficion;
import beans.Interes;
import beans.Personalidad;
import beans.Usuario;
import daos.AficionDAO;
import daos.InteresDAO;
import daos.PersonalidadDAO;
import daos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;

/**
 *
 * @author Asier
 */
@WebServlet(name = "modificarPerfil", urlPatterns = {"/Perfil"})
public class modificarPerfil extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            boolean fem = true;
            boolean feme_bus = true;

            String em = (String) request.getParameter("perfil_email");
            String pass = (String) request.getParameter("perfil_password");
            String nk = (String) request.getParameter("perfil_nick");
            String gnero = (String) request.getParameter("perfil_genero");

            if (gnero.equals("Masculino")) {
                fem = false;
            }

            String ciuad = (String) request.getParameter("perfil_ciudad");
            String Cpos = (String) request.getParameter("perfil_cp");
            int dad = Integer.parseInt(request.getParameter("perfil_edad"));
            float alt = Float.parseFloat(request.getParameter("perfil_altura"));
            int pso = Integer.parseInt(request.getParameter("perfil_peso"));
            String asp = (String) request.getParameter("perfil_const");

            Usuario u = new Usuario(nk, em, pass, fem, dad, alt, pso, asp, ciuad, Cpos, "");
            UsuarioDAO us = new UsuarioDAO(BD.getConexion());
            us.modificarUsuario(u);

            //Personalidad
            PersonalidadDAO ps = new PersonalidadDAO(BD.getConexion());
            String[] cara = request.getParameterValues("perfil_carac");
            ps.eliminarPersonalidades(nk);
            if (cara != null) {
                for (String c : cara) {
                    Personalidad Pp = new Personalidad(u.getNick(), c);
                    ps.insertarPersonalidad(Pp);
                }
            }

            //Aficiones
            AficionDAO as = new AficionDAO(BD.getConexion());
            String[] gust = request.getParameterValues("perfil_gustos");
            as.eliminarAficiones(nk);
            if (gust != null) {
                for (String g : gust) {
                    Aficion Gp = new Aficion(u.getNick(), g);
                    as.insertarAficion(Gp);

                }
            }

            //Intereses
            String gene_bus = (String) request.getParameter("genero_busqueda");
            if (gene_bus.equals("Masculino")) {
                feme_bus = false;
            }
            int eda_bus = Integer.parseInt(request.getParameter("edad_busqueda"));
            double altur_bus = Double.parseDouble(request.getParameter("altura_busqueda"));
            int pes_bus = Integer.parseInt(request.getParameter("peso_busqueda"));
            String ciuda_bus = (String) request.getParameter("ciudad_busqueda");
            String cons_bus = (String) request.getParameter("const_busqueda");
            String cpe_bus = request.getParameter("cp_busqueda");

            Interes int_us = new Interes(nk, feme_bus, eda_bus, altur_bus, pes_bus, cons_bus, ciuda_bus, cpe_bus);
            InteresDAO interD = new InteresDAO(BD.getConexion());

            interD.cambiarInteres(int_us);

            response.sendRedirect("perfil.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(modificarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(modificarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
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
