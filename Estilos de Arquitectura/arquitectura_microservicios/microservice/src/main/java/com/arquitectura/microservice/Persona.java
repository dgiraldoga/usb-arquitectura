package com.arquitectura.microservice;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Persona implements Serializable{

    private String nombre;
    private String correo;
    private int edad;
    private int identificacion;

    Persona (){
        
    }

    Persona(int identificacion, String nombre, String correo, int edad) {
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.identificacion = identificacion;
    }



    public abstract ArrayList<Persona> personas_db (Persona persona);

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }



    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", correo=" + correo + ", edad=" + edad + ", identificacion="
                + identificacion + "]";
    }

    
}
