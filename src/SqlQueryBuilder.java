import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlQueryBuilder {
	public ArrayList<String> queriedList;
	SqlQueryBuilder(int[] combined, Connection connection) {
		queriedList = new ArrayList<String>();
		try {
			Statement statement = null;
			statement = connection.createStatement();
			for (int i = 0; i < combined.length; ++i) {
				ResultSet rS = statement.executeQuery("SELECT * FROM DRINKS where ID = '" + combined[i] + "';");
				queriedList.add(i, rS.getString(2));
				queriedList.add(i, rS.getString(5));
			}
		} catch ( Exception e ) {}
	}
}