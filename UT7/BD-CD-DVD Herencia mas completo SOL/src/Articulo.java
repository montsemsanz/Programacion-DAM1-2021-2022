/**
 * La clase Articulo representa un art�culo multimedia.
 * La informaci�n sobre el art�culo se almacena y 
 * puede ser extra�da.
 * Esta clase sirve como superclase para articulos m�s
 * espec�ficos.
 */
public class Articulo
{
    private String titulo;
    private int duracionTotal;
    private boolean hayCopia;
    private String comentario;

    /**
     * Inicializar los atributos del art�culo
     */
    public Articulo(String elTitulo, int duracion)
    {
        titulo = elTitulo;
        duracionTotal = duracion;
        hayCopia = false;
        comentario = "";
    }

    /**
     * Introducir un comentario del art�culo
     */
    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * Devolver el comentario del art�culo
     */
    public String getComentario()
    {
        return comentario;
    }

    /**
     * Establecer el flag que indica si se tiene una copia o no
     */
    public void setHayCopia(boolean hay)
    {
        hayCopia = hay;
    }

    /**
     * Devolver el flag que indica si se tiene una copia o no
     */
    public boolean getHayCopia()
    {
        return hayCopia;
    }

    /**
     * accesor para la duraci�n del art�culo
     */
    public int getDuracion()
    {
        return duracionTotal;
    }

    /**
     * Escribir detalles sobre el art�culo
     */
    public void print()
    {
        System.out.println("--------------------------");
        System.out.println("T�tulo: " + titulo + " (" + duracionTotal + " mins)");
        if(hayCopia) 
        {
            System.out.print(" * ");
        }        
        if (!comentario.isEmpty())
            System.out.println("\t" + comentario);
    }
}
