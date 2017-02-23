
public class SearchingIngredientsCode {

	public static void main(String[] args){
		
		Ingredients ingred = new Ingredients();
		Spirits spirit = new Spirits();;
		
		
		int[] combined = merge(spirit.vodka, ingred.juiceApple, ingred.juiceOrange, ingred.baileysIrishCream);
		

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
	}
	//This function will take as many arrays as the user puts into it as arguments, and append them all together.  We could probably find
	//another way to append all if this won't work with our checkbox implementation.
	final static public int[] merge(final int[] ...arrays ) {
	    int size = 0;
	    for ( int[] a: arrays )
	        size += a.length;

	        int[] res = new int[size];

	        int destPos = 0;
	        for ( int i = 0; i < arrays.length; i++ ) {
	            if ( i > 0 ) destPos += arrays[i-1].length;
	            int length = arrays[i].length;
	            System.arraycopy(arrays[i], 0, res, destPos, length);
	        }

	        return res;
	}
}

