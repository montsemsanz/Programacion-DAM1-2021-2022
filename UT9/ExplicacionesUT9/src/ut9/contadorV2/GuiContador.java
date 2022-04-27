
package ut9.contadorV2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiContador extends Application {

    private TextField txtValor;
    private Label lblContador;
    private Button btnIncremento;
    private Button btnDecremento;
    private Button btnReset;
    private RadioButton rbtBlanco;
    private RadioButton rbtVerde;
    private CheckBox cbxNegrita;
    private Contador contador; // el modelo

    public GuiContador() {

        contador = new Contador();
    }

    @Override
    public void start(Stage stage) {

        BorderPane root = crearGui();

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Contador en JavaFX - V2");
        scene.getStylesheets().add(
                getClass().getResource("application.css")
                        .toExternalForm());
        stage.show();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(5));

        panel.setTop(crearPanelTop());

        lblContador = new Label();
        lblContador.setId("label");
        lblContador.setText(Integer.toString(contador.getValor()));
        lblContador.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lblContador.setAlignment(Pos.CENTER);
        panel.setCenter(lblContador);
        panel.setBottom(crearPanelBottom());
        panel.setRight(crearPanelDerecha());
        return panel;
    }

    private HBox crearPanelBottom() {

        btnIncremento = new Button("+");
        btnIncremento.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        btnIncremento.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                incrementar();

            }

        });
        btnDecremento = new Button("-");
        btnDecremento.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        btnDecremento.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                decrementar();

            }

        });

        btnReset = new Button("Reset");
        btnReset.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

        btnReset.setOnAction(new GestorReset());

        HBox panel = new HBox();
        HBox.setHgrow(btnIncremento, Priority.ALWAYS);
        HBox.setHgrow(btnDecremento, Priority.ALWAYS);
        HBox.setHgrow(btnReset, Priority.ALWAYS);
        panel.setSpacing(5);
        panel.setPadding(new Insets(5));
        panel.getChildren().addAll(btnIncremento, btnDecremento, btnReset);
        return panel;
    }

    private void reset() {

        contador.reset();
        lblContador.setText(Integer.toString(contador.getValor()));
        cogerFoco();
    }

    private void decrementar() {

        contador.decrementar();
        lblContador.setText(Integer.toString(contador.getValor()));

    }

    private void incrementar() {

        contador.incrementar();
        lblContador.setText(Integer.toString(contador.getValor()));

    }

    private VBox crearPanelDerecha() {

        VBox panel = new VBox();
        panel.setSpacing(15);
        panel.setPadding(new Insets(20));

        rbtBlanco = new RadioButton("Fondo Blanco");
        rbtBlanco.setId("negrita");
        rbtBlanco.setOnAction(e -> cambiarColorFondo(e));

        rbtVerde = new RadioButton("Fondo Verde");
        rbtVerde.setId("negrita");
        rbtVerde.setOnAction(e -> cambiarColorFondo(e));
        rbtVerde.setSelected(true);

        ToggleGroup grupo = new ToggleGroup();
        rbtBlanco.setToggleGroup(grupo);
        rbtVerde.setToggleGroup(grupo);

        cbxNegrita = new CheckBox("Negrita");
        cbxNegrita.setId("negrita");
        cbxNegrita.setOnAction(e -> ponerNegrita());

        panel.getChildren().addAll(rbtVerde, rbtBlanco, cbxNegrita);
        return panel;
    }

    /**
     * @return
     */
    private void ponerNegrita() {

        String estilo = lblContador.getStyle();
        if (cbxNegrita.isSelected()) {

            lblContador.setStyle(estilo + "; -fx-font-weight: bold");
        } else {
            lblContador.setStyle(estilo + "; -fx-font-weight: normal");
        }
    }

    /**
     * @param e
     * @return
     */
    private void cambiarColorFondo(ActionEvent e) {

        if (e.getSource() == rbtBlanco) {

            lblContador.setStyle(" -fx-background-color: white;");
        } else if (e.getSource() == rbtVerde) {

            lblContador.setStyle("-fx-background-color: rgb(0,128,128);");
        }
        ponerNegrita();
    }

    private HBox crearPanelTop() {

        HBox panel = new HBox();
        panel.setSpacing(5);
        panel.setPadding(new Insets(5));
        Label lblValor = new Label("Valor contador");
        txtValor = new TextField();
        txtValor.setPrefColumnCount(20);
        txtValor.setOnAction(e -> leerValor());
        // txtValor.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        HBox.setHgrow(txtValor, Priority.ALWAYS);
        panel.getChildren().addAll(lblValor, txtValor);
        return panel;
    }

    private void leerValor() {

        String strValor = txtValor.getText();
        try {
            if (strValor.isEmpty()) {
                // System.out.println("Teclee valor ");
                mostrarDialogo("Teclee valor");
            } else {
                int valor = Integer.parseInt(strValor);
                contador.setValor(valor);
            }

        } catch (NumberFormatException e) {
            // System.out.println("Teclee valor num�rico");
            mostrarDialogo("Teclee valor num�rico");
        } finally {
            cogerFoco();
        }

        lblContador.setText(Integer.toString(contador.getValor()));

    }

    private void mostrarDialogo(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje.toUpperCase());
        alerta.showAndWait();

    }

    /**
     *
     */
    private void cogerFoco() {

        txtValor.requestFocus();
        txtValor.selectAll();

    }

    private class GestorReset implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            reset();

        }

    }

    public static void main(String[] args) {

        launch(args);
    }
}
