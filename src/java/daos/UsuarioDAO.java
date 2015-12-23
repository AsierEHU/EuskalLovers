/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author Asier
 */
import beans.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioDAO {

    private final Connection cn;

    public UsuarioDAO(Connection cn) {
        this.cn = cn;
    }

    public boolean esCorrecto(String email, String pass) throws SQLException {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Usuario where Email='" + email + "' and Password='" + pass + "'");
        return rs.next();
    }

    public Iterator<Usuario> recuperarUsuarios() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Usuario");
        while (rs.next()) {
            usuarios.add(new Usuario(rs.getString("Email"), rs.getString("Password"), rs.getString("Nick")));
        }
        return usuarios.iterator();
    }

    public Usuario cogerUsuario(String email) throws SQLException {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Usuario where Email='" + email + "'");
        if (rs.next()) {
            return new Usuario(rs.getString("Nick"), rs.getString("Email"), rs.getString("Password"),rs.getBoolean("Genero"), rs.getInt("Edad"),rs.getDouble("Altura"),rs.getDouble("Peso"),rs.getString("Constitucion"),rs.getString("Ciudad"),rs.getString("CP"),rs.getString("Foto"));
        }
        return null;
    }

    public boolean insertarUsuario(Usuario a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Usuario (Email, Password, Nick) values ('" + a.getEmail() + "','" + a.getContraseña()+ "','" +a.getNick()+"')");
        return total != 0;
    }

    public boolean eliminarUsuario(String email) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Usuario where Email='" + email+ "')");
        return total != 0;
    }
}
