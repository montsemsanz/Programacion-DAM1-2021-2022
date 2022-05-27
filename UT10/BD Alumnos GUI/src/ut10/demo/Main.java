package ut10.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			 FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(
			 this.getClass().getResource("/vista/GuiAlumnos.fxml"));
			 GridPane root = loader.load();

			Scene scene = new Scene(root, 700, 500);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("BD alumnos JAVAFX");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
