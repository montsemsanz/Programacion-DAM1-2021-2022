
/**
 * La clase JuegoNumeroSecreto modela las reglas del
 * juego y guarda el estado del mismo
 * 
 */
import java.util.Random;
public class JuegoNumeroSecreto
{
    private static final int MAX_INTENTOS = 5;
    private int numeroSecreto;
    private Contador intentos;
    private boolean terminado;   
    private String resultado; // aqu� se deja el mensaje "M�s alto", "M�s bajo", "Has adivinado el n�", ......
    private static Random generador = new Random();

    /**
     * Constructor de la clase JuegoNumeroSecreto
     * crea el generador y el contador de intentos y prepara
     * el juego para empeazr a jugar
     */
    public JuegoNumeroSecreto()    {
        intentos = new Contador();
        resetJuego();
    }

    /**
     * Prepara todo para empezar a jugar,
     * genera un n� secreto, el contador de intentos se pone otra vez a 0
     * etc, .......
     *   
     */
    public void resetJuego()    {
        numeroSecreto = generador.nextInt(100) + 1; 
        intentos.reset();
        terminado = false;
        resultado = "";
    }

    /**
     * 
     * Accesor para el n� de intentos 
     */
    public int getIntentos()    {
        return intentos.getContador();
    }

    /**
     * 
     * Devuelve el m�ximo n� de intentos permitidos
     */
    public int getMaximoIntentos()    {
        return MAX_INTENTOS;
    }

    /**
     * Aumenta el n� de intentos por parte del usuario
     */

    public void incrementarIntentos()    {
        intentos.incrementar();
    }

    /**
     * Simula una �nica jugada
     * 
     * Cada nueva jugada es un intento m�s. Habr� que comprobar si 
     * ha acertado o no y si ha consumido todos sus intentos actualizando el estado
     * del juego adecuadamente. El resultado "M�s alto", "M�s bajo", .... se deja
     * en resultado
     * 
     * @param intentado el n� intentado
     */
    public void realizarJugada(int intentado)    {

        incrementarIntentos();
        if (getIntentos() == MAX_INTENTOS || intentado == numeroSecreto)     {
            terminado = true;
            if (numeroSecreto == intentado)     {

                resultado = "Enhorabuena has adivinado el n�mero " + numeroSecreto + 
                "\nen " + getIntentos() + " intentos";   
            }
            else    {
                resultado = "Lo siento, has agotado los " + MAX_INTENTOS + " intentos " +
                "\nEl n� secreto era " + numeroSecreto;
            }
        }
        else  if (numeroSecreto < intentado)     {
            resultado = " M�s bajo";
        }
        else    {
            resultado = " M�s alto";
        }

    }

    /**
     * 
     * Accesor que devuelve el valor del atributo terminado
     *  
     */
    public boolean haTerminado()   {        
        return terminado;
    }

    /**
     * Accesor para el resultado obtenido
     */
    public String getResultado()    {        
        return resultado;
    }

}
