
package ut9.ejemplos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Ejemplo18ComboBox extends Application {
    private ComboBox<Integer> cmbValores;
    private Label lblSeleccionado;

    @Override
    public void start(Stage stage) {

        HBox root = crearGui();
        Scene scene = new Scene(root, 400, 100);
        stage.setScene(scene);
        stage.setTitle("- Ejemplo ComboBox -");
        scene.getStylesheets()
                .add(getClass().getResource("/estilo.css")
                        .toExternalForm());
        stage.show();
    }

    private HBox crearGui() {

        HBox panel = new HBox();
        panel.getChildren().addAll(crearPanelCombo());
        return panel;
    }

    private HBox crearPanelCombo() {

        HBox panel = new HBox();
        panel.setPadding(new Insets(10, 10, 10, 10));
        panel.setSpacing(8);

        Label lblTexto = new Label("Elija valor del ComboBox");

        lblTexto.setPrefWidth(150);
        lblTexto.setAlignment(Pos.CENTER_RIGHT);

        cmbValores = new ComboBox<>();
        for (int i = 1; i <= 10; i++) {
            cmbValores.getItems().add(i);

        }
        cmbValores.setValue(1);
        cmbValores.setMaxWidth(Integer.MAX_VALUE);
        HBox.setHgrow(cmbValores, Priority.ALWAYS);
        cmbValores.setOnAction(e -> mostrarSeleccionado());

        lblSeleccionado = new Label();
        mostrarSeleccionado();
        panel.getChildren().addAll(lblTexto, cmbValores, lblSeleccionado);

        return panel;
    }

    private void mostrarSeleccionado() {
        lblSeleccionado.setText("Seleccionado valor "+ " " + cmbValores.getValue());
    }

    public static void main(String[] args) {

        launch(args);
    }
}
