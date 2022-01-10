
public class Participante 
{
    private String nombre;
    private Participante emisor;
    private Participante receptor;

    /**
     * Constructor
     * Cuando se crea un participante emisor y receptor
     * est�n a null (ni se regala ni se recibe de nadie)
     */
    public Participante(String nombre) {
        super();
        this.nombre = nombre.toUpperCase();
        this.emisor = null;
        this.receptor = null;
    }

    /**
     * accesor para el nombre del participante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre del participante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para el emisor del participante
     * (a qui�n regala)
     */
    public Participante getEmisor() {
        return emisor;
    }

    /**
     * mutador para el emisor del participante
     * Establecer a qui�n regala
     */
    public void setEmisor(Participante emisor) {
        this.emisor = emisor;
    }

    /**
     * accesor para el receptor (de qui�n recibe)
     */
    public Participante getReceptor() {
        return receptor;
    }

    /**
     * mutador para el receptor (establecer de qui�n recibe)
     */
    public void setReceptor(Participante receptor) {
        this.receptor = receptor;
    }

    /**
     * Representaci�n textual del participante
     */
    public String toString() {
        String str = nombre + " env�a a ";

        if (emisor == null) {
            str += " NADIE";
        } else {
            str += emisor.getNombre();
        }
        str += " y recibe de ";
        if (receptor == null) {
            str += " NADIE";
        } else {
            str += receptor.getNombre();
        }
        return str;
    }
}
