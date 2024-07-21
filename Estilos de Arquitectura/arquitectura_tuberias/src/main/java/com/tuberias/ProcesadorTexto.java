package com.tuberias;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ProcesadorTexto {

    private String texto;

    public ProcesadorTexto(String texto) {
        this.texto = this.convertir_minusculas(texto);
        this.eliminar_espacios(this.texto);

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    private String eliminar_espacios(String texto) {
        String sinEspacios = texto.replaceAll("\\s{2,}", " ");
        this.setTexto(sinEspacios);
        return this.getTexto();
    }

    private String convertir_minusculas(String texto) {
        this.setTexto(texto.toLowerCase());
        return this.getTexto();
    }

    public void eliminar_palabras(ArrayList<String> palabras) {


            palabras.forEach(palabra -> {
                Pattern pattern = Pattern.compile(palabra);
                Matcher matcher = pattern.matcher(this.getTexto());
                if (matcher.find() || !palabra.equals(" ")) {
                    this.setTexto(this.texto.replaceAll(palabra, ""));
                }

            });
        JOptionPane.showMessageDialog(null, "Su nuevo texto es \n" + this.getTexto());
    }

    @Override
    public String toString() {
        return this.getTexto();
    }
}
