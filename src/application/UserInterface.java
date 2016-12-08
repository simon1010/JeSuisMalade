package application;

import org.controlsfx.control.StatusBar;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.chart.PieChart;
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
import javafx.scene.layout.GridPane;

public class UserInterface extends BorderPane {
    
	/* Define all controls here and be sure to make them public */
	public ToolBar toolbar;
	public StatusBar statusbar;

	// The big boys
  public TabPane tabPane;
  public Tab tabInsert;
  public Tab tabQuery;
  public Tab tabExperimental;
	
  // Insertion tab content
	public FlowPane inputFields;
	public TextField codBoala, varsta;
	public Button butAdaugare;
	public Button butInterogare;
	public ComboBox<String> sexul;
	public TextArea outputWindow;
	
	// Query tab content
	public FlowPane QinputFields;
  public TextField QcodBoala;
  public Button QbutInterogare;
  public ComboBox<String> Qsexul, Qvarsta;;
  public TextArea QoutputWindow;
  
  // Experimental tab content
	public GridPane expFields;
	public PieChart expPieChart;

  /* End control definitions*/
  public UserInterface() {
    
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
    this.Qvarsta = new ComboBox<String>();
    Qvarsta.setMinWidth(190);
    Qvarsta.getItems().add("");
    for(String it : CategoriiVarsta.categoriiVarsta) {
      Qvarsta.getItems().add(it);
    }
    QinputFields.getChildren().add(Qvarsta);

    // TODO: change to radio-buttons
    // Train - harmonica
    QinputFields.getChildren().add(new Label("Sexul:"));
    Qsexul = new ComboBox<String>();
    Qsexul.getItems().add("");
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
    outputWindow.setMinHeight(500);
    outputWindow.setEditable(false);
    inputFields.getChildren().add(outputWindow);
    
    QoutputWindow = new TextArea();
    QoutputWindow.setMaxWidth(500);
    QoutputWindow.setMinHeight(500);
    QoutputWindow.setEditable(false);
    QinputFields.getChildren().add(QoutputWindow);

    // The TABS
    tabPane         = new TabPane();
    tabInsert       = new Tab();
    tabQuery        = new Tab();
    tabExperimental = new Tab();
        
    inputFields.setOrientation(Orientation.VERTICAL);
    inputFields.setVgap(10);
    inputFields.setHgap(20);
    inputFields.setPadding(new Insets(10, 10, 10, 10));

    // TODO:
    // inputFields.setPrefWrapLength(210);

    QinputFields.setOrientation(Orientation.VERTICAL);
    QinputFields.setVgap(10);
    QinputFields.setHgap(20);
    QinputFields.setPadding(new Insets(10, 10, 10, 10));

    // EXPERIMENTAL
    expFields = new GridPane();
    expPieChart = new PieChart();
    expFields.getChildren().add(expPieChart);
       
    PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
    PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
    PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);

    expPieChart.getData().add(slice1);
    expPieChart.getData().add(slice2);
    expPieChart.getData().add(slice3);

    
    tabInsert.setContent(inputFields);
    tabQuery.setContent(QinputFields);
    tabExperimental.setContent(expFields);

    tabInsert.setText("Inserare");
    tabQuery.setText("Interogare");
    tabExperimental.setText("Experimental");
    
    tabInsert.setClosable(false);
    tabQuery.setClosable(false);
    tabExperimental.setClosable(false);

    tabPane.getTabs().add(tabInsert);
    tabPane.getTabs().add(tabQuery);
    tabPane.getTabs().add(tabExperimental);

    this.setCenter(tabPane);
    this.setBottom(statusbar);
  }
  @Override
public void resize(double width, double height) {
    super.resize(width, height);
  System.out.println("w= " +width + "h= " + height + "\n");
}
// private double windowW = 0, windowH = 0;
//  
//  @Override
//  public void resize(double width, double height) {
//    
//    if (windowH != 0 && windowW != 0) {
//      double deltaH = 0., deltaW = 0.;
//      if (windowH != height) {
//        deltaH = height - windowH;
//      }
//      if (windowW != width) {
//        deltaW = width - windowW;
//      }
//      
//      double qw = QoutputWindow.getWidth();
//      double qh = QoutputWindow.getHeight();
//      
//      System.out.println("w= " +qw + "h= " + qh + "\n");
//      QoutputWindow.setMinHeight(qh + deltaH);
//      QoutputWindow.setMinWidth(qw + deltaW);
//    }
//
//    windowH = height;
//    windowW = width;
//
//    super.resize(width, height);
//  }

}
