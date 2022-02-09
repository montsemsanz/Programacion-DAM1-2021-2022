
/**
 *  
 */
public class DemoMapPaises
{

    public static void main(String[] args)    {
        MapPaises map = new MapPaises();
        map.addPais("Portugal", "Lisboa");
        map.addPais("Francia", "París");
        map.addPais("Irlanda", "Dublín");
        map.addPais("España", "Madrid");
        map.addPais("Italia", "Roma");
        map.addPais("Alemania", "Berlín");
        map.addPais("peru", "Lima");
        map.addPais("austria", "viena");

        map.mostrarPaisesV1();
        System.out.println("\nTotal paises " + map.totalPaises());
        String pais = "Portugal";
        String capital = map.capitalDe(pais);
        if (capital != null) {
            System.out.println("\nCapital de " + pais + " = " + map.capitalDe(pais));
        }
        else {
            System.out.println("\nNo existe el país " + pais);
        }
        if (map.estaPais(pais)) {
            System.out.println("\nCapital de " + pais + " = " + map.capitalDe(pais));
        }
        map.borrarPais(pais);
        map.mostrarPaisesV3();

        System.out.println("\nCapitales presentes en el map " + map.grupoCapitales().toString());

        map.addPais("Portugal", "Lisboa");
        map.addPais("peru", "Lima");
        map.addPais("austria", "viena");
        System.out.println("Agrupados países por letra\n" + map.agruparPorLetra());

    }

}
