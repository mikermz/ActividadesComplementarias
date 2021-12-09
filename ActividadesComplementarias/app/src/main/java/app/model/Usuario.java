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
public class Usuario {

    private String nombreUsuario;
    private String contra;
    private String tipoUsuario;
    private long clave;

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public Usuario() {
    }

    public Usuario(long clave,String nombreUsuario, String contra, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contra = contra;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }


}
