/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author MCO
 */
public class BDConnect extends HttpServlet {

  // Declaración de variables miembro
  private String nombre = null;
  private String apellidos = null;
  private String opinion = null;
  private String comentarios = null;

  // Referencia a un objeto de la interface java.sql.Connection 
  Connection conn = null;

  // Este método se ejecuta una única vez (al ser inicializado el servlet por primera vez)
  // Se suelen inicializar variables y ejecutar operaciones costosas en tiempo
  // de ejecución (abrir ficheros, conectar con bases de datos, etc) 
  public void init (ServletConfig config) throws ServletException {

    // Llamada al método init() de la superclase (GenericServlet)
    // Así se asegura una correcta inicialización del servlet
    super.init(config);

    // dsn (Data Source Name) de la base de datos
    String dsn = new String("jdbc:ucanaccess://C:/Users/Asier/Desktop/Aserrin/Carrera/TERCERO/ADSI/ServletsJDBC1-ej/web/WEB-INF/ServletOpinion2.accdb");

    // Carga del Driver del puente JDBC-ODBC
    try {
        
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    } catch(ClassNotFoundException ex) {
      System.out.println("Error al cargar el driver");
      System.out.println(ex.getMessage());
    } {
         // Logger.getLogger(ServletOpinion2.class.getName()).log(Level.SEVERE, null, ex);
      }
    // Establecimiento de la conexión con la base de datos
    try {
      conn = DriverManager.getConnection(dsn);
    } catch (SQLException sqlEx) {
      System.out.println("Se ha producido un error al" +
                         " establecer la conexión con: " + dsn);
      System.out.println(sqlEx.getMessage());
    }

    System.out.println("Iniciando ServletOpinion (version BD)...");
  } // fin del método init()

  // Este método es llamado por el servidor web al "apagarse" (shut down).
  // Sirve para proporcionar una correcta desconexión de una base de datos, 
  // cerrar ficheros abiertos, etc.
  public void destroy () {
    super.destroy();
    System.out.println("Cerrando conexion...");
    try {
      conn.close();
    } catch(SQLException ex){
      System.out.println("No se pudo cerrar la conexion");
      System.out.println(ex.getMessage());
    }
  } // fin del método destroy()

  // Método de llamada mediante un HTTP POST 
  public void doPost (HttpServletRequest req, HttpServletResponse resp)
                                     throws ServletException, IOException {

    boolean hayError = false;

    // adquisición de los valores del formulario
    if(!req.getParameter("nombre").equals(""))
      nombre = req.getParameter("nombre");
    else 
      hayError=true;
            
    if(!req.getParameter("apellidos").equals(""))
      apellidos = req.getParameter("apellidos");
    else
      hayError = true;

    if(!req.getParameter("opinion").equals(""))
      opinion = req.getParameter("opinion");
    else 
      hayError = true;

    if(!req.getParameter("comentarios").equals(""))
      comentarios = req.getParameter("comentarios");
    else
      hayError = true;

    // Mandar al usuario los valores adquiridos (Si no se ha producido error)
    if(!hayError) {
      if (actualizarBaseDeDatos() == 0)
        devolverPaginaHTML(resp);
      else
        resp.sendError(500, "Se ha producido un error al actualizar la base de datos");
    } else
      resp.sendError(500, "Se ha producido un error en la adquisición de parámetros");
  } // fin doPost()

  public int actualizarBaseDeDatos() {
    // crear un statement de SQL
    Statement stmt=null;
    int numeroFilasActualizadas=0;

    // Ejecución del query de actualización de la base de datos
    try {
      stmt = conn.createStatement();
      numeroFilasActualizadas = stmt.executeUpdate("INSERT INTO Opiniones_Recogidas VALUES "+
                              "('"+nombre+"','"+apellidos+"','"+opinion+"','"+comentarios+"')");
      if(numeroFilasActualizadas!=1) return -1;
    } catch (SQLException sql) {
      System.out.println("Se produjo un error creando Statement");
      System.out.println(sql.getMessage());
      return -2;
    } 
     return 0;
  } // fin método actualizarBaseDeDatos()

  public void devolverPaginaHTML(HttpServletResponse resp) {
    // Se obtiene un PrintWriter donde escribir (sólo para mandar texto)
    PrintWriter out=null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");
      System.out.println(io.getMessage());
    }

    // Se establece el tipo de contenido MIME de la respuesta
    resp.setContentType("text/html");

    // Se mandan los valores
    out.println("<html>");
    out.println("<head>");
    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
    out.println("<title>Valores recogidos en el formulario</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<b><font size=+2>Valores recogidos del");
    out.println("formulario: </font></b>");
    out.println("<p><font size=+1><b>Nombre: </b>"+nombre+"</font>");
    out.println("<br><fontsize=+1><b>Apellido : </b>"+apellidos+"</font><b><font size=+1></font></b>");
    out.println("<p><font size=+1><b>Opini&oacute;n: "+"</b><i>"+opinion+"</i></font>");
    out.println("<br><font size=+1><b>Comentarios: </b>"+comentarios+"</font>");
    out.println("<P><HR><CENTER><H2>Valores actualizados con éxito</CENTER>");
    out.println("</body>");
    out.println("</html>");

    // Se fuerza la descarga del buffer y se cierra el PrintWriter
    out.flush();
    out.close();
  } // fin de devolverPaginaHTML()
} // fin de la clase servletOpinion2

