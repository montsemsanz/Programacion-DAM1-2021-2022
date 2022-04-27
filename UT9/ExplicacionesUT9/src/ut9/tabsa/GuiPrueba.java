package ut9.tabsa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GuiPrueba extends Application {
    private Label lblProbandoTop;
    private Label lblProbandoBottom;
    private Tab1 tab1;
    private Tab2 tab2;

    @Override
    public void start(Stage stage) {
        BorderPane root = crearGui();
        Scene scene = new Scene(root, 750, 650);
        stage.setScene(scene);
        stage.setTitle("Empresa");
//        scene.getStylesheets().add(getClass().getResource("/application.css")
//                .toExternalForm());
        stage.show();
        tab1.setGui(this);
        tab2.setGui(this);



    }

    private BorderPane crearGui() {
        BorderPane panel = new BorderPane();
        lblProbandoTop = new Label("Probando");
        lblProbandoBottom= new Label("Probando");

        panel.setTop(lblProbandoTop);
        panel.setCenter(crearTabPane());
        panel.setBottom(lblProbandoBottom);

        return panel;
    }

    private TabPane crearTabPane() {
        TabPane tabPane = new TabPane();
        tab1 = new Tab1("Tab1");
        tab2 = new Tab2("Tab2");
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        return tabPane;
    }

    public void saludar(String mensaje) {
        lblProbandoTop.setText(mensaje);


    }
}
