package formacion.demo;

import formacion.modelo.Formacion;

import java.util.Locale;

public class DemoFormacion {
    public static void main(String[] args) {
        Formacion formacion = new Formacion();
        testAddCursillo(formacion);
        
        
        testTotalHorasDeCursillosDe(formacion, "Total horas de cursillos " +
                "realizadas por", "pepe");
        testTotalHorasDeCursillosDe(formacion,
                "Total horas de cursillos realizadas por", "ana");
        testTotalHorasDeCursillosDe(formacion,
                "Total horas de cursillos realizadas por", "jesus");
        
        testAlumnoConMasHorasDeCursillos(formacion);
        
        testAlumnosTotalCursillos(formacion);
        
        testTotalHorasDeCursillos(formacion);
        
    }
    
    private static void testTotalHorasDeCursillosDe(Formacion formacion,
                                                    String mensaje,
                                                    String alumno) {
        System.out.println(mensaje + " " + alumno.toUpperCase() + " = " + formacion.totalHorasCursillosDe(alumno));
    }
    
    private static void testAlumnoConMasHorasDeCursillos(Formacion formacion) {
        System.out.println("\nCon más horas de cursillos: " + formacion.alumnoConMasHorasDeCursillos());
        System.out.println();
        
    }
    
    private static void testTotalHorasDeCursillos(Formacion formacion) {
        
        formacion.alumnosTotalHorasCursillos();
        System.out.println();
    }
    
    private static void testAlumnosTotalCursillos(Formacion formacion) {
        System.out.println("\nAlumnos y total cursillos");
        formacion.alumnosTotalCursillos();
        System.out.println();
    }
    
    private static void testAddCursillo(Formacion formacion) {
        formacion.addCursillo("pepe", "php", 20);
        formacion.addCursillo("pepe", "java", 90);
        formacion.addCursillo("ana", "php", 10);
        formacion.addCursillo("ana", "java", 70);
        formacion.addCursillo("luis", "seo", 10);
        formacion.addCursillo("jose", "java", 40);
        formacion.addCursillo("ana", "c#", 100);
        formacion.addCursillo("alberto", "xml", 70);
        formacion.addCursillo("jose", "joomla", 10);
        formacion.addCursillo("pepe", "php", 20);
        formacion.addCursillo("ana", "php", 10);
        formacion.addCursillo("jose", "joomla", 10);
        
        System.out.println("Después de añadir\n\n" + formacion.toString());
    }
    
}
