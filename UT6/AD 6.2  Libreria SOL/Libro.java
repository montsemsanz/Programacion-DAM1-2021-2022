/**
 * Describe un libro de la biblioteca
 *
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro 
{
    private String titulo;
    private String autor;
    private int paginas;  
    private Estado estado;
    private String fechaPrestamo;

    /**
     * Constructor de la clase Libro
     * 
     * 
     */
    public Libro(String titulo, String autor, int paginas)    {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.estado = Estado.NOPRESTADO;
        this.fechaPrestamo = "";

    }

    /**
     * 
     * @return accesor para el titulo
     *       
     */
    public String getTitulo()     {       
        return titulo;
    }

    /**
     * 
     * @return devuelve el autor
     */
    public String getAutor()     {        
        return autor;
    }

    /**
     * 
     * @return devuelve el n� de p�ginas 
     */
    public int getPaginas()     {        
        return paginas;
    }

    /**
     * @return devuelve el estado del libro
     */
    public Estado getEstado()    {        
        return estado;
    }

    /**
     * Indica si est� prestado
     */
    public boolean  estaPrestado()    {        
        return estado == Estado.PRESTADO;
    }

    /**
     * Mutador para prestar el libro
     * S�lo se puede prestar un libro 
     * no prestado anteriormente
     * Al prestar un libro cambia su estado
     * y la fecha en la que se prest�
     */
    public void prestar()    {        
        if (estado == Estado.NOPRESTADO)    {
            estado = Estado.PRESTADO;
            fechaPrestamo = obtenerFechaPrestamo();
        }
        else     {
            System.out.println("Ya est� prestado");
        }
    }

    /**
     * Mutador para devolver un libro
     * S�lo se puede devolver un libro 
     * prestado anteriormente
     * Al prestar un libro cambia su estado
     * y la fecha en la que se prest� vuelve 
     * a ser ""
     */
    public void devolver()
    {        
        if (estado == Estado.PRESTADO)     {
            estado = Estado.NOPRESTADO;
            fechaPrestamo = "";
        }
        else   {
            System.out.println("No hab�a sido prestado");
        }
    }

    /**
     * @return la fecha de pr�stamo que es la fecha actual
     *          en formato String
     */
    private String obtenerFechaPrestamo()    {
        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return hoy.format(formato);

    }

    /**
     * 
     * @return representaci�n textual del libro
     */
    public String toString()    {
        String str = "Titulo: " + getTitulo() +
            "\nAutor: " + getAutor() +
            "\nN� p�ginas: " + getPaginas() + 
            "\nEstado: " + estado.toString();
        if (estaPrestado())    {
            str = str + " (" + fechaPrestamo + ")";
        }
        str += "\n";
        return str;
    }

}
