
/**
 *  
 */
import java.util.Scanner;
public class InterfazTexto
{
    private final int INGRESO = 1;
    private final int REINTEGRO = 2;
    private final int CONSULTA = 3;
    private final int IMPRIMIR = 4;
    private final int SALIR = 5;

    private Cuenta cuenta;
    private Scanner teclado;

    /**
     * Constructor de la clase InterfazUsuario
     */
    public InterfazTexto()    {
        teclado = new Scanner(System.in);
    }

    /**
     * Controla la l�gica de la aplicaci�n
     */
    public void iniciar()    {
        borrarPantalla();
        System.out.println("Introduzca el n�mero de cuenta");
        int numeroCuenta = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Introduzca el nombre del titular");
        String titular = teclado.nextLine();
        cuenta = new Cuenta(numeroCuenta, titular);  
        int opcion = menu();
        while (opcion != SALIR)       {
            switch (opcion)         {       
                case INGRESO:
                realizarIngreso();
                break;
                case REINTEGRO:
                realizarReintegro();
                break;
                case CONSULTA:
                consultarSaldo();
                break;
                case IMPRIMIR:
                imprimirDatosCuenta();
                break;

            }  
            opcion = menu();
        }
        System.out.println("��� Fin de la aplicaci�n bancaria !!!!");

    }

    /**
     * M�todo privado que pide la cantidad a ingreasar y lo ingresa en la cuenta
     */

    private void realizarIngreso()    {
        double cantidad;  
        System.out.println("Introduzca cantidad a ingresar ");  
        cantidad = teclado.nextDouble();
        cuenta.ingresar(cantidad);
    }

    /**
     * M�todo privado que pide la cantidad a reintegrar y lo saca de la cuenta
     */
    private void realizarReintegro()   {
        double cantidad;  
        System.out.println("Introduzca cantidad a reintegrar ");  
        cantidad = teclado.nextDouble();
        cuenta.reintegrar(cantidad);
    }

    /**
     * M�todo privado que muestra el saldo
     */
    private void consultarSaldo()    { 
        System.out.println("El saldo de su cuenta es  " +
            cuenta.getSaldo());  
    }

    /**
     * M�todo privado que muestra los datos de la cuenta
     */
    private void imprimirDatosCuenta()    { 
        System.out.println("Datos de la cuenta");
        System.out.println(cuenta.toString());
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
        System.out.println(" 1.- Ingreso");
        System.out.println(" 2.- Reintegro");
        System.out.println(" 3.- Consulta saldo");
        System.out.println(" 4.- Imprimir datos cuenta");
        System.out.println(" 5.- Salir");
        int opcion = leerOpcion(" Teclea opci�n....");
        while (!opcionValida(opcion))   {
            opcion = leerOpcion("Error, Teclea opci�n correcta ....");

        }
        return opcion;
    }

    /**
     *  Pide y devuelve una opci�n
     *  
     */
    private int  leerOpcion(String mensaje)    {
        System.out.println(mensaje);
        int opcion = teclado.nextInt();
        return opcion;
    }

    /**
     * Valida que una opci�n est� entre 1 y 5
     */
    private boolean opcionValida(int opcion)    {
        return opcion >= INGRESO && opcion <= SALIR;
    }

    /**
     * Borrar la pantalla  
     */
    private void borrarPantalla()    {
        System.out.print('\u000C');
    }

}
