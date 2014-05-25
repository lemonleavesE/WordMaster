package application;
	
import java.util.Observable;
import java.util.Observer;

import model.TxtHandler;
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


public class Main extends Application implements Observer{
	
	static Word word = new Word(1, "1","1", 0);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/*基本样式，这里是一个form表单 (TODO)*/
			
			/*From 表单*/
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			grid.setId("grid");
			
			Text scenetitle = new Text("Welcome");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label userName = new Label("User Name:");
			grid.add(userName, 0, 1);

			final TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			userTextField.setOnKeyReleased(new EventHandler<KeyEvent>(){

			public void handle(KeyEvent arg0) {
				// TODO Auto-generated method stub
				word.setUser(userTextField.getText());
			}});
			
			
			Label pw = new Label("Password:");
			grid.add(pw, 0, 2);

			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			
			Button btn = new Button("Sign in");
			HBox hbBtn = new HBox(10);
			hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbBtn.getChildren().add(btn);
			grid.add(hbBtn, 1, 4);
			
			/*基本信息*/
			Scene scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*controller，主要是界面的linstener，然后调用observer和observation*/
	public static void main(String[] args) 
	{
		word.addObserver(new TxtHandler());
		word.addObserver(new Main());
		//word.setState(2);
		//word.setWord(3);
		
		launch(args);
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		/*
		 * if(msg=="词数不足")
		 * {
		 * 		前台显示：词数不足
		 * }
		 * 
		 * */
		System.out.println("hewe");
		
	}
}
