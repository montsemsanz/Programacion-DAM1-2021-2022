package ut9.tabsb;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label lblProbandoTop;
    @FXML
    private Label lblProbandoButtom;

    @FXML
    private Tab1Controller tab1Controller;
    @FXML
    private Tab2Controller tab2Controller;

    @FXML
    private void initialize() {
        tab1Controller.injectarControladorPrueba(this);
        tab2Controller.injectarControladorPrueba(this);

    }

      public void saludar(String text) {
        lblProbandoTop.setText(text);
    }
}
