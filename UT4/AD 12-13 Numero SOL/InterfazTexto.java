import java.util.Scanner;
public class InterfazTexto
{
    private final int NUEVO_NUMERO = 1;
    private final int FACTORIAL = 2;
    private final int PRIMO = 3;
    private final int FIGURA = 4;
    private final int CONTAR_CIFRAS = 5;
    private final int ES_CAPICUA = 6;
    private final int A_BASE8 = 7;
    private final int ESTA_CIFRA = 8;
    private final int CIFRAS_REPETIDAS = 9;
    private final int A_BASE2 = 10;   
    private final int SALIR = 11;
    private Numero numero;
    private Scanner teclado;

    /**
     * Constructor de la clase InterfazUsuario
     */
    public InterfazTexto()   {
        teclado = new Scanner(System.in);
        numero = null;

    }

    /**
     * Controla la l�gica del objeto InterfazTexto
     */
    public void iniciar()    {
        borrarPantalla();

        int opcion = menu();
        while (opcion != SALIR)   {
            if (opcion >= FACTORIAL && opcion <= A_BASE2)       {
                if (numero == null)       {
                    System.out.println("Ejecute la opci�n 1 para crear un n�");
                }
                else   {
                    switch (opcion)       {       

                        case FACTORIAL:  
                        factorial();
                        break;
                        case PRIMO:
                        primo();
                        break;
                        case FIGURA:
                        escribirFigura();
                        break;
                        case CONTAR_CIFRAS:
                        contarCifras();
                        break;
                        case ES_CAPICUA:
                        esCapicua();                        
                        break;
                        case  A_BASE8:
                        aBase8();
                        break; 
                        case  CIFRAS_REPETIDAS:
                        hayCifrasRepetidas();
                        break;
                        case  A_BASE2:
                        aBase2();
                        break;
                        case  ESTA_CIFRA:
                        estaCifra();
                        break;
                    }   
                }
            }
            else     {
                numero = crearNumero();

            }

            opcion = menu();
        }
        System.out.println("���� FIN de la aplicaci�n !!!");

    }

    /**
     * pide un n� y lo devuelve
     */
    private Numero crearNumero()    {
        System.out.println("Introduzca un n�mero");
        int num =  teclado.nextInt();  
        if (numero == null) {
            numero = new Numero(num);
        }
        else {
            numero.setNumero(num);
        }
        return numero;
    }

    /**
     * Presenta un men� en la pantalla
     * para que el usuario pueda elegir su opci�n
     * @return  devuelve la opci�n seleccionada
     */ 

    private int menu()    {

        System.out.println(" ..........................................................");
        System.out.println(" Elige una opci�n ......");
        System.out.println(" ..........................................................");
        System.out.println(" 1.- Solicitar nuevo numero");
        System.out.println(" 2.- Factorial");
        System.out.println(" 3.- Primo");
        System.out.println(" 4.- Escribir figura");
        System.out.println(" 5.- Contar cifras");
        System.out.println(" 6.- Comprobar capic�a");
        System.out.println(" 7.- A base 8");
        System.out.println(" 8.- Est� cifra");
        System.out.println(" 9.- Hay cifras repetidas");
        System.out.println(" 10.- A base 2");      
        System.out.println(" 11.- Salir");
        int opcion = leerOpcion();
        while (!opcionValida(opcion))  {
            opcion = leerOpcion();
        }      
        return opcion;
    }

    /**
     *  lee una opci�n y la devuelve
     *
     *  
     */
    private int leerOpcion()    {
        System.out.println("Dame opci�n");
        return teclado.nextInt();
    }

    /**
     *  devuelve true si una opci�n es v�lida, false en otro caso
     *  
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= NUEVO_NUMERO && opcion <= SALIR;
    }

    /**
     * mostrar el factorial
     */
    private void factorial()    { 
        borrarPantalla();
        System.out.println("El factorial de " +
            numero.getNumero() + " es " + numero.factorial());
    }

    /**
     * indicar si es primo
     */
    private void primo()    { 
        borrarPantalla();
        System.out.println("El n� " +
            numero.getNumero() + " es primo? " + numero.esPrimo());
    }

    /**
     * escribir figura
     */
    private void escribirFigura()    { 
        borrarPantalla();
        numero.escribirFigura(); 
    }

    /**
     * contarCifras
     */
    private void contarCifras()    { 
        borrarPantalla();
        System.out.println(numero.getNumero() + " tiene  " +
            numero.contarCifras() + " cifras");  
    }

    /**
     * Mostrar si es o no capic�a
     */
    private void esCapicua()    { 
        borrarPantalla();
        System.out.println(numero.getNumero() + " es capic�a?  " +
            numero.esCapicua());  
    }

    /**
     * muestra el n� en base 8
     */
    private void aBase8()   { 
        borrarPantalla();
        System.out.println(numero.getNumero() + " en base 8 =  " +
            numero.aBase8());

    }

    /**
     * muestra el n� en base 2
     */
    private void aBase2()    { 
        borrarPantalla();
        System.out.println(numero.getNumero() + " en base 2 =  " +
            numero.aBase2()); 

    }

    /**
     *  Muestra si hay o no cifras repetidas en el n�mero
     *  
     */
    public void hayCifrasRepetidas()    {
        borrarPantalla();
        System.out.println("El n�mero " + numero.getNumero() + " tiene cifras repetidas? " +
            numero.hayCifrasRepetidas()); 
    }

    /**
     *  Pide una cifra e indica si est� o no en el n�
     *  
     */
    public void estaCifra()    {
        borrarPantalla();
        System.out.println("Dame cifra: ");
        int cifra = teclado.nextInt();
        if (numero.estaCifra(cifra))   {
            System.out.println("La cifra " + cifra + " est� en el n�");
        }
        else     {
            System.out.println("La cifra " + cifra + " no est� en el n�");
        }
    }

    /**
     * Borrar la pantalla  
     */
    private void borrarPantalla()    {
        System.out.print('\u000C');
    }

}

