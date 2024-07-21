import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.tuberias.ProcesadorTexto;

public class Main {
    public static void main(String[] args) {

        ProcesadorTexto procesadorTexto = new ProcesadorTexto(JOptionPane.showInputDialog(null, "Ingrese un texto"));

        ArrayList<String> palabras = palabras(procesadorTexto.getTexto());

        palabras.forEach(pa -> {
            System.out.println(pa);
        });

        procesadorTexto.eliminar_palabras(palabras);


    }

    public  static ArrayList<String> palabras(String texto) {
        JOptionPane.showMessageDialog(null, "Su texto actual es\n" + texto);
        ArrayList<String> palabras = new ArrayList<>();
        String canPalabras = JOptionPane.showInputDialog("Cantidad de palabras a eliminar");
        try {
            int numero = ((canPalabras.equals(""))?0:Integer.parseInt(canPalabras));
            if (numero == 0) {
                JOptionPane.showMessageDialog(null, "El numero debe ser mayor de cero");
            } else {
                palabras = new ArrayList<>();
                for (int i = 0; i < numero; i++) {
                    palabras.add(JOptionPane.showInputDialog(null, String.format("Ingrese %d palabra", i + 1)));

                }

            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error formato numero -> " + e.getMessage());
        }

        return palabras;
    }
}
