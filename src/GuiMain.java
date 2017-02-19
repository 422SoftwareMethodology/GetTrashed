import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class GuiMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/TrashedGUI.fxml"));
			Scene scene = new Scene(root,620,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
			final ComboBox comboBox = new ComboBox();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
