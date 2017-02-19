
public class Main {
	public static void main(String[] args) {
		for (int i = 11000; i < 18000; ++i) {
			for (Drink drink : BuildDB.getJSONFromUrl("http://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + i)) {
				System.out.println(drink.getStrDrink());
			}
		}
	}
}
