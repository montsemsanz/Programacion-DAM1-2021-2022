
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SeleccionEjemplo2 {

    private final static String BD = "bdpersonas";
    private final static String USUARIO = "pepe";
    private final static String PASSWORD = "pepa";
    private static Scanner teclado = new Scanner(System.in);


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
     * Ejecutar la consulta de selección: obtener nombre apellido edad y estado
     * civil mostrando nombres de columnas de los hombres con edad > [edad leída por
     * teclado] ordenado por apellido
     *
     * Si no hay resultados se muestra el mensaje "No hay ninguna coincidencia"
     */
    public static void ejecutarConsultaSeleccion1() {

        try (Connection conexion = conectar();) {
            System.out.println("Teclee edad");
            int edad = teclado.nextInt();
            String sql = "SELECT nombre, apellido, edad, eCivil FROM personas WHERE genero = 'h' AND edad >  "
                    + edad
                    + " ORDER BY apellido, nombre";

            try (Statement st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {
                if (rs.isBeforeFirst()) {
                    ResultSetMetaData md = rs.getMetaData();
                    System.out.printf("%-20s %-20s %7s %10s\n",
                            md.getColumnName(2).toUpperCase(),
                            md.getColumnName(1).toUpperCase(),
                            md.getColumnName(3).toUpperCase(),
                            md.getColumnName(4).toUpperCase());
                    while (rs.next()) {
                        String apellido = rs.getString("apellido");
                        String nombre = rs.getString(1);
                        int ed = rs.getInt("edad");
                        char estado = rs.getString(4).charAt(0);
                        System.out.printf("%-20s %-20s %7d %5c \n",
                                apellido, nombre, ed, estado);
                    }

                } else {
                    System.out.println("No hay ninguna coincidencia");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar " + e);
        }


    }

    /**
     * Ejecutar la consulta de selección: mostrar el total de hombres en la BD
     */
    public static void ejecutarConsultaSeleccion2() {
        String sql = "SELECT count(*) as 'Total hombres' FROM personas WHERE genero = 'h'";

        try (Connection conexion = conectar();) {
            try (Statement st = conexion.createStatement();
                 ResultSet rs = st.executeQuery(sql);) {
                if (rs.next()) {
                    System.out.println(
                            rs.getMetaData().getColumnName(1) + ": "
                                    + rs.getInt(1));
                }

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


        SeleccionEjemplo2.ejecutarConsultaSeleccion1();
        System.out.println("------------------");
        SeleccionEjemplo2.ejecutarConsultaSeleccion2();


    }

}
