import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * La clase guarda en una colección ArrayList una
 * lista de números enteros
 */
public class ListaNumeros {
    private List<Integer> lista;

    /**
     * Constructor  - instancia la colección
     */
    public ListaNumeros() {
        lista = new ArrayList<>();
    }



    /**
     * añade un número a la colección
     */
    public void add(int numero) {
        lista.add(numero);
    }

    /**
     * detectar si la lista está vacía
     */
    public boolean estaVacia() {
        return lista.size() == 0;
    }

    /**
     * borrar todos los elementos de la lista, dejadla vacía
     */
    public void borrarLista() {
        lista.clear();
    }

    /**
     * Crea un fichero de texto  cuyo nombre se
     * pasa como argumento
     * Para crear el fichero recorreremos la colección y
     * guardaremos cada nº de la lista en el fichero, un nº por línea
     *
     * Capturamos las excepciones que se puedan producir
     */
    public void salvarEnFicheroDeTextoV0(String nombre) {
        PrintWriter salida = null;
        try {
            File f = new File(nombre);
            //salida = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
            salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for (Integer n : lista) {
                salida.println(n);
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        } finally {
            if (salida != null) {
                salida.close();

            }
        }

    }

    /**
     * Crea un fichero de texto  cuyo nombre se
     * pasa como argumento
     * Para crear el fichero recorreremos la colección y
     * guardaremos cada nº de la lista en el fichero, un nº por línea
     *
     * Capturamos las excepciones que se puedan producir
     */
    public void salvarEnFicheroDeTexto(String nombre) {
        File f = new File(nombre);
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));) {
            for (Integer n : lista) {
                salida.println(n);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando BufferedReader
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTextoV0(String nombre) {
        BufferedReader entrada = null;
        try {
            File f = new File(nombre);
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    lista.add(Integer.parseInt(linea));

                } catch (NumberFormatException e) {
                    System.out.println("Error al leer un nº " + e.getMessage());

                }
                linea = entrada.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                entrada.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());

            } catch (NullPointerException e) {
                System.out.println("valor null para variable entrada ");

            }

        }
    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando BufferedReader
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTexto(String nombre) {
        File f = new File(nombre);
        try (BufferedReader entrada = new BufferedReader(new FileReader(f));) {
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    lista.add(Integer.parseInt(linea));

                } catch (NumberFormatException e) {
                    System.out.println("Error al leer un nº " + e.getMessage());

                }
                linea = entrada.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando Scanner
     *
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTextoConScanner(String nombre) {
        Scanner entrada = null;
        try {
            File f = new File(nombre);
            entrada = new Scanner(f);
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                try {
                    lista.add(Integer.parseInt(linea));

                } catch (NumberFormatException e) {
                    System.out.println("Error al leer un nº " + e.getMessage());

                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {

            if (entrada != null) {
                entrada.close();
            }
        }

    }

    /**
     * lee de un fichero de texto cuyo nombre se pasa
     * como argumento una serie de nºs enteros y cada nº lo guarda en la lista
     * Al acabar se cierra el fichero
     *
     * Usando Scanner
     *
     *
     * Capturaremos las excepciones que se puedan producir
     * incluidas las de conversión de formato. Las líneas con errores se ignoran
     * continuando la ejecución del programa
     */
    public void leerFicheroDeTextoConScannerV2(String nombre) {
        Scanner entrada = null;
        try {
            File f = new File(nombre);
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                try {
                    int n = entrada.nextInt();
                    lista.add(n);
                } catch (InputMismatchException e) {
                    System.out.println("Error al leer un nº " + entrada.next()); // hacer un flush

                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    /**
     * Representación textual de la colección
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de números\n");
        for (Integer n : lista) {
            sb.append(n + " ");
        }
        return sb.toString();
    }

    /**
     * Muestra la lista en pantalla
     */
    public void mostrarLista() {
        System.out.println(this.toString());
    }

}
