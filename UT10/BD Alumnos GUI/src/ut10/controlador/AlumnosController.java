package ut10.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ut10.database.UtilsConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class AlumnosController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private Button btnBuscar;

    @FXML
    private RadioButton rbtAscendente;

    @FXML
    private RadioButton rbtDescendente;

    @FXML
    private CheckBox cbxPendiente;

    @FXML
    private Button btnListar;

    @FXML
    private TextArea areaTexto;

    @FXML
    void buscar(ActionEvent event) {
        String nombre = txtNombre.getText();
        TextField txtFoco = txtNombre;
        if (nombre.isEmpty()) {
            mostrarMensaje("Teclee nombre");

        } else {
            String apellido = txtApellido.getText();
            if (apellido.isEmpty()) {
                mostrarMensaje("Teclee apellido");
                txtFoco = txtApellido;
            } else {
                mostrarDatos(nombre, apellido);
            }
        }
        cogerFoco(txtFoco);


    }

    @FXML
    void listar(ActionEvent event) {
        String cabecera = "Listado de alumnos";
        String sql = "SELECT nombre, apellido, nota FROM alumnos ";
        if (cbxPendiente.isSelected()) {
            sql = sql + "WHERE pendiente = 'SI' ";
            cabecera += " con asignaturas pendientes ";
        } else {
            sql = sql + "WHERE pendiente = 'NO' ";
            cabecera += " sin asignaturas pendientes ";
        }

        sql += " ORDER BY apellido ";
        if (rbtDescendente.isSelected()) {
            sql += "DESC";
            cabecera += "\nen orden descendente de apellido";
        } else if (rbtAscendente.isSelected()) {
            cabecera += "\nen orden ascendente de apellido";
        }

        try (Connection conexion = UtilsConexion.getConexion();
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            areaTexto.setText(cabecera + "\n");
            areaTexto.appendText("--------------------------------------------------\n");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    areaTexto.appendText(
                            rs.getString("apellido") + ",\t" + rs.getString("nombre") + "\t" + rs.getInt("nota") + "\n");
                }


            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private void mostrarDatos(String nombre, String apellido) {
        String sql = "SELECT * FROM alumnos WHERE nombre = ? AND apellido = ?";
        try (Connection conexion = UtilsConexion.getConexion();
              PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.isBeforeFirst()) {
                    ResultSetMetaData rsm = rs.getMetaData();
                    String strCabecera = String.format("%-20s%-20s%-20s%20s", rsm.getColumnName(3).toUpperCase(),
                            rsm.getColumnName(2).toUpperCase(), rsm.getColumnName(4).toUpperCase(),
                            rsm.getColumnName(5).toUpperCase());
                    areaTexto.setText(strCabecera + "\n");
                    while (rs.next()) {
                        String strFormateada = String.format("%-25s%-25s%-25d%25s", rs.getString(3), rs.getString(2),
                                rs.getInt(4), rs.getString(5));
                        areaTexto.appendText(strFormateada);
                    }

                } else {
                    areaTexto.setText("No hay coincidencias");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    private void mostrarMensaje(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    public void cogerFoco(TextField txt) {

        txt.requestFocus();
        txt.selectAll();
    }



}
