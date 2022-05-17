
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SeleccionEjemplo1 {

    private final static String BD = "bdpersonas";
    private final static String USUARIO = "pepe";
    private final static String PASSWORD = "pepa";

    /**
     * carga del driver y conexión con la BD
     */
    public static Connection conectar() throws SQLException {

        // Obtener conexión a la BD
        Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost/" + BD, USUARIO,
                PASSWORD);
        return conexion;

    }


    /**
     * Ejecutar la consulta de selección: obtener nombre,apellido, edad de todas
     * las personas
     */
    public static void ejecutarConsultaSeleccion() {
        Connection conexion = null;
        try {
            conexion = conectar();
            Statement st = null;
            ResultSet rs = null;
            try {
                // preparar consulta SQL como String
                String sql = "SELECT nombre, apellido, edad FROM personas";

                // Preparar una sentencia Statement desde la conexión para enviar y
                // ejecutar sentencias SQL
                st = conexion.createStatement();
                // Ejecutar la consulta y obtener el conjunto de resultados
                rs = st.executeQuery(sql);

                // Utilizamos metadatos para mostrar los nombres de las columnas de
                // la tabla y escribir la cabecera del listado
                ResultSetMetaData md = rs.getMetaData();
                System.out.printf("%-20s %-20s %7s\n",
                        md.getColumnName(1).toUpperCase(),
                        md.getColumnName(2).toUpperCase(),
                        md.getColumnName(3).toUpperCase());

                // Iterar sobre el conjunto de resultados
                while (rs.next()) {
                    String nombre = rs.getString(1); // aquí a partir del nº de
                    // columna
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");

                    // System.out.println(id + "\t" + nombre + "\t\t\t" + apellido +
                    // "\t\t\t" + edad + "\t" + estado + "\t" + genero) ;
                    System.out.printf("%-20s %-20s %7d\n", nombre,
                            apellido, edad);

                }
                System.out.println();
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    st.close();
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error estableciendo conexión JDBC: "
                    + e);
        } finally {
            try {
                cerrarConexion(conexion);
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión");
            }
        }


    }

    /**
     * Ejecutar la consulta de selección: obtener nombre,apellido, edad de todas
     * las personas
     *
     * try-with-resources
     */
    public static void ejecutarConsultaSeleccionVersion2() {
        // preparar consulta SQL como String
        String sql = "SELECT nombre, apellido, edad FROM personas";
        try (Connection conexion = conectar();) {
            System.out.println("Conexión establecida con la BD " + BD);
            System.out.println();

            try (Statement st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);) {
                // Utilizamos metadatos para mostrar los nombres de las columnas de
                // la tabla y escribir la cabecera del listado
                ResultSetMetaData md = rs.getMetaData();
                System.out.println(String.format("%-20s %-20s %7s\n",
                        md.getColumnName(1).toUpperCase(),
                        md.getColumnName(2).toUpperCase(),
                        md.getColumnName(3).toUpperCase()));

                // Iterar sobre el conjunto de resultados
                while (rs.next()) {
                    String nombre = rs.getString(1); // aquí a partir del nº de
                    // columna
                    String apellido = rs.getString("apellido");
                    int edad = rs.getInt("edad");

                    // System.out.println(id + "\t" + nombre + "\t\t\t" + apellido +
                    // "\t\t\t" + edad + "\t" + estado + "\t" + genero) ;
                    System.out.printf("%-20s %-20s %7d\n", nombre,
                            apellido, edad);

                }
                System.out.println();
            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar " + e);
        }


    }

    public static void cerrarConexion(Connection conexion) throws SQLException {
        conexion.close();


    }

    public static void main(String[] args) {

        SeleccionEjemplo1.ejecutarConsultaSeleccion();
        System.out.println("------------------");
        SeleccionEjemplo1.ejecutarConsultaSeleccionVersion2();


    }

}
