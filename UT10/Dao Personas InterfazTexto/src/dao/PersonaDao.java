package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexion;
import modelo.Persona;

public class PersonaDao {


    public PersonaDao() {

    }

    /**
     * devuelve la relación de personas en la BD
     * usar try-with-resources
     */
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            if (con == null) {
                System.out.println("Conexión null");
            }
            String sql = "SELECT * FROM personas";
            try (PreparedStatement pst = con.prepareStatement(sql);
                 ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Persona p = aPersona(rs);
                    if (p != null) {
                        personas.add(p);
                    }

                }

            } catch (SQLException e) {
                System.out.println("SQL Excepción:" + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return personas;
    }

    /**
     * A partir del ResulSet crea y devuelve un objeto Persona
     * Se capturan las excepciones
     */
    private Persona aPersona(ResultSet rs) {
        Persona p = null;
        try {
            p = new Persona(rs.getInt("idPersona"), rs.getString(2),
                    rs.getString("apellido"), rs.getInt("edad"),
                    rs.getString("eCivil").charAt(0),
                    rs.getString(6).charAt(0));
        } catch (Exception e) {
            System.out.println(e);
        }
        return p;
    }

    /**
     * devuelve la relación de personas con edad menor que la indicada
     * usar try-with-resources
     */
    public List<Persona> personasMenoresDe(int edad) {
        List<Persona> personas = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            String sql = "SELECT * FROM personas WHERE edad < ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, edad);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Persona p = aPersona(rs);
                        if (p != null) {
                            personas.add(p);
                        }

                    }
                } catch (SQLException e) {
                    System.out.println("SQL Excepción:" + e.getMessage());
                }

            } catch (SQLException e) {
                System.out.println("SQL Excepción:" + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personas;
    }

    /**
     * añade una nueva persona a la BD
     * usar try-with-resources
     */
    public void guardarPersona(Persona p) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO personas (nombre, apellido, edad, eCivil, genero) "
                    + " VALUES (?, ?, ?, ?, ?)";

            // Statement.RETURN_GENERATED_KEYS nos devuelve el id de la Persona que la BD
            // generará y asignará a la nueva fila de persona
            try (PreparedStatement pst = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, p.getNombre());
                pst.setString(2, p.getApellido());
                pst.setInt(3, p.getEdad());
                pst.setString(4, p.getEstadoCivil() + "");
                pst.setString(5, p.getGenero() + "");
                pst.executeUpdate();

            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * borrar la persona con un determinado apellido
     * usar try-with-resources
     */
    public void borrarPersonaPorApellido(String apellido) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "DELETE FROM personas WHERE UPPER(apellido) LIKE ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, "%" + apellido.toUpperCase() + "%");
//			System.out.println(pst.toString());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * borrar la persona con un determinado id
     * usar try-with-resources
     */
    public void borrarPersonaPorId(int id) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "DELETE FROM personas WHERE idPersona = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setInt(1, id);
//			System.out.println(pst.toString());
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());

        } catch (Exception e) {
            System.out.println("SQL Exception:" + e.getMessage());
        }
    }

    /**
     * borrar las personas con un determinado estado civil
     */
    public void borrarPersonasDeEstadoCivil(char c) {

        try (Connection con = Conexion.getConexion()) {
            String sql = "DELETE FROM personas WHERE eCivil = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, String.valueOf(c));
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.getMessage());

        } catch (Exception e) {
            System.out.println("SQL Exception:" + e.getMessage());
        }

    }

}
