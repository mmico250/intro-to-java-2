package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;


public class Main extends Application {

	   private Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
	   private Button plusBtn, minusBtn, multBtn, divBtn, equalBtn, clearBtn;
	   private Label display;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		      Font mainFont = new Font("courrier", 36);
		      
		      GridPane pane = new GridPane();
		      pane.setHgap(10);
		      pane.setVgap(10);
		      
		      display = new Label("0");
		      display.setFont(mainFont);
		      pane.add(display, 0, 0, 3, 1);
		      
		      oneBtn = new Button("1");
		      oneBtn.setFont(mainFont);
		      oneBtn.setOnAction(this::processDigitButton);
		      pane.add(oneBtn, 0, 1);
		      
		      twoBtn = new Button("2");
		      twoBtn.setFont(mainFont);
		      twoBtn.setOnAction(this::processDigitButton);
		      pane.add(twoBtn, 1, 1);
		      
		      threeBtn = new Button("3");
		      threeBtn.setFont(mainFont);
		      threeBtn.setOnAction(this::processDigitButton);
		      pane.add(threeBtn, 2, 1);
		      
		      fourBtn = new Button("4");
		      fourBtn.setFont(mainFont);
		      fourBtn.setOnAction(this::processDigitButton);
		      pane.add(fourBtn, 0, 2);
		      
		      fiveBtn = new Button("5");
		      fiveBtn.setFont(mainFont);
		      fiveBtn.setOnAction(this::processDigitButton);
		      pane.add(fiveBtn, 1, 2);
		      
		      sixBtn = new Button("6");
		      sixBtn.setFont(mainFont);
		      sixBtn.setOnAction(this::processDigitButton);
		      pane.add(sixBtn, 2, 2);
		      
		      sevenBtn = new Button("7");
		      sevenBtn.setFont(mainFont);
		      sevenBtn.setOnAction(this::processDigitButton);
		      pane.add(sevenBtn, 0, 3);
		      
		      eightBtn = new Button("8");
		      eightBtn.setFont(mainFont);
		      eightBtn.setOnAction(this::processDigitButton);
		      pane.add(eightBtn, 1, 3);
		      
		      nineBtn = new Button("9");
		      nineBtn.setFont(mainFont);
		      nineBtn.setOnAction(this::processDigitButton);
		      pane.add(nineBtn, 2, 3);
		      
		      zeroBtn = new Button("0");
		      zeroBtn.setFont(mainFont);
		      zeroBtn.setOnAction(this::processDigitButton);
		      pane.add(zeroBtn, 1, 4);
		      
		      plusBtn = new Button("+");
		      plusBtn.setFont(mainFont);
		      plusBtn.setOnAction(this::processOperatorButton);
		      pane.add(plusBtn, 3, 1);
		      
		      minusBtn = new Button("-");
		      minusBtn.setFont(mainFont);
		      minusBtn.setOnAction(this::processOperatorButton);
		      pane.add(minusBtn, 3, 2);
		      
		      multBtn = new Button("*");
		      multBtn.setFont(mainFont);
		      multBtn.setOnAction(this::processOperatorButton);
		      pane.add(multBtn, 3, 3);
		      
		      divBtn = new Button("/");
		      divBtn.setFont(mainFont);
		      divBtn.setOnAction(this::processOperatorButton);
		      pane.add(divBtn, 3, 4);
		      
		      equalBtn = new Button("=");
		      equalBtn.setFont(mainFont);
		      equalBtn.setPrefWidth(150);
		      equalBtn.setOnAction(this::processOperatorButton);
		      pane.add(equalBtn, 0, 5, 2, 1);
		      
		      clearBtn = new Button("C");
		      clearBtn.setFont(mainFont);
		      clearBtn.setPrefWidth(150);
		      clearBtn.setOnAction(this::processClearButton);
		      pane.add(clearBtn, 2, 5, 2, 1);
		      
		      Scene calcScene = new Scene(pane, 400, 500);
		      primaryStage.setTitle("Calculator");
		      primaryStage.setScene(calcScene);
		      primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	   public void processDigitButton(ActionEvent event)
	   {
	   }
	   
	   private void performPreviousOperation()
	   {
	   }
	   
	   public void processOperatorButton(ActionEvent event)
	   {
	   }
	   
	   public void processClearButton(ActionEvent event)
	   {
	   }
	   

	public static void main(String[] args) {
		launch(args);
	}
}
