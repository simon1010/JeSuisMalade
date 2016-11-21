package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// DBC Part
			SQLiteJDBC myDB = new SQLiteJDBC();
			// end DBC Part
			
			// UI
			UserInterface ui = new UserInterface();
			// end UI
			
			// Class which connects the DBC to the UI, business-logic
			Connector uiToDBConnector = new Connector(myDB, ui);
			
			Scene scene = new Scene(ui,750,320);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
