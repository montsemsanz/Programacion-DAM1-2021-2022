package ut9.tabsa;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class Tab2 extends Tab {
    private Label lblSaludo2;
    private Button btnSaludar2;

    private GuiPrueba gui; // referencia a la ventana principal

    public Tab2(String titulo) {
        this.setText(titulo);
        this.setContent(crearBorderPane());
    }

    private BorderPane crearBorderPane() {
        BorderPane panel = new BorderPane();
        panel.setStyle("-fx-background-color: #DAF7A6");

        btnSaludar2 = new Button("Saludar");
        btnSaludar2.setMaxSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        btnSaludar2.setOnAction(e -> saludar2());
        BorderPane.setMargin(btnSaludar2, new Insets(40));
        panel.setCenter(btnSaludar2);

        lblSaludo2 = new Label("El saludo");
        lblSaludo2.setAlignment(Pos.CENTER);
        lblSaludo2.setMaxWidth(Integer.MAX_VALUE);
        panel.setBottom(lblSaludo2);


        return panel;
    }

    private void saludar2() {
        lblSaludo2.setText("Hola desde Tab2");
    }

    public void setGui(GuiPrueba guiPrueba) {
    }
}
