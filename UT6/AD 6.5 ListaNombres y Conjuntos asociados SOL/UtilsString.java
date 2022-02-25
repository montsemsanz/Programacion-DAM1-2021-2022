
/**
 *  Clase de utilidades. Contiene solo m�todos
 *  est�ticos
 *  
 */
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class UtilsString
{
    /**
     *  Dada una cadena obtiene y devuelve su conjunto de caracteres
     *  Importa el orden en el conjunto
     *
     */
    public static  TreeSet<Character> getConjuntoCaracteres(String cadena)    {
        TreeSet<Character> conjunto = new  TreeSet<>();
        for (int i = 0; i < cadena.length(); i++)   {
            conjunto.add(cadena.charAt(i));
        }
        return conjunto;
    }

     /**
     *  Dada una cadena obtiene su conjunto de caracteres num�ricos
     *  No importa el orden en el conjunto
     *  
     *  Usa alg�n m�todo de la clase Character  para comprobar si un caracter es  
     *  num�rico o no
     *
     */
    public static  HashSet<Character> getConjuntoDigitos(String cadena)    {
        HashSet<Character> conjunto = new  HashSet<>();
        for (int i = 0; i < cadena.length(); i++)    {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter))   {
                conjunto.add(caracter);
            }
        }
        return conjunto;
    }
    
     /**
     *  Dada una cadena obtiene su conjunto de letras may�sculas
     *  en el orden en el que aparecen   en la cadena
     *   
     *
     */
    public  static LinkedHashSet<Character> getConjuntoMayusculas(String cadena)    {
        LinkedHashSet<Character> conjunto = new  LinkedHashSet<>();
        for (int i = 0; i < cadena.length(); i++)    {
            char caracter = cadena.charAt(i);
            if (Character.isUpperCase(caracter))   {
                conjunto.add(caracter);
            }
        }
        return conjunto;
    }
        
        
}
