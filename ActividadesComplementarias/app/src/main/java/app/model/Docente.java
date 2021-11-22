/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author jaime.infante
 */
public class Docente {

    private int claveDocente;
    private String nombre;
    private String claveUsuario;

    public Docente() {
    }

    public Docente(int claveDocente, String nombre, String claveUsuario) {
        this.claveDocente = claveDocente;
        this.nombre = nombre;
        this.claveUsuario = claveUsuario;
    }

    public Docente(int claveDocente, String nombre) {
        this.claveDocente = claveDocente;
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Docente{" + "claveDocente=" + claveDocente + ", nombre=" + nombre + ", claveUsuario=" + claveUsuario + '}';
    }


    public int getClaveDocente() {
        return claveDocente;
    }

    public void setClaveDocente(int claveDocente) {
        this.claveDocente = claveDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }


}
