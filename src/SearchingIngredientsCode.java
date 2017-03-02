import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SearchingIngredientsCode {
	public ArrayList<Integer> Search(ArrayList<String> filterIngredients){
		Ingredients ingredients = new Ingredients();
		Spirits spirit = new Spirits();
		ArrayList<Integer> combined = new ArrayList<Integer>();
		Class<? extends Ingredients> ingredientsClass = ingredients.getClass();
		Field[] ingredientFields = ingredientsClass.getDeclaredFields();		
		Class<? extends Spirits> spiritsClass = spirit.getClass();
		Field[] spiritFields = spiritsClass.getDeclaredFields();
		
		for (int i = 0; i < filterIngredients.size(); ++i) {
			for (Field f : spiritFields) {
				if (f.getName().equals(filterIngredients.get(i))) {
					try {
						Integer[] boxedInts = IntStream.of((int[])f.get(spirit)).boxed().toArray(Integer[]::new);
						List<Integer> tempList = Arrays.asList(boxedInts);
						combined.addAll(tempList);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			for (Field f : ingredientFields) {
				if (f.getName().equals(filterIngredients.get(i))) {
					try {
						Integer[] boxedInts = IntStream.of((int[])f.get(ingredients)).boxed().toArray(Integer[]::new);
						List<Integer> tempList = Arrays.asList(boxedInts);
						combined.addAll(tempList);
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		Collections.sort(combined);
		return combined;
	}
}