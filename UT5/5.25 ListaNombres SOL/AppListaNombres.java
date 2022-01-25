import java.util.Arrays;
/**
 * 
 * Acepta como argumento del main el tama�o m�ximo de la lista
 * Si no se pasan argumentos se muestra un mensaje de error, se le informa al usuario
 * de la sintaxis a utilizar y se acaba el programa
 * 
 * En otro caso se crea la lista y:
 *  - se llama al m�todo cargarDeFichero() 
 *  - se muestra la lista
 *  - se muestra el nombre m�s largo
 *  - se borran los que empiezan por 'r'
 *  - se muestra la lista
 *  - se muestra cu�ntos empiezan por 'aL'
 *  - se muestran los nombres que empiezan por "a"
 */
public class AppListaNombres
{

    /**
     *  
     */
    public static void main(String[] args)    {
        if (args.length != 1)     {
            System.out.println("Error en n� de argumentos\nSintaxis:java AppListaNombres <n>");

        }
        else {
            int n = Integer.parseInt(args[0]);
            ListaNombres lista = new ListaNombres(n);
            lista.cargarDeFichero();
            System.out.println("Despu�s de insertar"); 
            System.out.println(lista.toString());

            System.out.println("El nombre m�s largo es " + lista.nombreMasLargo());
            lista.borrarLetra('r');
            System.out.println("\nDespu�s de borrar los que empiezan por \'r\' \n" + lista.toString());

            System.out.println("Empiezan por \'aL\' " + lista.empiezanPor("aL")); 

            String[] porA = lista.empiezanPorLetra('a');
            System.out.println("Empiezan por \'a\' ");
            for (int i = 0; i < porA.length; i++)     {
                System.out.print(porA[i] + "\t");
            }
            System.out.println();
            
            
            System.out.println("Antes de invertir");
            System.out.println(lista.toString());
            System.out.println("Despu�s de invertir");         
            System.out.println(Arrays.toString(lista.invertir()));

        }
    }
}
