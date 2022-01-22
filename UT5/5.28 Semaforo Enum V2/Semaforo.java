
/**
 * Modela un sem�foro
 * http://javarevisited.blogspot.com.es/2011/08/enum-in-java-example-tutorial.html
 */
public class Semaforo
{
   private ColorSemaforo estado;  

    /**
     * Constructor de la clase Semaforo
     */
    public Semaforo()    {
        estado = ColorSemaforo.VERDE;
    }

    /**
     * accesor 
     */
    public   ColorSemaforo getEstado()    {
        return estado;
    }

    /**
     * mutador, cambia el estado del sem�foro
     */
    public  void  cambiarEstado()     {
        switch (estado)
        {
            case VERDE: estado = ColorSemaforo.AMARILLO;
                        break;
            case ROJO:  estado = ColorSemaforo.VERDE;
                        break;
            case AMARILLO:  estado = ColorSemaforo.ROJO;
                        break; 
        }
         
    }

    /**
     * Devuelve los colores del sem�foro en formato String
     */
    public String getColoresSemaforo()     {
        String str = "";
        ColorSemaforo[]  colores = ColorSemaforo.values();
        for (int i = 0; i < colores.length; i++) {
            str = str + colores[i].toString() + "\t" + colores[i].getSegundos() + " sg.";
        }
            
        return str;
    }

    /**
     * Representaci�n textual del color del sem�foro    
     */
    public String toString()    {

        return estado.toString();
    }
}
