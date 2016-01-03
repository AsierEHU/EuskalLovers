/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import beans.Premium;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Asier
 */
public class PremiumDAO {

    private final Connection cn;

    public PremiumDAO(Connection cn) {
        this.cn = cn;
    }

    public boolean esPremium(String pNick) throws SQLException {
        boolean prem = false;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from Premium where Nick='" + pNick + "'");
        if (rs.next()) {
            prem = true;
        }
        return prem;
    }

    public boolean hacerPremium(Premium p) throws SQLException {
        Statement st = cn.createStatement();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(p.getFechaHora());
        int total = st.executeUpdate("insert into Premium(Nick,CuentaTarjeta,Saldo,FechaHora,Pack) values ('"+p.getNick()+"','" + p.getCuentaTajeta() + "'," + p.getSaldo()+ ",'" + currentTime + "'," +  p.getPack()+ ")");
        return total!=0;
    }
    
    public boolean darBajaPremium(String nk) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Premium where Nick='" + nk + "'");
        return total != 0;
    }
    
    public long tiempoPremium(String nk,int pk)throws SQLException{
        long tiempo = 0;
        Calendar hoy = Calendar.getInstance();
        hoy.add(Calendar.DATE, -pk);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setCalendar(hoy);
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("Select FechaHora from Premium where Nick='"+nk+"'");
        if(rs.next()){
        SimpleDateFormat rgf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rgf.format(rs.getDate("FechaHora"));
        tiempo = (sdf.getCalendar().getTimeInMillis() - rgf.getCalendar().getTimeInMillis());
        }
        return tiempo;        
    }
    
    public int getPack(String nk)throws SQLException{
        int pck = 0;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("Select Pack from Premium where nick='"+nk+"'");
        if(rs.next()){
            pck = rs.getInt("Pack");
        }
        return pck;
    }
    
    public boolean actualizarSaldo(int cantidad, String nick) throws SQLException{
        Statement st = cn.createStatement();
        int total = st.executeUpdate("update Premium set saldo=saldo-" +cantidad+"where nick ='"+nick+"'");
        return total != 0;
    }
    
}
