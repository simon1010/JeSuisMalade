package application;

public class Connector {
  
	public Connector(SQLiteJDBC DB, UserInterface UI)
	{
		handleButAdaugare(DB, UI);
		handleButInterogare(DB, UI);
	}
	
	private void handleButInterogare(SQLiteJDBC dB, UserInterface uI) 
	{
	  uI.butInterogare.setOnMouseEntered(value ->  {
      uI.statusbar.setText("Apasa pentru a interoga baza de date");
    });
    
    uI.butInterogare.setOnMouseExited(value ->  {
      uI.statusbar.setText("OK");
    });
  }

  private void handleButAdaugare(SQLiteJDBC DB, UserInterface UI)
	{
		UI.butAdaugare.setOnMouseEntered(value ->  {
			UI.statusbar.setText("Apasa pentru adaugare in baza de date");
		});
		
		UI.butAdaugare.setOnMouseExited(value ->  {
			UI.statusbar.setText("OK");
		});
		
		UI.butAdaugare.setOnAction(value ->  {
			UI.statusbar.setText("Se adauga in baza de date");
			// TODO make varsta map to a value from the categorii de varsta
			// TODO clear the textboxes after insert
			// TODO create an overview stringbox in the UI itself
			try {
        if(DB.newEntry(Integer.parseInt(UI.codBoala.getText()), getAgeCategory(Integer.parseInt(UI.varsta.getText())), UI.sexul.getValue().charAt(0)))
        {
        	DB.printContent();
        	UI.statusbar.setText("Adaugat!");
        }
      } catch (NumberFormatException | InvalidArgumentException e) {
        e.printStackTrace();
      }
    });
	}
	
	public static int getAgeCategory(int Age)
	{
	  if(Age >= 85)
	  {
	    return 18;
	  }
	  int cat = 1;
	  for(int i = 0; i < 86; i+= 5, cat++)
	  {
	    if(i > Age)
	      return cat - 1;
	  }
	  return 0;
	}
	
	
}
