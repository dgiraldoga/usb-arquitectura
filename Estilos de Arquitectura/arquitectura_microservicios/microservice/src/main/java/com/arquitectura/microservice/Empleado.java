package com.arquitectura.microservice;


import java.util.ArrayList;

public class Empleado extends Persona{

    private String profesion;
    private static int contador;


    public Empleado (String nombre, String correo, int edad, String profesion) {
        super(++contador, nombre, correo, edad);
        this.profesion = profesion;
    }

    

    public String getProfesion() {
        return profesion;
    }



    @Override
    public ArrayList<Persona> personas_db(Persona persona) {
        ArrayList<Persona> listaPersonas =  new ArrayList<>();

        listaPersonas.add(persona);
        return listaPersonas;
    }

    @Override
    public String toString (){
        return "Empleado" + super.toString().concat("\n" + String.format("Profesion := %s", this.getProfesion()));
    }

    

}
