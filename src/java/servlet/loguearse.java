/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import daos.PremiumDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;
import daos.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asier
 */

public class loguearse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        String em = (String) request.getParameter("email_control");
        String pass = (String) request.getParameter("pass_control");
        UsuarioDAO us = new UsuarioDAO(BD.getConexion());
        PremiumDAO pus = new PremiumDAO(BD.getConexion());
        long tim = (long) 0.00;

        if (us.esCorrecto(em, pass)) {
            request.getSession(true).setAttribute("usuario_email", em);
            
            String nk = us.devuelveNick(em);
            if(pus.esPremium(nk)){
                if(pus.getPack(nk)==1){
                    if(pus.tiempoPremium(nk,30) < 0){            
                        pus.darBajaPremium(nk);
                        tim = pus.tiempoPremium(nk,30);
                         }
                }
                if(pus.getPack(nk)==3){
                    if(pus.tiempoPremium(nk,90) < 0){
                        pus.darBajaPremium(nk);
                        tim = pus.tiempoPremium(nk,90);
                    }
                }
                if(pus.getPack(nk)==6){
                    if(pus.tiempoPremium(nk,180)<0){
                        pus.darBajaPremium(nk);
                        tim = pus.tiempoPremium(nk,180);
                    }
                    
                    request.getSession(true).setAttribute("tiempoPremium", tim);
                    
                }
            }
            
            response.sendRedirect("principal.jsp");
        } else {
            response.sendRedirect("index.jsp?error=login");
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
            Logger.getLogger(loguearse.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(loguearse.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
