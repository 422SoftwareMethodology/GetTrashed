import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class SearchingIngredientsCode {
	public TreeMap<Integer, Integer> Search(ArrayList<String> filterIngredients){
		TreeMap<Integer, Integer> occurrenceSet = new TreeMap<Integer, Integer>();
		Ingredients ingredients = new Ingredients();
		Spirits spirit = new Spirits();
		ArrayList<Integer> combined = new ArrayList<Integer>();
		Field[] ingredientFields = ingredients.getClass().getDeclaredFields();		
		Field[] spiritFields = spirit.getClass().getDeclaredFields();
		
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
		for (Integer index : combined) {
			occurrenceSet.putIfAbsent(index, Collections.frequency(combined, index));
		}
		
		return occurrenceSet;
	}
}