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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.BD;
import utils.GMail;

/**
 *
 * @author Adrián
 */
@MultipartConfig
public class registrarse extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            boolean fem_reg = true;
            boolean fem_bus = true;
            boolean alturaSi = false;
            boolean pesoSi = false;
            boolean altura_busqueda_si = false;
            boolean peso_busqueda_si = false;
            boolean cp_busqueda_si = false;

            
            
            String nick = (String) request.getParameter("registro_nick");
            String mail = (String) request.getParameter("registro_email");
            UsuarioDAO ud = new UsuarioDAO(BD.getConexion());
            if (!ud.yaExisteUsuario(nick, mail)) {

                String pass = (String) request.getParameter("registro_password");
                String gen = (String) request.getParameter("registro_genero");
                if (gen.equals("Masculino")) {
                    fem_reg = false;
                }
                String ciudad = (String) request.getParameter("registro_ciudad");
                String cp = request.getParameter("registro_cp");
                int edad = Integer.parseInt(request.getParameter("registro_edad"));
                float altura = (float) 0.0;
                if (request.getParameter("registro_altura").equals("")) {
                } else {
                    alturaSi = true;
                    altura = Float.parseFloat(request.getParameter("registro_altura"));
                }
                int peso = 0;
                if (request.getParameter("registro_peso").equals("")) {
                } else {
                    pesoSi = true;
                    peso = Integer.parseInt(request.getParameter("registro_peso"));
                }
                String consti = (String) request.getParameter("registro_const");
                String[] caracter;
                caracter = request.getParameterValues("registro_carac");
                String[] gustos;
                gustos = request.getParameterValues("registro_gustos");
                
                Part foto = request.getPart("registro_foto");
                String fotoName=new Date().getTime()+foto.getSubmittedFileName();
                String path=getServletContext().getRealPath("/img/fotos")+"/"+fotoName;
                OutputStream out = new FileOutputStream(new File(path));
                InputStream filecontent = foto.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                Usuario u = new Usuario(nick, mail, pass, fem_reg, consti, edad, ciudad, cp, fotoName);

                ud.insertarUsuario(u);

                if (alturaSi) {
                    Usuario u1 = new Usuario(nick, mail, pass, fem_reg, edad, altura, peso, consti, ciudad, cp, fotoName);
                    UsuarioDAO ud1 = new UsuarioDAO(BD.getConexion());
                    ud1.actualizarAltura(u1);
                }

                if (pesoSi) {
                    Usuario u2 = new Usuario(nick, mail, pass, fem_reg, edad, altura, peso, consti, ciudad, cp, fotoName);
                    UsuarioDAO ud2 = new UsuarioDAO(BD.getConexion());
                    ud2.actualizarPeso(u2);
                }

                if (caracter != null) {
                    for (String caracter1 : caracter) {
                        Personalidad per = new Personalidad(nick, caracter1);
                        PersonalidadDAO perD = new PersonalidadDAO(BD.getConexion());
                        perD.insertarPersonalidad(per);
                    }
                }

                if (gustos != null) {
                    for (String aficion1 : gustos) {
                        Aficion afi = new Aficion(nick, aficion1);
                        AficionDAO afiD = new AficionDAO(BD.getConexion());
                        afiD.insertarAficion(afi);
                    }
                }

                String gen_bus = (String) request.getParameter("genero_busqueda");
                if (gen_bus.equals("Hombres")) {
                    fem_bus = false;
                }
                int edad_bus = Integer.parseInt(request.getParameter("edad_busqueda"));

                float altura_bus = (float) 0.0;
                if (request.getParameter("altura_busqueda").equals("")) {
                } else {
                    altura_busqueda_si = true;
                    altura_bus = Float.parseFloat(request.getParameter("altura_busqueda"));
                }
                int peso_bus = 0;
                if (request.getParameter("peso_busqueda").equals("")) {
                } else {
                    peso_busqueda_si = true;
                    peso_bus = Integer.parseInt(request.getParameter("peso_busqueda"));
                }
                String ciudad_bus = (String) request.getParameter("ciudad_busqueda");
                String const_bus = (String) request.getParameter("const_busqueda");
                String cp_bus = (String) request.getParameter("cp_busqueda");
                if (cp_bus.equals("null")) {
                    cp_bus = "";
                } else {
                    cp_busqueda_si = true;
                }

                Interes inter_usuario = new Interes(nick, fem_bus, edad_bus, const_bus, ciudad_bus);
                InteresDAO interD = new InteresDAO(BD.getConexion());

                interD.insertarInteresBasico(inter_usuario);

                if (altura_busqueda_si) {
                    Interes inter_usuario1 = new Interes(nick, fem_bus, edad_bus, altura_bus, peso_bus, const_bus, ciudad_bus, cp_bus);
                    InteresDAO interD1 = new InteresDAO(BD.getConexion());
                    interD1.actualizarAlturaBusqueda(inter_usuario1);
                }
                if (peso_busqueda_si) {
                    Interes inter_usuario2 = new Interes(nick, fem_bus, edad_bus, altura_bus, peso_bus, const_bus, ciudad_bus, cp_bus);
                    InteresDAO interD2 = new InteresDAO(BD.getConexion());
                    interD2.actualizarPesoBusqueda(inter_usuario2);
                }
                if (cp_busqueda_si) {
                    Interes inter_usuario3 = new Interes(nick, fem_bus, edad_bus, altura_bus, peso_bus, const_bus, ciudad_bus, cp_bus);
                    InteresDAO interD3 = new InteresDAO(BD.getConexion());
                    interD3.actualizarCPBusqueda(inter_usuario3);
                }

                GMail.getMail().enviarMensaje(mail, "Nueva alta", "Enhorabuena! Se ha dado de alta en EuskalLovers.");
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("registro.jsp?error=usuario");
            }

        } catch (SQLException ex) {
            Logger.getLogger(registrarse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(registrarse.class.getName()).log(Level.SEVERE, null, ex);
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
