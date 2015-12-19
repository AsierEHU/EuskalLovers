/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;

/**
 *
 * @author Asier
 */
public class BD {

    // Referencia a un objeto de la interface java.sql.Connection 
    private static Connection conn;

    public static Connection getConexion() {
        if (conn == null) {
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                // Establecimiento de la conexión con la base de datos
                conn = DriverManager.getConnection("jdbc:odbc:euskallovers");
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return conn;
    }

    // Este método es llamado por el servidor web al "apagarse" (shut down).
    // Sirve para proporcionar una correcta desconexión de una base de datos, 
    // cerrar ficheros abiertos, etc.
    public static void destroy() {
        System.out.println("Cerrando conexion...");
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexion");
            System.out.println(ex.getMessage());
        }
    } // fin del método destroy()

}
