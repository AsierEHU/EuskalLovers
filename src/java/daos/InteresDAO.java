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
import beans.Usuario;
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
        ResultSet rs = st.executeQuery("select * from Interes where nick ='"+nick+"'");
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
    
    public int getEdadInteres(String nick)throws SQLException{
        int res = 0;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Edad from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getInt("Edad");
        }
        return res;
    }
    
    public String getCiudadInteres(String nick)throws SQLException{
        String res="";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Ciudad from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getString("Ciudad");
        }
        return res;
    }
    
    public String getCPInteres(String nick)throws SQLException{
        String res="";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select CP from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getString("CP");
        }
        return res;
    }
    
    public String getConstitucionInteres(String nick)throws SQLException{
        String res="";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Constitucion from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getString("Constitucion");
        }
        return res;
    }
    
    public String getGeneroInteres(String nick)throws SQLException{
        String res="Femenino";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select genero from Interes where nick ='"+nick+"'");
        if(rs.next()){
            if(rs.getBoolean("Genero")){
                res="Masculino";
            }
        }
        return res;
    }
    
    public int getPesoInteres(String nick)throws SQLException{
        int res = 0;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Peso from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getInt("Peso");
        }
        return res;
    }
    
    public double getAlturaInteres(String nick)throws SQLException{
        double res = 0.0;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Altura from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getDouble("Altura");
        }
        return res;
    }
    
    public boolean insertarInteresBasico(Interes a)throws SQLException{
        Statement st = cn.createStatement();
        int fem =0;
         if(a.isGenero()==false){
             fem=1;
         }
         int res = st.executeUpdate("insert into Interes(Nick,Genero,Edad,Constitucion,Ciudad) values ('" + a.getNick() + "','" + fem + "','" + a.getEdad() +"','"+ a.getConstitucion() +"','"+ a.getCiudad()+"')");
         return res!=0;
    }
    
    public boolean insertarInteres(Interes a) throws SQLException{
         Statement st = cn.createStatement();
         int fem =0;
         if(a.isGenero()==false){
             fem=1;
         }
         int res = st.executeUpdate("insert into Interes(Nick,Genero,Edad,CP,Peso,Altura,Constitucion,Ciudad) values ('" + a.getNick() + "','" + fem + "','" + a.getEdad() + "','" + a.getCp() + "','" +  a.getPeso() + "','" + a.getAltura() + "','" + a.getConstitucion() + "','"+a.getCiudad()+"')");
         return res!=0;
     }
          
     public boolean insertarInteresUsuario(Usuario u, Interes a) throws SQLException{
         Statement st = cn.createStatement();
         int res = st.executeUpdate("insert into Interes(Genero,Edad,Cp,Peso,Altura,,Ciudad) values (" + a.isGenero() + "','" + a.getEdad() + "','" + a.getCp() + "','" +  a.getPeso() + "','" + a.getAltura() + "','" + a.getConstitucion() + "','"+ a.getCiudad()+"') where Interes.Nick = '" + u.getNick() + "'");
         return res !=0;
     }
     
     public boolean cambiarInteres(Interes a) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Interes set Genero="+a.isGenero()+",Edad="+a.getEdad()+",Cp='"+a.getCp()+"', Peso=" +a.getPeso()+", Altura=" +a.getAltura()+", Constitucion='"+a.getConstitucion()+"' where Interes.Nick = '"+a.getNick()+"'");
        return total != 0;
    }
     
     public boolean actualizarAlturaBusqueda(Interes a)throws SQLException{
         Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Interes set Altura='"+ a.getAltura()+"' where Interes.Nick = '"+a.getNick()+"'");
        return total != 0;
     }
     
     public boolean actualizarPesoBusqueda(Interes a)throws SQLException{
         Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Interes set Peso='"+ a.getPeso()+"' where Interes.Nick = '"+a.getNick()+"'");
        return total != 0;
     }
     
     public boolean actualizarCPBusqueda(Interes a)throws SQLException{
         Statement st = cn.createStatement();
        int total = st.executeUpdate("Update Interes set CP='"+ a.getCp()+"' where Interes.Nick = '"+a.getNick()+"'");
        return total != 0;
     }
}

//
