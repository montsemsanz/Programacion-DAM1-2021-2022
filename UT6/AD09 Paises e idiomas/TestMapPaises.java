import java.util.TreeSet;
/**
 * Clase para probar los métodos de MapPaises  
 */
public class TestMapPaises
{

    
    public static void main(String[] args)    {
        MapPaises map = new MapPaises();
        map.add("portugal", "portugués");
        map.add("brasil", "portugués");
        map.add("alemania", "alemán");
        map.add("suiza", "alemán");
        map.add("suiza", "francés");
        map.add("bélgica", "francés");
        map.add("bélgica", "flamenco");
        map.add("bélgica", "alemán");
        map.add("españa", "castellano");
        map.add("españa", "gallego");
        map.add("españa", "euskera");
        map.add("españa", "catalán");

        map.printPaises();
        String pais = "España";
        TreeSet<String> idiomas = map.idiomasQueHablanEn(pais);
        if (idiomas != null) {
            System.out.println("En " + pais.toUpperCase() + " se habla " + idiomas.toString());
        }
        else {
            System.out.println("El país " + pais.toUpperCase() + " no existe ");
        }
        pais = "francia";
        idiomas = map.idiomasQueHablanEn(pais);
        if (idiomas != null) {
            System.out.println("En " + pais.toUpperCase() + " se habla " + idiomas.toString());
        }
        else {
            System.out.println("El país "  + pais.toUpperCase() + " no existe ");
        }

        pais = "Suiza";
        System.out.println("En " + pais.toUpperCase() + " hablan " +
            map.totalIdiomasQueHablanEn(pais) + " idioma/s");

        String idioma = "alemán";
        System.out.println("El idioma " + idioma + " se habla en " +
            map.paisesQueHablanIdioma(idioma));

        String pais2 = "Bélgica";
        System.out.println(pais.toUpperCase() + " y " +  pais2.toUpperCase() +
            " hablan " + map.idiomasComunes(pais, pais2).toString());
    }
}
