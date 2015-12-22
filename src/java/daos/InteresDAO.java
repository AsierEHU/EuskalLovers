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
            }
            intereses.add(rs.getString("email").toString());
            intereses.add(rs.getString("constitucion"));
            
            if((Integer)rs.getInt("cp") != null){
              Integer codigo = rs.getInt("cp");
                intereses.add(codigo.toString());
            }
            if(rs.getString("ciudad")!=null){
            intereses.add(rs.getString("email"));
            }
        }
        return intereses.iterator();
    }
}
