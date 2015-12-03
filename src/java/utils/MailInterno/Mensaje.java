/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.MailInterno;

/**
 *
 * @author docencia
 */
public class Mensaje {
    private final String sender;
    private final String reciever;
    private final String mensaje;

    public Mensaje(String sender, String reciever, String mensaje) {
        this.sender = sender;
        this.reciever = reciever;
        this.mensaje = mensaje;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
}
