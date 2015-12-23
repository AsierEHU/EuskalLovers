/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Visita;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Adrián
 */
public class VisitaDAO {
    
    private final Connection cn;

    public VisitaDAO(Connection cn) {
        this.cn = cn;
    }
    public boolean haVisitado (String nickV) throws SQLException {
        boolean visitado = false;
        Statement st= cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Visita where nick2 =" + nickV + "'");
        if(rs.next()){
            visitado = true;
        }       
        return visitado;  
    }
    public Iterator<String> recuperarVisitas (String nickV) throws SQLException {
        ArrayList<String> visitas = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Visita where nick1 = " + nickV);
        while (rs.next()) {
            visitas.add(rs.getString("nick2"));
        }       
        return visitas.iterator();
    }
    
    public boolean insertarVisita(Visita v) throws SQLException {
        Statement st= cn.createStatement();
        int total = st.executeUpdate("insert into Visita values('"+v.getNick1()+"','"+v.getNick2()+"')");       
        return 0 != total;
    }
    
    public boolean eliminarVisita (Visita v)throws SQLException {
       Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Visita where nick1='" + v.getNick1()+"'"); 
        return total != 0;  
    }   
}
