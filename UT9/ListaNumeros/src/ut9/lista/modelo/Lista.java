
package ut9.lista.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Representa una lista de enteros
 */
public class Lista {

    private List<Integer> lista;

    /**
     * Constructor
     */
    public Lista() {

        lista = new ArrayList<>();

    }

    /**
     * A�adir un n� a la lista en la posici�n adecuada. Utiliza el m�todo
     * privado buscarPosicion()
     */

    public void addNumero(int n) {

        int pos = buscarPosicion(n);
        lista.add(pos, n);

    }

    /**
     * Dado un n� devuelve la posici�n de la lista en la que hay que insertarlo
     */
    private int buscarPosicion(int n) {

        int i = lista.size() - 1;
        while (i >= 0 && lista.get(i) > n) {
            i--;
        }
        return i + 1;
    }

    /**
     * Borra de la lista todos los elementos repetidos
     */
    public void borrarRepetidos() {

        Set<Integer> tmp = new TreeSet<>(lista);
        lista.clear();
        lista.addAll(tmp);

    }

    /**
     * Borra un n? de la lista dada la posici�n
     */
    public void borrarDePosicion(int pos) {

        if (!estaVacia()) {
            if (pos >= 0 && pos < lista.size()) {
                lista.remove(pos);
            }
        }
    }

    /**
     * Detecta si est� o no la lista vac?a
     */
    public boolean estaVacia() {

        return lista.size() == 0;
    }

    /**
     * Cargar la lista desde un fichero numeros.txt. Cada l�nea del fichero
     * contiene un n� entero.
     * Propaga las posibles excepciones
     */
    public void cargarDeFichero()  throws  IOException {
//        try (Scanner entrada = new Scanner(
//                getClass().getResourceAsStream("/numeros.txt"));) {
//            // Scanner sc = new Scanner(new File("numeros.txt"));
//            while (entrada.hasNextInt()) {
//                addNumero(entrada.nextInt());
//            }
//
//        }

        try (Scanner entrada = new Scanner(new File("resources/numeros.txt"));) {
            while (entrada.hasNextInt()) {
                addNumero(entrada.nextInt());
            }

        }


    }

    /**
     * Salvar la lista en un fichero de texto resultado.txt. En cada l�nea del
     * fichero un n� - Se propagan las posibles excepciones
     */
    public void salvarEnFichero() throws IOException {

        try (PrintWriter salida = new PrintWriter(
                new BufferedWriter(new FileWriter("resultado.txt")))) {
            for (Integer i : lista) {
                salida.println(i + "");
            }

        }
    }

    /**
     * Representaci�n textual de la lista
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer i : lista) {
            sb.append(i + "\n");
        }
        return sb.toString();
    }
}
