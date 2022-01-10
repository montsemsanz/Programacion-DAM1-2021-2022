import java.util.Arrays;
import java.util.Random;

public class JuegoAmigoInvisible {
    private static final int MAX_PARTICIPANTES = 50;
    private static Random generador = new Random();
    private Participante[] participantes;
    private int pos;

    /**
     * crea la "bolsa" de participantes al tama�o m�ximo
     */
    public JuegoAmigoInvisible() {
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.pos = 0;
    }

    /**
     * A�ade un participante al final de la bolsa si no est� llena
	 * se asume que el participante no existe
     */
    public void add(Participante participante) {
        if (pos < participantes.length) {
            participantes[pos] = participante;
            pos++;
        }

    }

    /**
     * devuelve el total de participantes
     */
    public int totalParticipantes() {
        return pos;

    }

    /**
     * devuelve una copia con el n�mero real de participantes
     */
    public Participante[] getParticipantes() {
        return Arrays.copyOf(participantes, pos);

    }

    /**
     * dado un nombre de participante devuelve la posici�n donde se encuentra o -1 si 
     * no est�
     * Nota -  para comparar cadenas haremos cadena1.equalsIgnoreCase(cadena2) 
     * que devuelve true si cadena1 es igual a cadena2 
     * (sin importar may�sculas o min�sculas)
     */
    private int buscarParticipante(String nombre) {
        for (int i = 0; i < pos; i++) {
            if (participantes[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *  dado un nombre de participante indica si est� ya en la bolsa
     */
    public boolean estaParticipante(String nombre) {
        return buscarParticipante(nombre) != -1;

    }

    /**
     * dado un nombre de participante devuelve el objeto asociado a �l 
     *  
     */
    public Participante datosDe(String nombre) {
        nombre = nombre.toUpperCase();
        int p = buscarParticipante(nombre);
        if (p == -1) {
            throw new RuntimeException("Error, no existe ese participante");
        }
        return participantes[p];
    }

    /**
     * Representaci�n textual de todos los participantes
     *  
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            sb.append(participantes[i]).append("\n");

        }
        return sb.toString();
    }

    /**
     * "Revuelve" la bolsa de participantes. 
     * Se puede hacer de forma sencilla
     * intercambiando un n� determinado de veces pares de elementos 
     * del array participantes de posiciones aleatorias
     * 
     */
    public void revolverParticipantes() {
        for (int i = 1; i <= 50; i++) {
            int p1 = generador.nextInt(pos);
            int p2 = generador.nextInt(pos);
            Participante aux = participantes[p1];
            participantes[p1] = participantes[p2];
            participantes[p2] = aux;
        }
    }

    /**
     * Elimina todas las asignaciones de emisor y receptor
     * de todos los participantes
     */
    public void reset() {
        for (int i = 0; i < pos; i++) {
            participantes[i].setEmisor(null);
            participantes[i].setReceptor(null);
        }
    }

    /**
     * Realiza la asignaci�n a cada participante del amigo invisible
     * previo "barajeo" de la bolsa inicial
     */
    public void asignarAmigos() {
        reset();
        revolverParticipantes();

        for (int i = 1; i < pos; i++) {
            participantes[i - 1].setEmisor(participantes[i]);
            participantes[i].setReceptor(participantes[i - 1]);
        }
        participantes[pos - 1].setEmisor(participantes[0]);
        participantes[0].setReceptor(participantes[pos - 1]);

    }

    /**
     * dado un participante lo borra. Se devuelve true si la operaci�n ha tenido �xito 
     * (estaba el participante) o false si no ha habido �xito (el participante no exist�a)
     * Cada vez que se borra un participante hay que eliminar 
     * todas las asignaciones de emisor y receptor
     */
    public boolean borrarParticipante(String nombre) {
        boolean exito = true;
        int p = buscarParticipante(nombre);
        if (p != -1) {
            System.arraycopy(participantes, p + 1, participantes, p,
                pos - p - 1);
            pos--;
            reset();
        } else {
            exito = false;
        }
        return exito;
    }

    /**
     * borra todos los participantes
     */
    public void borrarTodos() {
        this.pos = 0;
    }


}
