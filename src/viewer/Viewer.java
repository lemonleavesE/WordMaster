package viewer;
	
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import model.WordHandler;
import controller.Action;
import controller.Lexicon;
import controller.Word;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Viewer extends Application implements Observer
{
	/*java的单例模式，确保整个应用程序中只有一个Viewer实例*/
	private volatile static Viewer instance = null; 

	  public static Viewer getInstance() { 
	    if (instance == null) { 
	      synchronized (Viewer.class) { 
	        if(instance == null) { 
	          instance = new Viewer(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 

	private GridPane grid;
	private static Text scenetitle = new Text("Welcome");
	
	private Label userName;
	private Label pw;
	private TextField userTextField;
	private PasswordField pwBox;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			/*基本样式，这里是一个form表单 (TODO)*/
			grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setId("grid");
			
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			userName = new Label("User Name:");
			grid.add(userName, 0, 1);

			userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			userTextField.setOnKeyReleased(new EventHandler<KeyEvent>(){

			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Action.getInstance().chooseLexicon("dsdsd");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
			
			
			pw = new Label("Password:");
			grid.add(pw, 0, 2);

			pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			
			Button btn = new Button("Sign in");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			
			/*From 表单*/
			
			/*基本信息*/
			scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		/*
		 
		 */
		if(arg0 instanceof Word)
		{    
             System.out.println("Viewer SomeThing changed:"+":"+arg1.toString());
             
             scenetitle.setText("ds");
            
		} 
		
	}
	

	/*controller，主要是界面的linstener，然后调用observer和observation*/
	public static void main(String[] args) 
	{
		//word.setState(2);
		//word.setWord(3);
		launch(args);
	}
}
