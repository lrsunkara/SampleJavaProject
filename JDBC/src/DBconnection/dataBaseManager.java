package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataBaseManager {

	private String databaseServerName = "localhost";
	private String databasePort ="1521";
	private String databaseName = "xe";
	private String userName = "hr";
	private String userPassword = "hr";
	private String connectionURL = "jdbc:oracle:thin:hr@//" + databaseServerName+":"+ databasePort +"/"+ databaseName;
	//DB URL:hr@//localhost:1521/xe
	private ResultSet dbRs = null;		
	private Statement dbSt = null;
	private Connection dbCon = null;
	private void connectToOracleDB()  throws SQLException, ClassNotFoundException{
		//Load the driver
		Class.forName("oracle.jdbc.OracleDriver");
		//Create connection
		dbCon = DriverManager.getConnection(connectionURL, userName, userPassword);
		dbSt = dbCon.createStatement();
		}
	public ResultSet runSQLQuerry(String sqlQuery) throws ClassNotFoundException, SQLException{
		connectToOracleDB();
		//dbRs= dbSt.executeQuery(sqlQuery);
	
	return dbSt.executeQuery(sqlQuery);
	}
	
	public static void main(String[] args)  throws Exception, SQLException{
		dataBaseManager db = new dataBaseManager();
		ResultSet dbRs = db.runSQLQuerry("select * from Employees");
	
		while(dbRs.next())
		{
			
			String fName = dbRs.getString("FIRST_NAME");
			System.out.println("First_Name:" + fName);
			
	
		}
		dbRs.close();
		db.closeDBObjects();

	}
	private void closeDBObjects() throws Exception, SQLException
	{
		System.out.println(dbCon.isClosed());
		dbSt.close();
		dbCon.close();
		System.out.println(dbCon.isClosed());
	}


}
