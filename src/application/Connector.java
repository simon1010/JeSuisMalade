package application;

public class Connector {
	
	public Connector(SQLiteJDBC DB, UserInterface UI)
	{
		// TODO move this to sepparate method
		UI.butAdaugare.setOnAction(value ->  {
			UI.statusbar.setText("OK -- Clicked Button");
			// TODO make varsta map to a value from the categorii de varsta
			// TODO clear the textboxes after insert
			// TODO create an overview stringbox in the UI itself
			if(DB.newEntry(Integer.parseInt(UI.codBoala.getText()), Integer.parseInt(UI.varsta.getText()), UI.sexul.getValue().charAt(0)))
			{
				DB.printContent();
			}
        });
		
	}
}
