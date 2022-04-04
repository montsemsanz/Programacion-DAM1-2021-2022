import java.io.IOException;

public class DemoListaPersonas {

    public static void main(String args[]) throws IOException {
        ListaPersonas lista = new ListaPersonas();
        lista.add(new Persona("Pepe", 34, 's'));
        lista.add(new Persona("Ana", 14, 'c'));
        lista.add(new Persona("Luis", 23, 's'));
        lista.add(new Persona("Juan", 50, 'd'));
        lista.add(new Persona("Elena", 22, 's'));

        lista.guardarEnFicheroDeTexto();
        System.out.println("Creado fichero con datos personas");
        System.out.println("----------------------");

        lista.leerDeFicheroDeTexto();
        System.out.println("Leído fichero con BufferedReader");
        lista.mostrar();
        lista.clear();
        System.out.println("----------------------");

        lista.leerDeFicheroDeTextoConScanner();
        System.out.println("Leído fichero con Scanner");
        lista.mostrar();

        System.out.println("----------------------");
        lista.guardarEstadisticas();
        System.out.println("Creado fichero con estadísticas");

        System.out.println("----------------------");
        lista.leerDeFicheroComoRecurso();
        System.out.println("Leído fichero como recurso");
        lista.mostrar();

        //mostrar el classpath
        System.out.println(System.getProperty("java.class.path"));


    }

}
