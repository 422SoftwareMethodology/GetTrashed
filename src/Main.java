import java.sql.*;

import org.apache.commons.codec.binary.StringUtils;

public class Main {
	public static void main(String[] args) {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:drinks.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      stmt = c.createStatement();
	      /*
	      String sql = "CREATE TABLE DRINKS " +
                  "(ID INT PRIMARY 	KEY     NOT NULL," +
                  " NAME           	TEXT    NOT NULL, " + 
                  " CATERGORY    	CHAR(50), "  	+ 
                  " ALCOHOLIC    	CHAR(50), "  	+ 
                  " INSTRUCTIONS 	CHAR(500), " 	+
                  " NUMINGREDIENTS 	INT,    "  		+
                  " INGREDIENT1  	CHAR(50), "  	+
                  " INGREDIENT2  	CHAR(50), "  	+
                  " INGREDIENT3  	CHAR(50), "  	+
                  " INGREDIENT4  	CHAR(50), "  	+
                  " INGREDIENT5  	CHAR(50), "  	+
                  " INGREDIENT6  	CHAR(50), "  	+
                  " INGREDIENT7  	CHAR(50), "  	+
                  " INGREDIENT8  	CHAR(50), "  	+
                  " INGREDIENT9  	CHAR(50), "  	+
                  " INGREDIENT10  	CHAR(50), "  	+
                  " INGREDIENT11  	CHAR(50), "  	+
                  " INGREDIENT12  	CHAR(50), "  	+
                  " INGREDIENT13  	CHAR(50), "  	+
                  " INGREDIENT14  	CHAR(50), "  	+
                  " INGREDIENT15  	CHAR(50), "  	+
                  " MEASUREMENT1  	CHAR(50), " 	+
                  " MEASUREMENT2  	CHAR(50), " 	+
                  " MEASUREMENT3  	CHAR(50), " 	+
                  " MEASUREMENT4  	CHAR(50), " 	+
                  " MEASUREMENT5  	CHAR(50), " 	+
                  " MEASUREMENT6  	CHAR(50), " 	+
                  " MEASUREMENT7  	CHAR(50), " 	+
                  " MEASUREMENT8  	CHAR(50), " 	+
                  " MEASUREMENT9  	CHAR(50), " 	+
                  " MEASUREMENT10  	CHAR(50), " 	+
                  " MEASUREMENT11  	CHAR(50), " 	+
                  " MEASUREMENT12  	CHAR(50), " 	+
                  " MEASUREMENT13  	CHAR(50), " 	+
                  " MEASUREMENT14  	CHAR(50), " 	+
                  " MEASUREMENT15  	CHAR(50))"; 
            */
	    String sql, name, category, alcoholic, instructions, ingr1, ingr2, ingr3, ingr4, ingr5, ingr6, ingr7, ingr8, ingr9, ingr10,
	    	   ingr11, ingr12, ingr13, ingr14, ingr15, msr1, msr2, msr3, msr4, msr5, msr6, msr7, msr8, msr9, msr10, msr11, msr12,
	    	   msr13, msr14, msr15;
	    int id = 3073;
		for (int i = 17172; i < 17173; ++i) {
			
				for (Drink drink : BuildDB.getJSONFromUrl("http://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + i)) {
					
					System.out.println("Name: " + drink.getStrDrink() + " \t ID: " + Integer.toString(id));
					
					name 			=	drink.getStrDrink();
					name 			=  	fixShit(name);
					category 		= 	drink.getStrCategory();
					alcoholic 		=	drink.getStrAlcoholic();
					instructions 	=	drink.getStrInstructions();
					instructions 	= 	fixDescription(instructions);
					ingr1 			=	fixIngredient(drink.getStrIngredient1());
					ingr2			=	fixIngredient(drink.getStrIngredient2());
					ingr3			=	fixIngredient(drink.getStrIngredient3());
					ingr4			=	fixIngredient(drink.getStrIngredient4());
					ingr5			=	fixIngredient(drink.getStrIngredient5());
					ingr6			=	fixIngredient(drink.getStrIngredient6());
					ingr7			=	fixIngredient(drink.getStrIngredient7());
					ingr8			=	fixIngredient(drink.getStrIngredient8());
					ingr9			=	fixIngredient(drink.getStrIngredient9());
					ingr10			=	fixIngredient(drink.getStrIngredient10());
					ingr11			=	fixIngredient(drink.getStrIngredient11());
					ingr12			=	fixIngredient(drink.getStrIngredient12());
					ingr13			=	fixIngredient(drink.getStrIngredient13());
					ingr14			=	fixIngredient(drink.getStrIngredient14());
					ingr15			=	fixIngredient(drink.getStrIngredient15());
					msr1			=	drink.getStrMeasure1();
					msr2			=	drink.getStrMeasure2();
					msr3			=	drink.getStrMeasure3();
					msr4			=	drink.getStrMeasure4();
					msr5			=	drink.getStrMeasure5();
					msr6			=	drink.getStrMeasure6();
					msr7			=	drink.getStrMeasure7();
					msr8			=	drink.getStrMeasure8();
					msr9			=	drink.getStrMeasure9();
					msr10			=	drink.getStrMeasure10();
					msr11			=	drink.getStrMeasure11();
					msr12			=	drink.getStrMeasure12();
					msr13			=	drink.getStrMeasure13();
					msr14			=	drink.getStrMeasure14();
					msr15			=	drink.getStrMeasure15();
				
					
				
					
					sql = "INSERT INTO DRINKS (ID, NAME, CATERGORY, ALCOHOLIC, INSTRUCTIONS, NUMINGREDIENTS, "
							+ "INGREDIENT1, INGREDIENT2, INGREDIENT3, INGREDIENT4, INGREDIENT5, INGREDIENT6, INGREDIENT7, "
							+ "INGREDIENT8, INGREDIENT9, INGREDIENT10, INGREDIENT11, INGREDIENT12, INGREDIENT13, INGREDIENT14, "
							+ "INGREDIENT15, MEASUREMENT1, MEASUREMENT2, MEASUREMENT3, MEASUREMENT4, MEASUREMENT5, MEASUREMENT6,"
							+ "MEASUREMENT7, MEASUREMENT8, MEASUREMENT9, MEASUREMENT10, MEASUREMENT11, MEASUREMENT12, MEASUREMENT13,"
							+ "MEASUREMENT14, MEASUREMENT15) " +
				              "VALUES (" + Integer.toString(id) + ", '" + name + "', '" + category +  "', '" + alcoholic + "', '" + instructions +
				              "', " + Integer.toString(0) + ", '" + ingr1 + "', '" + ingr2 + "', '" + ingr3 + "', '" + ingr4 + "', '" + ingr5 + "', '" +
				              ingr6 + "', '" + ingr7 + "', '" + ingr8 + "', '" + ingr9 + "', '" + ingr10 + "', '" + ingr11 + "', '" + ingr12 + "', '" 
				              + ingr13 + "', '" + ingr14 + "', '" + ingr15 + "', '" + msr1 + "', '" + msr2 + "', '" + msr3 + "', '" + msr4 + "', '" 
				              + msr5 + "', '" + msr6 + "', '" + msr7 + "', '" + msr8 + "', '" + msr9 + "', '" + msr10 + "', '" + msr11 + "', '" + msr12 + "', '"
				              + msr13 + "', '" + msr14 + "', '" + msr15 + "');";
				              
					/*sql = "INSERT INTO DRINKS (ID, NAME, CATERGORY) " +
				              "VALUES (0, 'Alexs suprise ;)', 'dropshot');";*/
			
					//System.out.println(sql);
				    stmt.executeUpdate(sql);
				    id++;
					
				}
			} 
	      
	      stmt.close();
	      c.commit();
	      c.close();
     
	    }catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }	
	    /*  
		for (int i = 11000; i < 18000; ++i) {
			for (Drink drink : BuildDB.getJSONFromUrl("http://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + i)) {
				System.out.println(drink.getStrDrink());
			}
		} */
	    System.out.println("DATABASE created successfully BOI");	
	    }


public static String fixShit(String name){
	int index = 0;
	int helper = 0;
	int size = name.length();
	String temp = name;
	int count = size - name.replace("'", "").length();
	name = temp;
	while(count > 0){
		helper = name.indexOf("'", index);
		StringBuilder sb = new StringBuilder(name);
		sb.insert(helper, "'");
		index = helper + 2;
		name = sb.toString();
		count--;
	}
	return name;	
}

public static String fixDescription(String description){
	int index = 0;
	int helper = 0;
	int size = description.length();
	String temp = description;
	int count = description.length() - description.replace("'", "").length();
	description = temp;
	while(count > 0){
		helper = description.indexOf("'", index);
		StringBuilder sb = new StringBuilder(description);
		sb.insert(helper, "'");
		index = helper +2;
		description = sb.toString();
		count--;
	}
	return description;
	
}

public static String fixIngredient(String ingredient){
	if(ingredient.contains("'")){
		int index = ingredient.indexOf("'");
		StringBuilder sb = new StringBuilder(ingredient);
		sb.insert(index, "'");
		ingredient = sb.toString();
	}

	return ingredient;
}

}