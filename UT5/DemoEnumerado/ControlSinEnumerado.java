
/**
 * Los objetos de esta clase mantienen un atributo nivel
 */
public class ControlSinEnumerado
{
     
    private static final int BAJO = 0;
    private static final int MEDIO = 1;
    private static final int ALTO = 2;
    private int nivel;

    /**
     * Constructor iniicializa nivel a BAJO 
     */
    public ControlSinEnumerado()    {
         nivel = BAJO;
    }

    /**
     *  devuelve el valor actual de nivel
     */
    public int getNivel()    {
         return nivel;
    }
    
     /**
     *  devuelve el valor actual de nivel
     */
    public void setNivel(int nivel)    {
         this.nivel = nivel;
    }
}
