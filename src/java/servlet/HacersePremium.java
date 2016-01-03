/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Premium;
import daos.PremiumDAO;
import daos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;

/**
 *
 * @author Asier
 */

public class HacersePremium extends HttpServlet {

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
        boolean noMoney = false;
        String ema = (String)request.getSession().getAttribute("usuario_email");
        UsuarioDAO uda = new UsuarioDAO(BD.getConexion());
        String nick = uda.devuelveNick(ema);
        PremiumDAO dP = new PremiumDAO(BD.getConexion());
        java.util.Date fecha = new Date();
        
        String cnt = (String)request.getParameter("premium_tarjeta");
        int sal = Integer.parseInt(request.getParameter("premium_saldo"));
        int pak = Integer.parseInt(request.getParameter("premiumPack"));
        
        if((pak==1 && sal<25) || (pak==2 && sal<65) || (pak==3 && sal<100)){
            noMoney = true;
        }
        
        if(noMoney){
            response.sendRedirect("premium.jsp?error=usuario");
        } else{
        Premium p = new Premium(nick, cnt, sal, fecha, pak);
        dP.hacerPremium(p);
        response.sendRedirect("principal.jsp");
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
            Logger.getLogger(HacersePremium.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HacersePremium.class.getName()).log(Level.SEVERE, null, ex);
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
