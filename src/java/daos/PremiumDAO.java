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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
        int total = st.executeUpdate("insert into Premium(Nick,CuentaTarjeta,Saldo,FechaHora,Pack) values ('" + p.getNick() + "','" + p.getCuentaTajeta() + "'," + p.getSaldo() + ",'" + currentTime + "'," + p.getPack() + ")");
        return total != 0;
    }

    public boolean darBajaPremium(String nk) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("delete from Premium where Nick='" + nk + "'");
        return total != 0;
    }

    public long tiempoPremium(String nk) throws SQLException, ParseException {
        long tiempo = 0;
        long hoy = new Date().getTime();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("Select FechaHora from Premium where Nick='" + nk + "'");
        if (rs.next()) {
            long reg = rs.getDate("FechaHora").getTime();
            tiempo = hoy - reg;
            tiempo = (tiempo) / (1000 * 60 * 60 * 24);
        }
        return tiempo;
    }
    
    public long tiempoQuedaPremium(String nk) throws SQLException, ParseException{
        long tiempo = tiempoPremium(nk);
        int pack =getPack(nk);

        switch (pack) {
            case 1:
                tiempo=30-tiempo;
                break;
            case 2:
                tiempo=90-tiempo;
                break;
            case 3:
                tiempo=180-tiempo;
                break;
            default:
                break;
        }
            return tiempo;
    }

    public int getPack(String nk) throws SQLException {
        int pck = 0;
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("Select Pack from Premium where nick='" + nk + "'");
        if (rs.next()) {
            pck = rs.getInt("Pack");
        }
        return pck;
    }

    public boolean actualizarSaldo(int cantidad, String nick) throws SQLException {
        Statement st = cn.createStatement();
        int total = st.executeUpdate("update Premium set saldo=saldo-" + cantidad + " where nick ='" + nick + "'");
        return total != 0;
    }

}
