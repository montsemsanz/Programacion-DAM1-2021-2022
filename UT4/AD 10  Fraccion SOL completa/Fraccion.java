
/**
 * La clase modela un n� racional, una fracci�n
 * representada por su numerador y denominador
 * 
 */
public class Fraccion
{  
    private int numerador;  
    private int denominador;

    /**
     *
     * Constructor  
     */
    public  Fraccion()   {
        numerador = 0;
        denominador = 0;
    }   
    /**
     * constructor para los objetos de la clase Fraccion
     */
    public Fraccion(int numerador, int denominador)   {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
         
    }  
    
    /**
     * Mutador para simplificar una fracci�n
     */
    private void simplificar()    {
        int maxComunDividor = mcd(numerador, denominador);
        numerador = numerador / maxComunDividor;
        denominador = denominador / maxComunDividor;
    }
    
     /**
     * Calcula el m�ximo com�n divisor de dos n�s
     */
    private int mcd(int num1, int num2)    {
        
        int resto = num1 % num2;
        while (resto != 0) {
            num1 = num2;
            num2 = resto;
            resto = num1 % num2;
        }
        return num2;
    }
    /**
     * Accesor para la numerador
     */
    public int getNumerador()    {
       return numerador;
    }
    
     /**
     * Accesor para el denominador
     */
    public int getDenominador()    {
       return denominador;
    }
    
    /**
     * Mutador para el numerador
     */
    public void setNumerador(int numerador)    {
       this.numerador = numerador;
    }
    
    /**
     * Mutador para el denominador
     */
    public void setDenominador(int denominador)    {
       this.denominador = denominador;
    }  
    
    /**
     * Suma la fracci�n actual por la que 
     * se recibe como par�metro
     * @param otra fraccion con la que sumar
     * @return  la suma de dos  fracciones
     */
    public Fraccion sumar(Fraccion otra)    {
        int nume = numerador * otra.getDenominador() + 
                    denominador * otra.getNumerador();
        int deno = denominador * otra.getDenominador();
        Fraccion suma = new Fraccion(nume, deno);
        return suma;
    }
    
     /**
     * Resta la fracci�n actual por la que 
     * se recibe como par�metro
     * @param otra  fracci�n con la que se resta
     * @return  la resta  de dos fracciones
     */
    public Fraccion restar(Fraccion otra)    {
        int nume = numerador * otra.getDenominador() -
                    denominador * otra.getNumerador();
        int deno = denominador * otra.getDenominador();
        Fraccion resta  = new Fraccion(nume, deno);
        return resta;
    }
    
    /**
     * Multiplica la fracci�n actual por la que 
     * se recibe como par�metro
     * @param otra fraccion por la que se multiplica
     * @return  el producto de dos fracciones
     */
    public Fraccion multiplicar(Fraccion otra)    {
        
        int nume = numerador * otra.getNumerador();
        int deno = denominador * otra.getDenominador();
        Fraccion producto = new Fraccion(nume, deno);
        return producto;
    }
    
    /**
     * Divide la fracci�n actual entre la que 
     * se pasa como par�metro
     * @param otra  fraccion entre la que se dividir�
     * @return  el cociente de dos fracciones
     */
    public Fraccion dividir(Fraccion otra)    {
        int nume = numerador * otra.getDenominador();
        int deno = denominador * otra.getNumerador();
        Fraccion division = new Fraccion(nume, deno);
        return division;
    }
    
    /**
     * Compara dos fracciones, la actual y 
     * la recibida como par�metro
     * @param otra la fracci�n con la que comparar
     * @return true si son iguales
     */
    public boolean igualQue(Fraccion otra)    {
        double esta = (double) numerador / denominador;
        double laOtra = (double) otra.getNumerador() /  otra.getDenominador();
        return esta == laOtra;
        
      
    }
    
     /**
     * Compara dos fracciones, la actual y 
     * la recibida como par�metro
     * @param otra la fracci�n con la que comparar
     * @return true si la fracci�na actual es 
     *          menor que la recibida como par�metro
     */
    public boolean menorQue(Fraccion otra)    {
        double esta = (double) numerador /  denominador;
        double laOtra = (double) otra.getNumerador() /  otra.getDenominador();
        return esta < laOtra;
    }
    
    /**
     *
     * @return  la fracci�n actual clonada   
     */
    public Fraccion clonar()    {
        return new Fraccion(this.numerador, this.denominador);
    }
    
    /**
     * Representaci�n textual de la fracci�n
     */
    
    public String toString()    {
        return numerador + " / " + denominador;
        
    }
                
}
