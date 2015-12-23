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
public class Usuario {

    private String nick;
    private String email;
    private String contraseña;
    private boolean genero;
    private int edad;
    private double altura;
    private double peso;
    private String constitucion;
    private String ciudad;
    private int cp;
    private String foto;

    public Usuario() {

    }
    // Completo

    public Usuario(String nick, String email, String contraseña, boolean genero, int edad, double altura, double peso, String constitucion, String ciudad, int cp, String foto) {
        super();
        this.nick = nick;
        this.email = email;
        this.contraseña = contraseña;
        this.genero = genero;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.constitucion = constitucion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.foto = foto;
    }
    //Obligatorios

    public Usuario(String nick, String email, String contraseña, boolean genero, String constitucion, String ciudad, int cp, String foto) {
        super();
        this.nick = nick;
        this.email = email;
        this.contraseña = contraseña;
        this.genero = genero;
        this.constitucion = constitucion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.foto = foto;
    }

    //Email, nick y contraseña
    public Usuario(String email, String contraseña, String nick) {
        this.email = email;
        this.contraseña = contraseña;
        this.nick = nick;
    }
    
    //Email y contraseña
    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public double getAltura() {
        return altura;
    }

    public String getConstitucion() {
        return constitucion;
    }

    public int getEdad() {
        return edad;
    }

    public int getCp() {
        return cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEmail() {
        return email;
    }

    public String getFoto() {
        return foto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNick() {
        return nick;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isFemenino() {
        return genero;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setConstitucion(String constitucion) {
        this.constitucion = constitucion;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

}
