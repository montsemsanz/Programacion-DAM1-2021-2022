package ut9.ejemplos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejemplo17Tab extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        
        TabPane tabPane = new TabPane();
        
        Tab tab1 = new Tab("Consultas", new Label("Consultas"));
        Tab tab2 = new Tab("Altas"  , new Label("Altas "));
        Tab tab3 = new Tab("Registro " , new Label("Registro "));
        
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);
        
        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene(vBox);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");
        
        primaryStage.show();
    }
}