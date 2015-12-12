/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.*;
import java.sql.*;


/**
 *
 * @author Asier
 */
public class ConexionBD {
      // Referencia a un objeto de la interface java.sql.Connection 
  Connection conn = null;
    // dsn (Data Source Name) de la base de datos
    String dsn = "jdbc:ucanaccess://C:/Users/Asier/Documents/NetBeansProjects/EuskalLovers/web/WEB-INF/EuskalLovers.accdb";
    
    boolean conectar(){
    // Carga del Driver del puente JDBC-ODBC
    try {
        
      Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    } catch(ClassNotFoundException ex) {
      System.out.println("Error al cargar el driver");
      System.out.println(ex.getMessage());
    } 
    // Establecimiento de la conexión con la base de datos
    try {
      conn = DriverManager.getConnection(dsn);
      return true;
    } catch (SQLException sqlEx) {
      System.out.println("Se ha producido un error al" +
                         " establecer la conexión con: " + dsn);
      System.out.println(sqlEx.getMessage());
    } return false;

    }
  
  // Este método es llamado por el servidor web al "apagarse" (shut down).
  // Sirve para proporcionar una correcta desconexión de una base de datos, 
  // cerrar ficheros abiertos, etc.
  public void destroy () {
    System.out.println("Cerrando conexion...");
    try {
      conn.close();
    } catch(SQLException ex){
      System.out.println("No se pudo cerrar la conexion");
      System.out.println(ex.getMessage());
    }
  } // fin del método destroy()

}




 