package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import modelo.Saludo;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorPruebas  {
    private Saludo saludo;

    @FXML
    private Button btnFrances;

    @FXML
    private Button btnIngles;

    @FXML
    private Button btnOtro;

    @FXML
    private CheckBox cbxmayusculas;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private Label lblTexto;

    @FXML
    private RadioButton rbtFrances;

    @FXML
    private RadioButton rbtIngles;

    @FXML
    private TextField txtNombre;

    @FXML
    public void initialize() {
        saludo = new Saludo();
    }

    @FXML
    void saludarFrances(ActionEvent event) {
        String mensaje = saludo.saludarFrances();
        if (cbxmayusculas.isSelected()) {
            mensaje = mensaje.toUpperCase();
        }
        lblTexto.setText(mensaje);

    }

    @FXML
    void saludarIngles(ActionEvent event) {
        String mensaje = saludo.saludarIngles();
        if (cbxmayusculas.isSelected()) {
            mensaje = mensaje.toUpperCase();
        }
        lblTexto.setText(mensaje);

    }

    @FXML
    void saludarPersonalizado(ActionEvent event) {
        String nombre = txtNombre.getText();
        if (nombre.isEmpty()) {
            txtNombre.setText("Teclee nombre");
        }
        else {
            if (rbtFrances.isSelected()) {
                lblTexto.setText(saludo.saludarFrancesPersonalizado(nombre));
            }
            else {
                lblTexto.setText(saludo.saludarInglesPersonalizado(nombre));
            }
        }

        cogerFoco();

    }

    private void cogerFoco() {

        txtNombre.requestFocus();
        txtNombre.selectAll();

    }


}