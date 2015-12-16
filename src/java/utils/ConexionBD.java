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
public class ConexionBD {

    private static ConexionBD conexionBD;
    // Referencia a un objeto de la interface java.sql.Connection 
    private Connection conn;
    // dsn (Data Source Name) de la base de datos
    private static final String dsn = "jdbc:ucanaccess://C:/EuskalLovers.accdb";

    private ConexionBD() throws ClassNotFoundException, SQLException {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        // Establecimiento de la conexión con la base de datos
        conn = DriverManager.getConnection(dsn);

    }

    public static ConexionBD getConexionBD() {
        if (conexionBD == null) {
            try {
                conexionBD = new ConexionBD();
            } catch (ClassNotFoundException | SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return conexionBD;
    }
    
    public Connection getConnection(){
        return conn;
    }

    // Este método es llamado por el servidor web al "apagarse" (shut down).
    // Sirve para proporcionar una correcta desconexión de una base de datos, 
    // cerrar ficheros abiertos, etc.
    public void destroy() {
        System.out.println("Cerrando conexion...");
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo cerrar la conexion");
            System.out.println(ex.getMessage());
        }
    } // fin del método destroy()

}
