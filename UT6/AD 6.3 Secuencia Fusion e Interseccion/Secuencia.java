import java.util.Arrays;
import java.util.HashSet;

/**
 * La clase Secuencia almacena un serie de 
 * n�meros ordenados.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Secuencia
{
    private ArrayList<Integer> lista;

    /**
     * Construye una secuencia a partir de la colecci�n 
     * recibida
     */        
    public Secuencia(ArrayList<Integer> otra)    {
        if (otra == null)     {
            throw new IllegalArgumentException("Colecci�n vac�a");
        }
        lista = new ArrayList<>();
        lista.addAll(otra); 
        Collections.sort(lista); //se puede porque Integer implementa el interfaz Comparable
    }

    /**
     * accesor para la secuencia ArrayList almacenada
     */

    public ArrayList<Integer> getSecuencia()    {
        ArrayList<Integer> copia = new ArrayList<>();
        copia.addAll(lista);
        return copia;
    }

    /**
     * Obtiene la fusi�n (la uni�n) de dos listas 
     * de n�meros ordenadas, la representada por el atributo lista y 
     * la representada por el par�metro otra
     * 
     */
    public ArrayList<Integer> fusionarCon(ArrayList<Integer> otra)    {
        if (otra == null)    {
            throw new IllegalArgumentException("Colecci�n nula");
        }
        ArrayList<Integer> copia = getSecuencia(); 
        copia.addAll(otra);         
        Collections.sort(copia);
        return copia;
    }

    /**
     * Obtiene la intersecci�n de lista y el par�metro otra. La  intersecci�n 
     * contiene los elementos comunes y no repetidos de ambas (en orden)
     */
    public  ArrayList<Integer> interseccionCon( ArrayList<Integer> otra)    {
        if (otra == null)   {
            throw new IllegalArgumentException("Colecci�n nula");
        }
        ArrayList<Integer> interseccion = new ArrayList<>();
        interseccion.addAll(lista);
        interseccion.retainAll(otra);
        return eliminarDuplicados(interseccion);

    }

    /**
     *  Elimina los duplicados de una lista
     *
     */
    private ArrayList<Integer> eliminarDuplicados(ArrayList<Integer> lista)    {
        HashSet<Integer> conjunto =  new HashSet<>(lista);
        lista.clear();
        lista.addAll(conjunto);
        return lista;

    }

    /**
     * Representaci�n textual de la secuencia guardada
     * por el objeto actual
     */
    public String toString()    {
        return lista.toString();
    }

    /**
     *  Prueba de la clase
     */
    public static void main(String[] args)    {
        ArrayList<Integer> lis1 = new ArrayList<>();
        lis1.addAll(Arrays.asList(3, 4, 4, 5, 7, 8, 9, 9, 14));
        Secuencia secuencia1 = new Secuencia(lis1);
        System.out.println("Secuencia 1 \n" + secuencia1.toString());

        ArrayList<Integer> lis2 = new ArrayList<>();
        lis2.addAll(Arrays.asList(1, 3, 3, 4, 12));
        Secuencia secuencia2 = new Secuencia(lis2);
        System.out.println("Secuencia 2 \n" + secuencia2.toString());

        ArrayList<Integer> fusion = secuencia1.fusionarCon(secuencia2.getSecuencia());
        System.out.println("Fusi�n\n" + fusion.toString());

        ArrayList<Integer> interseccion = secuencia1.interseccionCon(secuencia2.getSecuencia());
        System.out.println("Intersecci�n\n" + interseccion.toString());

    }

}
