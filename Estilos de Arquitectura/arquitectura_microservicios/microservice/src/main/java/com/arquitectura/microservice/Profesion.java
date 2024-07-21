package com.arquitectura.microservice;

public enum Profesion {

    INGENIERO(new String[]{"Sistemas", "Electronica", "Mecatronica"}), CONTADOR (new String[]{"Publico", "Gestion", "Impuesto"});

    private String[] tipo; 

    Profesion (String[] tipo){
        this.tipo = tipo;
    }

    public String [] getTipo() {
        return tipo;
    }

    

}
