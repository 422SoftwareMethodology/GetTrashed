import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class SearchingIngredientsCode {

	public Integer[] Search(ArrayList<String> filterIngredients){
		
		Ingredients ingredients = new Ingredients();
		Spirits spirit = new Spirits();
		Integer[] combined = new Integer[4000];
		Class<? extends Ingredients> ingredientsClass = ingredients.getClass();
		Field[] ingredientFields = ingredientsClass.getDeclaredFields();		
		Class<? extends Spirits> spiritsClass = spirit.getClass();
		Field[] spiritFields = spiritsClass.getDeclaredFields();
		
		for (int i = 0; i < filterIngredients.size(); ++i) {
			for (Field f : spiritFields) {
				if (f.getName().equals(filterIngredients.get(i))) {
					try {
						combined = merge((int[]) f.get(spirit));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			for (Field f : ingredientFields) {
				if (f.getName().equals(filterIngredients.get(i))) {
					try {
						combined = merge((int[]) f.get(ingredients));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		for (int i = 0; i < combined.length; ++i) {
			if (combined[i] != null) {
				System.out.println(combined[i]);
			}
		}
		MergeSort mms = new MergeSort();
		mms.sort(combined);
		
		int combinedSize = combined.length;
		
		Integer[] twoIngredients = new Integer[combinedSize];
		Integer[] threeIngredients = new Integer[combinedSize];
		Integer[] fourIngredients = new Integer[combinedSize];
		int twoArrayPosition = 0;
		int threeArrayPosition = 0;
		int fourArrayPosition = 0;
		int numIngredients = 1;
		for(int i = 0; i < combined.length - 1; i++){
			if(combined[i] == combined[i+1]){
				numIngredients++;
			}
			else{
				//here is where we would add the recipe to an array that corresponds to number of ingredients missing
				//We would compare the amount of ingredients we have (number of consecutive ingredients), to the 
				//number of ingredients in the recipe (by doing a call to the database).  If getNumIngred(i) -numIngredients = 0,
				//then it would go into the ready to make, otherwise, the difference would be the number of missing ingredients.  If we limit
				//the number of missing ingredients to "Ready to make", "Missing One", "Missing Two", and "Missing 3 or more", we would
				//only have to deal with 4 arrays.  For this demo, I'm just going to add the number of ingredients into their arrays.
				if(numIngredients == 2){
					twoIngredients[twoArrayPosition] = combined[i];
					numIngredients = 1;
					twoArrayPosition++;
				}
				else if(numIngredients == 3){
					threeIngredients[threeArrayPosition] = combined[i];
					numIngredients = 1;
					threeArrayPosition++;
				}
				else if(numIngredients ==4){
					fourIngredients[fourArrayPosition] = combined[i];
					numIngredients = 1;
					fourArrayPosition++;
				}
				else{
					numIngredients = 1;
				}
			}
		}
		System.out.print("Two Ingredients List: ");
				for (int i = 0; i < twoIngredients.length; i++){
					if(twoIngredients[i] != null){
						System.out.print(twoIngredients[i] + " ");
					}
				}
		System.out.print("\n");
		System.out.print("Three Ingredients List: ");
		for (int i = 0; i < threeIngredients.length; i++){
			if(threeIngredients[i] != null){
				System.out.print(threeIngredients[i] + " ");
			}
		}
		System.out.print("\n");
		System.out.print("Four Ingredients List: ");
		for (int i = 0; i < fourIngredients.length; i++){
			if(fourIngredients[i] != null){
				System.out.print(fourIngredients[i] + " ");
			}
		}
System.out.print("\n");
return combined;
	}
	//This function will take as many arrays as the user puts into it as arguments, and append them all together.  We could probably find
	//another way to append all if this won't work with our checkbox implementation.
	final static public Integer[] merge(final int[] ...arrays ) {
	    int size = 0;
	    for (int[] a : arrays) {
	        size += a.length;
	    }
	    Integer[] res = new Integer[size];
	    for (int[] a : arrays) {
	    	Integer[] boxedInts = IntStream.of(a).boxed().toArray(Integer[]::new);
	    	int destPos = 0;
	        for ( int i = 0; i < arrays.length; i++ ) {
	            if (i > 0) {
	            	destPos += boxedInts.length;
	            }
	            int length = boxedInts.length;
	            System.arraycopy(boxedInts, 0, res, destPos, length);
	        }
	    }
	    return res;
	}
}

