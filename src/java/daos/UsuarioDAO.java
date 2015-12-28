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
            return new Usuario(rs.getString("Nick"), rs.getString("Email"), rs.getString("Password"),rs.getBoolean("Genero"), rs.getInt("Edad"),rs.getFloat("Altura"),rs.getInt("Peso"),rs.getString("Constitucion"),rs.getString("Ciudad"),rs.getString("CP"),rs.getString("Foto"));
        }
        return null;
    }

    public boolean insertarUsuario(Usuario a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Usuario (Email, Password, Nick, Edad, Genero, Ciudad, Constitucion, CP, Foto) values ('" + a.getEmail() + "','" + a.getContraseña()+ "','" +a.getNick()+"',"+a.getEdad()+","+a.isFemenino()+",'"+a.getCiudad()+"','"+a.getConstitucion()+"','"+a.getCp()+"','"+a.getFoto()+"')");
        return total != 0;
    }
    
    public boolean insertarUsuarioCompleto(Usuario a) throws SQLException{
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Usuario (Email, Password, Nick, Edad, Altura, Peso, Genero, Ciudad, Constitucion, CP, Foto) values ('" + a.getEmail() + "','" + a.getContraseña()+ "','" +a.getNick()+"',"+a.getEdad()+","+a.getAltura()+","+a.getPeso()+","+a.isFemenino()+",'"+a.getCiudad()+"','"+a.getConstitucion()+"','"+a.getCp()+"','"+a.getFoto()+"')");
        return total != 0;
    }

    public boolean eliminarUsuario(String email) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Usuario where Email='"+email+'"');
        return total != 0;
    }
    
    public boolean modificarUsuario(Usuario u)throws SQLException{
        Statement st = cn.createStatement();
        int total = st.executeUpdate("update Usuario set Nick='"+u.getNick()+"',Password='"+u.getContraseña()+"',Genero="+u.isFemenino()+",Edad="+u.getEdad()+",Altura="+u.getAltura()+",Peso="+u.getPeso()+",Constitucion='"+u.getConstitucion()+"',Ciudad='"+u.getCiudad()+"',CP='"+u.getCp()+"'where nick ='"+u.getNick()+"'");
        return total!=0;
    }
    
    public boolean actualizarAltura(Usuario u)throws SQLException{
        Statement st = cn.createStatement();
        int total = st.executeUpdate("update Usuario set altura='"+u.getAltura()+"' where nick='"+u.getNick()+"')");
        return total!=0;       
    }
    public boolean actualizarPeso(Usuario u)throws SQLException{
        Statement st = cn.createStatement();
        int total = st.executeUpdate("update Usuario set peso='"+u.getPeso()+"' where nick='"+u.getNick()+"')");
        return total!=0;       
    }
}
