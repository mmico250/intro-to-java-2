package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class Main extends Application {
	
	Label message;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      message = new Label("My first application!");
		      message.setFont(mainFont);
		      
		      FlowPane root = new FlowPane(message);
		      Scene scene = new Scene(root,400,400);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Simple text");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
