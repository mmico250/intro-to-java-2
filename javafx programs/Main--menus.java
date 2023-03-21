package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;


public class Main extends Application {
	
	   Label message;

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      
		      message = new Label();
		      message.setFont(mainFont);
		      
		      MenuBar menuBar = new MenuBar();
		      menuBar.setStyle("-fx-font: 24px \"Courrier\";");  
		      
		      Menu menuLetter = new Menu("Letter");      
		      MenuItem aMenu = new MenuItem("A");
		      aMenu.setOnAction(this::processAmenu);
		      MenuItem bMenu = new MenuItem("B");
		      bMenu.setOnAction(this::processBmenu);
		      MenuItem cMenu = new MenuItem("C");
		      cMenu.setOnAction(this::processCmenu);
		      menuLetter.getItems().addAll(aMenu, bMenu, cMenu);
		      
		      Menu menuAction = new Menu("Action");      
		      MenuItem clearMenu = new MenuItem("Clear");
		      clearMenu.setOnAction(this::processClearMenu);
		      menuAction.getItems().addAll(clearMenu);
		      
		      menuBar.getMenus().addAll(menuLetter, menuAction);
		      
		      VBox pane = new VBox(menuBar, message);
		      Scene scene = new Scene(pane,400,300);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Menus");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processAmenu(ActionEvent event)
	   {
	      message.setText("A");
	   }

	   public void processBmenu(ActionEvent event)
	   {
	      message.setText("B");
	   }

	   public void processCmenu(ActionEvent event)
	   {
	      message.setText("C");
	   }

	   public void processClearMenu(ActionEvent event)
	   {
	      message.setText("--");
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
