package ut10.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ut10.database.UtilsConexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private static final String BD = "bdusuarios";

    // private Stage stage;

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    void login(ActionEvent event) {
        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            lblError.setText("Teclee usuario");
            cogerFoco(txtNombre);
        }
        else {
            String password = txtPassword.getText().trim();
            if (password.isEmpty()) {
                lblError.setText("Teclee password");
                cogerFoco(txtPassword);
            }
            else {
                boolean exito = comprobarUsuario(nombre, password);
                if (exito) {
                    iniciarSesion(event);
                }
                else {
                    lblError.setText("Usuario y/o contraseña incorrectos");
                    cogerFoco(txtNombre);
                }
            }
        }



    }

    private boolean comprobarUsuario(String nombre, String password) {
        boolean exito = false;
        String sql = "SELECT nombre, password FROM usuarios WHERE nombre LIKE BINARY ? AND password LIKE BINARY ?";
        try (Connection conexion = UtilsConexion.getConexion(BD);
             PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1,nombre);
            pst.setString(2,password);
            try (ResultSet rs = pst.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    exito = false;
                }
                else {
                    exito = true;
                }


            }
            catch (SQLException e) {
                    System.out.println("Error en consulta " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }


        return exito;

    }



    private void iniciarSesion(ActionEvent event) {
        GridPane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/vista/GuiAlumnos.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
            scene.setRoot(root);
            Node nodo = (Node) event.getSource();
            Stage stage = (Stage) nodo.getScene().getWindow();

            stage.hide();
            stage.setScene(scene);
            stage.setTitle("Aplicación BD Alumnos");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void iniciarSesion2(ActionEvent event) {
//        GridPane root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("/vista/GuiAlumnos.fxml"));
//            Node nodo = (Node) event.getSource();
//            Scene scene = nodo.getScene();
//            scene.setRoot(root);
//
//            Stage stage = (Stage) scene.getWindow();
//            stage.hide();
//            stage.setScene(scene);
//            stage.setTitle("Aplicación BD Alumnos");
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    private void iniciarSesion3(ActionEvent event) {

//        try {
//            GridPane root = FXMLLoader.load(getClass().getResource("/vista/GuiAlumnos.fxml"));
//            Node nodo = (Node) event.getSource();
//            Scene scene = nodo.getScene();
//            scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
//            scene.setRoot(root);
//            stage.hide();
//            stage.setScene(scene);
//            stage.setTitle("Aplicación BD Alumnos");
//            stage.show();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

//    public void setStage(Stage stage) {
//        this.stage = stage;
//    }


    public void cogerFoco(TextField txt) {

        txt.requestFocus();
        txt.selectAll();
    }


}
