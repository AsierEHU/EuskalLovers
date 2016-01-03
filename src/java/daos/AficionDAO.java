/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Aficion;
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
public class AficionDAO {

    private final Connection cn;

    public AficionDAO(Connection cn) {
        this.cn = cn;
    }

    public boolean insertarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("insert into Aficion(Nick,Nombre)values('"+a.getNick()+ "','" +a.getNombre()+"')");
        return 0 != total;
    }

    public boolean eliminarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Aficion where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + "'");
        return total != 0;
    }

    public boolean cambiarAficion(Aficion a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Aficion set Nombre='" + a.getNombre() + "' where Nick='" + a.getNick() + "' AND Nombre='" + a.getNombre() + "'");
        return total != 0;
    }
    
    public ArrayList<String> cogerAficiones(String nick) throws SQLException {
        ArrayList<String> personalidades = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Aficion where Nick='"+nick+"'");
        while(rs.next()){
            personalidades.add(rs.getString("Nombre"));
        }
        return personalidades;
    }
    
    public boolean estaAficion(String nombre,String usuario)throws SQLException{
        boolean esta=false;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Aficion where Nick='"+usuario+"'and Nombre='"+nombre+"'");
        if(rs.next()){
            esta=true;
        }
        return esta;
    }
    public boolean eliminarAficiones(String nick) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Aficion where Nick='"+nick+"'");
        return total != 0;
    }
    
    public int numAficionesComun(String nicka, String nickb) throws SQLException{
        int result = 0;
        for(String c: cogerAficiones(nicka)){
            for(String a: cogerAficiones(nickb)){
                if(c.equals(a)){
                    result ++;
                }
            }
        }
        return result;
    }
    
}
