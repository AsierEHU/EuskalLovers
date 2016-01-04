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

public class InteresDAO {
    
    private final Connection cn;

    public InteresDAO(Connection cn) {
        this.cn = cn;
    }
    
    public Interes recuperarInteres(String nick) throws SQLException {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Interes where nick ='"+nick+"'");
        if (rs.next()) {
            return new Interes(nick, rs.getBoolean("genero"), rs.getInt("Edad"), rs.getFloat("altura"), rs.getInt("peso"), rs.getString("constitucion"), rs.getString("ciudad"), rs.getString("cp"));
        }
        return null;
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
    
    public float getAlturaInteres(String nick)throws SQLException{
        float res = 0.0f;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select Altura from Interes where nick ='"+nick+"'");
        if(rs.next()){
            res = rs.getFloat("Altura");
        }
        return res;
    }
    
    public boolean insertarInteresBasico(Interes a)throws SQLException{
        Statement st = cn.createStatement();
        int fem =1;
         if(a.isGenero()==false){
             fem=0;
         }
         int res = st.executeUpdate("insert into Interes(Nick,Genero,Edad,Constitucion,Ciudad) values ('" + a.getNick() + "','" + fem + "','" + a.getEdad() +"','"+ a.getConstitucion() +"','"+ a.getCiudad()+"')");
         return res!=0;
    }
    
    public boolean insertarInteres(Interes a) throws SQLException{
         Statement st = cn.createStatement();
         int fem =1;
         if(a.isGenero()==false){
             fem=0;
         }
         int res = st.executeUpdate("insert into Interes(Nick,Genero,Edad,CP,Peso,Altura,Constitucion,Ciudad) values ('" + a.getNick() + "','" + fem + "','" + a.getEdad() + "','" + a.getCp() + "','" +  a.getPeso() + "','" + a.getAltura() + "','" + a.getConstitucion() + "','"+a.getCiudad()+"')");
         return res!=0;
     }
          
//     public boolean insertarInteresUsuario(Usuario u, Interes a) throws SQLException{
//         Statement st = cn.createStatement();
//         int res = st.executeUpdate("insert into Interes(Genero,Edad,Cp,Peso,Altura,,Ciudad) values (" + a.isGenero() + "','" + a.getEdad() + "','" + a.getCp() + "','" +  a.getPeso() + "','" + a.getAltura() + "','" + a.getConstitucion() + "','"+ a.getCiudad()+"') where Interes.Nick = '" + u.getNick() + "'");
//         return res !=0;
//     }
     
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
     
//     public ArrayList<String> buscarUsuariosBasico(Interes a)throws SQLException{
//        ArrayList<String> usuariosBuscados = new ArrayList<>();
//        Statement st = cn.createStatement();
//        ResultSet rs = st.executeQuery("select nick from usuario where genero='"+a.isGenero()+"' and edad='"+a.getEdad()+"' and ciudad='"+a.getCiudad()+"' and constitucion='"+a.getConstitucion()+"'");
//        while (rs.next()) {
//            usuariosBuscados.add(rs.getString("Nick"));
//        }
//        return usuariosBuscados;
//    }
     
     public ArrayList<String> buscarUsuariosConcreto(Interes a)throws SQLException{
        ArrayList<String> usuariosBuscados = new ArrayList<>();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select nick from usuario where genero="+a.isGenero()+" or edad="+a.getEdad()+" or altura="+a.getAltura()+" or peso="+a.getPeso()+" or ciudad='"+a.getCiudad()+"' or cp='"+a.getCp()+"' or constitucion='"+a.getConstitucion()+"'");
        while (rs.next()) {
            usuariosBuscados.add(rs.getString("Nick"));
        }
        return usuariosBuscados;
    }
}
    
