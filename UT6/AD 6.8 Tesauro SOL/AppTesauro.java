


/**
 * Clase AppTesauro -  incluye el m�todo main()
 * Arranca la aplicaci�n
 */
public   class AppTesauro
{
     
    /**
     * 
     */
    public static void main(String[] args)    {
         Tesauro tesauro = new Tesauro();
         tesauro.a�adirSinonimo("obeso gordo");
         tesauro.a�adirSinonimo("delgado enjuto fino flaco");
         tesauro.a�adirSinonimo("delegar encargar encomendar facultar");
         tesauro.a�adirSinonimo("excelente brillante colosal exquisito estupendo soberbio");
         tesauro.a�adirSinonimo("maravilloso estupendo magnifico excelente soberbio");
         tesauro.a�adirSinonimo("estupendo soberbio magnifico superior maravilloso");
         tesauro.escribirTesauro();
         
         String sinonimo = "soberbio";
         System.out.println("Se va a borrar el sin�nimo " + sinonimo);
         System.out.println("Se ha borrado de las siguientes claves " + tesauro.borrarSinonimo(sinonimo).toString());
         
         tesauro.escribirTesauro();
         
          
         
    }
}
