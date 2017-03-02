import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class SqlDatabase {
	private Connection connection = null;
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
	
	public ArrayList<String> Query(int[] combined) {
		SqlQueryBuilder sqlQuery = new SqlQueryBuilder(combined, connection);
		return sqlQuery.queriedList;
	}
}