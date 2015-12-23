/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Time;

/**
 *
 * @author Asier
 */
public class Premium {
    private String nick;
    private long cuentaTajeta;
    private int saldo;
    private Time fechaHora;
    private int pack;
    
    public Premium(String nick, long cuentaTarjeta, int saldo, Time fechaHora, int pack){
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

    public long getCuentaTajeta() {
        return cuentaTajeta;
    }

    public void setCuentaTajeta(long cuentaTajeta) {
        this.cuentaTajeta = cuentaTajeta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Time getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Time fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
