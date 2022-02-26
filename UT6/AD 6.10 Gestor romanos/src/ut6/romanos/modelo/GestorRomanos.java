package ut6.romanos.modelo;

import java.util.Map;
import java.util.TreeMap;

/**
 * La clase GestorArabigos genera una lista
 * de n�s ar�bigos con sus correspondientes
 * n�s romanos.
 * La lista est� ordenada por n� ar�bigo
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
     * A�adir un romano. Se a�ade la clave que es 
     * su valor ar�bigo y el valor asociado que es
     * el n� romano
     *
     * @param  romano el n� romano se a�ade como 
     *          valor asociado.
     *
     */
    public void addRomano(String romano) {
        listaArabigos.put(conversor.convertir(romano), romano.toUpperCase());
        
    }
    
    /**
     * A�adir varios romanos.  
     *
     * @param  el array con los n�s romanos
     *
     */
    public void addRomanos(String[] romanos) {
        for (String romano : romanos) {
            this.addRomano(romano);
        }
        
        
    }
    
    /**
     * representaci�n  textual del map
     *
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%20s%20s\n", "Ar" +
                "�bigos", "Romanos"));
        for (Map.Entry<Integer, String> entrada : listaArabigos.entrySet()) {
            sb.append(String.format("%20d%20s\n", entrada.getKey(),
                    entrada.getValue()));
            
        }
        return sb.toString();
        
    }
    
    /**
     * Mostrar la lista de ar�bigos   
     *
     */
    public void escribirListaArabigos() {
        System.out.println(this.toString());
        
    }
    
    
}
