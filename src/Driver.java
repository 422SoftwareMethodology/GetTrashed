import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {
	public static SqlDatabase sqlDatabase;
	public static void Main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		sqlDatabase = new SqlDatabase();
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainView.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 1000, 700);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}