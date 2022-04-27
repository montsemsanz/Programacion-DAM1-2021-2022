package ut9.tabsb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Tab1Controller {
    @FXML
    private MainController controladorPrueba;

    @FXML
    private Button btnSaludar1;

    @FXML
    private Label lblSaludo1;

    @FXML
    private void initialize() {
        System.out.println("En ControladorTab1");
        System.out.println(lblSaludo1.getText());
    }

    @FXML
    void saludar1(ActionEvent event) {
        lblSaludo1.setText("Hola desde Tab1");
        controladorPrueba.saludar(lblSaludo1.getText());

    }

    public void injectarControladorPrueba(MainController controladorPrueba){
        this.controladorPrueba = controladorPrueba;
    }

    public void testFunction() {
        if(lblSaludo1 == null) {
            System.out.println("It is printed, so it is null now.");
            lblSaludo1.setText("But not here. It will throw an error.");
        }
    }
}
