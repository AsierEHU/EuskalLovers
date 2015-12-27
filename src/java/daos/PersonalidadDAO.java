/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Personalidad;
import beans.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Asier
 */
public class PersonalidadDAO {

    private final Connection cn;

    public PersonalidadDAO(Connection cn) {
        this.cn = cn;
    }

    public boolean insertarPersonalidad(Personalidad a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Personalidad(Nick,Nombre)values('"+a.getNick()+"','"+a.getNombre()+"')");
        return 0 != total;
    }

    public boolean eliminarPersonalidad(Personalidad a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Personalidad where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + "'");
        return total != 0;
    }

    public boolean eliminarPersonalidades(String nick) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Personalidad where Nick='"+nick+"'");
        return total != 0;
    }

    public boolean cambiarPersonalidad(Personalidad a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Personalidad set Nombre='" + a.getNombre() + "' where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + "'");
        return total != 0;
    }

    public Iterator<Personalidad> cogerPersonalidades() throws SQLException {
        ArrayList<Personalidad> personalidades = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Personalidad");
        while (rs.next()) {
            personalidades.add(new Personalidad(rs.getString("Nick"), rs.getString("Nombre")));
        }
        return personalidades.iterator();
    }

    public boolean estaPersonalidad(String nombre, String usuario) throws SQLException {
        boolean esta = false;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Personalidad where Nick='"+usuario+"'and Nombre='"+nombre+"'");
        if (rs.next()) {
            esta = true;
        }
        return esta;
    }

}
