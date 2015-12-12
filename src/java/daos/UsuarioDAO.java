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
import java.util.HashMap;

public class UsuarioDAO {   
private Connection cn;

   
    public UsuarioDAO(Connection cn){
            this.cn=cn;
}
    
    public boolean esCorrecto(String email, String pass) throws SQLException
    {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Usuario where Email='"+ email +"' and Contraseña='"+ pass +"'");
        if(rs.next())
        {
        	return true;
        }
        return false;
    }
    
    public HashMap<Integer, Usuario> recuperarUsuarios() throws SQLException
    {
        HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from usuarios");
        int id=0;
        while(rs.next())
        {
            usuarios.put(id, new Usuario(rs.getString("email"),rs.getString("contraseña")));
            id ++;
        }
        return usuarios;
    }
    
    public Usuario cogerUsuario(String email) throws SQLException
    {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from administradores where email="+ email);
        if(rs.next())
        {
            return new Usuario(rs.getString("email"),rs.getString("contraseña"));
        }
        return null;
    }
    
    public boolean insertarUsuario(Usuario a) throws SQLException
    {
        Statement st=cn.createStatement();
        int total=st.executeUpdate("insert into usuario (nombre, contraseña) values ('"+a.getEmail()+"','"+a.getContraseña());
    return total != 0;
    }
       
    public boolean eliminarUsuario(String email) throws SQLException
    {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from usuario where email=" + email);
    return total != 0; 
    }
}