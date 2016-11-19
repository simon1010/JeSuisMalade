package application;

import java.sql.*;

public class SQLiteJDBC {
	
	Connection c   = null;
	Statement stmt = null;
	
	public SQLiteJDBC()
	{
		createConnection();
		
		// call if modifying initial table structure, the application ships with a pre-defined database structure.
		tableSetup();
	}
	
	public boolean newEntry(int codBoala, int categorieVarsta, char sex)
	{
		String sql = "INSERT INTO BOLNAVI (COD_BOALA,CATEGORIE_VARSTA,SEX) " +
                "VALUES (" + codBoala + "," + categorieVarsta + "," + sex +");";
		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public void closeDBAccess() throws SQLException
	{	
		stmt.close();
		c.close();
	}
	
	private void createConnection()
	{
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c    = DriverManager.getConnection("jdbc:sqlite:test.db");
	      stmt = c.createStatement();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	private void tableSetup()
	{
		String initialQuery = "SELECT name FROM sqlite_master WHERE type='table' AND name='BOLNAVI'";
		
		try {
			ResultSet resultSet = stmt.executeQuery(initialQuery);
			//String tableName = resultSet.getString("name"); 
			if(!resultSet.next()){
				
				String sql = "CREATE TABLE BOLNAVI " +
						     "(NRCRT  INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL, " + 
						     " COD_BOALA           INT                   NOT NULL, " +  // 1 - 999
						     " CATEGORIE_VARSTA    INT                   NOT NULL, " +  // 1 - 10 -> Create association
						     " SEX                 CHAR(1)               NOT NULL)" ;  // Male Female only
			
				stmt.executeUpdate(sql);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void dropTable()
	{
		String sql = "DROP TABLE BOLNAVI";		
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
