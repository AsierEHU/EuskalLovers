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

import beans.Interes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class InteresDAO {
    private final Connection cn;

    public InteresDAO(Connection cn) {
        this.cn = cn;
    }
    
     public Iterator<String> recuperarIntereses(String nick) throws SQLException {
        ArrayList<String> intereses = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Interes where nick = " + nick);
        while (rs.next()) {
            if(rs.getString("ciudad")!=null){
            intereses.add(rs.getString("email"));
            }
            if(!rs.getBoolean("genero")){
            intereses.add("Femenino");
            } else{ intereses.add("Masculino");}
            
            intereses.add(rs.getString("email").toString());
            intereses.add(rs.getString("constitucion"));
            intereses.add(((Integer)rs.getInt("Edad")).toString());
            
            if((Integer)rs.getInt("cp") != null){
              Integer codigo = rs.getInt("cp");
                intereses.add(codigo.toString());
            }
            if(rs.getString("ciudad")!=null){
            intereses.add(rs.getString("email"));
            }
            
            if((Double)rs.getDouble("altura")!=null){
                intereses.add(((Double)rs.getDouble("altura")).toString());
            }
            if((Double)rs.getDouble("peso")!=null){
                intereses.add(((Double)rs.getDouble("peso")).toString());
            }
        }
        return intereses.iterator();
    }
     public boolean insertarInteres(Interes a) throws SQLException{
         Statement st = cn.createStatement();
         int res = st.executeUpdate("insert into Interes(Nick,Genero,Edad,CP,Peso,Altura,Constitucion) values ('" + a.getNick() + "','" + a.isGenero() + "','" + a.getEdad() + "','" + a.getCp() + "','" +  a.getPeso() + "','" + a.getAltura() + "','" + a.getConstitucion() + "'");
         return res!=0;
     }
}
