import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlQueryBuilder {
	public ArrayList<String> queriedList;
	SqlQueryBuilder(Integer[] combined, Connection connection) {
		String[] drinkInfo = new String[2];
		queriedList = new ArrayList<String>();
		try {
			Statement statement = null;
			statement = connection.createStatement();
			for (int i = 0; i < combined.length; ++i) {
				ResultSet rS = statement.executeQuery("SELECT * FROM DRINKS where ID = '" + combined[i] + "';");
				drinkInfo[0] = rS.getString(2);
				//System.out.println(rS.getString(2));
				drinkInfo[1] = rS.getString(5);
				//System.out.println(rS.getString(5));
				queriedList.add(i, rS.getString(2));
				queriedList.add(i, rS.getString(5));
				//System.out.println(queriedList.get(i)[0]);
				//System.out.println(queriedList.get(0)[0]);
			}
			/*for (int j = 0; j < queriedList.size(); ++j) {
				System.out.println(queriedList.get(j)[0]);
			}*/
			System.out.println(combined.length);
			System.out.println(queriedList.size());
		} catch ( Exception e ) {}
	}
}
