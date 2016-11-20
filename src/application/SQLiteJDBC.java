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
 
 // the categorieVarsta entry will be an index value representing one of the following categories:
 /* 
1   0-4
2   5-9
3   10-14
4   15-19
5   20-24
6   25-29
7   30-34
8   35-39
9   40-44
10  45-49
11  50-54
12  55-59
13  60-64
14  65-69
15  70-74
16  75-79
17  80-84
18  85+
  */
 
 public boolean newEntry(int codBoala, int categorieVarsta, char sex) throws InvalidArgumentException
 {
   // Validate inputs
   if(categorieVarsta < 1 || categorieVarsta > 18)
     throw new InvalidArgumentException("categorieVarsta - invalid");
   
   if(codBoala < 1 || codBoala > 999)
     throw new InvalidArgumentException("codBoala - invalid");
   
   if(sex != 'M' && sex != 'm' && sex != 'F' && sex != 'f' )
     throw new InvalidArgumentException("sex - invalid");
   
  String sql = "INSERT INTO BOLNAVI (COD_BOALA,CATEGORIE_VARSTA,SEX) " +
                "VALUES (" + codBoala + "," + categorieVarsta + ",'" + sex +"');";
  
  try {
   stmt.executeUpdate(sql);
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   return false;
  }
  return true;
 }

 public void printContent()
 {
  try {
   ResultSet rs = stmt.executeQuery("SELECT * FROM BOLNAVI;");
   while (rs.next()) {
    int nrCrt     = rs.getInt("NRCRT");
    int codBoala  = rs.getInt("COD_BOALA");
    int catVarsta = rs.getInt("CATEGORIE_VARSTA");
    String  sexul = rs.getString("SEX");
    System.out.println("NRCRT            = " + nrCrt);
    System.out.println("COD_BOALA        = " + codBoala);
    System.out.println("CATEGORIE_VARSTA = " + catVarsta);
    System.out.println("GENUL            = " + sexul);
    System.out.println();
   }
   rs.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
  
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
