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

@SuppressWarnings("restriction")
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

	//the ingredients arraylist
	ArrayList<String> filterIngredients = new ArrayList<String>();
	ArrayList<String> cocktailResults = new ArrayList<String>();
	ObservableList<String> tempList = null;
	ArrayList<String> drinkNames = new ArrayList<String>();
	ArrayList<String> drinkDirections = new ArrayList<String>();
	 
	// Select groups toggle
	private boolean selectAllStatus = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	
	public void selectAllLiquorCheckboxes(){
		selectAllLiquorsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	checkAllLiquor(true);
				
		    }
		});
		
	}
	
	public void selectAllMixerCheckboxes(){
		selectAllMixersButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	checkAllIngredients(true);

		    }
		});
		
	}
	
	public void selectAllIngredients(){
		selectAllIngredientsButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {

		    	checkAllIngredients(selectAllStatus);
		    	checkAllLiquor(selectAllStatus);
		    	selectAllStatus = !selectAllStatus;
		    	if (selectAllStatus) {
		    		selectAllIngredientsButton.setText("Select All Ingredients");
		    	} else {
		    		selectAllIngredientsButton.setText("Deselect All Ingredients");
		    	}
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
				   Integer index = null;
				   String cocktailName = cocktailList.getSelectionModel().getSelectedItem();
				   index = cocktailList.getSelectionModel().getSelectedIndex();
				   cocktailInfo.setText(drinkDirections.get(drinkDirections.size() - 1 - index));
				   String imageUrl = "http://cdn.liquor.com/wp-content/uploads/2011/09/02120028/white-russian-720x720-recipe.jpg";
				   Image newImage = new Image(imageUrl);
				   cocktailImage.setImage(newImage);
				}		   
		});	
	}

// The Checkbox Functions
	public void checkAllIngredients(boolean checkStatus) {
		
    	sodaWaterCheckbox.setSelected(checkStatus);
    	sodaCherryColaCheckbox.setSelected(checkStatus);
    	sodaColaCheckbox.setSelected(checkStatus);
    	sodaDrPepperCheckbox.setSelected(checkStatus);
    	sodaGingerAleCheckbox.setSelected(checkStatus);
    	sodaLemonLimeCheckbox.setSelected(checkStatus);
    	sodaMountainDewCheckbox.setSelected(checkStatus);
    	sodaOrangeCheckbox.setSelected(checkStatus);
    	sodaRootBeerCheckbox.setSelected(checkStatus);
    	schweppesRusschianCheckbox.setSelected(checkStatus);
    	chocolateMilkCheckbox.setSelected(checkStatus);
    	creamCheckbox.setSelected(checkStatus);
    	eggYolkCheckbox.setSelected(checkStatus);
    	eggCheckbox.setSelected(checkStatus);
    	eggnogCheckbox.setSelected(checkStatus);
    	condensedMilkCheckbox.setSelected(checkStatus);
    	milkCheckbox.setSelected(checkStatus);
    	vanillaIceCreamCheckbox.setSelected(checkStatus);
    	whippingCreamCheckbox.setSelected(checkStatus);
    	yoghurtCheckbox.setSelected(checkStatus);
    	chocolateIceCreamCheckbox.setSelected(checkStatus);
    	brownSugarCheckbox.setSelected(checkStatus);
    	worcestershireSauceCheckbox.setSelected(checkStatus);
    	chocolateSyrupCheckbox.setSelected(checkStatus);
    	chocolateCheckbox.setSelected(checkStatus);
    	cocoaPowderCheckbox.setSelected(checkStatus);
    	cocoaPowderCheckbox.setSelected(checkStatus);
    	coconutMilkCheckbox.setSelected(checkStatus);
    	coffeeCheckbox.setSelected(checkStatus);
    	beefBouillonCheckbox.setSelected(checkStatus);
    	almondCheckbox.setSelected(checkStatus);
    	espressoCheckbox.setSelected(checkStatus);
    	iceCheckbox.setSelected(checkStatus);
    	icedTeaCheckbox.setSelected(checkStatus);
    	jelloCheckbox.setSelected(checkStatus);
    	saltCheckbox.setSelected(checkStatus);
    	sherbetCheckbox.setSelected(checkStatus);
    	sugarSyrupCheckbox.setSelected(checkStatus);
    	sugarCheckbox.setSelected(checkStatus);
    	tabascoSauceCheckbox.setSelected(checkStatus);
    	tangCheckbox.setSelected(checkStatus);
    	teaCheckbox.setSelected(checkStatus);
    	waterCheckbox.setSelected(checkStatus);
    	anisCheckbox.setSelected(checkStatus);
    	angosturaBittersCheckbox.setSelected(checkStatus);
    	bittersCheckbox.setSelected(checkStatus);
    	cardamomCheckbox.setSelected(checkStatus);
    	clovesCheckbox.setSelected(checkStatus);
    	gingerCheckbox.setSelected(checkStatus);
    	halfAndHalfCheckbox.setSelected(checkStatus);
    	heavyCreamCheckbox.setSelected(checkStatus);
    	honeyCheckbox.setSelected(checkStatus);
    	hotChocolateCheckbox.setSelected(checkStatus);
    	mintCheckbox.setSelected(checkStatus);
    	orangeBittersCheckbox.setSelected(checkStatus);
    	fruitAppleCheckbox.setSelected(checkStatus);
    	fruitBananaCheckbox.setSelected(checkStatus);
    	fruitCranberriesCheckbox.setSelected(checkStatus);
    	fruitGrapesCheckbox.setSelected(checkStatus);
    	fruitKiwiCheckbox.setSelected(checkStatus);
    	fruitLemonCheckbox.setSelected(checkStatus);
    	fruitLimeCheckbox.setSelected(checkStatus);
    	fruitMangoCheckbox.setSelected(checkStatus);
    	fruitOrangeCheckbox.setSelected(checkStatus);
    	fruitPineappleCheckbox.setSelected(checkStatus);
    	fruitRasinsCheckbox.setSelected(checkStatus);
    	fruitStrawberriesCheckbox.setSelected(checkStatus);
    	juiceAppleCheckbox.setSelected(checkStatus);
    	juiceCiderCheckbox.setSelected(checkStatus);
    	juiceClamatoCheckbox.setSelected(checkStatus);
    	juiceCranberryCheckbox.setSelected(checkStatus);
    	juiceFruitCheckbox.setSelected(checkStatus);
    	juiceFruitPunchCheckbox.setSelected(checkStatus);
    	juiceGrapeCheckbox.setSelected(checkStatus);
    	juiceHawaiianPunchCheckbox.setSelected(checkStatus);
    	juiceKoolAidCheckbox.setSelected(checkStatus);
    	juiceMaraschinoCherryCheckbox.setSelected(checkStatus);
    	juicePassionFruitCheckbox.setSelected(checkStatus);
    	juicePineappleCheckbox.setSelected(checkStatus);
    	juiceTomatoCheckbox.setSelected(checkStatus);
    	peachNectarCheckbox.setSelected(checkStatus);
    	sourMixCheckbox.setSelected(checkStatus);
    	sweetAndSourCheckbox.setSelected(checkStatus);
    	orangePeelCheckbox.setSelected(checkStatus);
    	lemonPeelCheckbox.setSelected(checkStatus);
    	limeJuiceCordialCheckbox.setSelected(checkStatus);
    	grenadineCheckbox.setSelected(checkStatus);
    	juiceGrapefruitCheckbox.setSelected(checkStatus);
    	juiceLemonCheckbox.setSelected(checkStatus);
    	juiceLimeCheckbox.setSelected(checkStatus);
    	juiceTropicanaCheckbox.setSelected(checkStatus);
    	juicePinkLemonadeCheckbox.setSelected(checkStatus);
    	juiceLimeadeCheckbox.setSelected(checkStatus);
    	juiceLemonadeCheckbox.setSelected(checkStatus);
    	juiceOrangeCheckbox.setSelected(checkStatus);
	}
	
	public void checkAllLiquor(boolean checkStatus) {
		ginCheckbox.setSelected(checkStatus);
		sloeGinCheckbox.setSelected(checkStatus);
		scotchCheckbox.setSelected(checkStatus);
		tequilaCheckbox.setSelected(checkStatus);
		absintheCheckbox.setSelected(checkStatus);
		amarettoCheckbox.setSelected(checkStatus);
		appleJackCheckbox.setSelected(checkStatus);
		cognacCheckbox.setSelected(checkStatus);
		everclearCheckbox.setSelected(checkStatus);
		grainAlcoholCheckbox.setSelected(checkStatus);
		cachacaCheckbox.setSelected(checkStatus);
		firewaterCheckbox.setSelected(checkStatus);
		rumAnejoCheckbox.setSelected(checkStatus);
		rumBacardiLimonCheckbox.setSelected(checkStatus);
		rumBlackCheckbox.setSelected(checkStatus);
		rumCoconutCheckbox.setSelected(checkStatus);
		rumDarkCheckbox.setSelected(checkStatus);
		rumGoldCheckbox.setSelected(checkStatus);
		rumLightCheckbox.setSelected(checkStatus);
		rumMalibuCheckbox.setSelected(checkStatus);
		rumOrangeCheckbox.setSelected(checkStatus);
		rumSpicedCheckbox.setSelected(checkStatus);
		rumCheckbox.setSelected(checkStatus);
		vodkaAbsolutCitronCheckbox.setSelected(checkStatus);
		vodkaAbsolutKurantCheckbox.setSelected(checkStatus);
		vodkaAbsolutPepparCheckbox.setSelected(checkStatus);
		vodkaCitrusCheckbox.setSelected(checkStatus);
		vodkaCranberryCheckbox.setSelected(checkStatus);
		vodkaLemonCheckbox.setSelected(checkStatus);
		vodkaLimeCheckbox.setSelected(checkStatus);
		vodkaMelonCheckbox.setSelected(checkStatus);
		vodkaOrangeCheckbox.setSelected(checkStatus);
		vodkaPeachCheckbox.setSelected(checkStatus);
		vodkaRaspberryCheckbox.setSelected(checkStatus);
		vodkaVanillaCheckbox.setSelected(checkStatus);
		vodkaCheckbox.setSelected(checkStatus);
		whiskeyBlendedCheckbox.setSelected(checkStatus);
		whiskeyBourbonCheckbox.setSelected(checkStatus);
		whiskeyCanadianCheckbox.setSelected(checkStatus);
		whiskeyIrishCheckbox.setSelected(checkStatus);
		whiskeyJackDanielsCheckbox.setSelected(checkStatus);
		whiskeyJimBeamCheckbox.setSelected(checkStatus);
		whiskeyRyeCheckbox.setSelected(checkStatus);
		whiskeyTennesseeCheckbox.setSelected(checkStatus);
		whiskeyWildTurkeyCheckbox.setSelected(checkStatus);
		whiskeyCheckbox.setSelected(checkStatus);
		brandyAppleCheckbox.setSelected(checkStatus);
		brandyApricotCheckbox.setSelected(checkStatus);
		brandyBlackberryCheckbox.setSelected(checkStatus);
		brandyCherryCheckbox.setSelected(checkStatus);
		brandyCoffeeCheckbox.setSelected(checkStatus);
		brandyPeachCheckbox.setSelected(checkStatus);
		brandyCheckbox.setSelected(checkStatus);
		calvadosCheckbox.setSelected(checkStatus);
		cherryHeeringCheckbox.setSelected(checkStatus);
		piscoCheckbox.setSelected(checkStatus);
		vermouthCheckbox.setSelected(checkStatus);
		vermouthDryCheckbox.setSelected(checkStatus);
		vermouthSweetCheckbox.setSelected(checkStatus);
		schnappsCheckbox.setSelected(checkStatus);
		schnappsAppleCheckbox.setSelected(checkStatus);
		schnappsBlackberryCheckbox.setSelected(checkStatus);
		schnappsBlueberryCheckbox.setSelected(checkStatus);
		schnappsButterscotchCheckbox.setSelected(checkStatus);
		schnappsCinnamonCheckbox.setSelected(checkStatus);
		schnappsKeyLargoCheckbox.setSelected(checkStatus);
		schnappsPeachCheckbox.setSelected(checkStatus);
		schnappsPeachTreeCheckbox.setSelected(checkStatus);
		schnappsPeppermintCheckbox.setSelected(checkStatus);
		schnappsRaspberryCheckbox.setSelected(checkStatus);
		schnappsRootBeerCheckbox.setSelected(checkStatus);
		schnappsStrawberryCheckbox.setSelected(checkStatus);
		schnappsVanillaCheckbox.setSelected(checkStatus);
		schnappsWatermelonCheckbox.setSelected(checkStatus);
		schnappsWildberryCheckbox.setSelected(checkStatus);
		rumpleMinzeCheckbox.setSelected(checkStatus);
		creamOfCoconutCheckbox.setSelected(checkStatus);
		cremeDeNoyauxCheckbox.setSelected(checkStatus);
		cremeDeBananaCheckbox.setSelected(checkStatus);
		cremeDeCacaoCheckbox.setSelected(checkStatus);
		cremeDeCassisCheckbox.setSelected(checkStatus);
		cremeDeMentheCheckbox.setSelected(checkStatus);
		aftershockCheckbox.setSelected(checkStatus);
		mauiCheckbox.setSelected(checkStatus);
		goldschlagerCheckbox.setSelected(checkStatus);
		hotDamnCheckbox.setSelected(checkStatus);
		hypnotiqCheckbox.setSelected(checkStatus);
		sourApplePuckerCheckbox.setSelected(checkStatus);
		aleCheckbox.setSelected(checkStatus);
		beerCheckbox.setSelected(checkStatus);
		champagneCheckbox.setSelected(checkStatus);
		dubonnetBlancCheckbox.setSelected(checkStatus);
		dubonnetRougeCheckbox.setSelected(checkStatus);
		whiteWineCheckbox.setSelected(checkStatus);
		coronaCheckbox.setSelected(checkStatus);
		guinessStoutCheckbox.setSelected(checkStatus);
		lagerCheckbox.setSelected(checkStatus);
		sakeCheckbox.setSelected(checkStatus);
		sherryCheckbox.setSelected(checkStatus);
		zimaCheckbox.setSelected(checkStatus);
		kummelCheckbox.setSelected(checkStatus);
		greenChartreuseCheckbox.setSelected(checkStatus);
		gallianoCheckbox.setSelected(checkStatus);
		benedictineCheckbox.setSelected(checkStatus);
		aquavitCheckbox.setSelected(checkStatus);
		yellowChartreuseCheckbox.setSelected(checkStatus);
		tripleSecCheckbox.setSelected(checkStatus);
		CuracaoCheckbox.setSelected(checkStatus);
		orangeCuracaoCheckbox.setSelected(checkStatus);
		blueCuracaoCheckbox.setSelected(checkStatus);
		cointreauCheckbox.setSelected(checkStatus);
		grandMarnierCheckbox.setSelected(checkStatus);
		tuacaCheckbox.setSelected(checkStatus);
		liqueurOrangeCheckbox.setSelected(checkStatus);
		liqueurBananaCheckbox.setSelected(checkStatus);
		liqueurRaspberryCheckbox.setSelected(checkStatus);
		liqueurKiwiCheckbox.setSelected(checkStatus);
		liqueurMelonCheckbox.setSelected(checkStatus);
		liqueurMidoriMelonCheckbox.setSelected(checkStatus);
		liqueurPeachCheckbox.setSelected(checkStatus);
		liqueurStrawberryCheckbox.setSelected(checkStatus);
		liqueurCoconutCheckbox.setSelected(checkStatus);
		tequilaRoseCheckbox.setSelected(checkStatus);
		anisetteCheckbox.setSelected(checkStatus);
		apfelkornCheckbox.setSelected(checkStatus);
		OuzoCheckbox.setSelected(checkStatus);
		barenjagerCheckbox.setSelected(checkStatus);
		pernodCheckbox.setSelected(checkStatus);
		blackSambucaCheckbox.setSelected(checkStatus);
		campariCheckbox.setSelected(checkStatus);
		drambuieCheckbox.setSelected(checkStatus);
		frangelicoCheckbox.setSelected(checkStatus);
		pisangAmbonCheckbox.setSelected(checkStatus);
		jagermeisterCheckbox.setSelected(checkStatus);
		ricardCheckbox.setSelected(checkStatus);
		sambucaCheckbox.setSelected(checkStatus);
		southernComfortCheckbox.setSelected(checkStatus);
		swedishPunschCheckbox.setSelected(checkStatus);
		yukonJackCheckbox.setSelected(checkStatus);
		advocaatCheckbox.setSelected(checkStatus);
		liqueurChocolateCheckbox.setSelected(checkStatus);
		liqueurCoffeeCheckbox.setSelected(checkStatus);
		liqueurGodivaCheckbox.setSelected(checkStatus);
		kahluaCheckbox.setSelected(checkStatus);
		baileysIrishCreamCheckbox.setSelected(checkStatus);
		tiaMariaCheckbox.setSelected(checkStatus);
		portCheckbox.setSelected(checkStatus);
		redWineCheckbox.setSelected(checkStatus);
	}
	
	public void ingredientArraylistMaker() {
		whatCanIMakeButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	filterIngredients.clear();
		    	
		    	if(ginCheckbox.isSelected()){
					filterIngredients.add("gin");
				}
		    	
		    	if(sloeGinCheckbox.isSelected()){
		    		filterIngredients.add("sloeGin");
				}

				if(scotchCheckbox.isSelected()){
					filterIngredients.add("scotch");
				}
				
				if(tequilaCheckbox.isSelected()){
					filterIngredients.add("tequila");
				}

				if(absintheCheckbox.isSelected()){
					filterIngredients.add("absinthe");
				}
				
				if(amarettoCheckbox.isSelected()){
					filterIngredients.add("amaretto");
				}
				if(appleJackCheckbox.isSelected()){
					filterIngredients.add("appleJack");
				}
				
				if(cognacCheckbox.isSelected()){
					filterIngredients.add("cognac");
				}
				
				if(everclearCheckbox.isSelected()){
					filterIngredients.add("everclear");
				}
				
				
				if(grainAlcoholCheckbox.isSelected()){
					filterIngredients.add("grainAlcohol");
				}
				
				if(cachacaCheckbox.isSelected()){
					filterIngredients.add("cachaca");
				}
				
				if(firewaterCheckbox.isSelected()){
					filterIngredients.add("firewater");
				}
				
				if(rumAnejoCheckbox.isSelected()){
					filterIngredients.add("rumAnejo");
				}
				
				if(rumBacardiLimonCheckbox.isSelected()){
					filterIngredients.add("rumBacardiLimon");
				}
				
				if(rumBlackCheckbox.isSelected()){
					filterIngredients.add("rumBlack");
				}
				
				if(rumCoconutCheckbox.isSelected()){
					filterIngredients.add("rumCoconut");
				}
				
				if(rumDarkCheckbox.isSelected()){
					filterIngredients.add("rumDark");
				}
				
				if(rumGoldCheckbox.isSelected()){
					filterIngredients.add("rumGold");
				}
				
				if(rumLightCheckbox.isSelected()){
					filterIngredients.add("rumLight");
				}
				
				if(rumMalibuCheckbox.isSelected()){
					filterIngredients.add("rumMalibu");
				}
				
				if(rumOrangeCheckbox.isSelected()){
					filterIngredients.add("rumOrange");
				}
				
				if(rumSpicedCheckbox.isSelected()){
					filterIngredients.add("rumSpiced");
				}
				
				if(rumCheckbox.isSelected()){
					filterIngredients.add("rum");
				}
				
				if(vodkaAbsolutCitronCheckbox.isSelected()){
					filterIngredients.add("vodkaAbsolutCitron");
				}
				
				if(vodkaAbsolutKurantCheckbox.isSelected()){
					filterIngredients.add("vodkaAbsolutKurant");
				}
				
				if(vodkaAbsolutPepparCheckbox.isSelected()){
					filterIngredients.add("vodkaAbsolutPeppar");
				}
				
				if(vodkaCitrusCheckbox.isSelected()){
					filterIngredients.add("vodkaCitrus");
				}
				
				if(vodkaCranberryCheckbox.isSelected()){
					filterIngredients.add("vodkaCranberry");
				}
				
				if(vodkaLemonCheckbox.isSelected()){
					filterIngredients.add("vodkaLemon");
				}
				
				if(vodkaLimeCheckbox.isSelected()){
					filterIngredients.add("vodkaLime");
				}
				
				if(vodkaMelonCheckbox.isSelected()){
					filterIngredients.add("vodkaMelon");
				}
				
				if(vodkaOrangeCheckbox.isSelected()){
					filterIngredients.add("vodkaOrange");
				}
				
				if(vodkaPeachCheckbox.isSelected()){
					filterIngredients.add("vodkaPeach");
				}
				
				if(vodkaRaspberryCheckbox.isSelected()){
					filterIngredients.add("vodkaRaspberry");
				}
				
				if(vodkaVanillaCheckbox.isSelected()){
					filterIngredients.add("vodkaVanilla");
				}
				
				if(vodkaCheckbox.isSelected()){
					filterIngredients.add("vodka");
					filterIngredients.add("vodkaAbsolut");
				}
				
				if(whiskeyBlendedCheckbox.isSelected()){
					filterIngredients.add("whiskeyBlended");
				}
				
				if(whiskeyBourbonCheckbox.isSelected()){
					filterIngredients.add("whiskeyBourbon");
				}
				
				if(whiskeyCanadianCheckbox.isSelected()){
					filterIngredients.add("whiskeyCanadian");
				}
				
				if(whiskeyIrishCheckbox.isSelected()){
					filterIngredients.add("whiskeyIrish");
				}
				
				if(whiskeyJackDanielsCheckbox.isSelected()){
					filterIngredients.add("whiskeyJackDaniels");
				}
				
				if(whiskeyJimBeamCheckbox.isSelected()){
					filterIngredients.add("whiskeyJimBeam");
				}
				
				if(whiskeyRyeCheckbox.isSelected()){
					filterIngredients.add("whiskeyRye");
				}
				
				if(whiskeyTennesseeCheckbox.isSelected()){
					filterIngredients.add("whiskeyTennessee");
				}
				
				if(whiskeyWildTurkeyCheckbox.isSelected()){
					filterIngredients.add("whiskeyWildTurkey");
				}
				
				if(whiskeyCheckbox.isSelected()){
					filterIngredients.add("whiskey");
				}
				
				if(brandyAppleCheckbox.isSelected()){
					filterIngredients.add("brandyApple");
				}
				
				if(brandyApricotCheckbox.isSelected()){
					filterIngredients.add("brandyApricot");
				}
				
				if(brandyBlackberryCheckbox.isSelected()){
					filterIngredients.add("brandyBlackberry");
				}
				
				if(brandyCherryCheckbox.isSelected()){
					filterIngredients.add("brandyCherry");
				}
				
				if(brandyCoffeeCheckbox.isSelected()){
					filterIngredients.add("brandyCoffee");
				}
				
				if(brandyPeachCheckbox.isSelected()){
					filterIngredients.add("brandyPeach");
				}
				
				if(brandyCheckbox.isSelected()){
					filterIngredients.add("brandy");
				}
				
				if(calvadosCheckbox.isSelected()){
					filterIngredients.add("calvados");
				}
				
				if(cherryHeeringCheckbox.isSelected()){
					filterIngredients.add("cherryHeering");
				}
				
				if(piscoCheckbox.isSelected()){
					filterIngredients.add("pisco");
				}
				
				if(vermouthCheckbox.isSelected()){
					filterIngredients.add("vermouth");
				}
				
				if(vermouthDryCheckbox.isSelected()){
					filterIngredients.add("vermouthDry");
				}
				
				if(vermouthSweetCheckbox.isSelected()){
					filterIngredients.add("vermouthSweet");
				}
				
				if(schnappsCheckbox.isSelected()){
					filterIngredients.add("schnapps");
				}
				
				if(schnappsAppleCheckbox.isSelected()){
					filterIngredients.add("schnappsApple");
				}
				
				if(schnappsBlackberryCheckbox.isSelected()){
					filterIngredients.add("schnappsBlackberry");
				}
				
				if(schnappsBlueberryCheckbox.isSelected()){
					filterIngredients.add("schnappsBlueberry");
				}
				
				if(schnappsButterscotchCheckbox.isSelected()){
					filterIngredients.add("schnappsButterscotch");
				}
				
				if(schnappsCinnamonCheckbox.isSelected()){
					filterIngredients.add("schnappsCinnamon");
				}
				
				if(schnappsKeyLargoCheckbox.isSelected()){
					filterIngredients.add("schnappsKeyLargo");
				}
				
				if(schnappsPeachCheckbox.isSelected()){
					filterIngredients.add("schnappsPeach");
				}
				
				if(schnappsPeachTreeCheckbox.isSelected()){
					filterIngredients.add("schnappsPeachTree");
				}
				
				if(schnappsPeppermintCheckbox.isSelected()){
					filterIngredients.add("schnappsPeppermint");
				}
				
				if(schnappsRaspberryCheckbox.isSelected()){
					filterIngredients.add("schnappsRaspberry");
				}
				
				if(schnappsRootBeerCheckbox.isSelected()){
					filterIngredients.add("schnappsRootBeer");
				}
				
				if(schnappsCheckbox.isSelected()){
					filterIngredients.add("schnapps");
				}
				
				if(schnappsStrawberryCheckbox.isSelected()){
					filterIngredients.add("schnappsStrawberry");
				}
				
				if(schnappsVanillaCheckbox.isSelected()){
					filterIngredients.add("schnappsVanilla");
				}
				
				if(schnappsWatermelonCheckbox.isSelected()){
					filterIngredients.add("schnappsWatermelon");
				}
				
				if(schnappsWildberryCheckbox.isSelected()){
					filterIngredients.add("schnappsWildberry");
				}
				
				if(rumpleMinzeCheckbox.isSelected()){
					filterIngredients.add("rumpleMinze");
				}
				
				if(creamOfCoconutCheckbox.isSelected()){
					filterIngredients.add("creamOfCoconut");
				}
				
				if(cremeDeNoyauxCheckbox.isSelected()){
					filterIngredients.add("cremeDeNoyaux");
				}
				
				if(cremeDeBananaCheckbox.isSelected()){
					filterIngredients.add("cremeDeBanana");
				}
				
				if(cremeDeCacaoCheckbox.isSelected()){
					filterIngredients.add("cremeDeCacao");
				}
				
				if(cremeDeCassisCheckbox.isSelected()){
					filterIngredients.add("cremeDeCassis");
				}
				
				if(cremeDeMentheCheckbox.isSelected()){
					filterIngredients.add("cremeDeMenthe");
				}
				
				if(aftershockCheckbox.isSelected()){
					filterIngredients.add("aftershock");
				}
				
				if(mauiCheckbox.isSelected()){
					filterIngredients.add("maui");
				}
				
				if(goldschlagerCheckbox.isSelected()){
					filterIngredients.add("goldschlager");
				}
				
				if(hotDamnCheckbox.isSelected()){
					filterIngredients.add("hotDamn");
				}
				
				if(hypnotiqCheckbox.isSelected()){
					filterIngredients.add("hypnotiq");
				}
				
				if(sourApplePuckerCheckbox.isSelected()){
					filterIngredients.add("sourApplePucker");
				}
				
				if(aleCheckbox.isSelected()){
					filterIngredients.add("ale");
				}
				
				if(beerCheckbox.isSelected()){
					filterIngredients.add("beer");
				}
				
				if(champagneCheckbox.isSelected()){
					filterIngredients.add("champagne");
				}
				
				if(dubonnetBlancCheckbox.isSelected()){
					filterIngredients.add("dubonnetBlanc");
				}
				
				if(dubonnetRougeCheckbox.isSelected()){
					filterIngredients.add("dubonnetRouge");
				}
				
				if(whiteWineCheckbox.isSelected()){
					filterIngredients.add("whiteWine");
				}
				
				if(coronaCheckbox.isSelected()){
					filterIngredients.add("corona");
				}
				
				if(guinessStoutCheckbox.isSelected()){
					filterIngredients.add("guinessStout");
				}
				
				if(lagerCheckbox.isSelected()){
					filterIngredients.add("lager");
				}
				
				if(sakeCheckbox.isSelected()){
					filterIngredients.add("sake");
				}
				
				if(sherryCheckbox.isSelected()){
					filterIngredients.add("sherry");
				}
				
				if(zimaCheckbox.isSelected()){
					filterIngredients.add("zima");
				}
				
				if(kummelCheckbox.isSelected()){
					filterIngredients.add("kummel");
				}
				
				if(greenChartreuseCheckbox.isSelected()){
					filterIngredients.add("greenChartreuse");
				}
				
				if(gallianoCheckbox.isSelected()){
					filterIngredients.add("galliano");
				}
				
				if(benedictineCheckbox.isSelected()){
					filterIngredients.add("benedictine");
				}
				
				if(aquavitCheckbox.isSelected()){
					filterIngredients.add("aquavit");
				}
				
				if(yellowChartreuseCheckbox.isSelected()){
					filterIngredients.add("yellowChartreuse");
				}
				
				if(tripleSecCheckbox.isSelected()){
					filterIngredients.add("tripleSec");
				}
				
				if(CuracaoCheckbox.isSelected()){
					filterIngredients.add("Curacao");
				}
				
				if(orangeCuracaoCheckbox.isSelected()){
					filterIngredients.add("orangeCuracao");
				}
				
				if(blueCuracaoCheckbox.isSelected()){
					filterIngredients.add("blueCuracao");
				}
				
				if(cointreauCheckbox.isSelected()){
					filterIngredients.add("cointreau");
				}
				
				if(grandMarnierCheckbox.isSelected()){
					filterIngredients.add("grandMarnier");
				}
				
				if(tuacaCheckbox.isSelected()){
					filterIngredients.add("tuaca");
				}
				
				if(liqueurOrangeCheckbox.isSelected()){
					filterIngredients.add("liqueurOrange");
				}
				
				if(liqueurBananaCheckbox.isSelected()){
					filterIngredients.add("liqueurBanana");
				}
				
				if(liqueurRaspberryCheckbox.isSelected()){
					filterIngredients.add("liqueurRaspberry");
				}
				
				if(liqueurKiwiCheckbox.isSelected()){
					filterIngredients.add("liqueurKiwi");
				}
				
				if(liqueurMelonCheckbox.isSelected()){
					filterIngredients.add("liqueurMelon");
				}
				
				if(liqueurMidoriMelonCheckbox.isSelected()){
					filterIngredients.add("liqueurMidoriMelon");
				}
				
				if(liqueurPeachCheckbox.isSelected()){
					filterIngredients.add("liqueurPeach");
				}
				
				if(liqueurStrawberryCheckbox.isSelected()){
					filterIngredients.add("liqueurStrawberry");
				}
				
				if(liqueurCoconutCheckbox.isSelected()){
					filterIngredients.add("liqueurCoconut");
				}
				
				if(tequilaRoseCheckbox.isSelected()){
					filterIngredients.add("tequilaRose");
				}
				
				if(anisetteCheckbox.isSelected()){
					filterIngredients.add("anisette");
				}
				
				if(apfelkornCheckbox.isSelected()){
					filterIngredients.add("apfelkorn");
				}
				
				if(OuzoCheckbox.isSelected()){
					filterIngredients.add("Ouzo");
				}
				
				if(barenjagerCheckbox.isSelected()){
					filterIngredients.add("barenjager");
				}
				
				if(pernodCheckbox.isSelected()){
					filterIngredients.add("pernod");
				}
				
				if(blackSambucaCheckbox.isSelected()){
					filterIngredients.add("blackSambuca");
				}
				
				if(campariCheckbox.isSelected()){
					filterIngredients.add("campari");
				}
				
				if(drambuieCheckbox.isSelected()){
					filterIngredients.add("drambuie");
				}
				
				if(frangelicoCheckbox.isSelected()){
					filterIngredients.add("frangelico");
				}
				
				if(pisangAmbonCheckbox.isSelected()){
					filterIngredients.add("pisangAmbon");
				}
				
				if(jagermeisterCheckbox.isSelected()){
					filterIngredients.add("jagermeister");
				}
				
				if(ricardCheckbox.isSelected()){
					filterIngredients.add("ricard");
				}
				
				if(sambucaCheckbox.isSelected()){
					filterIngredients.add("sambuca");
				}
				
				if(southernComfortCheckbox.isSelected()){
					filterIngredients.add("southernComfort");
				}
				
				if(swedishPunschCheckbox.isSelected()){
					filterIngredients.add("swedishPunsch");
				}
				
				if(yukonJackCheckbox.isSelected()){
					filterIngredients.add("yukonJack");
				}
				
				if(advocaatCheckbox.isSelected()){
					filterIngredients.add("advocaat");
				}
				
				if(liqueurChocolateCheckbox.isSelected()){
					filterIngredients.add("liqueurChocolate");
				}
				
				if(liqueurCoffeeCheckbox.isSelected()){
					filterIngredients.add("liqueurCoffee");
				}
				
				if(liqueurGodivaCheckbox.isSelected()){
					filterIngredients.add("liqueurGodiva");
				}
				
				if(kahluaCheckbox.isSelected()){
					filterIngredients.add("kahlua");
				}
				
				if(baileysIrishCreamCheckbox.isSelected()){
					filterIngredients.add("baileysIrishCream");
				}
				
				if(tiaMariaCheckbox.isSelected()){
					filterIngredients.add("tiaMaria");
				}
				
				if(sodaWaterCheckbox.isSelected()){
					filterIngredients.add("sodaWater");
				}
				
				if(sodaCherryColaCheckbox.isSelected()){
					filterIngredients.add("sodaCherryCola");
				}
				
				if(sodaColaCheckbox.isSelected()){
					filterIngredients.add("sodaCola");
				}
				
				if(sodaDrPepperCheckbox.isSelected()){
					filterIngredients.add("sodaDrPepper");
				}
				
				if(sodaGingerAleCheckbox.isSelected()){
					filterIngredients.add("sodaGingerAle");
				}
				
				if(sodaLemonLimeCheckbox.isSelected()){
					filterIngredients.add("sodaLemonLime");
				}
				
				if(sodaMountainDewCheckbox.isSelected()){
					filterIngredients.add("sodaMountainDew");
				}
				
				if(sodaOrangeCheckbox.isSelected()){
					filterIngredients.add("sodaOrange");
				}
				
				if(sodaRootBeerCheckbox.isSelected()){
					filterIngredients.add("sodaRootBeer");
				}
				
				if(schweppesRusschianCheckbox.isSelected()){
					filterIngredients.add("schweppesRusschian");
				}
				
				if(chocolateMilkCheckbox.isSelected()){
					filterIngredients.add("chocolateMilk");
				}
				
				if(creamCheckbox.isSelected()){
					filterIngredients.add("cream");
				}
				
				if(eggYolkCheckbox.isSelected()){
					filterIngredients.add("eggYolk");
				}
				
				if(eggCheckbox.isSelected()){
					filterIngredients.add("egg");
				}
				
				if(eggnogCheckbox.isSelected()){
					filterIngredients.add("eggnog");
				}
				
				if(condensedMilkCheckbox.isSelected()){
					filterIngredients.add("condensedMilk");
				}
				
				if(milkCheckbox.isSelected()){
					filterIngredients.add("milk");
				}
				
				if(vanillaIceCreamCheckbox.isSelected()){
					filterIngredients.add("vanillaIceCream");
				}
				
				if(whippingCreamCheckbox.isSelected()){
					filterIngredients.add("whippingCream");
				}
				
				if(yoghurtCheckbox.isSelected()){
					filterIngredients.add("yoghurt");
				}
				
				if(chocolateIceCreamCheckbox.isSelected()){
					filterIngredients.add("chocolateIceCream");
				}
				
				if(brownSugarCheckbox.isSelected()){
					filterIngredients.add("brownSugar");
				}
				
				if(worcestershireSauceCheckbox.isSelected()){
					filterIngredients.add("worcestershireSauce");
				}
				
				if(chocolateSyrupCheckbox.isSelected()){
					filterIngredients.add("chocolateSyrup");
				}
				
				if(chocolateCheckbox.isSelected()){
					filterIngredients.add("chocolate");
				}
				
				if(cocoaPowderCheckbox.isSelected()){
					filterIngredients.add("cocoaPowder");
				}
				
				if(coconutMilkCheckbox.isSelected()){
					filterIngredients.add("coconutMilk");
				}
				
				if(coffeeCheckbox.isSelected()){
					filterIngredients.add("coffee");
				}
				
				if(beefBouillonCheckbox.isSelected()){
					filterIngredients.add("beefBouillon");
				}
				
				if(almondCheckbox.isSelected()){
					filterIngredients.add("almond");
				}
				
				if(espressoCheckbox.isSelected()){
					filterIngredients.add("espresso");
				}
				
				if(iceCheckbox.isSelected()){
					filterIngredients.add("ice");
				}
				
				if(icedTeaCheckbox.isSelected()){
					filterIngredients.add("icedTea");
				}
				
				if(jelloCheckbox.isSelected()){
					filterIngredients.add("jello");
				}
				
				if(saltCheckbox.isSelected()){
					filterIngredients.add("salt");
				}
				
				if(sherbetCheckbox.isSelected()){
					filterIngredients.add("sherbet");
				}
				
				if(sugarSyrupCheckbox.isSelected()){
					filterIngredients.add("sugarSyrup");
				}
				
				if(sugarCheckbox.isSelected()){
					filterIngredients.add("sugar");
				}
				
				if(tabascoSauceCheckbox.isSelected()){
					filterIngredients.add("tabascoSauce");
				}
				
				if(tangCheckbox.isSelected()){
					filterIngredients.add("tang");
				}
				
				if(teaCheckbox.isSelected()){
					filterIngredients.add("tea");
				}
				
				if(waterCheckbox.isSelected()){
					filterIngredients.add("water");
				}
				
				if(anisCheckbox.isSelected()){
					filterIngredients.add("anis");
				}
				
				if(angosturaBittersCheckbox.isSelected()){
					filterIngredients.add("angosturaBitters");
				}
				
				if(bittersCheckbox.isSelected()){
					filterIngredients.add("bitters");
				}
				
				if(cardamomCheckbox.isSelected()){
					filterIngredients.add("cardamom");
				}
				
				if(clovesCheckbox.isSelected()){
					filterIngredients.add("cloves");
				}
				
				if(gingerCheckbox.isSelected()){
					filterIngredients.add("ginger");
				}
				
				if(halfAndHalfCheckbox.isSelected()){
					filterIngredients.add("halfAndHalf");
				}
				
				if(heavyCreamCheckbox.isSelected()){
					filterIngredients.add("heavyCream");
				}
				
				if(honeyCheckbox.isSelected()){
					filterIngredients.add("honey");
				}
				
				if(hotChocolateCheckbox.isSelected()){
					filterIngredients.add("hotChocolate");
				}
				
				if(mintCheckbox.isSelected()){
					filterIngredients.add("mint");
				}
				
				if(orangeBittersCheckbox.isSelected()){
					filterIngredients.add("orangeBitters");
				}
				
				if(portCheckbox.isSelected()){
					filterIngredients.add("port");
				}
				
				if(redWineCheckbox.isSelected()){
					filterIngredients.add("redWine");
				}
				
				if(fruitAppleCheckbox.isSelected()){
					filterIngredients.add("fruitApple");
				}
				
				if(fruitBananaCheckbox.isSelected()){
					filterIngredients.add("fruitBanana");
				}
				
				if(fruitCranberriesCheckbox.isSelected()){
					filterIngredients.add("fruitCranberries");
				}
				
				if(fruitGrapesCheckbox.isSelected()){
					filterIngredients.add("fruitGrapes");
				}
				
				if(fruitKiwiCheckbox.isSelected()){
					filterIngredients.add("fruitKiwi");
				}
				
				if(fruitLemonCheckbox.isSelected()){
					filterIngredients.add("fruitLemon");
				}
				
				if(fruitLimeCheckbox.isSelected()){
					filterIngredients.add("fruitLime");
				}
				
				if(fruitMangoCheckbox.isSelected()){
					filterIngredients.add("fruitMango");
				}
				
				if(fruitOrangeCheckbox.isSelected()){
					filterIngredients.add("fruitOrange");
				}
				
				if(fruitPineappleCheckbox.isSelected()){
					filterIngredients.add("fruitPineapple");
				}
				
				if(fruitRasinsCheckbox.isSelected()){
					filterIngredients.add("fruitRasins");
				}
				
				if(fruitStrawberriesCheckbox.isSelected()){
					filterIngredients.add("fruitStrawberries");
				}
				
				if(juiceAppleCheckbox.isSelected()){
					filterIngredients.add("juiceApple");
				}
				
				if(juiceCiderCheckbox.isSelected()){
					filterIngredients.add("juiceCider");
				}
				
				if(juiceClamatoCheckbox.isSelected()){
					filterIngredients.add("juiceClamato");
				}
				
				if(juiceCranberryCheckbox.isSelected()){
					filterIngredients.add("juiceCranberry");
				}
				
				if(juiceFruitCheckbox.isSelected()){
					filterIngredients.add("juiceFruit");
				}
				
				if(juiceFruitPunchCheckbox.isSelected()){
					filterIngredients.add("juiceFruitPunch");
				}
				
				if(juiceGrapeCheckbox.isSelected()){
					filterIngredients.add("juiceGrape");
				}
				
				if(juiceHawaiianPunchCheckbox.isSelected()){
					filterIngredients.add("juiceHawaiianPunch");
				}
				
				if(juiceKoolAidCheckbox.isSelected()){
					filterIngredients.add("juiceKoolAid");
				}
				
				if(juiceMaraschinoCherryCheckbox.isSelected()){
					filterIngredients.add("juiceMaraschinoCherry");
				}
				
				if(juicePassionFruitCheckbox.isSelected()){
					filterIngredients.add("juicePassionFruit");
				}
				
				if(juicePineappleCheckbox.isSelected()){
					filterIngredients.add("juicePineapple");
				}
				
				if(juiceTomatoCheckbox.isSelected()){
					filterIngredients.add("juiceTomato");
				}
				
				if(peachNectarCheckbox.isSelected()){
					filterIngredients.add("peachNectar");
				}
				
				if(sourMixCheckbox.isSelected()){
					filterIngredients.add("sourMix");
				}
				
				if(sweetAndSourCheckbox.isSelected()){
					filterIngredients.add("sweetAndSour");
				}
				
				if(orangePeelCheckbox.isSelected()){
					filterIngredients.add("orangePeel");
				}
				
				if(lemonPeelCheckbox.isSelected()){
					filterIngredients.add("lemonPeel");
				}
				
				if(limeJuiceCordialCheckbox.isSelected()){
					filterIngredients.add("limeJuiceCordial");
				}
				
				if(grenadineCheckbox.isSelected()){
					filterIngredients.add("grenadine");
				}
				
				if(juiceGrapefruitCheckbox.isSelected()){
					filterIngredients.add("juiceGrapefruit");
				}
				
				if(juiceLemonCheckbox.isSelected()){
					filterIngredients.add("juiceLemon");
				}
				
				if(juiceLimeCheckbox.isSelected()){
					filterIngredients.add("juiceLime");
				}
				
				if(juiceTropicanaCheckbox.isSelected()){
					filterIngredients.add("juiceTropicana");
				}
				
				if(juicePinkLemonadeCheckbox.isSelected()){
					filterIngredients.add("juicePinkLemonade");
				}
				
				if(juiceLimeadeCheckbox.isSelected()){
					filterIngredients.add("juiceLimeade");
				}
				
				if(juiceLemonadeCheckbox.isSelected()){
					filterIngredients.add("juiceLemonade");
				}
				
		    	drinkNames.clear();
		    	drinkDirections.clear();
		    	tempList = FXCollections.observableArrayList(drinkNames);
				cocktailList.setItems(tempList);

				SearchingIngredientsCode search = new SearchingIngredientsCode();
				cocktailResults = Driver.sqlDatabase.Query(search.Search(filterIngredients));
				for (int i = 0; i < cocktailResults.size(); ++i) {
					if (i < cocktailResults.size()/2) {
						drinkDirections.add(cocktailResults.get(i));
					} else {
						drinkNames.add(cocktailResults.get(i));
					}
				}
				tempList = FXCollections.observableArrayList(drinkNames);
				cocktailList.setItems(tempList);
		    }
		});
	}
	
	// The javafx checkboxes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//Base Spirits

	@FXML
	public CheckBox ginCheckbox;
	@FXML
	public CheckBox sloeGinCheckbox;
	@FXML
	public CheckBox scotchCheckbox;
	@FXML
	public CheckBox tequilaCheckbox;
	@FXML
	public CheckBox absintheCheckbox;
	@FXML
	public CheckBox amarettoCheckbox;
	@FXML
	public CheckBox appleJackCheckbox;
	@FXML
	public CheckBox cognacCheckbox;
	@FXML
	public CheckBox everclearCheckbox;
	@FXML
	public CheckBox grainAlcoholCheckbox;
	@FXML
	public CheckBox cachacaCheckbox;
	@FXML
	public CheckBox firewaterCheckbox;

	//Rum
	@FXML
	public CheckBox rumAnejoCheckbox;
	@FXML
	public CheckBox rumBacardiLimonCheckbox;
	@FXML
	public CheckBox rumBlackCheckbox;
	@FXML
	public CheckBox rumCoconutCheckbox;
	@FXML
	public CheckBox rumDarkCheckbox;
	@FXML
	public CheckBox rumGoldCheckbox;
	@FXML
	public CheckBox rumLightCheckbox;
	@FXML
	public CheckBox rumMalibuCheckbox;
	@FXML
	public CheckBox rumOrangeCheckbox;
	@FXML
	public CheckBox rumSpicedCheckbox;
	@FXML
	public CheckBox rumCheckbox;

	// VODKA
	@FXML
	public CheckBox vodkaAbsolutCitronCheckbox;
	@FXML
	public CheckBox vodkaAbsolutKurantCheckbox;
	@FXML
	public CheckBox vodkaAbsolutPepparCheckbox;
	@FXML
	public CheckBox vodkaCitrusCheckbox;
	@FXML
	public CheckBox vodkaCranberryCheckbox;
	@FXML
	public CheckBox vodkaLemonCheckbox;
	@FXML
	public CheckBox vodkaLimeCheckbox;
	@FXML
	public CheckBox vodkaMelonCheckbox;
	@FXML
	public CheckBox vodkaOrangeCheckbox;
	@FXML
	public CheckBox vodkaPeachCheckbox;
	@FXML
	public CheckBox vodkaRaspberryCheckbox;
	@FXML
	public CheckBox vodkaVanillaCheckbox;
	@FXML
	public CheckBox vodkaCheckbox;

	//WHISKY
	@FXML
	public CheckBox whiskeyBlendedCheckbox;
	@FXML
	public CheckBox whiskeyBourbonCheckbox;
	@FXML
	public CheckBox whiskeyCanadianCheckbox;
	@FXML
	public CheckBox whiskeyIrishCheckbox;
	@FXML
	public CheckBox whiskeyJackDanielsCheckbox;
	@FXML
	public CheckBox whiskeyJimBeamCheckbox;
	@FXML
	public CheckBox whiskeyRyeCheckbox;
	@FXML
	public CheckBox whiskeyTennesseeCheckbox;
	@FXML
	public CheckBox whiskeyWildTurkeyCheckbox;
	@FXML
	public CheckBox whiskeyCheckbox;

	//BRANDY
	@FXML
	public CheckBox brandyAppleCheckbox;
	@FXML
	public CheckBox brandyApricotCheckbox;
	@FXML
	public CheckBox brandyBlackberryCheckbox;
	@FXML
	public CheckBox brandyCherryCheckbox;
	@FXML
	public CheckBox brandyCoffeeCheckbox;
	@FXML
	public CheckBox brandyPeachCheckbox;
	@FXML
	public CheckBox brandyCheckbox;
	@FXML
	public CheckBox calvadosCheckbox;
	@FXML
	public CheckBox cherryHeeringCheckbox;
	@FXML
	public CheckBox piscoCheckbox;

	//Vermouth
	@FXML
	public CheckBox vermouthCheckbox;
	@FXML
	public CheckBox vermouthDryCheckbox;
	@FXML
	public CheckBox vermouthSweetCheckbox;

	//SCHNAPPS
	@FXML
	public CheckBox schnappsCheckbox;
	@FXML
	public CheckBox schnappsAppleCheckbox;
	@FXML
	public CheckBox schnappsBlackberryCheckbox;
	@FXML
	public CheckBox schnappsBlueberryCheckbox;
	@FXML
	public CheckBox schnappsButterscotchCheckbox;
	@FXML
	public CheckBox schnappsCinnamonCheckbox;
	@FXML
	public CheckBox schnappsKeyLargoCheckbox;
	@FXML
	public CheckBox schnappsPeachCheckbox;
	@FXML
	public CheckBox schnappsPeachTreeCheckbox;
	@FXML
	public CheckBox schnappsPeppermintCheckbox;
	@FXML
	public CheckBox schnappsRaspberryCheckbox;
	@FXML
	public CheckBox schnappsRootBeerCheckbox;
	@FXML
	public CheckBox schnappsStrawberryCheckbox;
	@FXML
	public CheckBox schnappsVanillaCheckbox;
	@FXML
	public CheckBox schnappsWatermelonCheckbox;
	@FXML
	public CheckBox schnappsWildberryCheckbox;
	@FXML
	public CheckBox rumpleMinzeCheckbox;

	// CREME DE ...
	@FXML
	public CheckBox creamOfCoconutCheckbox;
	@FXML
	public CheckBox cremeDeNoyauxCheckbox;
	@FXML
	public CheckBox cremeDeBananaCheckbox;
	@FXML
	public CheckBox cremeDeCacaoCheckbox;
	@FXML
	public CheckBox cremeDeCassisCheckbox;
	@FXML
	public CheckBox cremeDeMentheCheckbox;

	// Party Spirits
	@FXML
	public CheckBox aftershockCheckbox;
	@FXML
	public CheckBox mauiCheckbox;
	@FXML
	public CheckBox goldschlagerCheckbox;
	@FXML
	public CheckBox hotDamnCheckbox;
	@FXML
	public CheckBox hypnotiqCheckbox;
	@FXML
	public CheckBox sourApplePuckerCheckbox;

	// WEAK
	@FXML
	public CheckBox aleCheckbox;
	@FXML
	public CheckBox beerCheckbox;
	@FXML
	public CheckBox champagneCheckbox;
	@FXML
	public CheckBox dubonnetBlancCheckbox;
	@FXML
	public CheckBox dubonnetRougeCheckbox;
	@FXML
	public CheckBox whiteWineCheckbox;
	@FXML
	public CheckBox coronaCheckbox;
	@FXML
	public CheckBox guinessStoutCheckbox;
	@FXML
	public CheckBox lagerCheckbox;
	@FXML
	public CheckBox sakeCheckbox;
	@FXML
	public CheckBox sherryCheckbox;
	@FXML
	public CheckBox zimaCheckbox;
	@FXML
	public CheckBox portCheckbox;
	@FXML
	public CheckBox redWineCheckbox;

	//herbalLiqueur
	@FXML
	public CheckBox kummelCheckbox;
	@FXML
	public CheckBox greenChartreuseCheckbox;
	@FXML
	public CheckBox gallianoCheckbox;
	@FXML
	public CheckBox benedictineCheckbox;
	@FXML
	public CheckBox aquavitCheckbox;
	@FXML
	public CheckBox yellowChartreuseCheckbox;

	//OrangeLiqueur
	@FXML
	public CheckBox tripleSecCheckbox;
	@FXML
	public CheckBox CuracaoCheckbox;
	@FXML
	public CheckBox orangeCuracaoCheckbox;
	@FXML
	public CheckBox blueCuracaoCheckbox;
	@FXML
	public CheckBox cointreauCheckbox;
	@FXML
	public CheckBox grandMarnierCheckbox;
	@FXML
	public CheckBox tuacaCheckbox;
	@FXML
	public CheckBox liqueurOrangeCheckbox;

	//fruitLiqueur
	@FXML
	public CheckBox liqueurBananaCheckbox;
	@FXML
	public CheckBox liqueurRaspberryCheckbox;
	@FXML
	public CheckBox liqueurKiwiCheckbox;
	@FXML
	public CheckBox liqueurMelonCheckbox;
	@FXML
	public CheckBox liqueurMidoriMelonCheckbox;
	@FXML
	public CheckBox liqueurPeachCheckbox;
	@FXML
	public CheckBox liqueurStrawberryCheckbox;
	@FXML
	public CheckBox liqueurCoconutCheckbox;
	@FXML
	public CheckBox tequilaRoseCheckbox;

	//Liqueur
	@FXML
	public CheckBox anisetteCheckbox;
	@FXML
	public CheckBox apfelkornCheckbox;
	@FXML
	public CheckBox OuzoCheckbox;
	@FXML
	public CheckBox barenjagerCheckbox;
	@FXML
	public CheckBox pernodCheckbox;
	@FXML
	public CheckBox blackSambucaCheckbox;
	@FXML
	public CheckBox campariCheckbox;
	@FXML
	public CheckBox drambuieCheckbox;
	@FXML
	public CheckBox frangelicoCheckbox;
	@FXML
	public CheckBox pisangAmbonCheckbox;
	@FXML
	public CheckBox jagermeisterCheckbox;
	@FXML
	public CheckBox ricardCheckbox;
	@FXML
	public CheckBox sambucaCheckbox;
	@FXML
	public CheckBox southernComfortCheckbox;
	@FXML
	public CheckBox swedishPunschCheckbox;
	@FXML
	public CheckBox yukonJackCheckbox;
	@FXML
	public CheckBox advocaatCheckbox;

	//Coffee and Chocolate Liqueur
	@FXML
	public CheckBox liqueurChocolateCheckbox;
	@FXML
	public CheckBox liqueurCoffeeCheckbox;
	@FXML
	public CheckBox liqueurGodivaCheckbox;
	@FXML
	public CheckBox kahluaCheckbox;
	@FXML
	public CheckBox baileysIrishCreamCheckbox;
	@FXML
	public CheckBox tiaMariaCheckbox;

	//SODA
	@FXML
	public CheckBox sodaWaterCheckbox;
	@FXML
	public CheckBox sodaCherryColaCheckbox;
	@FXML
	public CheckBox sodaColaCheckbox;
	@FXML
	public CheckBox sodaDrPepperCheckbox;
	@FXML
	public CheckBox sodaGingerAleCheckbox;
	@FXML
	public CheckBox sodaLemonLimeCheckbox;
	@FXML
	public CheckBox sodaMountainDewCheckbox;
	@FXML
	public CheckBox sodaOrangeCheckbox;
	@FXML
	public CheckBox sodaRootBeerCheckbox;
	@FXML
	public CheckBox schweppesRusschianCheckbox;

	//Eggs & Dairy
	@FXML
	public CheckBox chocolateMilkCheckbox;
	@FXML
	public CheckBox creamCheckbox;
	@FXML
	public CheckBox eggYolkCheckbox;
	@FXML
	public CheckBox eggCheckbox;
	@FXML
	public CheckBox eggnogCheckbox;
	@FXML
	public CheckBox condensedMilkCheckbox;
	@FXML
	public CheckBox milkCheckbox;
	@FXML
	public CheckBox vanillaIceCreamCheckbox;
	@FXML
	public CheckBox whippingCreamCheckbox;
	@FXML
	public CheckBox yoghurtCheckbox;
	@FXML
	public CheckBox chocolateIceCreamCheckbox;
	@FXML
	public CheckBox halfAndHalfCheckbox;
	@FXML
	public CheckBox heavyCreamCheckbox;

	//Common Kitchen
	@FXML
	public CheckBox brownSugarCheckbox;
	@FXML
	public CheckBox worcestershireSauceCheckbox;
	@FXML
	public CheckBox chocolateSyrupCheckbox;
	@FXML
	public CheckBox chocolateCheckbox;
	@FXML
	public CheckBox cocoaPowderCheckbox;
	@FXML
	public CheckBox beefBouillonCheckbox;
	@FXML
	public CheckBox almondCheckbox;
	@FXML
	public CheckBox iceCheckbox;
	@FXML
	public CheckBox jelloCheckbox;
	@FXML
	public CheckBox saltCheckbox;
	@FXML
	public CheckBox sherbetCheckbox;
	@FXML
	public CheckBox sugarSyrupCheckbox;
	@FXML
	public CheckBox sugarCheckbox;
	@FXML
	public CheckBox tabascoSauceCheckbox;
	@FXML
	public CheckBox honeyCheckbox;

	
	//Drinks
	@FXML
	public CheckBox tangCheckbox;
	@FXML
	public CheckBox teaCheckbox;
	@FXML
	public CheckBox waterCheckbox;
	@FXML
	public CheckBox icedTeaCheckbox;
	@FXML
	public CheckBox espressoCheckbox;
	@FXML
	public CheckBox coffeeCheckbox;
	@FXML
	public CheckBox coconutMilkCheckbox;
	@FXML
	public CheckBox hotChocolateCheckbox;

	// Spice&Bitters
	@FXML
	public CheckBox anisCheckbox;
	@FXML
	public CheckBox angosturaBittersCheckbox;
	@FXML
	public CheckBox bittersCheckbox;
	@FXML
	public CheckBox cardamomCheckbox;
	@FXML
	public CheckBox clovesCheckbox;
	@FXML
	public CheckBox gingerCheckbox;
	@FXML
	public CheckBox mintCheckbox;
	@FXML
	public CheckBox orangeBittersCheckbox;


	//fruit
	@FXML
	public CheckBox fruitAppleCheckbox;
	@FXML
	public CheckBox fruitBananaCheckbox;
	@FXML
	public CheckBox fruitCranberriesCheckbox;
	@FXML
	public CheckBox fruitGrapesCheckbox;
	@FXML
	public CheckBox fruitKiwiCheckbox;
	@FXML
	public CheckBox fruitLemonCheckbox;
	@FXML
	public CheckBox fruitLimeCheckbox;
	@FXML
	public CheckBox fruitMangoCheckbox;
	@FXML
	public CheckBox fruitOrangeCheckbox;
	@FXML
	public CheckBox fruitPineappleCheckbox;
	@FXML
	public CheckBox fruitRasinsCheckbox;
	@FXML
	public CheckBox fruitStrawberriesCheckbox;

	//juice
	@FXML
	public CheckBox juiceAppleCheckbox;
	@FXML
	public CheckBox juiceCiderCheckbox;
	@FXML
	public CheckBox juiceClamatoCheckbox;
	@FXML
	public CheckBox juiceCranberryCheckbox;
	@FXML
	public CheckBox juiceFruitCheckbox;
	@FXML
	public CheckBox juiceFruitPunchCheckbox;
	@FXML
	public CheckBox juiceGrapeCheckbox;
	@FXML
	public CheckBox juiceHawaiianPunchCheckbox;
	@FXML
	public CheckBox juiceKoolAidCheckbox;
	@FXML
	public CheckBox juiceMaraschinoCherryCheckbox;
	@FXML
	public CheckBox juicePassionFruitCheckbox;
	@FXML
	public CheckBox juicePineappleCheckbox;
	@FXML
	public CheckBox juiceTomatoCheckbox;
	@FXML
	public CheckBox peachNectarCheckbox;

	//citrus
	@FXML
	public CheckBox sourMixCheckbox;
	@FXML
	public CheckBox sweetAndSourCheckbox;
	@FXML
	public CheckBox orangePeelCheckbox;
	@FXML
	public CheckBox lemonPeelCheckbox;
	@FXML
	public CheckBox limeJuiceCordialCheckbox;
	@FXML
	public CheckBox grenadineCheckbox;
	@FXML
	public CheckBox juiceOrangeCheckbox;
	@FXML
	public CheckBox juiceGrapefruitCheckbox;
	@FXML
	public CheckBox juiceLemonCheckbox;
	@FXML
	public CheckBox juiceLimeCheckbox;
	@FXML
	public CheckBox juiceTropicanaCheckbox;
	@FXML
	public CheckBox juicePinkLemonadeCheckbox;
	@FXML
	public CheckBox juiceLimeadeCheckbox;
	@FXML
	public CheckBox juiceLemonadeCheckbox;
}