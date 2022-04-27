package ut9.tabsb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Tab2Controller {
    @FXML
    private MainController controladorPrueba;

    @FXML
    private Button btnSaludar2;

    @FXML
    private Label lblSaludo2;

    @FXML
    private void initialize() {
        System.out.println("En ControladorTab2");
    }

    @FXML
    void saludar2(ActionEvent event) {
        lblSaludo2.setText("Hola desde Tab2");
        controladorPrueba.saludar(lblSaludo2.getText());

    }

    public void injectarControladorPrueba(MainController controladorPrueba){
        this.controladorPrueba = controladorPrueba;
    }


}
