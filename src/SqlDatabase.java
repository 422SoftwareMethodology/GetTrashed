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
	
	public ArrayList<String> Query(Integer[] combined) {
		SqlQueryBuilder sqlQuery = new SqlQueryBuilder(combined, connection);
		//System.out.println("In SqlDatabase");
		for (int i = 0; i < sqlQuery.queriedList.size(); ++i) {
			//System.out.println(sqlQuery.queriedList.get(i)[0]);
		}
		return sqlQuery.queriedList;
	}
}