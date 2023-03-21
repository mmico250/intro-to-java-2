package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;


public class Main extends Application {
	
	Label message;
	Button OKbutton;
	TextArea mainText;

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      
		      mainText = new TextArea();
		      mainText.setFont(mainFont);
		      mainText.setPrefRowCount(5);
		      mainText.setPrefColumnCount(15);
		      mainText.setWrapText(true);
		      
		      OKbutton = new Button("OK");
		      OKbutton.setFont(mainFont);
		      OKbutton.setOnAction(this::processButton);
		      
		      message = new Label();
		      message.setFont(mainFont);
		      		      
		      FlowPane root = new FlowPane(mainText, OKbutton, message);
		      Scene scene = new Scene(root,400,300);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Text Area");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processButton(ActionEvent event)
	   {
	      String text = mainText.getText();
	      
	      // grab the first line
	      int posReturn = text.indexOf("\n");
	      String firstLine;
	      if (posReturn == -1)
	    	  firstLine = text;
	      else
	    	  firstLine = text.substring(0, posReturn);
	      
	      // grab the first word in that first line
	      int posSpace = firstLine.indexOf(" ");
	      String firstWord;
	      if (posSpace == -1)
	         firstWord = firstLine;
	      else
	         firstWord = firstLine.substring(0, posSpace);
	      
	      message.setText("Text: " + firstWord + "...");
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
