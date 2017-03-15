import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map.Entry;

public class SqlDatabase {
	private Connection connection = null;
	private SqlQueryBuilder sqlQuery;
	SqlDatabase() {}
	
	public void OpenConnection() {
        String sDriverName = "org.sqlite.JDBC";
	    try {
	    	Class.forName(sDriverName);
	    	connection = DriverManager.getConnection("jdbc:sqlite::resource:drinks.db");
	    } catch ( Exception e ) {
	    	System.err.println(e.getClass().getName() + ": " + e.getMessage());
	    	System.exit(0);
	    }
	}
	
	public void CloseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> QueryForNumIngredients(Entry<Integer, Integer> entry) {
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