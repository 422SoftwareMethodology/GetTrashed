import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;

public class MainViewController implements Initializable {
	
	@FXML
	private ListView<String> cocktailList;
	// the list of all cocktails
	
	@FXML
	public CheckBox vodkaCheckbox;
	@FXML
	public CheckBox whiskyCheckbox;
	public CheckBox rumCheckbox;
	public CheckBox ginCheckbox;
	public CheckBox kahluaCheckbox;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> testList = FXCollections.observableArrayList("White Russian", "Whisky Sour", "Jack and Coke", "Sidecar", "Gimlet", "Martini");
		cocktailList.setItems(testList);
		
		/**
		 * Clicking on cocktail from list
		 */
		cocktailList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			   @Override
		        public void handle(MouseEvent event) {
		            System.out.println("clicked on " + cocktailList.getSelectionModel().getSelectedItem());
			   }
		});
	}
	
	public void checkBoxChecked() {
		if(vodkaCheckbox.isSelected()){
			  System.out.println("clicked on " + vodkaCheckbox.getText());
		}	
	}
}