package ut9.tabsa;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;


public class Tab1 extends Tab {
    private Label lblSaludo1;
    private Button btnSaludar1;

    private GuiPrueba gui; // referencia a la ventana principal

    public Tab1(String titulo) {
        this.setText(titulo);
        this.setContent(crearPanelVBox());
    }

    private VBox crearPanelVBox() {
        VBox panel = new VBox();
        panel.setSpacing(10);
        panel.setPadding(new Insets(10));
        panel.setStyle("-fx-background-color: #F88379");
        lblSaludo1 = new Label("El saludo");
        lblSaludo1.setAlignment(Pos.CENTER);
        lblSaludo1.setMaxWidth(Integer.MAX_VALUE);
        btnSaludar1 = new Button("Saludar");
        btnSaludar1.setMaxWidth(Integer.MAX_VALUE);
        btnSaludar1.setOnAction(e -> saludar1());
        panel.getChildren().addAll(lblSaludo1, btnSaludar1);
        return panel;

    }

    private void saludar1() {
        lblSaludo1.setText("Hola desde Tab1");
        gui.saludar(lblSaludo1.getText());
    }

    public void setGui(GuiPrueba gui) {
        this.gui = gui;
    }

}
