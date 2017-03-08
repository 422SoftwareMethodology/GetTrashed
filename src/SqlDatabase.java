import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SqlDatabase {
	private Connection connection = null;
	private SqlQueryBuilder sqlQuery;
	SqlDatabase() {
		String srcLocation = Driver.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String sTempDb = "drinks.db";
        String sJdbc = "jdbc:sqlite:" + srcLocation;
        System.out.println(sJdbc);
        String sDbUrl = sJdbc + sTempDb;
        String sDriverName = "org.sqlite.JDBC";
	    try {
	    	Class.forName(sDriverName);
	    	connection = DriverManager.getConnection(sDbUrl);
	    } catch ( Exception e ) {
	    	System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    	System.exit(0);
	    }
	    System.out.println("Opened database successfully");
    }
	
	public String QueryForName(Entry<Integer, Integer> entry) {
		sqlQuery = new SqlQueryBuilder(entry, connection);
		return sqlQuery.QueryName();
	}
	
	public Integer QueryForNumIngredients(Entry<Integer, Integer> entry) {
		sqlQuery = new SqlQueryBuilder(entry, connection);
		return sqlQuery.QueryNumIngredients();
	}
	
	public String QueryForDirections(String drinkName) {
		sqlQuery = new SqlQueryBuilder(drinkName, connection);
		return sqlQuery.QueryDirections();
	}
	
	public ArrayList<String> QueryForIngredients(String drinkName) {
		sqlQuery = new SqlQueryBuilder(drinkName, connection);
		return sqlQuery.QueryIngredients();
	}
	
	public ArrayList<String> QueryForMeasurements(String drinkName) {
		sqlQuery = new SqlQueryBuilder(drinkName, connection);
		return sqlQuery.QueryMeasurements();
	}
}