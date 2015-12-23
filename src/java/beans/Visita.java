/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Asier
 */
public class Visita {
     private String nick1;
     private String nick2;
     
     public Visita(String n1,String n2){
         this.nick1 = n1;
         this.nick2 = n2;
     }

    public String getNick1() {
        return nick1;
    }

    public String getNick2() {
        return nick2;
    }

    public void setNick1(String nick1) {
        this.nick1 = nick1;
    }

    public void setNick2(String nick2) {
        this.nick2 = nick2;
    } 
}
