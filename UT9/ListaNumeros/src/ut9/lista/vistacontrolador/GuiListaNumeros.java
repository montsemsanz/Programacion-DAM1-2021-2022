
package ut9.lista.vistacontrolador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ut9.lista.modelo.Lista;

import java.io.IOException;
import java.util.Optional;

public class GuiListaNumeros extends Application {

    private TextField txtNumero;
    private Button btnAdd;
    private Button btnBorrarRepetidos;
    private Button btnBorrarDePosicion;
    private Button btnSalvar;
    private TextArea area;

    private Lista lista; // el modelo

    @Override
    public void start(Stage stage)  {

        lista = new Lista();
        BorderPane root = crearGui();

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("- Lista de n�meros con fichero -");
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());
        stage.show();
        try {
            lista.cargarDeFichero();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        actualizarAreaTexto();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(10));
        panel.setTop(crearPanelNumero());

        area = new TextArea();
        panel.setCenter(area);

        panel.setBottom(crearPanelBotones());

        return panel;
    }

    private HBox crearPanelNumero() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(8));
        panel.setSpacing(8);
        panel.setAlignment(Pos.CENTER);
        Label lblNumero = new Label("N�mero");
        txtNumero = new TextField();
        txtNumero.setOnAction(event -> add());

        panel.getChildren().addAll(lblNumero, txtNumero);

        return panel;
    }

    private HBox crearPanelBotones() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(8));
        panel.setSpacing(8);
        panel.setAlignment(Pos.CENTER);

        btnAdd = new Button("A�adir n�mero");
        btnAdd.setPrefWidth(120);
        btnAdd.setOnAction(event -> add());

        btnBorrarRepetidos = new Button("Borrar repetidos");
        btnBorrarRepetidos.setPrefWidth(120);
        btnBorrarRepetidos.setOnAction(event -> borrarRepetidos());

        btnBorrarDePosicion = new Button("Borrar de posici�n");
        btnBorrarDePosicion.setPrefWidth(120);
        btnBorrarDePosicion.setOnAction(event -> borrarDePosicion());

        btnSalvar = new Button("Salvar");
        btnSalvar.setPrefWidth(120);
        btnSalvar.setOnAction(event -> salvar());

        panel.getChildren().addAll(btnAdd, btnBorrarRepetidos,
                btnBorrarDePosicion, btnSalvar);

        return panel;
    }

    /**
	 * a�adir un n� a la lista, hay que a�adirlo al mnodelo
	 * y actualziar el �rea de texto
     */
    private void add() {

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
            mostrarError("Error al convertir n�, teclee valor num�rico");
        } finally {
            cogerFoco();
        }
    }

    private void mostrarError(String mensaje) {

        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Aviso al usuario/a");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    /**
     * borrar los valores repetidos de la lista
     */
    private void borrarRepetidos() {

        lista.borrarRepetidos();
        actualizarAreaTexto();
        cogerFoco();
    }

    /**
     * Se pide una posici�n al usuario con el cuadro de di�logo TextInputDialog
     * y se borra el n� que hay en esa posici�n de la lista
	 * Habr� que actualizar el �rea de texto
     */
    private void borrarDePosicion() {

        TextInputDialog dialogo = new TextInputDialog();
        dialogo.setTitle("Entrada de datos");
        dialogo.setHeaderText(null);
        dialogo.setContentText("Teclee posici�n");
        Optional<String> resul = dialogo.showAndWait();
        if (resul.isPresent()) {
            String valor = resul.get();
            if (valor.isEmpty()) {
                mostrarError("Introduzca una posici�n");
            } else {
                try {
                    int pos = Integer.parseInt(resul.get());
                    lista.borrarDePosicion(pos);
                    actualizarAreaTexto();
                } catch (NumberFormatException e) {
                    mostrarError("Introduzca una posici�n correcta");
                }
            }

        } else {
            mostrarError("Cancelada la entrada de datos");
        }

        cogerFoco();

    }

    /**
     * actualiza el �rea de texto mostrando la lista de n�meros
	 * El foco siempre vuelve a la caja de texto
     */
    private void actualizarAreaTexto() {

        area.setText("");
        area.appendText(lista.toString());
        cogerFoco();

    }

    /**
     * Guarda la lista en un fichero
     */
    private void salvar() {

        try {
            lista.salvarEnFichero();
            System.out.println("Guardados enteros en el fichero");
            cogerFoco();
        } catch (IOException e) {
            System.out.println("Error al salvar en fichero");
        }
    }

    /**
     * llevar el foco a la caja de texto y seleccionar el texto
     */
    private void cogerFoco() {

        txtNumero.requestFocus();
        txtNumero.selectAll();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
