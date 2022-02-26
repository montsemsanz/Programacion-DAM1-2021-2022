package otroconversor.romanos;

import java.util.LinkedHashMap;
import java.util.Set;

public class ConversorRomanos {
    private LinkedHashMap<Character, Integer> map;
    
    /**
     * Constructor 
     */
    public ConversorRomanos() {
        map = new LinkedHashMap<Character, Integer>();
        inicializar();
    }
    
    /**
     * Da valores iniciales al map
     */
    private void inicializar() {
        String letras = "MDCLXVI";
        int[] numeros = {1000, 500, 100, 50, 10, 5, 1};
        
        for (int i = 0; i < letras.length(); i++) {
            map.put(letras.charAt(i), numeros[i]);
        }
    }
    
    /**
     * convierte el nº romano a arábigo
     * @param romano el nº romano a convertir
     * @return el nº arábigo
     */
    public int aArabigo(String romano) {
        romano = romano.toUpperCase();
        int arabigo = 0;
        for (int i = 0; i < romano.length(); i++) {
            arabigo += map.get(romano.charAt(i));
        }
        return arabigo;
    }
    
    /**
     * convierte el nº arábigo (menor o igual a 4000, asumimos esto)
     * a romano en notación antigua
     * @param arabigo el nº arábigo  a convertir
     * @return el nº romano
     *
     *
     */
    public String aRomano(int arabigo) {
        int aux = arabigo;
        StringBuilder sb = new StringBuilder();
        Set<Character> claves = map.keySet();
        for (Character c : claves) {
            int valor = map.get(c);
            if (aux >= valor) {
                int coc = aux / valor;
                for (int i = 1; i <= coc; i++) {
                    sb.append(c);
                }
                aux = aux % valor;
            }
            
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        ConversorRomanos conversor = new ConversorRomanos();
        String romano = "MMDDXXIII";
        int arabigo = conversor.aArabigo(romano);
        System.out.println(romano + " =>" + arabigo);
        System.out.println(arabigo + " =>" + romano);
    }
    
}
