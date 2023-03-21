package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;


public class Main extends Application {
	
	Label message;
	Button smileButton;

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      message = new Label("My first application!");
		      message.setFont(mainFont);
		      message.setMinWidth(600);
		      
		      smileButton = new Button("Smile!");
		      smileButton.setFont(mainFont);
		      smileButton.setOnAction(this::processButton);
		      
		      FlowPane root = new FlowPane(message, smileButton);
		      Scene scene = new Scene(root,600,200);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Text and Button");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processButton(ActionEvent event)
	   {
	      String currentMsg = message.getText();
	      message.setText(currentMsg + " Smile!");
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
