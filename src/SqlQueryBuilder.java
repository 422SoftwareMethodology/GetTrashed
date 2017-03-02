import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlQueryBuilder {
	String name;
	ArrayList<Integer> iDArray;
	ArrayList<String> queriedList = new ArrayList<String>();
	Connection localConnection;
	SqlQueryBuilder(ArrayList<Integer> combined, Connection connection) {
		iDArray = combined;
		localConnection = connection;
	}
	
	SqlQueryBuilder(String drinkName, Connection connection) {
		name = drinkName;
		localConnection = connection;
	}
	
	public ArrayList<String> QueryForName() {
		try {
			Statement statement = null;
			statement = localConnection.createStatement();
			for (int i = 0; i < iDArray.size(); ++i) {
				ResultSet rS = statement.executeQuery("SELECT * FROM DRINKS where ID = '" + iDArray.get(i) + "';");
				queriedList.add(i, rS.getString(2));
				queriedList.add(i, rS.getString(5));
			}
		} catch ( Exception e ) {}
		return queriedList;
	}
	
	public ArrayList<String> QueryForIngredients() {
		try {
			Statement statement = null;
			statement = localConnection.createStatement();
			ResultSet rS = statement.executeQuery("SELECT * FROM DRINKS where NAME = '" + name + "';");
			queriedList.add(rS.getString(7));
			queriedList.add(rS.getString(8));
			queriedList.add(rS.getString(9));
			queriedList.add(rS.getString(10));
			queriedList.add(rS.getString(11));
			queriedList.add(rS.getString(12));
			queriedList.add(rS.getString(13));
			queriedList.add(rS.getString(14));
			queriedList.add(rS.getString(15));
			queriedList.add(rS.getString(16));
			queriedList.add(rS.getString(17));
			queriedList.add(rS.getString(18));
			queriedList.add(rS.getString(19));
			queriedList.add(rS.getString(20));
			queriedList.add(rS.getString(21));
		} catch ( Exception e ) {}
		return queriedList;
	}
	
	public ArrayList<String> QueryForMeasurements() {
		try {
			Statement statement = null;
			statement = localConnection.createStatement();
			ResultSet rS = statement.executeQuery("SELECT * FROM DRINKS where NAME = '" + name + "';");
			queriedList.add(rS.getString(22));
			queriedList.add(rS.getString(23));
			queriedList.add(rS.getString(24));
			queriedList.add(rS.getString(25));
			queriedList.add(rS.getString(26));
			queriedList.add(rS.getString(27));
			queriedList.add(rS.getString(28));
			queriedList.add(rS.getString(29));
			queriedList.add(rS.getString(30));
			queriedList.add(rS.getString(31));
			queriedList.add(rS.getString(32));
			queriedList.add(rS.getString(33));
			queriedList.add(rS.getString(34));
			queriedList.add(rS.getString(35));
			queriedList.add(rS.getString(36));
		} catch ( Exception e ) {}
		return queriedList;
	}
}