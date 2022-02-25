
/**
 * Multimap - Un objeto de esta clase guarda
 * en un map claves String que representan n�meros
 * y m�ltiplos asociados a esas claves
 * 
 * Ejer. AD07
 * 
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class SerieMultiplos
{

    private Map<String, ArrayList<Integer>> mapMultiplos;

    /**
     * Constructor de la clase SeriePotencias
     */
    public SerieMultiplos()    {
        mapMultiplos = new HashMap<>();

    }

    /**
     * 
     * @param  num el n� que ser� la clave
     *  
     */
    public void a�adirEntrada(int num)     {
        String clave = String.valueOf(num);
        if (!mapMultiplos.containsKey(clave))        {
            ArrayList<Integer> valor = generarMultiplos(num);           
            mapMultiplos.put(clave, valor);
        }
    }

    /**
     * 
     * @param  num el n� del que se generear�n los m�ltiplos
     * @return una colecci�n ArrayLIst con los m�ltiplos generados
     */
    private ArrayList<Integer> generarMultiplos(int num)    {
        ArrayList<Integer> multi = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++)   {
            multi.add(num * i);
        }
        return multi;
    }

    /**
     * 
     * @param  num el n� del que se obtendr�n los m�ltiplos
     * @return  la colecci�n asociada en el map   
     */
    public ArrayList<Integer> obtenerMultiplosDe(int num)    {

        String clave = String.valueOf(num);
        return mapMultiplos.get(clave);

    }

    /**
     * Visualiza el map (claves y valores asociados)
     *    
     */
    public void escribirMap()    {
        Set<String> claves = mapMultiplos.keySet();  
        for (String clave: claves)   {
            System.out.print("N� (clave): " + clave);
            ArrayList<Integer> valores = mapMultiplos.get(clave);
            escribirValor(valores);
            System.out.println();
            System.out.println("----------------------------\n");
        }

    }

    /**
     * M�todo privado de ayuda que visualiza aun ArrayList
     *    
     */
    private void escribirValor(ArrayList<Integer> lista)    {
        System.out.print("\tM�ltiplos: ");
        for (int i: lista)   {
            System.out.print(i + " ");
        }
    }

    /**
     * borrar del map (de todas las entradas) el m�ltiplo indicado
     * Con Map.Entry y un iterador
     */
    public  int borrarMultiplo(int multi)    {
        int total = 0;
        Set<Map.Entry<String, ArrayList<Integer>>> conjuntoEntradas = mapMultiplos.entrySet(); 
        Iterator<Map.Entry<String, ArrayList<Integer>>> it = conjuntoEntradas.iterator();
        while (it.hasNext())    {
            Map.Entry<String, ArrayList<Integer>> entrada = it.next();
            ArrayList<Integer> lista = entrada.getValue();
            // si paso a remove() multi lo toma como posici�n del ArrayList y no
            // como un objeto Integer
            if (lista.remove(new Integer(multi))) {
                total ++;
            }
        }
        return total;
    }

    /**
     *  
     */
    public static void main(String[] args)    {
        SerieMultiplos serie = new SerieMultiplos();
        serie.a�adirEntrada(5);
        serie.a�adirEntrada(3);
        serie.a�adirEntrada(5);
        serie.a�adirEntrada(2);
        serie.a�adirEntrada(6);
        serie.escribirMap();

        int num = 7;
        ArrayList<Integer> multiplos = serie.obtenerMultiplosDe(num);
        if (multiplos != null)    {
            System.out.println("M�ltiplos de " + num + " = " + 
                multiplos.toString());
        }
        System.out.println();
        num = 5;
        multiplos = serie.obtenerMultiplosDe(num);
        if (multiplos != null)     {
            System.out.println("M�ltiplos de " + num + " = " + 
                multiplos.toString());
        }
        System.out.println();
        num = 12;
        int borrados = serie.borrarMultiplo(num);
        System.out.println("Despu�s de borrar el m�ltiplo " + num);
        serie.escribirMap();
        System.out.println("Se han borrado " + borrados);
    }

}
