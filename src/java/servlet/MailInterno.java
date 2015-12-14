/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.Usuario;
import daos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.ConexionBD;
import utils.MailInterno.Mensaje;
import utils.MailInterno.MessageControl;

/**
 *
 * @author docencia
 */
public class MailInterno extends HttpServlet {

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
        
        //Luego borrar
        request.getSession(true).setAttribute("usuario_email", "asier@asier.com");
        //
        
        String  usuario_email=(String) request.getSession(true).getAttribute("usuario_email");
        
        UsuarioDAO udao= new UsuarioDAO(ConexionBD.getConexionBD().getConnection());
               
        Usuario usuario=null;
        try {
            usuario = udao.cogerUsuario(usuario_email);
        } catch (SQLException ex) {
            Logger.getLogger(MailInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String peticion = request.getParameter("peticion");
        if (peticion != null) {
            MessageControl mc = MessageControl.getMessageControl();
            String usuario_nick = usuario.getNick();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            switch (peticion) {
                //addMessage()
                case "0":
                    String receiver = request.getParameter("destinatario");
                    String mensaje = request.getParameter("mensaje");
                    Mensaje men = new Mensaje(usuario_nick, receiver, mensaje);
                    mc.addMensaje(men);
                    out.println("{\"enviado\":\"ok\"}");
                    break;

                //getMensajesEnviados()
                case "1":
                    Iterator<Mensaje> mensajesEnviados = mc.getMensajesEnviados(usuario_nick);
                    String contentOut = "{\"mensajes\":[";
                    boolean tieneMensajes = false;
                    while (mensajesEnviados.hasNext()) {
                        Mensaje x = mensajesEnviados.next();
                        contentOut += "{\"receiver\":\"" + x.getReciever() + "\",\"mensaje\":\"" + x.getMensaje() + "\"},";
                        tieneMensajes = true;
                    }
                    if (tieneMensajes) {
                        contentOut = contentOut.substring(0, contentOut.length() - 1);
                    }
                    contentOut += "]}";
                    out.println(contentOut);
                    break;

                //getMensajesRecibidos()
                case "2":
                    Iterator<Mensaje> mensajesRecibidos = mc.getMensajesRecibidos(usuario_nick);
                    String contentIn = "{\"mensajes\":[";
                    while (mensajesRecibidos.hasNext()) {
                        Mensaje x = mensajesRecibidos.next();
                        contentIn += "{\"sender\":\"" + x.getSender() + "\",\"mensaje\":\"" + x.getMensaje() + "\"},";
                    }
                    contentIn = contentIn.substring(0, contentIn.length() - 1);
                    contentIn += "]}";
                    out.println(contentIn);
                    break;

                //getNumeroMensajesRecibidos()
                case "3":
                    int numMensajes = mc.getNumeroMensajesRecibidos(usuario_nick);
                    out.println("{\"cantidad\":\"" + numMensajes + "\"}");
                    break;

                default:
                    out.println("{\"error\":\"Error en la peticion\"}");
                    break;
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
