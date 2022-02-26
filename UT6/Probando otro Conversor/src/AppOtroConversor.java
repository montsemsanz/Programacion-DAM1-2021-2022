import otroconversor.romanos.ConversorRomanos;

import java.util.Scanner;

public class AppOtroConversor {
    public static void main(String[] args) {
        ConversorRomanos conversor = new ConversorRomanos();
        Scanner teclado = new Scanner(System.in);
        for (int i = 1; i <= 4; i++)   {
            System.out.print("Dame n� ar�bigo: ");
            int numero = teclado.nextInt();
            System.out.println("Su romano es: " + conversor.aRomano(numero));
        }
        System.out.println("-----------------------");
        teclado.nextLine();
        for (int i = 1; i <= 4; i++)     {
            System.out.print("Dame n� romano: ");
            String romano = teclado.nextLine();
            System.out.println("Su ar�bigo es: " + conversor.aArabigo(romano));
        }
    }

}
