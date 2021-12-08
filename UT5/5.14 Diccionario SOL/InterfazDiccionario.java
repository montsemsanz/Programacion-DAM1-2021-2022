
/**
 * clase InterfazDiccionario 
 *  
 */
import java.util.Scanner;
public class InterfazDiccionario
{
    private static final int A�ADIR = 1;
    private static final int MOSTRAR = 2;
    private static final int TRADUCIR = 3;
    private static final int SALIR = 4;
    
    private Scanner teclado;
    private Diccionario diccionario;

    /**
     * Constructor de objetos de la clase InterfazDiccionario
     */
    public InterfazDiccionario(Diccionario diccionario)    {
        teclado = new Scanner(System.in);
        this.diccionario = diccionario;
        
    }

    /**
     * Incluye la l�gica de la aplicaci�n
     *  
     */
    public void iniciar()   {
        borrarPantalla();
        int opcion = menu();
        while (opcion != SALIR)   {
            switch (opcion)        {
                case A�ADIR: a�adirPalabra();
                              break;
                case MOSTRAR: mostrarDiccionario();
                              break;
                case TRADUCIR: traducirPalabra();
                              break;
                
            }
            opcion = menu(); 
        }
    }
    
    /**
     * Presenta el men� 
     * @return  la opci�n seleccionada
     */
    private int menu()    {
        System.out.println("********************************");
        System.out.println("Gesti�n de un diccionario\n");
        System.out.println("********************************");
        System.out.println("1. A�adir palabra");
        System.out.println("2. Mostrar diccionario");
        System.out.println("3. Traducir palabra");
        System.out.println("4. Salir");
        System.out.print("Teclea opci�n: ");
        int opcion = teclado.nextInt();
        while (!opcionValida(opcion))   {
             System.out.print("Opci�n incorrecta, Teclea opci�n: ");
             opcion = teclado.nextInt();
        }
        return opcion;
    }
    
    /**
     *  Devuelve true si la opci�n es correcta, false en otro caso
     *
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= A�ADIR && opcion <= SALIR;
    }

 
    
    /**
     * A�ade una nueva palabra al diccioanrio
     */
    private void a�adirPalabra()   {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        System.out.println("Palabra a a�adir");
        System.out.print("Castellano: ");
        String castellano = teclado.nextLine();
        System.out.print("Ingl�s: ");
        String ingles = teclado.nextLine();
        diccionario.insertarPalabra(new Palabra(castellano, ingles));
        
    }
    
     /**
     * Mostrar el diccioanrio
     */
    private void mostrarDiccionario()   {
        borrarPantalla();
        diccionario.escribirDiccionario();
        
    }
    
    /**
     * Traducir una  palabra al diccioanrio
     */
    private void traducirPalabra()    {
        borrarPantalla();
        teclado.nextLine(); //limpiar el buffer
        System.out.println("Palabra a traducir");
        System.out.print("Posici�n: ");
        int posi = teclado.nextInt();
        String  traducci�n = diccionario.traducirPalabra(posi);
        if (traducci�n != null)   {
            System.out.println(traducci�n);
        }
        else   {
            System.out.println("No existe la palabra solicitada");
        }
        
    }
    
    
    /**
     * Borrar la pantalla
     */
    private void borrarPantalla()    {
        System.out.println("\u000C");
    }
    
    
    
    
    
    
    
}
