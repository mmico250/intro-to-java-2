package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;


public class Main extends Application {
	
	   Label message;
	   Button try1, try2, try3;

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      message = new Label("Nothing clicked yet");
		      message.setFont(mainFont);
		      message.setMinWidth(400);
		      
		      try1 = new Button("Message");
		      try1.setFont(mainFont);
		      try1.setOnAction(this::processTry1Button);
		      
		      try2 = new Button("Question");
		      try2.setFont(mainFont);
		      try2.setOnAction(this::processTry2Button);

		      try3 = new Button("Input");
		      try3.setFont(mainFont);
		      try3.setOnAction(this::processTry3Button);

		      FlowPane pane = new FlowPane(message, try1, try2, try3);
		      Scene scene = new Scene(pane,400,200);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example pop-ups");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processTry1Button(ActionEvent event)
	   {
	      Alert alert = new Alert(AlertType.INFORMATION, 
	                     "What a nice day!" , ButtonType.OK);
	      alert.showAndWait();
	   }

	   public void processTry2Button(ActionEvent event)
	   {
	      Alert alert = new Alert(AlertType.CONFIRMATION, 
	                     "Do you like Java?" , 
	                     ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
	      alert.showAndWait();

	      if (alert.getResult() == ButtonType.YES)
	      {
	         message.setText("You like Java!");
	      }
	      else if (alert.getResult() == ButtonType.NO)
	      {
	         message.setText("You do not like Java...");
	      }
	   }

	   public void processTry3Button(ActionEvent event)
	   {
	      TextInputDialog dialog = new TextInputDialog();
	      dialog.setTitle("Name input");
	      dialog.setHeaderText("Enter your name");
	      Optional<String> result = dialog.showAndWait();
	      if (result.isPresent())
	      {
	         String input = dialog.getEditor().getText();
	         message.setText("Hi " + input);
	      }
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
