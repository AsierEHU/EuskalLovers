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
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.BD;
import utils.MailInterno.ListaMensajes;
import utils.MailInterno.Mensaje;

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
    
    private HashMap<String, ListaMensajes> mensajesOutput;
    private HashMap<String, ListaMensajes> mensajesInput;
    
    
    @Override
    public void init(ServletConfig cfg) throws ServletException {
        super.init(cfg);
        mensajesOutput = new HashMap<>();
        mensajesInput = new HashMap<>();
    }
    
    private void addMensaje(Mensaje men) {
        ListaMensajes lmo = mensajesOutput.get(men.getSender());
        if (lmo == null) {
            lmo = new ListaMensajes();
            mensajesOutput.put(men.getSender(), lmo);
        }
        lmo.addMensaje(men);
        
        ListaMensajes lmi = mensajesInput.get(men.getReciever());
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(men.getReciever(), lmi);
        }
        lmi.addMensaje(men);
    }

    private Iterator<Mensaje> getMensajesEnviados(String usuario) {
        ListaMensajes lmo = mensajesOutput.get(usuario);
        if (lmo == null) {
            lmo = new ListaMensajes();
            mensajesOutput.put(usuario, lmo);
        }
        return lmo.getMensajes();
    }
    
    private Iterator<Mensaje> getMensajesRecibidos(String usuario) {
        ListaMensajes lmi = mensajesInput.get(usuario);
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(usuario, lmi);
        }
        return lmi.getMensajes();
    }

    private int getNumeroMensajesRecibidos(String usuario) {
        ListaMensajes lmi = mensajesInput.get(usuario);
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(usuario, lmi);
        }
        return lmi.getNumeroMensajes();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String  usuario_email=(String) request.getSession(true).getAttribute("usuario_email");
        
        UsuarioDAO udao= new UsuarioDAO(BD.getConexion());
               
        Usuario usuario=null;
        try {
            usuario = udao.cogerUsuario(usuario_email);
        } catch (SQLException ex) {
            Logger.getLogger(MailInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String peticion = request.getParameter("peticion");
        if (peticion != null) {
            String usuario_nick = usuario.getNick();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            switch (peticion) {
                //addMessage()
                case "0":
                    String receiver = request.getParameter("destinatario");
                    String mensaje = request.getParameter("mensaje");
                    Mensaje men = new Mensaje(usuario_nick, receiver, mensaje);
                    addMensaje(men);
                    out.println("{\"enviado\":\"ok\"}");
                    break;

                //getMensajesEnviados()
                case "1":
                    Iterator<Mensaje> mensajesEnviados = getMensajesEnviados(usuario_nick);
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
                    Iterator<Mensaje> mensajesRecibidos = getMensajesRecibidos(usuario_nick);
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
                    int numMensajes = getNumeroMensajesRecibidos(usuario_nick);
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
