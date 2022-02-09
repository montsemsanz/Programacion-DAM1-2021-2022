
/**
 * 
 */

public class TestUrna
{
    public static void main (String[] args)    {
        if (args.length != 1)    {
            System.out.println("N�mero incorrecto de par�metros\nUsage: java TestUrna <n>");
            return;
        }
        int cuantasBolas = Integer.parseInt(args[0]);
        Urna urna = new Urna();
        for (int i = 1; i <= cuantasBolas; i++)   {
            urna.meterBola(new Bola());
        }
        System.out.println("Despu�s de a�adir " + cuantasBolas + " bolas");
        urna.mostrarUrna();
        System.out.println("Hay " + urna.cuantasBlancas() + " bolas blancas");
        System.out.println("Hay " + urna.cuantasNegras() + " bolas negras");
        
        urna.borrarBlancas();
        System.out.println("Despu�s de borrar las bolas blancas ");       
        urna.mostrarUrna();

    }

}
