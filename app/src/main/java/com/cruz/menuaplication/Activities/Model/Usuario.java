package com.cruz.menuaplication.Activities.Model;

/**
 * Created by FERNANDO on 27/09/2017.
 */

public class Usuario {
    private String user;
    private String pass;
    private String nombre;
    private String rol;

    public Usuario(){

    }

    public Usuario(String user, String pass, String nombre, String rol) {
        this.user = user;
        this.pass = pass;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
