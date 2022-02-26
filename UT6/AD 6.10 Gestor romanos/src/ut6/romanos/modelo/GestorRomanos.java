package ut6.romanos.modelo;

import java.util.Map;
import java.util.TreeMap;

/**
 * La clase GestorArabigos genera una lista
 * de nºs arábigos con sus correspondientes
 * nºs romanos.
 * La lista está ordenada por nº arábigo
 * Para modelar la lista se utiliza un TreeMap
 */

public class GestorRomanos {
    
    private TreeMap<Integer, String> listaArabigos;
    private ConversorRomanos conversor;
    
    /**
     * Constructor 
     */
    public GestorRomanos(ConversorRomanos conversor) {
        this.conversor = conversor;
        this.listaArabigos = new TreeMap<>();
        
        
    }
    
    /**
     * Añadir un romano. Se añade la clave que es 
     * su valor arábigo y el valor asociado que es
     * el nº romano
     *
     * @param  romano el nº romano se añade como 
     *          valor asociado.
     *
     */
    public void addRomano(String romano) {
        listaArabigos.put(conversor.convertir(romano), romano.toUpperCase());
        
    }
    
    /**
     * Añadir varios romanos.  
     *
     * @param  el array con los nºs romanos
     *
     */
    public void addRomanos(String[] romanos) {
        for (String romano : romanos) {
            this.addRomano(romano);
        }
        
        
    }
    
    /**
     * representación  textual del map
     *
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%20s%20s\n", "Ar" +
                "ábigos", "Romanos"));
        for (Map.Entry<Integer, String> entrada : listaArabigos.entrySet()) {
            sb.append(String.format("%20d%20s\n", entrada.getKey(),
                    entrada.getValue()));
            
        }
        return sb.toString();
        
    }
    
    /**
     * Mostrar la lista de arábigos   
     *
     */
    public void escribirListaArabigos() {
        System.out.println(this.toString());
        
    }
    
    
}
