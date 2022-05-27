package ut9.lista.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import ut9.lista.modelo.Lista;
import ut9.lista.modelo.PosicionIncorrectaExcepcion;

import java.io.IOException;
import java.util.Optional;

public class ListaController //implements Initializable
{
    private Lista lista;

    @FXML
    private TextField txtNumero;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBorrarRepetidos;

    @FXML
    private Button btnBorrarDePosicion;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextArea area;

    public ListaController() {
        this.lista = new Lista();
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            lista.cargarDeFichero();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        actualizarAreaTexto();
//    }

    @FXML
    public void initialize() {
        try {
            lista.cargarDeFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        actualizarAreaTexto();

    }

    @FXML
    void add(ActionEvent event) {
        try {
            String texto = txtNumero.getText();
            if (texto.length() != 0) {
                int numero = Integer.parseInt(texto);
                lista.addNumero(numero);
                actualizarAreaTexto();

            } else {
                mostrarError("Teclee un valor");
            }
        } catch (NumberFormatException e) {
            mostrarError("Error al convertir nº, teclee valor numérico");
        } finally {
            cogerFoco();
        }

    }

    private void mostrarError(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Aviso al usuario/a");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    @FXML
    void borrarDePosicion(ActionEvent event) {
        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Entrada de datos");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Teclee posición");
        Optional<String> resul = dialogo.showAndWait();
        if (resul.isPresent()) {
            String valor = resul.get();
            if (valor.isEmpty()) {
                mostrarError("Introduzca una posición");
            } else {
                try {
                    int pos = Integer.parseInt(resul.get());
                    lista.borrarDePosicion(pos);
                    actualizarAreaTexto();
                } catch (NumberFormatException e) {
                    mostrarError("Introduzca una posición correcta");
                } catch (PosicionIncorrectaExcepcion e) {
                    mostrarError(e.getMessage());
                }
            }

        } else {
            mostrarError("Cancelada la entrada de datos");
        }

        cogerFoco();

    }

    @FXML
    void borrarRepetidos(ActionEvent event) {
        lista.borrarRepetidos();
        actualizarAreaTexto();
        cogerFoco();

    }

    @FXML
    void salvar(ActionEvent event) {
        try {
            lista.salvarEnFichero();
            System.out.println("Guardados enteros en el fichero");
            cogerFoco();
        } catch (IOException e) {
            System.out.println("Error al salvar en fichero");
        }
    }

    /**
     * actualiza el área de texto mostrando la lista de números
     * El foco siempre vuelve a la caja de texto
     */
    private void actualizarAreaTexto() {

        area.setText("");
        area.appendText(lista.toString());
        cogerFoco();

    }

    /**
     * llevar el foco a la caja de texto y seleccionar el texto
     */
    private void cogerFoco() {

        txtNumero.requestFocus();
        txtNumero.selectAll();
    }


}