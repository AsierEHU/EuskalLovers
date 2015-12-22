/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asier
 */
@WebServlet(name = "pruebica", urlPatterns = {"/pruebica"})
public class pruebica extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String hol = request.getParameter("email");
            /* TODO output your page here. You may use following sample code. */
           out.println("primero");
           try{
               
               // no me va ni usando la clase BD ni creando la conexión manualmente
               //BD nh = new BD();
               
           Connection con; // = nh.getConexion();
           
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             out.println("connection");
            con = DriverManager.getConnection("jdbc:odbc:euskallovers");
             out.println("connection");
            out.println("connection");
                Statement set;
                int rs;
                out.println("rs");
                set = con.createStatement();
                out.println("create");
                rs = set.executeUpdate("insert into Usuario('Email', 'Nick', 'Contraseña') values ( " + hol + ",'asier','12345')");
           
           
           
               
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pruebica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pruebica at " + hol  + rs + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
           }
           catch(Exception e){
               e.getMessage();
           }
                
           
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
        } catch (ClassNotFoundException ex) {
            System.out.println("no va");
        } catch (SQLException ex) {
            Logger.getLogger(pruebica.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pruebica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(pruebica.class.getName()).log(Level.SEVERE, null, ex);
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
