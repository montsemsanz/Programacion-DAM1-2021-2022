package ut6.romanos.demo;

import ut6.romanos.modelo.ConversorRomanos;
import ut6.romanos.modelo.GestorRomanos;

/**
 * La clase que inicia el gestor de romanos
 *
 */
public class AppRomanos {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error, Usage: java AppRomanos " +
                    "<romano1> " +
                    "<romano2> <romano3> ...." +
                    " ");
        } else {
            GestorRomanos gestor =
                    new GestorRomanos(new ConversorRomanos());
            gestor.addRomanos(args);
            System.out.println(gestor);
            
        }
        
    }
    
    
}
