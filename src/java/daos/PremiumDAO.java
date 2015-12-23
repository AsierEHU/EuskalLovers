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
        int total = st.executeUpdate("insert into Premium(Nick,CuentaTarjeta,Saldo,FechaHora,Pack) values ('" + p.getNick() + "','" + p.getCuentaTajeta() + "','" + p.getSaldo()+ "','" + p.getFechaHora() + "','" +  p.getPack()+ "')");
        return total!=0;
    }
}
