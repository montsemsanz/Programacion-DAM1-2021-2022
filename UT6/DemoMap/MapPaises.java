
/**
 *   Una colección hashMap que asocia países con sus capitales
 *   http://javaconceptoftheday.com/how-hashmap-works-internally-in-java/
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;

public class MapPaises
{

    private HashMap<String, String> mapPaises;

    /**
     * Constructor  
     */
    public MapPaises()    {
        mapPaises = new HashMap<>();
    }

    /**
     * Añadir una nueva entrada al map, la clave es el país, el
     * valor asociado la capital
     * 
     */
    public void addPais(String pais, String capital)    {
        mapPaises.put(pais.toUpperCase(), capital.toUpperCase());

    }

    /**
     * Dado un país obtener su capital
     */
    public  String capitalDe(String pais)    {
        return mapPaises.get(pais.toUpperCase());
    }

    /**
     * detecta si existe o no una clave en el map
     */
    public  boolean estaPais(String pais)    {
        return mapPaises.containsKey(pais.toUpperCase());
    }

    /**
     *  Dado un país elimina la entrada correspondiente a esa clave
     *
     */
    public void borrarPais(String pais)    {
        mapPaises.remove(pais.toUpperCase());
    }

    /**
     * detecta si existe o no un valor en el map
     */
    public  boolean estaCapital(String capital)    {
        return mapPaises.containsValue(capital.toUpperCase());
    }

    /**
     * nº de elementos del map
     */
    public  int totalPaises()    {
        return mapPaises.size();
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de claves (keySet)
     * Con for mejorado
     */
    public void mostrarPaisesV1()    {
        Set<String> conjuntoPaises = mapPaises.keySet();
        for (String pais: conjuntoPaises) {
            System.out.println(pais + " - " + mapPaises.get(pais));
        }

    }
    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de claves (keySet)
     * Con iterador
     */
    public void mostrarPaisesV2()    {
        Set<String> conjuntoPaises = mapPaises.keySet();
        Iterator<String> it = conjuntoPaises.iterator();
        while (it.hasNext())   {
            String pais = it.next();
            System.out.println(pais + " - " + mapPaises.get(pais));
        }
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de entradas (entrySet)
     * Con for mejorado
     */
    public void mostrarPaisesV3()    {
        Set<Map.Entry<String, String>> conjuntoEntradas = mapPaises.entrySet();
        for (Map.Entry<String, String> entrada: conjuntoEntradas)   {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        } 
    }

    /**
     * Mostrar cada país junto con su capital
     * Recorremos el map obteniendo el conjunto de entradas (entrySet) y recorriéndolas
     * con un iterador
     */
    public void mostrarPaisesV4()    {
        Set<Map.Entry<String, String>> conjuntoEntradas = mapPaises.entrySet();
        Iterator<Map.Entry<String, String>> it = conjuntoEntradas.iterator();
        while (it.hasNext())   {
            Map.Entry<String, String> entrada = it.next();
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }
    }

    /**
     *  Devuelve la colección de capitales presentes en el map
     *
     */
    public Collection<String> grupoCapitales()    {
        return mapPaises.values();
    }
    
    /**
     *  Agrupar nombres de países por letra
     *  Cada letra con el conjunto (en oreden alfabético)
     *  de países en esa letra
     *  LAs letras se recuperan en orden alfabético también
     */
    public TreeMap<Character, TreeSet<String>> agruparPorLetra()    {
        TreeMap<Character, TreeSet<String>> paisesPorLetra = new TreeMap<>();
        Set<String> paises = mapPaises.keySet();
        for (String pais: paises) {
            char letra = pais.charAt(0);
            if (paisesPorLetra.containsKey(letra)) {
                paisesPorLetra.get(letra).add(pais);
            }
            else {
                TreeSet<String> nombres = new TreeSet<>();
                nombres.add(pais);
                paisesPorLetra.put(letra, nombres);
            }
            
        }
        return paisesPorLetra;
        
    }

}
