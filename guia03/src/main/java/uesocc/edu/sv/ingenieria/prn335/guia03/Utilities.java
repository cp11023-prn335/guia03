package uesocc.edu.sv.ingenieria.prn335.guia03;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.enterprise.context.Dependent;

@LocalBean
@Dependent
public class Utilities implements Serializable {

    /**
     * Este metodo devuelve el resumen de un texto, retornando las primera 20
     * letras
     *
     * @param texto recibe el texto a resumir
     * @return devuelve las primeras 20 letras el texto
     */
    public String getResume(String texto) {

        String cadena = "";
        int recorrido;
        if (texto != null) {
            if (texto.length() > 20) {
                for (recorrido = 0; recorrido < 20; recorrido++) {
                    cadena += String.valueOf(texto.charAt(recorrido));
                }
            } else {
                cadena = texto;
            }
        } else {
            cadena = null;
        }
        return cadena;
    }

    /**
     * Este metodo se encarga de eliminar los dobles espacios remplazandolo por
     * un solo espacio, ademas coloca inicial mayuscula a todas las palabras
     *
     * @param texto recibe el texto que va ser capitalizado
     * @return Retorna el texto sin dobles espacios y las palabras con inicial
     * mayuscula
     */
    public String capitalizar(String texto) {
        String cadena = "";
        if (texto != null) {
            if (texto.length() > 0) {
                for (int rec2 = 0; rec2 < texto.length(); rec2++) {
                    texto = texto.replaceAll("  ", " ");
                }
                if (texto.charAt(0) != ' ') {
                    cadena = String.valueOf(texto.charAt(0)).toUpperCase();
                }

                for (int rec = 1; rec < texto.length(); rec++) {
                    if (texto.charAt(rec - 1) == ' ' && texto.charAt(rec) != ' ') {
                        cadena += String.valueOf(texto.charAt(rec)).toUpperCase();
                    } else {
                        cadena += String.valueOf(texto.charAt(rec)).toLowerCase();
                    }

                }
            } else {
                cadena = "";
            }
        } else {
            cadena = null;
        }
        return cadena;
    }

    /**
     *
     * @param frase cadena de texto que contiene la frase a buscar
     * @param texto cadena de texto donde se buscaran las coincidencias
     * @return cantidad de coincidencias de la frase en el texto
     */
    public int contarCoincidencias(String frase, String texto) {
        int cantidad = 0, niv = 0;
        String busqueda;
        if(texto!=null){
        if (frase.length() < texto.length()) {
            for (int rec = frase.length(); rec <= texto.length(); rec++, niv++) {
                busqueda = "";
                for (int rec2 = 0 + niv; rec2 < frase.length() + niv; rec2++) {
                    busqueda += String.valueOf(texto.charAt(rec2));
                }
                if (frase.equalsIgnoreCase(busqueda)) {
                    cantidad++;
                }
            }

        } else {
            cantidad = 0;
        }
        }else{
            cantidad=0;
        }
        return cantidad;
    }

}
