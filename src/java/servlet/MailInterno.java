/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String peticion = request.getParameter("peticion");
        if (peticion != null) {
            MessageControl mc = (MessageControl) getServletContext().getAttribute("mailInterno");
            if (mc == null) {
                mc = MessageControl.getMessageControl();
                getServletContext().setAttribute("mailInterno", mc);
            }
            String usuario = "Prueba";
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            switch (peticion) {
                //addMessage()
                case "0":
                    String destinatario = request.getParameter("destinatario");
                    String mensaje = request.getParameter("mensaje");
                    Mensaje men = new Mensaje(usuario, destinatario, mensaje);
                    mc.addMensaje(men);
                    break;
                    
                //getMensajes()
                case "1":
                    Iterator<Mensaje> mensajes = mc.getMensajes(usuario);
                    String content = "{'mensajes':[";
                    while (mensajes.hasNext()) {
                        Mensaje x = mensajes.next();
                        content += "{'sender':'" + x.getSender() + "','mensaje':'" + x.getMensaje() + "'},";
                    }
                    content = content.substring(0, content.length() - 1);
                    content += "]}";
                    break;
                    
                //getNumeroMensajes()
                case "2":
                    int numMensajes = mc.getNumeroMensajes(usuario);
                    out.println("{'cantidad':'" + numMensajes + "'}");
                    break;
                    
                default:
                    out.println("{'error':'Error en la peticion'}");
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
