package ut8.matrices.test;

import ut8.matrices.io.MatrizIO;
import ut8.matrices.modelo.Matriz;
import ut8.matrices.modelo.MatrizExcepcion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class TestMatriz {

    public static void main(String[] args) {

        try {
            String mt1 = args[0];
            String mt2 = args[1];
            String mt3 = args[2];
            Matriz uno = MatrizIO.leerDeFichero(mt1);
            Matriz dos = MatrizIO.leerDeFichero(mt2);
            Matriz tres = MatrizIO.leerDeFichero(mt3);
            System.out.println("Matriz 1\n" + uno.toString());
            System.out.println("Matriz 2\n" + dos.toString());
            System.out.println("Matriz 3\n" + tres.toString());

            Matriz suma = uno.sumar(dos);
            System.out
                    .println("Suma de las matrices 1 y 2\n"
                            + suma.toString());
            MatrizIO.salvarEnFichero(suma, "datos/suma.txt");

            Matriz producto = uno.multiplicarPor(tres);
            System.out.println(
                    "Producto de las matrices 1 y 3\n"
                            + producto.toString());
            MatrizIO.salvarEnFichero(producto, "datos/producto.txt");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error en argumentos del main " + e);
        } catch (InputMismatchException e) {
            System.out.println("Error al leer datos del fichero " + e);
        } catch (NoSuchElementException e) {
            System.out.println("Error no hay datos para leer " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado " + e);
        } catch (IOException e) {
            System.out.println("Error IO " + e);
        } catch (MatrizExcepcion e) {
            System.out.println(e);
        }

    }

}
