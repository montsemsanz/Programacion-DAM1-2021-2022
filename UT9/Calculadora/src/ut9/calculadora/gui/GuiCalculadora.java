
package ut9.calculadora.gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import ut9.calculadora.modelo.Calculadora;

public class GuiCalculadora extends Application {

    private Calculadora calculadora; // el modelo
    private TextField txtNumero1;
    private TextField txtNumero2;
    private RadioButton rbtSuma;
    private RadioButton rbtResta;
    private RadioButton rbtProducto;
    private RadioButton rbtDivision;
    private Button btnCalcular;
    private Label lblResultado;

    @Override
    public void start(Stage stage) {

        this.calculadora = new Calculadora();
        BorderPane root = crearGui();

        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.setTitle("- Calculadora sencilla -");
        scene.getStylesheets().add(
                getClass().getResource("/application.css")
                        .toExternalForm());
        stage.show();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(0));
        Label lblTitulo = new Label("Calculadora");
        lblTitulo.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lblTitulo.setId("titulo");
        panel.setTop(lblTitulo);

        GridPane grid = crearGrid();
        BorderPane.setAlignment(grid, Pos.CENTER_RIGHT);
        BorderPane.setMargin(grid, new Insets(5));

        panel.setCenter(grid);
        lblResultado = new Label("Resultado");
        lblResultado.setId("resultado");
        lblResultado.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

        // lblResultado.setAlignment(Pos.CENTER);
        panel.setBottom(lblResultado);
        return panel;
    }

    private GridPane crearGrid() {

        GridPane panel = new GridPane();
        // panel.setGridLinesVisible(true);

        panel.setPadding(new Insets(10, 5, 10, 5));
        panel.setHgap(8);
        panel.setVgap(8);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);

        panel.getColumnConstraints().addAll(col1, col2, col3);

        for (int f = 1; f <= 3; f++) {
            RowConstraints fila = new RowConstraints();
            // fila.setMinHeight(30);
            fila.setVgrow(Priority.ALWAYS);
            panel.getRowConstraints().add(fila);
        }

        Label lblNumero1 = new Label("Número 1");
        GridPane.setHalignment(lblNumero1, HPos.RIGHT);
        Label lblNumero2 = new Label("Número 2");
        GridPane.setHalignment(lblNumero2, HPos.RIGHT);
        txtNumero1 = new TextField();
        txtNumero2 = new TextField();
        btnCalcular = new Button("Calcular");
        btnCalcular.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        btnCalcular.setDefaultButton(true);
        btnCalcular.setOnAction(e -> calcular());

        panel.add(lblNumero1, 0, 0);
        panel.add(lblNumero2, 0, 1);
        panel.add(txtNumero1, 1, 0);
        panel.add(txtNumero2, 1, 1);
        panel.add(btnCalcular, 2, 0, 1, 3);
        HBox panelBotones = crearPanelBotonesOperaciones();
        panel.add(panelBotones, 1, 2);

        // panel.setId("bordegrid");
        return panel;
    }

    private HBox crearPanelBotonesOperaciones() {

        HBox panel = new HBox();
        panel.setSpacing(10);
        panel.setAlignment(Pos.CENTER);
        rbtSuma = new RadioButton("Suma");
        rbtSuma.setSelected(true);
        rbtResta = new RadioButton("Resta");
        rbtProducto = new RadioButton("Producto");
        rbtDivision = new RadioButton("División entera");

        ToggleGroup grupo = new ToggleGroup();
        rbtSuma.setToggleGroup(grupo);
        rbtResta.setToggleGroup(grupo);
        rbtProducto.setToggleGroup(grupo);
        rbtDivision.setToggleGroup(grupo);

        panel.getChildren().addAll(rbtSuma, rbtResta, rbtProducto, rbtDivision);
        return panel;
    }

    private void calcular() {

        TextField target = txtNumero1;
        String txtN1 = txtNumero1.getText().trim();
        String txtN2 = txtNumero2.getText().trim();
        if (txtN1.isEmpty()) {
            mostrarMensaje("Teclee valor");
            cogerFoco(target);

        } else if (txtN2.isEmpty()) {
            target = txtNumero2;
            mostrarMensaje("Teclee valor");
            cogerFoco(target);

        } else {

            try {
                target = txtNumero1;
                int n1 = Integer.parseInt(txtN1);
                target = txtNumero2;
                int n2 = Integer.parseInt(txtN2);
                target = txtNumero1;
                if (rbtSuma.isSelected()) {
                    int resul = calculadora.sumar(n1, n2);
                    lblResultado.setText(String.format("Suma: " + resul));
                } else if (rbtResta.isSelected()) {
                    int resul = calculadora.restar(n1, n2);
                    lblResultado.setText(String.format("Resta: " + resul));
                } else if (rbtProducto.isSelected()) {
                    int resul = calculadora.multiplicar(n1, n2);
                    lblResultado.setText(String.format("Producto: " + resul));
                } else {
                    try {
                        int resul = calculadora.dividir(n1, n2);
                        lblResultado.setText(
                                String.format("División entera: "
                                        + resul));

                    } catch (ArithmeticException e) {
                        mostrarMensaje("Error división entre 0");
                        target = txtNumero2;

                    }

                }

            } catch (NumberFormatException e) {

                mostrarMensaje("Error al convertir nº");
            } finally {
                cogerFoco(target);
            }

        }
    }

    private void mostrarMensaje(String mensaje) {

        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Aviso al usuario/a");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    private void cogerFoco(TextField target) {

        target.requestFocus();
        target.selectAll();

    }

    public static void main(String[] args) {

        launch(args);
    }
}
