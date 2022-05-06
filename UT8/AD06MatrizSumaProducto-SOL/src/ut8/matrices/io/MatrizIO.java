package ut8.matrices.io;

import ut8.matrices.modelo.Matriz;
import ut8.matrices.modelo.MatrizExcepcion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MatrizIO {

    /**
     * Crea y devuelve una matriz cargando sus valores a partir de un fichero de
     * texto. La primera línea del fichero siempre contiene dos nºs, las filas y
     * columnas de la natriz- Luego siguen tantas líneas de texto como marquen
     * las filas y cada línea con tantos números como marquen las columnas. El
     * separador es el tabulador ('\t')
     * Todas las excepciones se propagan
     * Usar try-with-resources
     */
    public static Matriz leerDeFichero(String nombre)
            throws MatrizExcepcion, FileNotFoundException, NoSuchElementException {

        Matriz matriz = null;
        File fichero = new File(nombre);
        try (Scanner entrada = new Scanner(fichero);) {
            int filas = entrada.nextInt();
            int columnas = entrada.nextInt();
            matriz = new Matriz(filas, columnas);
            for (int f = 0; f < filas; f++) {
                for (int c = 0; c < columnas; c++) {
                    int numero = entrada.nextInt();
                    matriz.setValor(numero, f, c);
                }
            }

        }
        return matriz;

    }

    /**
     * Guarda en el fichero especificado la matriz recibida como argumento
     * La primera línea del fichero contendrá las filas y columnas de la matriz
     * Luego habrá tantas líneas filas como filas tenga la matriz y en
     * cada línea tantos números como columnas
     *
     * Todas las excepciones se propagan
     * Usar try-with-resources
     */
    public static void salvarEnFichero(Matriz matriz, String nombre)
            throws MatrizExcepcion, IOException {

        File fichero = new File(nombre);
        try (PrintWriter salida = new PrintWriter(
                new BufferedWriter(new FileWriter(fichero)));) {
            salida.println(matriz.getFilas() + "\t" + matriz.getColumnas());
            for (int f = 0; f < matriz.getFilas(); f++) {
                for (int c = 0; c < matriz.getColumnas(); c++) {
                    salida.print(matriz.getValor(f, c) + "\t");
                }
                salida.println();
            }
        }

    }
}
