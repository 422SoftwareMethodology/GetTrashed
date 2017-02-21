import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainViewController implements Initializable {

	@FXML
	private AnchorPane imgPane;
	
	@FXML// the list of all cocktails
	private ListView<String> cocktailList;


	@FXML// Detail of selected cocktail
	public Label cocktailInfo;
	
	@FXML
	public ImageView cocktailImage;

	@FXML
	public CheckBox vodkaCheckbox;
	@FXML
	public CheckBox whiskyCheckbox;
	@FXML
	public CheckBox rumCheckbox;
	@FXML
	public CheckBox ginCheckbox;
	@FXML
	public CheckBox kahluaCheckbox;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> testList = FXCollections.observableArrayList("White Russian", "Whisky Sour", "Jack and Coke", "Sidecar", "Gimlet", "Martini");
		cocktailList.setItems(testList);



		/**
		 * Clicking on cocktail from list
		 */
		cocktailList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			   @Override
		        public void handle(MouseEvent event) {
				   //PUT COCKTAIL INFO HERE
				   String cocktailName =cocktailList.getSelectionModel().getSelectedItem();
				   if(cocktailName == "White Russian"){
						/**
						 * Cocktail Detail Text
						 */
						cocktailInfo.setText("Cocktail name:  White Russian\n Cocktail Ingredient: Vodka Kahlua Cream\n How to Make it: Pour and Stir");
						
						/**
						 * Img window
						 */
						String imageUrl = "http://cdn.liquor.com/wp-content/uploads/2011/09/02120028/white-russian-720x720-recipe.jpg";
						Image newImage = new Image(imageUrl);
						
						cocktailImage.setImage(newImage);
				   }
				   else if(cocktailName == "Whisky Sour"){
						/**
						 * Cocktail Detail Text
						 */
						cocktailInfo.setText("Cocktail name:  Whisky Sour\n Cocktail Ingredient: Bourbon Lemon Simple \n How to Make it: Pour and Stir");
						
						/**
						 * Img window
						 */
						String imageUrl = "http://cdn.liquor.com/wp-content/uploads/2011/07/fa-Whiskey-Sour.jpg";
						Image newImage = new Image(imageUrl);
						
						cocktailImage.setImage(newImage);
				   }
				   
		           System.out.println("clicked on " + cocktailName);
			   }
		});
		

		cocktailImage.fitWidthProperty().bind(imgPane.widthProperty());
		cocktailImage.fitHeightProperty().bind(imgPane.heightProperty());
		
	}

	public void checkBoxChecked() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		if(vodkaCheckbox.isSelected()){
			  System.out.println("clicked on " + vodkaCheckbox.getText());
		}

		if(whiskyCheckbox.isSelected()){
			  System.out.println("clicked on " + whiskyCheckbox.getText());
		}

		if(ginCheckbox.isSelected()){
			  System.out.println("clicked on " + ginCheckbox.getText());
		}

		if(rumCheckbox.isSelected()){
			  System.out.println("clicked on " + rumCheckbox.getText());
		}

		if(kahluaCheckbox.isSelected()){
			  System.out.println("clicked on " + kahluaCheckbox.getText());
		}

	}



}