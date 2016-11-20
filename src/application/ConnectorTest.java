package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectorTest {

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
  
  @Test
  public void testGetAgeCategory() {
    
    for (int i = 0; i < 200; i++)
    {
      assertTrue(Connector.getAgeCategory(i) != 0);
    }
    
    assertTrue(Connector.getAgeCategory(0) == 1);
    assertTrue(Connector.getAgeCategory(2) == 1);
    assertTrue(Connector.getAgeCategory(4) == 1);
    assertTrue(Connector.getAgeCategory(5) == 2);
    assertTrue(Connector.getAgeCategory(39) == 8);
    assertTrue(Connector.getAgeCategory(40) == 9);
    assertTrue(Connector.getAgeCategory(52) == 11);
    assertTrue(Connector.getAgeCategory(82) == 17);
    assertTrue(Connector.getAgeCategory(85) == 18);
    assertTrue(Connector.getAgeCategory(100) == 18);
    
  }

}
