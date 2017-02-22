import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class MainViewController implements Initializable {


	
	@FXML// the list of all cocktails
	private ListView<String> cocktailList;


	@FXML// Detail of selected cocktail
	public Label cocktailInfo;
	
	@FXML //Image of the selected cocktail
	public ImageView cocktailImage;
	@FXML
	private AnchorPane imgPane;
	
	// the javafx buttons
	@FXML
	public Button selectAllIngredientsButton;
	@FXML
	public Button selectAllLiquorsButton;
	@FXML
	public Button selectAllMixersButton;
	@FXML
	public Button whatCanIMakeButton;

	// The javafx checkboxes
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
	@FXML
	public CheckBox limeCheckbox;
	@FXML
	public CheckBox lemonCheckbox;
	
	//the ingredients arraylist
	 ArrayList<String> filterIngredients = new ArrayList<String>();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> testList = FXCollections.observableArrayList("White Russian", "Whisky Sour", "Jack and Coke", "Sidecar", "Gimlet", "Martini");
		cocktailList.setItems(testList);

		//Default img load
		String imageUrl = "http://cdn.playbuzz.com/cdn/f6b9bbfb-8708-49ad-a164-cdea284a0845/2bfcacf2-c580-4b60-aa95-8b5616d5c350.jpg";
		Image newImage = new Image(imageUrl);
		
		cocktailImage.setImage(newImage);

		//initialize the button actions
		listClick();
		selectAllLiquorCheckboxes();
		selectAllMixerCheckboxes();
		selectAllIngredients();
		ingredientArraylistMaker();
		

		cocktailImage.fitWidthProperty().bind(imgPane.widthProperty());
		cocktailImage.fitHeightProperty().bind(imgPane.heightProperty());
		
	}

	public void ingredientArraylistMaker() {
		whatCanIMakeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	filterIngredients.clear();
		    	
		    	//Liquor
		    	if(vodkaCheckbox.isSelected()){
		    		filterIngredients.add("vodka");
				}

				if(whiskyCheckbox.isSelected()){
					filterIngredients.add("whisky");
				}

				if(ginCheckbox.isSelected()){
					filterIngredients.add("gin");
				}

				if(rumCheckbox.isSelected()){
					filterIngredients.add("rum");
				}

				if(kahluaCheckbox.isSelected()){
					filterIngredients.add("kahlua");
				}
				
				//Mixers
				if(limeCheckbox.isSelected()){
					filterIngredients.add("lime");
				}
				if(lemonCheckbox.isSelected()){
					filterIngredients.add("lemon");
				}
				System.out.println("Contents of Arraylist: " + filterIngredients);
		    }
		});
	}
	
	public void selectAllLiquorCheckboxes(){
		selectAllLiquorsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				vodkaCheckbox.setSelected(true);
				whiskyCheckbox.setSelected(true);
				ginCheckbox.setSelected(true);
				rumCheckbox.setSelected(true);
				kahluaCheckbox.setSelected(true);
		    }
		});
		
	}
	
	public void selectAllMixerCheckboxes(){
		selectAllMixersButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	limeCheckbox.setSelected(true);
				lemonCheckbox.setSelected(true);
		    }
		});
		
	}
	
	public void selectAllIngredients(){
		selectAllIngredientsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	limeCheckbox.setSelected(true);
				lemonCheckbox.setSelected(true);
				vodkaCheckbox.setSelected(true);
				whiskyCheckbox.setSelected(true);
				ginCheckbox.setSelected(true);
				rumCheckbox.setSelected(true);
				kahluaCheckbox.setSelected(true);
		    }
		});
	}
	
	public void listClick() {
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
		
	}



}