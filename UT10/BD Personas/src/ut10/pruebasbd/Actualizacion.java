
package ut10.pruebasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Actualizacion {

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
     * insertar un nuevo registro en la BD
     */
    public static void ejecutarConsultaActualizacion1() {

        PreparedStatement pst = null;
        Connection conexion = null;
        try {
            conexion = conectar();
            // Insertar una nueva persona Santiago Segura 42 c h
            String sql = "INSERT INTO personas  VALUES (null, 'Santiago', 'Segura', 42, 'c', 'h')";
            System.out.println(sql);
            // Preparar una sentencia Statement desde la conexión para enviar y
            // ejecutar sentencias SQL
            pst = conexion.prepareStatement(sql);
            // Ejecutar la consulta
            pst.executeUpdate(); // devuelve el nº de filas afectadas, si no
            // nos interesa ignoramos este valor
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                pst.close();
                cerrarConexion(conexion);

            } catch (SQLException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }

    }

    /**
     * actualizar la edad de la persona anterior (localizar dando el apellido)
     */
    public static void ejecutarConsultaActualizacion2() {

        try (Connection conexion = conectar();
             PreparedStatement pst = conexion.prepareStatement("UPDATE personas  SET edad = 45 WHERE apellido = 'Segura' ");) {
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * borrar la persona con el apellido anterior
     */
    public static void ejecutarConsultaActualizacion3() {

        try (Connection conexion = conectar();
             PreparedStatement pst = conexion.prepareStatement("DELETE FROM personas  WHERE apellido = 'Segura' ");) {
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * Contar el total de personas en la BD
     */
    public static void ejecutarConsultaSeleccion() {

        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conexion = conectar();
            // preparar consulta para listar todas las personas en la BD
            String sql = "SELECT * FROM personas";
            pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%-20s %-20s",
                        rs.getString("apellido"),
                        rs.getString("nombre")));
            }

            // muestro ahora solo la primera persona del conjunto de resultados
            System.out.println();
            System.out.println("Primera persona");
            rs.first();
            System.out.println(String.format("%-20s %-20s",
                    rs.getString("apellido"),
                    rs.getString("nombre")));

            // preparar consulta para contar el total de personas en la BD
            sql = "SELECT COUNT(*) AS 'TotalPersonas' FROM personas";
            pst = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            rs.next();
            int totalPersonas = rs.getInt("TotalPersonas");
            System.out.println("\nTotal personas en la BD "
                    + totalPersonas);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                pst.close();
                rs.close();
                cerrarConexion(conexion);
            } catch (SQLException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }

    }


    public static void cerrarConexion(Connection conexion) throws SQLException {
        conexion.close();


    }

    public static void main(String[] args) {

        Actualizacion.ejecutarConsultaSeleccion();
        System.out.println("-------------------------------------------");
//
//		Actualizacion.ejecutarConsultaActualizacion1();
//		Actualizacion.ejecutarConsultaSeleccion();
//        System.out.println("-------------------------------------------");

//		Actualizacion.ejecutarConsultaActualizacion2();
//		Actualizacion.ejecutarConsultaSeleccion();
//		System.out.println("-------------------------------------------");
//
//        Actualizacion.ejecutarConsultaActualizacion3();
//        System.out.println("-------------------------------------------");
//        Actualizacion.ejecutarConsultaSeleccion();


    }

}
