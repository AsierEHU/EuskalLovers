/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.MailInterno;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author docencia
 */
public class ListaMensajes {
    
    private final ArrayList<Mensaje> mensajes;
    
    public ListaMensajes(){
        mensajes = new ArrayList<>();
    }
    
    public void addMensaje(Mensaje men){
        mensajes.add(men);
    }
    
    public Iterator<Mensaje> getMensajes(){
        return mensajes.iterator();
    }
      
    
}
