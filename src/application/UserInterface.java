package application;

import org.controlsfx.control.StatusBar;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;

public class UserInterface extends BorderPane {
    
	/* Define all controls here and be sure to make them public */
	public ToolBar toolbar;
	public StatusBar statusbar;
	
	public FlowPane inputFields;
	public TextField codBoala, varsta;
	public Button butAdaugare;
	public ComboBox<String> sexul;
	/* End control definitions*/

	public UserInterface()
    {
    	this.toolbar = new ToolBar();
	    this.statusbar = new StatusBar();
	    
	    // Flow pane and items
	    this.inputFields = new FlowPane();
	    inputFields.getChildren().add(new Label("Cod Boala:"));
	    this.codBoala = new TextField();
	    inputFields.getChildren().add(codBoala);
	    
	    inputFields.getChildren().add(new Label("Varsta:"));
	    this.varsta = new TextField();
	    inputFields.getChildren().add(varsta);
	    
	    inputFields.getChildren().add(new Label("Sexul:"));
	    sexul = new ComboBox<String>();
	    sexul.getItems().add("M");
	    sexul.getItems().add("F");
	    inputFields.getChildren().add(sexul);
	    
	    butAdaugare = new Button("Adaugare");
	    inputFields.getChildren().add(butAdaugare);
	    inputFields.setOrientation(Orientation.VERTICAL);
	    inputFields.setVgap(10);
	    
	    Region region = new Region();
	    region.setMinWidth(10);
	    this.setLeft(region);
	    /*
	    Button button = new Button("Adaugare");
        Label label = new Label("Not clicked");
        button.setOnAction(value ->  {
           statusbar.setText("OK -- Clicked Button");
           label.setText("Clicked!");
        });

        HBox hbox = new HBox(button, label);*/
        
	    this.setTop(toolbar);
	    this.setCenter(inputFields);
	    this.setBottom(statusbar);
    }

}
