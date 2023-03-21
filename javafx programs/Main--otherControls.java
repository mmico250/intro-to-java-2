package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;
import javafx.scene.text.Font;


public class Main extends Application {
	
	   Label message;
	   Button OKbutton;
	   CheckBox isStudent;
	   RadioButton childButton, adultButton, seniorButton;
	   ChoiceBox<String> provinceChoice;
	   String[] provinces = {"NB", "NS", "PEI", "NL"};

	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 24);
		      
		      // code for check box
		      
		      isStudent = new CheckBox("Student");
		      isStudent.setFont(mainFont);
		      isStudent.setSelected(true);
		      
		      // code for radio buttons
		      
		      ToggleGroup ageGroup = new ToggleGroup();
		      
		      childButton = new RadioButton("child");
		      childButton.setFont(mainFont);
		      childButton.setToggleGroup(ageGroup);
		      
		      adultButton = new RadioButton("adult");
		      adultButton.setFont(mainFont);
		      adultButton.setSelected(true);
		      adultButton.setToggleGroup(ageGroup);
		      
		      seniorButton = new RadioButton("senior");
		      seniorButton.setFont(mainFont);
		      seniorButton.setToggleGroup(ageGroup);
		      
		      // code for choice box
		      
		      provinceChoice = new ChoiceBox<String>();
		      provinceChoice.setStyle("-fx-font: 24px \"Courrier\";");  
		      provinceChoice.getItems().addAll(provinces);
		      provinceChoice.getSelectionModel().select(0);
		      
		      // Note: for each of the controls above, you can specify
		      // an event handler in the same way as for buttons
		      // (i.e., with setOnAction method)
		      
		      // code for OK button and label
		         
		      OKbutton = new Button("OK");
		      OKbutton.setFont(mainFont);
		      OKbutton.setOnAction(this::processButton);
		      
		      message = new Label();
		      message.setFont(mainFont);
		      message.setMinWidth(400);
		      
		      // putting it all together
		      
		      VBox pane = new VBox(isStudent, 
		                        childButton, adultButton, seniorButton,
		                        provinceChoice,
		                        OKbutton, message);
		      pane.setSpacing(10);

		      Scene scene = new Scene(pane,400,400);
		      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		      primaryStage.setScene(scene);
		      primaryStage.setTitle("Example Other Controls");
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processButton(ActionEvent event)
	   {
	      String msg = "";
	      
	      if (isStudent.isSelected())
	         msg += "-- is a student";
	      else
	         msg += "-- is not a student";
	        
	      if (childButton.isSelected())
	         msg += "-- child";
	      else if (adultButton.isSelected())
	         msg += "-- adult";
	      else
	         msg += "-- senior";
	         
	      int index = provinceChoice.getSelectionModel().getSelectedIndex();
	      msg += "-- " + provinces[index];
	      
	      message.setText(msg);
	   }

	   public static void main(String[] args) {
		launch(args);
	}
}
