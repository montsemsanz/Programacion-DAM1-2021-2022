
package vistasControladores;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Saludo;

public class Prueba1 extends Application {

    private Saludo saludo;
    private Button btnFrances;
    private Button btnIngles;
    private Label lblTexto;
    private RadioButton rbtFrances;
    private RadioButton rbtIngles;
    private CheckBox cbxMayus;
    private TextField txtNombre;

    @Override
    public void start(Stage stage) {

        saludo = new Saludo();

        BorderPane root = crearGui();

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.setTitle("- Prueba 1 -");
        scene.getStylesheets().add(getClass().getResource("/application.css")
                .toExternalForm());
        stage.show();
    }

    private BorderPane crearGui() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(6));

        panel.setTop(crearPanelNorte());

        panel.setCenter(crearPanelCentral());

        return panel;
    }

    private BorderPane crearPanelCentral() {

        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(6));
        panel.setId("panel-central");

        lblTexto = new Label("texto de la etiqueta");
        lblTexto.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        lblTexto.setAlignment(Pos.CENTER);
        panel.setCenter(lblTexto);

        panel.setRight(crearPanelDerecha());

        panel.setBottom(crearPanelGrid());

        return panel;
    }

    private GridPane crearPanelGrid() {

        GridPane panel = new GridPane();
        panel.setPadding(new Insets(6));
        panel.setVgap(8);
        panel.setHgap(8);
        panel.getStyleClass().add("gridpane");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(50);
        panel.getColumnConstraints().addAll(col1, col2, col3);

        RowConstraints row = new RowConstraints(60);
        panel.getRowConstraints().add(row);

        txtNombre = new TextField();
        txtNombre.setPromptText("Caja de texto");
        txtNombre.setOnAction(event -> saludarPersonalizado());
        panel.add(txtNombre, 0, 0);

        Button btnOtro = new Button("Otro saludo");
        btnOtro.setMaxWidth(Integer.MAX_VALUE);
        btnOtro.setOnAction(event -> saludarPersonalizado());
        panel.add(btnOtro, 1, 0);

        HBox panelRadio = crearPanelBotonesRadio();
        panelRadio.setAlignment(Pos.CENTER);
        panelRadio.setMaxWidth(Integer.MAX_VALUE);
        GridPane.setHgrow(panelRadio, Priority.ALWAYS);

        panel.add(panelRadio, 2, 0);

        return panel;
    }

    private void saludarPersonalizado() {

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

    private HBox crearPanelBotonesRadio() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);
        panel.getStyleClass().add("hbox");

        rbtFrances = new RadioButton("Franc�s");
        rbtFrances.setSelected(true);
        rbtIngles = new RadioButton("Ingl�s");

        ToggleGroup grupo = new ToggleGroup();
        rbtFrances.setToggleGroup(grupo);
        rbtIngles.setToggleGroup(grupo);

        panel.getChildren().addAll(rbtFrances, rbtIngles);

        return panel;
    }

    private VBox crearPanelDerecha() {

        VBox panel = new VBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);

        VBox panelArriba = crearPanelDerechaArriba();
        VBox.setVgrow(panelArriba, Priority.ALWAYS);
        panel.getChildren().add(panelArriba);
        VBox panelAbajo = crearPanelDerechaAbajo();
        VBox.setVgrow(panelAbajo, Priority.ALWAYS);
        panel.getChildren().add(panelAbajo);

        return panel;
    }

    private VBox crearPanelDerechaAbajo() {

        VBox panel = new VBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);
        panel.getStyleClass().add("vbox");
        panel.setAlignment(Pos.BOTTOM_CENTER);
        Button btnA = new Button("A");
        panel.getChildren().add(btnA);
        Button btnB = new Button("B");
        panel.getChildren().add(btnB);

        return panel;
    }

    private VBox crearPanelDerechaArriba() {

        VBox panel = new VBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);
        panel.getStyleClass().add("vbox");
        panel.setAlignment(Pos.TOP_CENTER);

        Button btnA = new Button("A");
        panel.getChildren().add(btnA);
        Button btnB = new Button("B");
        panel.getChildren().add(btnB);

        return panel;
    }

    private HBox crearPanelNorte() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(10));
        panel.setSpacing(7);
        panel.setAlignment(Pos.CENTER);

        btnFrances = new Button("Franc�s");
        btnFrances.setPrefWidth(70);
        btnFrances.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {

                saludarFrances();

            }
        });

        btnIngles = new Button("Ingl�s");
        btnIngles.setMaxWidth(Integer.MAX_VALUE);
        btnIngles.setOnAction(event -> saludarIngles());

        HBox.setHgrow(btnIngles, Priority.ALWAYS);

        panel.getChildren().addAll(btnFrances, btnIngles);

        cbxMayus = new CheckBox("En may�sculas");
        panel.getChildren().add(cbxMayus);

        return panel;
    }

    private void saludarIngles() {

        String mensaje = saludo.saludarIngles();
        if (cbxMayus.isSelected()) {
            mensaje = mensaje.toUpperCase();
        }
        lblTexto.setText(mensaje);
    }

    private void saludarFrances() {

        String mensaje = saludo.saludarFrances();
        if (cbxMayus.isSelected()) {
            mensaje = mensaje.toUpperCase();
        }
        lblTexto.setText(mensaje);

    }

    public static void main(String[] args) {

        launch(args);
    }
}