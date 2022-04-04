/**
 * La clase modela una lista de personas
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPersonas {
    private static final String NOMBRE_FICHERO = "datos/personas.txt";
    private List<Persona> personas;

    public ListaPersonas() {
        personas = new ArrayList<>();

    }


    /**
     * añade una persona a la lista
     */
    public void add(Persona p) {

        personas.add(p);

    }

    /**
     * vacía la lista
     */
    public void clear() {
        personas.clear();
    }

    /**
     * guarda en un fichero de texto los datos de cada persona
     * Recorreremos la lista y guardaremos por cada persona sus
     * datos en el fichero. Escribirimeos una línea
     * de texto por cada persona con formato nombre:edad:estado
     *
     *
     * Usa las clases PrintWriter, BufferedWriter, FileWriter
     *
     * Hay que propagar las excepciones, no capturarlas
     */
    public void guardarEnFicheroDeTexto() throws IOException {

        File f = new File(NOMBRE_FICHERO);
//        if (f.exists()) {
//            salida = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
//        } else {
//            salida = new PrintWriter(new BufferedWriter(new FileWriter(f)));
//        }
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
            for (Persona p : personas) {
                salida.println(p.getNombre() + ":" +
                        p.getEdad() + ":" +
                        p.getEstadoCivil());
            }
        }


    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y
     * se crea un objeto Persona que añadiremos a la lista
     * Usa las clases  BuffererReader, FileReader
     *
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTexto() {
        BufferedReader entrada = null;
        try {
            File f = new File(NOMBRE_FICHERO);
            entrada = new BufferedReader(new FileReader(f));
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    Persona persona = parsearLinea(linea);
                    this.add(persona);
                } catch (NumberFormatException e) {
                    System.out.println("Error en línea " + linea);
                } finally {
                    linea = entrada.readLine();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    /**
     * Parsea la línea, es decir, extrae de la línea la información
     * de una persona
     */
    private Persona parsearLinea(String linea) throws NumberFormatException {
        String[] datos = linea.split(":");
        return new Persona(datos[0].trim(),
                Integer.parseInt(datos[1].trim()),
                datos[2].trim().charAt(0));
    }

    /**
     * Lee del fichero de texto  una a una las líneas de datos que
     * contienen los datos de cada persona. Cada línea se parsea
     * (según el separador utilizado, en nuestro caso los :) y
     * se crea un objeto Persona que añadiremos a la lista
     * Usa la clase  Scanner
     *
     * Hay que capturar las excepciones generadas
     */
    public void leerDeFicheroDeTextoConScanner() {

        File f = new File(NOMBRE_FICHERO);
        try (Scanner entrada = new Scanner(f);
             // Scanner entrada = new Scanner(new FileReader(f))
        ) {
            while (entrada.hasNextLine()) {
                String linea = null;
                try {
                    linea = entrada.nextLine();
                    Persona persona = parsearLinea(linea);
                    this.add(persona);
                } catch (NumberFormatException e) {
                    System.out.println("Error en línea " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Guarda en el fichero "estadis.txt" la relación de personas solteras
     * y el nº total de ellas
     *
     * Se propagan (se avisa)  las excepciones que puedan ocurrir
     */
    public void guardarEstadisticas() throws IOException {

        File f = new File("datos/estadis.txt");
        try (PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
            salida.println("Relación de personas solteras ");
            int solteras = 0;
            for (Persona p : personas) {
                if (p.estaSoltera()) {
                    salida.println(p.toString());
                    solteras++;
                }
            }
            salida.printf("Total personas solteras %4d", solteras);
        }


    }

    /**
     * representación textual de la lista de personas
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de personas\n");
        for (Persona p : personas) {
            sb.append(p.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * Mostrar la lista
     */
    public void mostrar() {
        System.out.println(this.toString());
    }

    /**
     * leer desde un fichero como recurso
     * Permite la lectura correcta de un fichero que está dentro de un jar
     */
    public void leerDeFicheroComoRecurso() {
        // opción A
        try (Scanner entrada = new Scanner(this.getClass().getResourceAsStream(NOMBRE_FICHERO));) {
            while (entrada.hasNextLine()) {
                String linea = null;
                try {
                    linea = entrada.nextLine();
                    Persona persona = parsearLinea(linea);
                    this.add(persona);
                } catch (NumberFormatException e) {
                    System.out.println("Error en línea " + linea);
                }
            }
        }

        // opción B
        try (Scanner entrada = new Scanner(ListaPersonas.class.getClassLoader()
                .getResourceAsStream(NOMBRE_FICHERO));) {
            String linea = null;
            try {
                linea = entrada.nextLine();
                Persona persona = parsearLinea(linea);
                this.add(persona);
            } catch (NumberFormatException e) {
                System.out.println("Error en línea " + linea);
            }
        }

        // opción C
        try (InputStream is = ListaPersonas.class.getClassLoader().getResourceAsStream(NOMBRE_FICHERO);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(is));
        ) {
            String linea = entrada.readLine();
            while (linea != null) {
                try {
                    Persona persona = parsearLinea(linea);
                    this.add(persona);
                } catch (NumberFormatException e) {
                    System.out.println("Error el línea " + linea);
                } finally {
                    linea = entrada.readLine();
                }
            }


        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

    }
}
