package com.example.erick.proyecto.data;

/**
 * Created by erick on 16/11/16.
 */

public class Usuario {

    private String rfc;
    private String nombre;
    private String apellido;
    private String password;
    private String telefono;

    public Usuario(String rfc, String nombre, String apellido, String password, String telefono){
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.telefono = telefono;
    }

    public String getRfc(){
        return rfc;
    }

    public void setRfc(){
        this.rfc = rfc;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(){
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(){
        this.password = password;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(){
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "rfc='" + rfc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password +'\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
