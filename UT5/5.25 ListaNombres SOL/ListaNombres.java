
/**
 * La clase mantiene una lista de nombres
 * en orden l�xicogr�fico  
 * 
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ListaNombres
{
    private String[]  lista;
    private int pos;

    /**
     * Constructor de la clase ListaNombres
     * n es el tama�o m�ximo de la lista
     */
    public ListaNombres(int n)   {              
        lista = new String[n];  
        pos = 0;
    }

    /**
     * @return  true si la lista est� vac�a   
     */
    public boolean  listaVacia()   {
        return pos == 0;
    }

    /**
     * 
     * @return  true si la lista est� llena   
     */
    public boolean  listaLlena()    {
        return pos == lista.length;
    }

    /**
     * Inserta un nombre en la lista �nicamente
     * si no est� y la lista no est� llena. La inserci�n se hace de tal
     * manera que el nombre queda colocado en el 
     * lugar que le corresponde manteniendo el orden 
     * de la lista (no se utiliza ning�n algoritmo de ordenaci�n)
     * Importan may�sculas  y min�sculas
     * 
     * @param nombre el nombre a insertar
     * @return  true si la inserci�n se hace con �xito   
     *
     */
    public boolean insertarNombre(String nombre)    {
        boolean insertado = false;
        if (!listaLlena())     {
            if (!estaNombre(nombre))   {
                //insertamos el nombre
                int j = pos - 1;
                while (j >= 0 && lista[j].compareTo(nombre) > 0) {
                    lista[j + 1] = lista[j];
                    j--;
                }
                lista[j + 1] = nombre;
                pos++;
                insertado = true;
            }
        }

        return insertado;
    }

    /**
     *  Busca un nomnbre en la lista
     *  Puesto que la lista est� en todo momento ordenada
     *  se hace una b�squeda binaria
     *  @param  nombre el nombre a buscar
     *  @return   true si ya existe el nombre en la lista  
     *   
     */
    private boolean estaNombre(String nombre)    {
        int izq = 0;
        int dcha = pos - 1;
        while (izq <= dcha)  {
            int mitad = (izq + dcha) / 2;
            int resul = lista[mitad].compareTo(nombre);
            if (resul == 0)    {
                return true;
            }
            else if (resul < 0)  {
                izq = mitad + 1;
            }
            else  {
                dcha = mitad - 1;  
            }
        }
        return false;
        //     return Arrays.binarySearch(lista, 0, pos, nombre) >= 0;  // otra posibilidad m�s c�moda
    }

    /**
     *  Busca y devuelve el nombre de mayor longitud
     *  en la lista. Si hay varios devuelve el
     *  primero encontrado
     *  Si la lista est� vac�a devuelve null
     *  
     *  @return   el nombre m�s largo  
     *  
     */
    public String nombreMasLargo()    {
        if (listaVacia())  {
            return null;
        }
        String masLargo = lista[0];
        for (int i = 1; i < pos; i++)  {
            if (lista[i].length() > masLargo.length())  {
                masLargo = lista[i];
            }
        }
        return masLargo;
    }

    /**
     * Borra de la lista los nombres que empiezan por 
     * una letra determinada (s� importan may�sculas y min�sculas)
     * No es lo mismo borrarLetra('A') que borrarLetra('a')
     *
     * @param letra la letra por la que han de empezar los nombres 
     *    
     */
    public void borrarLetra(char letra)   {
        int i = 0;
        while (i < pos)  {
            if (lista[i].charAt(0) == letra)  {
                borrarDePosicion(i);

            }
            else {
                i++;     
            }
        }
    }

    /**
     * Borra un nombre de la posici�n indicada
     * 
     *
     * @param  p posici�n del nombre a borrar
     *  
     */
    private void borrarDePosicion(int p)    {
        // for (int i = p + 1; i < pos; i++) {
            // lista[i - 1] = lista[i]; 
        // }
        // pos--;                

        System.arraycopy(lista, p + 1, lista, p, pos - p - 1);
        pos--;
    }

    /**
     *  devuelve un  array con los elementos de lista pero en orden inverso
     *  el primero ahora es el ultimo de lista, el segundo el antepen�ltimo,..... y adem�s cada
     *  nombre en el nuevo array se invierte tambi�n
     *  
     */
    public String[] invertir()    {
        String[] invertido = new String[pos];
        for (int i =  pos - 1; i >= 0; i--)  {
            invertido[pos - i - 1] = invertir(lista[i]);
        }
        return invertido;
    }

    /**
     *  Dado un nombre lo devuelve invertido.
     *  Usar StringBuilder
     */
    public static String invertir(String nombre)    {
        return new StringBuilder(nombre).reverse().toString();
    }

    /**
     * Lee de un fichero de texto una serie 
     * de nombres con ayuda de un objeto de la 
     * clase Scanner y los almacena en la lista
     */
    public void cargarDeFichero()     {
        try   {
            Scanner sc = new Scanner(new File("nombres.txt"));
            while (sc.hasNextLine() && !listaLlena())     {
                insertarNombre(sc.nextLine());
            }
            sc.close();
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
    }

    /**
     * Cuenta cu�ntos nombres empiezan por una determinada 
     * cadena sin importar si es may�scula o min�scula
     *
     * @param  la cadena de comienzo
     * @return  la cantidad de nombres calculados   
     */
    public int empiezanPor(String inicio)    {
        String ini = inicio.toUpperCase();
        int cuantos = 0;
        for (int i = 0; i < pos; i++)   {
            String n = lista[i].toUpperCase();
            if (n.startsWith(ini))  {
                cuantos++;
            }
        }
        return cuantos;

    }

    /** 
     * 
     * Devuelve un array con los nombres que empiezan por una determinada 
     * letra sin importar si es may�scula o min�scula
     * 
     * @param  la letra de comienzo
     * @return  la cantidad de nombres encontrados
     *          con esa letra   
     */ 
    public String[] empiezanPorLetra(char letra)    {
        String ini = String.valueOf(letra).toUpperCase();
        String[] resul = new String[empiezanPor(ini)];
        int j = 0;
        for (int i = 0; i < pos; i++)    {
            String n = lista[i].toUpperCase();
            if (n.startsWith(ini))    {
                resul[j] = lista[i];
                j++;
            }
        }

        return resul;

    }

    /**
     * Representaci�n textual de la cadena
     * 
     * @return la cadena resultante    
     */
    public String toString()    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++)  {
            sb.append(lista[i] + "\n");
        }
        sb.append("\n");
        return sb.toString();
    }

}
