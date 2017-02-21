import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class test {
	public static String[] userinput;
	public static String i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;
	public ArrayList<String> drinklist;

	public static void main( String args[] ){
		 {
			 	Connection c = null;
			    Statement stmt = null;
			    try {
			      Class.forName("org.sqlite.JDBC");
			      c = DriverManager.getConnection("jdbc:sqlite:drinks.db");
			      c.setAutoCommit(false);
			      System.out.println("Opened database successfully");
			      String in1 = "Club soda";
			      String in2 = "Sugar";
			      String in3 = "Bourbon";
			      userinput = new String[3];
			      userinput[0] = in1;
			      userinput[1] = in2;
			      userinput[2] = in3;
			      //select query from table
			      Statement stmt1 = c.createStatement();
			      ResultSet rs = stmt1.executeQuery("SELECT * FROM DRINKS WHERE INGREDIENT1 = '" + userinput[0] + "' OR INGREDIENT1 = '" + userinput[1] + "' OR INGREDIENT1 ='" + userinput[2]
			    		+ "' OR INGREDIENT2 = '" + userinput[0] + "' OR INGREDIENT2 = '" + userinput[1] + "' OR INGREDIENT2 ='" + userinput[2]
			    		+ "' OR INGREDIENT3 = '" + userinput[0] + "' OR INGREDIENT3 = '" + userinput[1] + "' OR INGREDIENT3 ='" + userinput[2]
			    		+ "' OR INGREDIENT4 = '" + userinput[0] + "' OR INGREDIENT4 = '" + userinput[1] + "' OR INGREDIENT4 ='" + userinput[2]
			    		+ "' OR INGREDIENT5 = '" + userinput[0] + "' OR INGREDIENT5 = '" + userinput[1] + "' OR INGREDIENT5 ='" + userinput[2]
			    		+ "' OR INGREDIENT6 = '" + userinput[0] + "' OR INGREDIENT6 = '" + userinput[1] + "' OR INGREDIENT6 ='" + userinput[2]
			    		+ "' OR INGREDIENT7 = '" + userinput[0] + "' OR INGREDIENT7 = '" + userinput[1] + "' OR INGREDIENT7 ='" + userinput[2]
			    		+ "' OR INGREDIENT8 = '" + userinput[0] + "' OR INGREDIENT8 = '" + userinput[1] + "' OR INGREDIENT8 ='" + userinput[2]		
			    		+ "' OR INGREDIENT9 = '" + userinput[0] + "' OR INGREDIENT9 = '" + userinput[1] + "' OR INGREDIENT9 ='" + userinput[2]
			    		+ "' OR INGREDIENT10 = '" + userinput[0] + "' OR INGREDIENT10 = '" + userinput[1] + "' OR INGREDIENT10 ='" + userinput[2]
			    	    + "' OR INGREDIENT11 = '" + userinput[0] + "' OR INGREDIENT11 = '" + userinput[1] + "' OR INGREDIENT11 ='" + userinput[2]
			    		+ "' OR INGREDIENT12 = '" + userinput[0] + "' OR INGREDIENT12 = '" + userinput[1] + "' OR INGREDIENT12 ='" + userinput[2]
			    		+ "' OR INGREDIENT13 = '" + userinput[0] + "' OR INGREDIENT13 = '" + userinput[1] + "' OR INGREDIENT13 ='" + userinput[2]
			    		+ "' OR INGREDIENT14 = '" + userinput[0] + "' OR INGREDIENT14 = '" + userinput[1] + "' OR INGREDIENT14 ='" + userinput[2]
			    		+ "' OR INGREDIENT15 = '" + userinput[0] + "' OR INGREDIENT15 = '" + userinput[1] + "' OR INGREDIENT15 ='" + userinput[2]
			    		+"';");
			      while (rs.next()) {
			    	 int score = 0;
			         int id = rs.getInt("ID");
			         String name = rs.getString("NAME");
			         i1 = rs.getString("INGREDIENT1");
			         i2 = rs.getString("INGREDIENT2");
			         i3 = rs.getString("INGREDIENT3");
			         i4 = rs.getString("INGREDIENT4");
			         i5 = rs.getString("INGREDIENT5");
			         i6 = rs.getString("INGREDIENT6");
			         i7 = rs.getString("INGREDIENT7");
			         i8 = rs.getString("INGREDIENT8");
			         i9 = rs.getString("INGREDIENT9");
			         i10 = rs.getString("INGREDIENT10");
			         i11 = rs.getString("INGREDIENT11");
			         i12 = rs.getString("INGREDIENT12");
			         i13 = rs.getString("INGREDIENT13");
			         i14 = rs.getString("INGREDIENT14");
			         i15 = rs.getString("INGREDIENT15");
			         score = matchingredient(userinput, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15);
			         
			         stmt = c.createStatement();
				     String sql = "UPDATE DRINKS set NUMINGREDIENTS = " + score + " WHERE ID = " + id + ";";
				     stmt.executeUpdate(sql);
			         int num  = rs.getInt("NUMINGREDIENTS");
			         
			         /*System.out.print( "ID = " + id + " ");
			         System.out.print( "NAME = " + name + " ");
			         System.out.print( "matchnum = " + num + " ");
			         System.out.print( "INGREDIENT1 = " + i1 + " ");
			         System.out.println( "INGREDIENT2 = " + i2);*/
			         stmt.close();
			      }
			      rs.close();
			      stmt1.close();
			      
			      Statement stmt2 = c.createStatement();
			      ResultSet rs1 = stmt2.executeQuery("SELECT * FROM DRINKS WHERE INGREDIENT1 = '" 
			    		    + userinput[0] + "' OR INGREDIENT1 = '" + userinput[1] + "' OR INGREDIENT1 ='" + userinput[2]
				    		+ "' OR INGREDIENT2 = '" + userinput[0] + "' OR INGREDIENT2 = '" + userinput[1] + "' OR INGREDIENT2 ='" + userinput[2]
				    		+ "' OR INGREDIENT3 = '" + userinput[0] + "' OR INGREDIENT3 = '" + userinput[1] + "' OR INGREDIENT3 ='" + userinput[2]
				    		+ "' OR INGREDIENT4 = '" + userinput[0] + "' OR INGREDIENT4 = '" + userinput[1] + "' OR INGREDIENT4 ='" + userinput[2]
				    		+ "' OR INGREDIENT5 = '" + userinput[0] + "' OR INGREDIENT5 = '" + userinput[1] + "' OR INGREDIENT5 ='" + userinput[2]
				    		+ "' OR INGREDIENT6 = '" + userinput[0] + "' OR INGREDIENT6 = '" + userinput[1] + "' OR INGREDIENT6 ='" + userinput[2]
				    		+ "' OR INGREDIENT7 = '" + userinput[0] + "' OR INGREDIENT7 = '" + userinput[1] + "' OR INGREDIENT7 ='" + userinput[2]
				    		+ "' OR INGREDIENT8 = '" + userinput[0] + "' OR INGREDIENT8 = '" + userinput[1] + "' OR INGREDIENT8 ='" + userinput[2]		
				    		+ "' OR INGREDIENT9 = '" + userinput[0] + "' OR INGREDIENT9 = '" + userinput[1] + "' OR INGREDIENT9 ='" + userinput[2]
				    		+ "' OR INGREDIENT10 = '" + userinput[0] + "' OR INGREDIENT10 = '" + userinput[1] + "' OR INGREDIENT10 ='" + userinput[2]
				    	    + "' OR INGREDIENT11 = '" + userinput[0] + "' OR INGREDIENT11 = '" + userinput[1] + "' OR INGREDIENT11 ='" + userinput[2]
				    		+ "' OR INGREDIENT12 = '" + userinput[0] + "' OR INGREDIENT12 = '" + userinput[1] + "' OR INGREDIENT12 ='" + userinput[2]
				    		+ "' OR INGREDIENT13 = '" + userinput[0] + "' OR INGREDIENT13 = '" + userinput[1] + "' OR INGREDIENT13 ='" + userinput[2]
				    		+ "' OR INGREDIENT14 = '" + userinput[0] + "' OR INGREDIENT14 = '" + userinput[1] + "' OR INGREDIENT14 ='" + userinput[2]
				    		+ "' OR INGREDIENT15 = '" + userinput[0] + "' OR INGREDIENT15 = '" + userinput[1] + "' OR INGREDIENT15 ='" + userinput[2]
				    		+"' ORDER BY NUMINGREDIENTS DESC;");
			      while (rs1.next()){
			    	  System.out.print( "ID = " + rs1.getInt("ID")+ " ");
			    	  System.out.print( "NAME = " + rs1.getString("NAME") + " ");
			    	  System.out.print( "Matchnum = " + rs1.getInt("NUMINGREDIENTS") + " ");
			    	  System.out.println("Missing = " + (userinput.length - rs1.getInt("NUMINGREDIENTS")));
			      }
			      rs1.close();
			      stmt2.close();
			      c.commit();
			      c.close();
			    } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			    }
			    System.out.println("Operation done successfully");
}
	}
	 public static int matchingredient(String [] input, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13,
			 String s14, String s15){
		 int result = 0;
		 for(int i = 0; i < input.length; i++){
			 if(s1.equals(input[i]))
				 result += 1;
			 if(s2.equals(input[i]))
				 result += 1;
			 if(s3.equals(input[i]))
				 result += 1;
			 if(s4.equals(input[i]))
				 result += 1;
			 if(s5.equals(input[i]))
				 result += 1;
			 if(s6.equals(input[i]))
				 result += 1;
			 if(s7.equals(input[i]))
				 result += 1;
			 if(s8.equals(input[i]))
				 result += 1;
			 if(s9.equals(input[i]))
				 result += 1;
			 if(s10.equals(input[i]))
				 result += 1;
			 if(s11.equals(input[i]))
				 result += 1;
			 if(s12.equals(input[i]))
				 result += 1;
			 if(s13.equals(input[i]))
				 result += 1;
			 if(s14.equals(input[i]))
				 result += 1;
			 if(s15.equals(input[i]))
				 result += 1;
		 }
		 return result;
	 }
	}
