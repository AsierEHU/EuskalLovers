/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Aficion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Asier
 */
public class AficionDAO {

    private final Connection cn;

    public AficionDAO(Connection cn) {
        this.cn = cn;
    }

    public boolean insertarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Aficion(Nick,Nombre)values('" + a.getNick() + "','" + a.getNombre() + "')");
        return 0 != total;
    }

    public boolean eliminarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Aficion where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + '"');
        return total != 0;
    }

    public boolean cambiarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Aficion set Nombre='" + a.getNombre() + "' where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + '"');
        return total != 0;
    }
}
