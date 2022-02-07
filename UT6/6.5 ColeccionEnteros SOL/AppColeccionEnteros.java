
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class AppColeccionEnteros
{

    public static void main(String[] args)    {
        ColeccionEnteros coleccion = new ColeccionEnteros();
        System.out.println("Lista original: " + coleccion);
        System.out.println("----------------");

        ArrayList<Integer> ordenada = coleccion.ordenar();
        System.out.println("Lista ordenada: \t " + ordenada);

        System.out.println("----------------");

        ArrayList<Integer> otra =  new ArrayList<>();
        otra.addAll(Arrays.asList(5, 8, 8, 10, 12, 18, 14, 13));
        coleccion.elementosComunes(otra);
        System.out.println("Original: " + coleccion + " Otra: " + otra);
        System.out.println("Original con elementos comunes \t " + coleccion);

        System.out.println("----------------");

        coleccion.add(18);
        coleccion.add(7);
        System.out.println("Original: " + coleccion + " Otra: " + otra);
        coleccion.elementosDiferentes(otra);
        System.out.println("Original con elementos diferentes \t " + coleccion);
    }

}
