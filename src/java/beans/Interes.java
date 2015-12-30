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
public class Interes {

    private String nick;
    private boolean genero;
    private int edad;
    private double altura;
    private double peso;
    private String constitucion;
    private String ciudad;
    private String cp;

    // todos
    public Interes(String nick, boolean genero, int edad, double altura, double peso, String constitucion, String ciudad, String cp) {
        super();
        this.nick = nick;
        this.genero = genero;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.constitucion = constitucion;
        this.ciudad = ciudad;
        this.cp = cp;
    }

    // minimos

    public Interes(String nick, boolean genero, int edad, String constitucion, String ciudad) {
        super();
        this.nick = nick;
        this.edad = edad;
        this.genero = genero;
        this.constitucion = constitucion;
        this.ciudad=ciudad;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public boolean isGenero() {
        return !genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(String constitucion) {
        this.constitucion = constitucion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

}
