
/**
 * Modela la interfaz con el usuario
 *
 */
import java.util.Scanner;
public class InterfazJuego
{
    private static Scanner teclado = new Scanner(System.in);
    private JuegoNumeroSecreto juego;

    /**
     * Constructor de la clase InterfazJuego
     */
    public InterfazJuego()    {

        juego = new JuegoNumeroSecreto();
    }

    /**
     * 
     * Controla la l�gica del juego, se le pregunta al usuario si desea jugar,
     * si es as� se hace una presentaci�n del juego y se prepara �ste para empezar
     * a jugar. Se le solicitan diferentes n�meros al usuario
     * hasta que lo adivina o se le agotan los 
     * intentos, es decir, hasta que acaba el juego
     * Cuando el juego termina se da la posibilidad de jugar de nuevo.
     * As� hasta que el usuario dice que no quiere continuar
     *     
     *  Esta versi�n con do .. while
     */
    public void jugar()    {
        char respuesta;
        do  {   
            presentacionJuego();
            // jugar una vez
            juego.resetJuego();
            while (!juego.haTerminado())      {
                int intento = leerNumero();
                juego.realizarJugada(intento);
                System.out.println(juego.getResultado());

            }
            teclado.nextLine(); //ignoro el salto de l�nea del buffer
            respuesta = seguirJugando("�Quieres jugar otra vez ( S/s) ?");

        }
        while (respuesta == 'S' || respuesta == 's');

    }

    /**
     * 
     * Controla la l�gica del juego, se le pregunta al usuario si desea jugar,
     * si es as� se hace una presentaci�n del juego y se prepara �ste para empezar
     * a jugar. Se le solicitan diferentes n�meros al usuario
     * hasta que lo adivina o se le agotan los 
     * intentos, es decir, hasta que acaba el juego
     * Cuando el juego termina se da la posibilidad de jugar de nuevo.
     * As� hasta que el usuario dice que no quiere continuar
     *     
     */
    public void jugarV2()    {
        char respuesta = seguirJugando("Quieres jugar? (S / s)");  
        boolean fin =  (respuesta != 'S' && respuesta != 's');
        while (!fin)   {   
            presentacionJuego();
            // jugar una vez
            juego.resetJuego();
            while (!juego.haTerminado())      {
                int intento = leerNumero();
                juego.realizarJugada(intento);
                System.out.println(juego.getResultado());

            }
            teclado.nextLine(); //ignoro el salto de l�nea del buffer
            respuesta = seguirJugando("�Quieres jugar otra vez ( S/s) ?");
            fin = (respuesta != 'S' && respuesta != 's');
        }

    }

    /**
     * Solicitar al usuario un n�
     * @return el n�mero tecleado
     */
    private int leerNumero()    {
        System.out.println("Piensa un n�");
        return teclado.nextInt();
    }

    /**
     * Mensaje de bienvenida al juego
     */
    private void presentacionJuego()    {
        borrarPantalla();
        System.out.println("*************************************************************");
        System.out.println("     Para jugar piensa un n� entre 1 y 100   ");
        System.out.println("     Has de adivinar un n� secreto en  " +  juego.getMaximoIntentos() + 
            " intentos          ");
        System.out.println("*************************************************************");
    }

    /**
     * Borrar la pantalla  
     */
    private void borrarPantalla()    {
        System.out.print('\u000C');
    }

    /**
     * Indicar al usuario si desea jugar otra vez 
     * Devuelve la respuesta del usuario
     * @return un caracter solicitado al usuario
     */
    private char seguirJugando(String mensaje)    {

        System.out.println(mensaje);
        char tecla = teclado.nextLine().charAt(0);  
        return tecla;
    }
}
