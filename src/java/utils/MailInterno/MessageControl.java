/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.MailInterno;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author docencia
 */
public class MessageControl {

    private static MessageControl messageControl;
    private final HashMap<String, ListaMensajes> mensajesOutput;
    private final HashMap<String, ListaMensajes> mensajesInput;

    private MessageControl() {
        mensajesOutput = new HashMap<>();
        mensajesInput = new HashMap<>();
    }

    public static MessageControl getMessageControl() {
        if (messageControl == null) {
            messageControl = new MessageControl();
        }
        return messageControl;
    }

    public void addMensaje(Mensaje men) {
        ListaMensajes lmo = mensajesOutput.get(men.getSender());
        if (lmo == null) {
            lmo = new ListaMensajes();
            mensajesOutput.put(men.getSender(), lmo);
        }
        lmo.addMensaje(men);
        
        ListaMensajes lmi = mensajesInput.get(men.getReciever());
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(men.getReciever(), lmi);
        }
        lmi.addMensaje(men);
    }

    public Iterator<Mensaje> getMensajesEnviados(String usuario) {
        ListaMensajes lmo = mensajesOutput.get(usuario);
        if (lmo == null) {
            lmo = new ListaMensajes();
            mensajesOutput.put(usuario, lmo);
        }
        return lmo.getMensajes();
    }
    
    public Iterator<Mensaje> getMensajesRecibidos(String usuario) {
        ListaMensajes lmi = mensajesInput.get(usuario);
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(usuario, lmi);
        }
        return lmi.getMensajes();
    }

    public int getNumeroMensajesRecibidos(String usuario) {
        ListaMensajes lmi = mensajesInput.get(usuario);
        if (lmi == null) {
            lmi = new ListaMensajes();
            mensajesInput.put(usuario, lmi);
        }
        return lmi.getNumeroMensajes();
    }
}
