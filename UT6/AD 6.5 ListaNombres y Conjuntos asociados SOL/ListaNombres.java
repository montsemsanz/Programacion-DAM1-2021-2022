
/**
 * la clase ListaNombres guarda  una lista ordenada
 * de nombres en may�sculas
 * 
 * Ejercicio AD06
 * 
 */
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ListaNombres
{

    private ArrayList<String> lista;

    /**
     * Constructor de la clase ListaNombres
     */
    public ListaNombres()   {
        lista = new ArrayList<>();
    }

    /**
     * A�ade un nuevo nombre en la posici�n que
     * le corresponde.  Indiferente may�sculas o min�sculas al ordenar
     * @param  nombre el nombre a a�adir
     *
     */
    public void a�adirNombre(String nombre)   {

        int pos = buscarPosicion(nombre);
        lista.add(pos, nombre);
    }

    /**
     * @return la posici�n en la que hay que insertar 
     * el nombre - Importan may�sculas / min�sculas al insertar en orden
     */
    private int buscarPosicion(String nombre)   {
//         int j = lista.size() - 1;
//         while (j >= 0 && lista.get(j).compareTo(nombre) > 0) {          
//             j--;
// 
//         }
//         return j + 1;
        
        int pos = Collections.binarySearch(lista, nombre);
        if (pos < 0) {// el nombre no est�
            pos++;
            pos = Math.abs(pos);
        }
        return pos;
    }

    /**
     * Obtiene el conjunto de caracteres del nombre de la posici�n indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public TreeSet<Character> obtenerConjuntoDeCaracteres(int pos)    {
        if (pos < 0 || pos >= lista.size()) {                       
            throw new IllegalArgumentException("Error en posici�n");
        }
        return UtilsString.getConjuntoCaracteres(lista.get(pos));

    }

    /**
     * Obtiene el conjunto de d�gitos num�ricos del nombre de la posici�n indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public HashSet<Character> obtenerConjuntoDeDigitos(int pos)    {
        if (pos < 0 || pos >= lista.size())    {               
            throw new IllegalArgumentException("Error en posici�n");
        }
        return UtilsString.getConjuntoDigitos(lista.get(pos));

    }

    /**
     * Obtiene el conjunto de letras may�sculas del nombre de la posici�n indicada
     * @throws IllegalArgumentException si el argumento recibido es incorrecto
     *           
     */
    public LinkedHashSet<Character> obtenerConjuntoMayusculas(int pos)   {
        if (pos < 0 || pos >= lista.size())  {                      
            throw new IllegalArgumentException("Error en posici�n");
        }
        return UtilsString.getConjuntoMayusculas(lista.get(pos));

    }

        
    /**
     * Representaci�n textual de la lista de nombres 
     * de la forma          Nombre - [conjunto de caracteres ]
     */
    public String toString()    {
        StringBuilder sb = new StringBuilder("Nombres y sus conjunto asociados (Caracteres  D�gitos  May�sculas)\n");
        for (int i = 0; i < lista.size(); i++)    {
            sb.append(lista.get(i)).append("   " + 
                    obtenerConjuntoDeCaracteres(i).toString() + "   ");
            sb.append(obtenerConjuntoDeDigitos(i).toString() + "   ");
            sb.append(obtenerConjuntoMayusculas(i).toString()).append("\n");
        }
        return sb.toString();
    }

   
    public void printLista()    {
        System.out.println(this.toString());
    }

     /**
     * lee los nombres de un fichero de texto 
     *      
     */
    public void leerDeFichero()    {
        try     {
            Scanner sc = new Scanner(new File("nombres.txt"));
            while (sc.hasNextLine() )     {
                a�adirNombre(sc.nextLine());
            }
            sc.close();
        }
        catch (IOException e)     {
            e.printStackTrace();
        }
    }
}
