package ut10.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ut10.controlador.LoginController;


/**
 * https://edencoding.com/stage-controller/
 * https://localcoder.org/javafx-how-to-get-stage-from-controller-during-initialization
 * https://davidhamann.de/2019/02/25/mysql-case-sensitive-like-search/
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			 FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(
			 this.getClass().getResource("/vista/Login.fxml"));
			 GridPane root = loader.load();

//			LoginController controller = loader.getController();
//			controller.setStage(primaryStage);

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Acceso a la aplicación BD ALumnos");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
