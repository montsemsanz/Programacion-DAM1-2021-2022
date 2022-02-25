
/**
 * Modela un diccionario en el que cada palabra
 * tiene asociados una serie de sin�nimos
 * 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Tesauro
{
    // a cada clave se le asocia un conjunto de sin�nimos
    // los sin�nimos no se repiten
    private HashMap<String, HashSet<String>> tesauro;

    /**
     * Constructor de la clase Tesauro
     */
    public Tesauro()    {
        tesauro = new HashMap<>();
    }

    /**
     * 
     * @param  palabra la palabra a a�adir
     *         sinonimo el sin�nimo de la palabra
     */
    public void a�adirSinonimo(String palabra, String sinonimo)    {
        if (!tesauro.containsKey(palabra))    {
            HashSet<String> sinonimos = new HashSet<String>();
            sinonimos.add(sinonimo);
            tesauro.put(palabra, sinonimos );
        }
        else   {
            tesauro.get(palabra).add(sinonimo);    
        }

    }

    /**
     * a�ade una palabra junto con todos sus sin�nimos 
     * @param linea contiene la palabra y sus sin�nimos
     *         el separador entre palabras es el blanco
     *         la primera palabra es la clave, el resto sin�nimos
     */
    public void a�adirSinonimo(String linea)    {
        String[] palabras = linea.trim().split("\\s+");
        String palabra = palabras[0].trim();
        for (int i = 1; i < palabras.length; i++)   {
            a�adirSinonimo(palabra, palabras[i]);
        }


    }

    /**
     * 
     * @param  sin el sin�nimo a borrar de cada conjunto
     *              de sin�nimos
     * @return   el conjunto de claves en las que estaba
     *            el sin�nimo borrado. Si no se borr�
     *            ninguno devuelve el conjunto vac�o
     */
    public HashSet<String> borrarSinonimo(String sin)    {
        HashSet<String> resul = new HashSet<String>();
        Set<String> claves = tesauro.keySet();
        for (String clave: claves)     {
            HashSet<String> valores = tesauro.get(clave);
            if (valores.contains(sin))        {
                resul.add(clave);
                valores.remove(sin);
            }
        }
        return resul;

    }

    /**
     * 
     * @return  representaci�n textual del map
     *     
     */
    public String toString()    {
        StringBuilder sb = new StringBuilder("TESAURO " + "\n");
        Set<String> claves = tesauro.keySet();
        for (String clave: claves)        {
            sb.append(clave + "\n" + "\tSIN�NIMOS  ");
            HashSet<String> valores = tesauro.get(clave);
            for (String valor: valores)         {
                sb.append(valor + "\t");
            }
            sb.append("\n");

        }
        return sb.toString();

    }

    /**
     * 
     * Visualiza el tesauro    
     */
    public void escribirTesauro()    {

        System.out.println(toString());
    }

}
