
/**
 * La clase modela un n� exponencial y permite realizar operaciones
 * con exponenciales
 * 
 */
public class Exponencial
{
    // cada objeto de la clase almacena la base y el exponente de un n� exponencial
    private int base;  
    private int exponente;

    /**
     * constructor para los objetos de la clase Exponencial
     * Construtor de un n� exponecial a partir de una base y exponente
     * @param base la base del n�
     * @param exponente el exponente del n�
     */
    public Exponencial(int base, int exponente)    {
        this.base = base;
        this.exponente = exponente;
    }

    /**
     * constructor para los objetos de la clase Exponencial
     * Construtor de un n� exponecial a partir de otro
     * @param otro el n� exponencial con el que se construir�
     * el actual
     */
    public Exponencial(Exponencial otro)    {
        base = otro.getBase();
        exponente = otro.getExponente();
    }

    /**
     * Accesor para la base
     */
    public int getBase()    {
        return base;
    }

    /**
     * Accesor para el exponente
     */
    public int getExponente()    {
        return exponente;
    }

    /**
     * Mutador para la base
     */
    public void setBase(int base)    {
        this.base = base;
    }

    /**
     * Mutador para el exponente
     */
    public void setExponente(int exponente)    {
        this.exponente = exponente;
    }

    /**
     * calcula a elevado a b
     * b siempre es un valor >= 0
     * 
     * 
     */
    private int potencia(int a, int b)    {
        int resul = 1;

        for (int i = 1; i <= b; i++)  {
            resul = resul * a;
        }
        return resul;
    }      

    /**
     * @return el valor exponencial del n�
     */
    public double valorExponencial()    {
        double resultado;
        int poten = potencia(base , Math.abs(exponente));
        if (exponente < 0)     {
            resultado = (double) 1 / poten;
        }
        else   {
            resultado = poten;
        }
        return resultado;
    }

    /**
     * Multiplica el actual n� exponencial por el que 
     * se recibe como par�metro
     * @param otro  n� exponencial por el que se multiplica
     * @return  el producto de dos n�s exponenciales
     */
    public Exponencial multiplicar(Exponencial otro)   {
        Exponencial tmp = new Exponencial(base, exponente + otro.getExponente());
        return tmp;
    }

    /**
     * Divide el actual n� exponencial entre el que 
     * se recibe como par�metro
     * @param otro  n� exponencial entre el que se dividir�
     * @return  el cociente de dos n�s exponenciales
     */
    public Exponencial dividir(Exponencial otro)   {
        Exponencial tmp = new Exponencial(base, exponente - otro.getExponente());
        return tmp;
    }

    /**
     * Eleva a una potencia un n� exponencial
     * 
     * @param n potencia a la que se eleva el n�
     * @return  nuevo n� exponencial elevado a n
     */
    public Exponencial elevar(int n)   {
        return new Exponencial(base, exponente * n);
    }

    /**
     * Representaci�n textual del n�mero
     */
    public String toString()
    {
        return "Base:" + base +
            "\tExponente:" + exponente + "\n\tValor: " +
            this.valorExponencial();
       
    }

}
