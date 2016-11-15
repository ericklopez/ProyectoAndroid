package com.example.erick.proyecto.data;

import java.util.UUID;

/**
 * Created by erick on 15/11/16.
 */

public class Pan {
    private String id;
    private String nombre;
    private String descripcion;
    private int precio;

    public Pan(String id, String nombre, String descripcion, int precio){
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getPrecio(){
        return precio;
    }

}
