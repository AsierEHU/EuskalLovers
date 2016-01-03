/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Asier
 */
public class Premium {
    private String nick;
    private String cuentaTajeta;
    private int saldo;
    private Date fechaHora;
    private int pack;
    
    public Premium(String nick, String cuentaTarjeta, int saldo, Date fechaHora, int pack){
        this.nick = nick;
        this.cuentaTajeta = cuentaTarjeta;
        this.saldo = saldo;
        this.fechaHora = fechaHora;
        this.pack = pack;
    }
    
    public int getPack(){
        return pack;
    }
    
    public void setPack(int pack){
        this.pack = pack;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCuentaTajeta() {
        return cuentaTajeta;
    }

    public void setCuentaTajeta(String cuentaTajeta) {
        this.cuentaTajeta = cuentaTajeta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
