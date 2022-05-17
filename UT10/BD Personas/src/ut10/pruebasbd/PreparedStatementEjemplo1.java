
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementEjemplo1 {

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
     * Mostrar mujeres cuyo nombre empieza por E
     */
    public static void ejecutarConsultaSeleccion1() {

        try (Connection conexion = conectar()) {
            // consulta sin parámetros
            String sql = "SELECT nombre, apellido  FROM personas WHERE nombre LIKE 'E%' AND genero = 'm'";
            try (PreparedStatement pst = conexion.prepareStatement(sql);
                 ResultSet rs = pst.executeQuery();) {

                System.out.println(String.format("%-20s %-20s ",
                        rs.getMetaData().getColumnName(1).toUpperCase(),
                        rs.getMetaData().getColumnName(2)
                                .toUpperCase()));
                while (rs.next()) {

                    String nombre = rs.getString(1);
                    String apellido = rs.getString("apellido");
                    System.out.println(String.format("%-20s %-20s ", nombre,
                            apellido));
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar " + e);
        }

    }



    /**
     * Ejecutar consulta de selección con parámetros (mostrar hombres o mujeres
     * [parámetro] cuyo nombre contenga [parámetro])
     */
    public static void ejecutarConsultaSeleccion2() {
        try (Connection conexion = conectar()) {
            // consulta con parámetros
            String sql = "SELECT nombre, apellido FROM personas WHERE nombre LIKE ? AND genero = ?";
            try (PreparedStatement  pst = conexion.prepareStatement(sql); ) {
                // antes de ejecutar la consulta establecemos los valores de los
                // parámetros
                pst.setString(1, "%a%");
                pst.setString(2, "m");
                try (ResultSet rs = pst.executeQuery()) {
                    // Utilizamos metadatos para mostrar los nombres de las columnas de
                    // la tabla y escribir la cabecera dewl listado
                    System.out.println(String.format("%-20s %-20s",
                            rs.getMetaData().getColumnName(1).toUpperCase(),
                            rs.getMetaData().getColumnName(2)
                                    .toUpperCase()));

                    // Iterar sobre el conjunto de resultados
                    while (rs.next()) {
                        String nombre = rs.getString(1); // aquí a partir del nº de
                        // columna
                        String apellido = rs.getString("apellido");
                        System.out.println(String.format(" %-20s %-20s", nombre,
                                apellido));
                    }
                }
                catch (SQLException e) {
                    System.out.println("Error  " + e);
                }
            }
            catch (SQLException e) {
                System.out.println("Error  " + e);
            }

        }
        catch (SQLException e) {
            System.out.println("Error al conectar " + e);
        }



    }

    public static void cerrarConexion(Connection conexion) throws SQLException {
        conexion.close();


    }

    public static void main(String[] args) {

        PreparedStatementEjemplo1.ejecutarConsultaSeleccion1();
        System.out.println("------------------");
        PreparedStatementEjemplo1.ejecutarConsultaSeleccion2();


    }

}
