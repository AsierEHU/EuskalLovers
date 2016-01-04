/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Interes;
import daos.InteresDAO;
import daos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Adrián
 */
@WebServlet(name = "busqueda", urlPatterns = {"/busqueda"})
public class busqueda extends HttpServlet {

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
            String basico = "Busqueda basica";
            String avanzado = "Busqueda avanzada";
            String buscarPerfil = "Visitar perfil";
            boolean gen = true;
            boolean alturaSi = false;
            boolean pesoSi = false;
            boolean cpSi = false;
            
            //Si pulsa el boton de busqueda de perfil
            if(buscarPerfil.equals(request.getParameter("buscar"))){
                    String nick = (String)request.getParameter("nick_busq");
                    UsuarioDAO uDAO = new UsuarioDAO(BD.getConexion());
                    String email = uDAO.devuelveEmail(nick);
                    request.getSession().setAttribute("email_perfil_busq", email);
                    response.sendRedirect("perfilBusqueda.jsp");
                    }
            
            //si pulsa el boton de busqueda basica
            if(basico.equals(request.getParameter("buscar"))){                       
            String genero = (String) request.getParameter("genero_busq");
                if (genero.equals("Masculino")) {
                    gen = false;
                }
            int edad = Integer.parseInt(request.getParameter("edad_busq"));
            float altura = (float) 0.0;
            if (request.getParameter("altura_busq").equals("")) {
                } else {
                    alturaSi = true;
                    altura = Float.parseFloat(request.getParameter("altura_busq"));
                }
            int peso = 0;
                if (request.getParameter("peso_busq").equals("")) {
                } else {
                    pesoSi = true;
                    peso = Integer.parseInt(request.getParameter("peso_busq"));
                }
            String ciudad = (String) request.getParameter("ciudad_busq");
            String cp = "";
            if(request.getParameter("cp_busq").equals("")){    
            }
            else{
                cpSi = true;
                cp = request.getParameter("cp_busq");}
            String consti = (String) request.getParameter("const_busq");
            
            if(pesoSi && alturaSi && cpSi){
            Interes inter1 = new Interes("", gen, edad, altura, peso,consti, ciudad,cp);
            InteresDAO interD1 = new InteresDAO(BD.getConexion());
            ArrayList<String> buscados = interD1.buscarUsuariosConcreto(inter1);
            request.getSession().setAttribute("listaBuscados", buscados); 
            }
            
            else{
                Interes inter2 = new Interes("",gen,edad,consti,ciudad);
                InteresDAO interD2 = new InteresDAO(BD.getConexion());
                ArrayList<String> buscados = interD2.buscarUsuariosBasico(inter2);
                request.getSession().setAttribute("listaBuscados", buscados);
            }
            response.sendRedirect("principal.jsp");
            }
            //si pulsa el boton de busqueda avanzada
            if (avanzado.equals(request.getParameter("buscar"))){
                String genero = (String) request.getParameter("genero_busq1");
                if (genero.equals("Masculino")) {
                    gen = false;
                }
                int edad = Integer.parseInt(request.getParameter("edad_busq1"));
                float altura = Float.parseFloat(request.getParameter("altura_busq1"));
                int peso = Integer.parseInt(request.getParameter("peso_busq1"));
                String ciudad = (String) request.getParameter("ciudad_busq1");
                String cp = request.getParameter("cp_busq1");
                String consti = (String) request.getParameter("const_busq1");
                Interes inter1 = new Interes("", gen, edad, altura, peso,consti, ciudad,cp);
                InteresDAO interD1 = new InteresDAO(BD.getConexion());
                ArrayList<String> buscados = interD1.buscarUsuariosConcreto(inter1);
                if (buscados==null){
                    Interes inter2 = new Interes("",gen,edad,consti,ciudad);
                    InteresDAO interD2 = new InteresDAO(BD.getConexion());
                    buscados = interD2.buscarUsuariosBasico(inter2);
                }
                    request.getSession().setAttribute("listaBuscados", buscados);
                    response.sendRedirect("principal.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(busqueda.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(busqueda.class.getName()).log(Level.SEVERE, null, ex);
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
