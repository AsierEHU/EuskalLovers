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
    private final HashMap<String, ListaMensajes> mailInterno;

    private MessageControl() {
        mailInterno = new HashMap<>();
    }

    public static MessageControl getMessageControl() {
        if (messageControl == null) {
            messageControl = new MessageControl();
        }
        return messageControl;
    }

    public void addMensaje(Mensaje men) {
        ListaMensajes lm = mailInterno.get(men.getSender());
        if (lm == null) {
            lm = new ListaMensajes();
            mailInterno.put(men.getSender(), lm);
        }
        lm.addMensaje(men);
    }

    public Iterator<Mensaje> getMensajes(String usuario) {
        ListaMensajes lm = mailInterno.get(usuario);
        if (lm == null) {
            lm = new ListaMensajes();
            mailInterno.put(usuario, lm);
        }
        return lm.getMensajes();
    }

    public int getNumeroMensajes(String usuario) {
        ListaMensajes lm = mailInterno.get(usuario);
        if (lm == null) {
            lm = new ListaMensajes();
            mailInterno.put(usuario, lm);
        }
        return lm.getNumeroMensajes();
    }
}
