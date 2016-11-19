package application;
	
import org.controlsfx.control.StatusBar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// DBC Part
			SQLiteJDBC myDB = new SQLiteJDBC();
			// end DBC Part
			
			BorderPane root = new BorderPane();
			
			ToolBar toolbar = new ToolBar();
		    StatusBar statusbar = new StatusBar();
		    
		    Button button = new Button("Click");
            Label label = new Label("Not clicked");
	        button.setOnAction(value ->  {
	           statusbar.setText("OK -- Clicked Button");
	           label.setText("Clicked!");
	        });

	        HBox hbox = new HBox(button, label);
	        
		    root.setTop(toolbar);
		    root.setCenter(hbox);
		    root.setBottom(statusbar);
		     
			Scene scene = new Scene(root,400,400);
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
