package application;

import org.controlsfx.control.StatusBar;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
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
	public Button butInterogare;
	public ComboBox<String> sexul;
	public TextArea outputWindow;
	public TabPane tabPane;
	public Tab tabInsert;
	public Tab tabQuery;
	/* End control definitions*/

	public FlowPane QinputFields;
  public TextField QcodBoala, Qvarsta;
  public Button QbutInterogare;
  public ComboBox<String> Qsexul;
  public TextArea QoutputWindow;
	
	
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
	    sexul.setMinWidth(190);
	    inputFields.getChildren().add(sexul);
	    
	    
	    
	     this.QinputFields = new FlowPane();
	      QinputFields.getChildren().add(new Label("Cod Boala:"));
	      this.QcodBoala = new TextField();
	      QinputFields.getChildren().add(QcodBoala);
	      
	      QinputFields.getChildren().add(new Label("Varsta:"));
	      this.Qvarsta = new TextField();
	      QinputFields.getChildren().add(Qvarsta);
	      
	      QinputFields.getChildren().add(new Label("Sexul:"));
	      Qsexul = new ComboBox<String>();
	      Qsexul.getItems().add("M");
	      Qsexul.getItems().add("F");
	      Qsexul.setMinWidth(190);
	      QinputFields.getChildren().add(Qsexul);
	    
	    
	    butAdaugare = new Button("Adaugare");
	    butAdaugare.setMinWidth(190);
	    inputFields.getChildren().add(butAdaugare);
	    
	    butInterogare = new Button("Interogare");
	    butInterogare.setMinWidth(190);
	    QinputFields.getChildren().add(butInterogare);
	    
	    outputWindow = new TextArea();
	    outputWindow.setMaxWidth(500);
	    outputWindow.setMinHeight(225);
	    outputWindow.setEditable(false);
	    QinputFields.getChildren().add(outputWindow);
	    
	    tabPane = new TabPane();
	    tabInsert = new Tab();
	    tabQuery = new Tab();
	    
	    
	    inputFields.setOrientation(Orientation.VERTICAL);
	    inputFields.setVgap(10);
	    inputFields.setHgap(20);
	    
	    
	    QinputFields.setOrientation(Orientation.VERTICAL);
      QinputFields.setVgap(10);
      QinputFields.setHgap(20);
      
	    
	    tabInsert.setContent(inputFields);
	    tabQuery.setContent(QinputFields);
	    
	    tabInsert.setText("Inserare");
	    tabQuery.setText("Interogare");
	    
	    tabInsert.setClosable(false);
	    tabQuery.setClosable(false);
	    
	    tabPane.getTabs().add(tabInsert);
	    tabPane.getTabs().add(tabQuery);
	    
	    Region regionLeft = new Region();
	    regionLeft.setMinWidth(10);
	    this.setLeft(regionLeft);
	    
	    Region regionRight = new Region();
	    regionRight.setMinWidth(10);
	    this.setRight(regionRight);
	    
	    /*
	    Button button = new Button("Adaugare");
        Label label = new Label("Not clicked");
        button.setOnAction(value ->  {
           statusbar.setText("OK -- Clicked Button");
           label.setText("Clicked!");
        });

        HBox hbox = new HBox(button, label);*/
      
	    //this.setTop(toolbar);
	    this.setCenter(tabPane);
	    this.setBottom(statusbar);
    }

}
