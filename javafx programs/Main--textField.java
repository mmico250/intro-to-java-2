package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;


public class Main extends Application {
	
	Label message;
	Button OKbutton;
	TextField inputField;

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      
		      inputField = new TextField();
		      inputField.setFont(mainFont);
		      inputField.setMinWidth(300);
		      inputField.setOnAction(this::processTextInput);
		      
		      OKbutton = new Button("OK");
		      OKbutton.setFont(mainFont);
		      OKbutton.setOnAction(this::processButton);
		      // Note: since the code is the same for both the button
		      // and the return char, we could have used the same
		      // method for both controls as event handler
		      
		      message = new Label();
		      message.setFont(mainFont);
		      message.setMinWidth(400);
		      
		      FlowPane root = new FlowPane(inputField, OKbutton, message);
		      Scene scene = new Scene(root,400,200);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Text Field");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processButton(ActionEvent event)
	   {
	      String name = inputField.getText();
	      message.setText(" Hi " + name + "!");
	   }

	   public void processTextInput(ActionEvent event)
	   {
	      String name = inputField.getText();
	      message.setText(" Hi " + name + "!");
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
