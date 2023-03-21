package application;
	
import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import java.util.Optional;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.event.ActionEvent;
import java.io.*;
import javafx.scene.control.TextInputControl;


public class Main extends Application {
	
   Project prj;
   ChoiceBox<String> fileChoice;
   TextArea fileContentArea;
   TextArea compileAndRunArea;
   String path = "";
   String coppied;
   boolean filesAdded = false;
   JavaFile curFile = null;

   @Override
   public void start(Stage primaryStage) {
      try {/*
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Path selection");
            dialog.setHeaderText("Enter the path to be used: ");
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent())
            {
               path = dialog.getEditor().getText();
            }
            */
         DirectoryChooser dirChooser = new DirectoryChooser();
         dirChooser.setTitle("Default path selection");
         File selectedDir = dirChooser.showDialog(primaryStage);
         path = selectedDir.getAbsolutePath();
            
         FileInputStream fis = null;
         DataInputStream infile = null;
         String prjName, textArea1="", textArea2="";
         int indexSelected=0;
         try
         {
            fis = new FileInputStream(path + "\\config.dat");
            infile = new DataInputStream(fis);
            prjName = infile.readUTF();
            indexSelected = infile.readInt();
            textArea1 = infile.readUTF();
            textArea2 = infile.readUTF();
            prj = Project.loadProject(prjName, path);
            curFile = prj.get(indexSelected);
            curFile.load();
         }
         catch (Exception e)
         {
            Alert alert = new Alert(AlertType.INFORMATION, 
                           "Problem loading the config.dat file: " + e.getMessage(), 
                           									ButtonType.OK);
            alert.showAndWait();
            prj = Project.getInitialInstance(path);
         }
         finally
         {
            try
            {
               if (infile != null)
                  infile.close();
            }
            catch (IOException e)
            {
               Alert alert = new Alert(AlertType.INFORMATION, 
                              "Problem closing the config.dat file", 
                              									ButtonType.OK);
               alert.showAndWait();
            }
         }
      
         MenuBar menuBar = new MenuBar();
         Menu menuFile = new Menu("File");      
         MenuItem prjMenu = new MenuItem("Create project");
         prjMenu.setOnAction(this::processPrjMenu);
         MenuItem loadPrjMenu = new MenuItem("Load project");
         loadPrjMenu.setOnAction(this::processLoadPrjMenu);
         MenuItem savePrjMenu = new MenuItem("Save project");
         savePrjMenu.setOnAction(this::processSavePrjMenu);
         MenuItem addFileMenu = new MenuItem("Add file");
         addFileMenu.setOnAction(this::processAddFileMenu);
         MenuItem saveFileMenu = new MenuItem("Save file");
         saveFileMenu.setOnAction(this::processSaveFileMenu);
         menuFile.getItems().addAll(prjMenu, loadPrjMenu, savePrjMenu,
            	  						addFileMenu, saveFileMenu);
            
         Menu menuAction = new Menu("Action");      
         MenuItem compileMenu = new MenuItem("Compile");
         compileMenu.setOnAction(this::processCompileMenu);
         MenuItem runMenu = new MenuItem("Run");
         runMenu.setOnAction(this::processRunMenu);
         menuAction.getItems().addAll(compileMenu, runMenu);
            
         Menu menuEdit = new Menu("Edit");      
         MenuItem cutMenu = new MenuItem("Cut");
         cutMenu.setOnAction(this::processCutMenu);
         MenuItem copyMenu = new MenuItem("Copy");
         copyMenu.setOnAction(this::processCopyMenu);
         MenuItem pasteMenu = new MenuItem("Paste");
         pasteMenu.setOnAction(this::processPasteMenu);
         MenuItem undoMenu = new MenuItem("Undo");
         undoMenu.setOnAction(this::processUndoMenu);
         MenuItem redoMenu = new MenuItem("Redo");
         redoMenu.setOnAction(this::processRedoMenu);
         menuEdit.getItems().addAll(cutMenu, copyMenu, pasteMenu, undoMenu, redoMenu);
            
         menuBar.getMenus().addAll(menuFile, menuAction, menuEdit);
      
         fileChoice = new ChoiceBox<String>();
         fileChoice.getItems().addAll(prj.getListFilenames());
         fileChoice.getSelectionModel().select(indexSelected);
         fileChoice.setOnAction(this::processFileSelection);
            
         fileContentArea = new TextArea();
         fileContentArea.setPrefRowCount(27);
         fileContentArea.setText(textArea1);
         compileAndRunArea = new TextArea();
         compileAndRunArea.setPrefRowCount(9);
         compileAndRunArea.setText(textArea2);
      	
         VBox pane = new VBox(menuBar, fileChoice,
            	fileContentArea, compileAndRunArea);
         Scene scene = new Scene(pane,800,700);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.setTitle("My Simple IDE");
         primaryStage.setOnCloseRequest(this::processClosing);
         primaryStage.show();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
	
   public void processFileSelection(ActionEvent event)
   {
      checkToSaveFile();
      int index = fileChoice.getSelectionModel().getSelectedIndex();
      JavaFile theFile = prj.get(index);
      if (theFile == null)
         return;
      try
      {
         theFile.load();
         fileContentArea.setText(theFile.getContent());
         curFile = theFile;
      }
      catch (IOException e)
      {
         Alert alert = new Alert(AlertType.INFORMATION, 
                        "Problem loading the file" , ButtonType.OK);
         alert.showAndWait();
      }
   }

   public void processCompileMenu(ActionEvent event)
   {
      compileAndRunArea.setText(prj.compile());
   }

   public void processRunMenu(ActionEvent event)
   {
      compileAndRunArea.setText(prj.run());
   }
	
   public void checkToSaveProject()
   {
      if (filesAdded)
      {
         Alert alert = new Alert(AlertType.CONFIRMATION, 
            	"The current project has been modified. Do you want to save it?" , 
            	ButtonType.YES, ButtonType.NO);
         alert.showAndWait();
         if (alert.getResult() == ButtonType.YES)
         {
            processSavePrjMenu(null);
            filesAdded = false;
         }
      
      }
   }
	
   public void checkToSaveFile()
   {	      
      if (curFile != null && !curFile.getContent().equals(fileContentArea.getText()))
      {
         Alert alert = new Alert(AlertType.CONFIRMATION, 
                  "The current file has been modified. Do you want to save it?" , 
                  ButtonType.YES, ButtonType.NO);
         alert.showAndWait();
         if (alert.getResult() == ButtonType.YES)
         {
            try
            {
               curFile.setContent(fileContentArea.getText());
               curFile.save();
            }
            catch (IOException e)
            {
               Alert alert2 = new Alert(AlertType.INFORMATION, 
                              "Problem saving the file" , ButtonType.OK);
               alert2.showAndWait();
            }
         }
      	
      }
   }
	
   public void processPrjMenu(ActionEvent event)
   {
      checkToSaveProject();
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Project creation");
      dialog.setHeaderText("Enter the name of the project: ");
      Optional<String> result = dialog.showAndWait();
      if (result.isPresent())
      {
         String name = dialog.getEditor().getText();
      	
         File myfile = new File(path + "\\" + name + ".dat");
         if (myfile.isFile())
         {
            Alert alert = new Alert(AlertType.INFORMATION, 
                          "This project already exist" , ButtonType.OK);
            alert.showAndWait();
            return;
         }
      
         prj = new Project(name, path);
         checkToSaveFile();
         fileChoice.getItems().clear();
         fileContentArea.setText("");
         compileAndRunArea.setText("");
         curFile = null;
      }
   }
	
   public void processLoadPrjMenu(ActionEvent event)
   {
      checkToSaveProject();
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Project loading");
      dialog.setHeaderText("Enter the name of the project: ");
      Optional<String> result = dialog.showAndWait();
      if (result.isPresent())
      {
         String name = dialog.getEditor().getText();
         try
         {
            prj = Project.loadProject(name, path);
            fileChoice.getItems().clear();
            fileChoice.getItems().addAll(prj.getListFilenames());
            checkToSaveFile();
            fileContentArea.setText("");
            compileAndRunArea.setText("");
            curFile = null;
         }
         catch (Exception e)
         {
            Alert alert = new Alert(AlertType.INFORMATION, 
                       "Problem loading the project" , ButtonType.OK);
            alert.showAndWait();
         }
      }
   }

   public void processSavePrjMenu(ActionEvent event)
   {
      try
      {
         Project.saveProject(prj);
         Alert alert = new Alert(AlertType.INFORMATION, 
                       "Project has been saved" , ButtonType.OK);
         alert.showAndWait();
      }
      catch (IOException e)
      {
         Alert alert = new Alert(AlertType.INFORMATION, 
                       "Problem saving the project" , ButtonType.OK);
         alert.showAndWait();
      }
   }

   public void processAddFileMenu(ActionEvent event)
   {
      TextInputDialog dialog = new TextInputDialog();
      dialog.setTitle("Adding a new file");
      dialog.setHeaderText("Enter the name of the file (no extension): ");
      Optional<String> result = dialog.showAndWait();
      if (result.isPresent())
      {
         String name = dialog.getEditor().getText();
         JavaFile file = new JavaFile(name, path);
         prj.addFile(file);
         fileChoice.getItems().addAll(name);
         filesAdded = true;
      }
   }
	
   public void processSaveFileMenu(ActionEvent event)
   {
      int index = fileChoice.getSelectionModel().getSelectedIndex();
      JavaFile theFile = prj.get(index);
      if (theFile == null)
      {
         Alert alert = new Alert(AlertType.INFORMATION, 
                    "No files currently selected" , ButtonType.OK);
         alert.showAndWait();
         return;
      }
      try
      {
         theFile.setContent(fileContentArea.getText());
         theFile.save();
      }
      catch (IOException e)
      {
         Alert alert = new Alert(AlertType.INFORMATION, 
                        "Problem saving the file" , ButtonType.OK);
         alert.showAndWait();
      }
   	
   }

   public void processClosing(WindowEvent event) 
   {
      checkToSaveFile();
      checkToSaveProject();
      FileOutputStream fos = null;
      DataOutputStream outfile = null;
         
      try
      {
         fos = new FileOutputStream(path + "\\config.dat");
         outfile = new DataOutputStream(fos);
         outfile.writeUTF(prj.getName());
         outfile.writeInt(fileChoice.getSelectionModel().getSelectedIndex());
         outfile.writeUTF(fileContentArea.getText());
         outfile.writeUTF(compileAndRunArea.getText());
      }
      catch (IOException e)
      {
         Alert alert = new Alert(AlertType.INFORMATION, 
                       "Problem saving the config.dat file" , ButtonType.OK);
         alert.showAndWait();
      }
      finally
      {
         try
         {
            if (outfile != null)
               outfile.close();
         }
         catch (IOException e)
         {
            Alert alert = new Alert(AlertType.INFORMATION, 
                       "Problem closing the config.dat file" , ButtonType.OK);
            alert.showAndWait();
         }
      }
   }
	
   public void processCutMenu(ActionEvent event)
   {
      coppied = fileContentArea.getSelectedText();
      fileContentArea.replaceSelection("");
   }
	
   public void processCopyMenu(ActionEvent event)
   {
      coppied = fileContentArea.getSelectedText();
   }
	
   public void processPasteMenu(ActionEvent event)
   {	
      if(fileContentArea.getSelectedText() != null)
      {
         fileContentArea.replaceSelection(coppied);
      }
      else
      {
         int pos = fileContentArea.getCaretPosition();
         fileContentArea.insertText(pos, coppied);
      }
   }
	
   public void processUndoMenu(ActionEvent event)
   {		
      if(fileContentArea.isUndoable())
      {
         fileContentArea.undo();
      }
   }
	
   public void processRedoMenu(ActionEvent event)
   {		
      if(fileContentArea.isRedoable())
      {
         fileContentArea.redo();
      }
   }

   public static void main(String[] args) {
      launch(args);
   }

}