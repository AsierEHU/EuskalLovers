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
import java.util.Iterator;
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

            //Si pulsa el boton de busqueda de perfil
            if (buscarPerfil.equals(request.getParameter("buscar"))) {
                String nickBusq = (String) request.getParameter("nick_busq");
                if(new UsuarioDAO(BD.getConexion()).yaExisteUsuario(nickBusq, "email")){
                    response.sendRedirect("perfilBusqueda.jsp?nick=" + nickBusq);
                }else{
                    response.sendRedirect("principal.jsp?error="+nickBusq);
                }
            }

            //si pulsa el boton de busqueda basica
            if (basico.equals(request.getParameter("buscar"))) {

                InteresDAO idao= new InteresDAO(BD.getConexion());
                Interes in = idao.recuperarInteres((String) request.getSession().getAttribute("usuario_nick"));
                ArrayList<String> buscadosList = idao.buscarUsuariosConcreto(in);
                String encontrados="?";
                Iterator<String> it =buscadosList.iterator();
                while(it.hasNext()){
                    encontrados+="nicks="+it.next()+"&";
                }
                encontrados=encontrados.substring(0, encontrados.length()-1);

                response.sendRedirect("principal.jsp"+encontrados);
            }
            //si pulsa el boton de busqueda avanzada
            if (avanzado.equals(request.getParameter("buscar"))) {
                String genero = (String) request.getParameter("genero_busq1");
                boolean gen=true;
                if (genero.equals("Masculino")) {
                    gen = false;
                }
                int edad = Integer.parseInt(request.getParameter("edad_busq1"));
                float altura = Float.parseFloat(request.getParameter("altura_busq1"));
                int peso = Integer.parseInt(request.getParameter("peso_busq1"));
                String ciudad = (String) request.getParameter("ciudad_busq1");
                String cp = request.getParameter("cp_busq1");
                String consti = (String) request.getParameter("const_busq1");
                
                InteresDAO idao= new InteresDAO(BD.getConexion());
                Interes in = new Interes("", gen, edad, altura, peso, consti, ciudad, cp);
                ArrayList<String> buscadosList = idao.buscarUsuariosConcreto(in);
                String encontrados="?";
                Iterator<String> it =buscadosList.iterator();
                while(it.hasNext()){
                    encontrados+="nicks="+it.next()+"&";
                }
                encontrados=encontrados.substring(0, encontrados.length()-1);

                response.sendRedirect("principal.jsp"+encontrados);
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
