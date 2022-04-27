package ut9.tabsb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppPrueba extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AppPrueba.class
                    .getResource("GuiPrueba.fxml"));
            BorderPane root = fxmlLoader.load();

            Scene scene = new Scene(root, 750, 650);

//            scene.getStylesheets()
//                    .add(getClass().getResource("/application.css")
//                            .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Probando tabs ....");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
