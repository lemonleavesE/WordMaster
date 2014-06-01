package viewer;
	
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import model.WordHandler;
import controller.Action;
import controller.Lexicon;
import controller.Word;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Test extends Application implements Observer
{
	/*java�ĵ���ģʽ��ȷ������Ӧ�ó�����ֻ��һ��Viewerʵ��*/
	private volatile static Test instance = null; 

	  public static Test getInstance() { 
	    if (instance == null) { 
	      synchronized (Test.class) { 
	        if(instance == null) { 
	          instance = new Test(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 


	private Scene scene;
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("WordMasterUI.fxml"));
	        scene = new Scene(root, 600, 400);
	        primaryStage.initStyle(StageStyle.DECORATED);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("WordMaster");
	        primaryStage.show();
			/*scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
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
             
             //scenetitle.setText("ds");
            
		} 
		
	}
	

	/*controller����Ҫ�ǽ����linstener��Ȼ�����observer��observation*/
	public static void main(String[] args) 
	{
		//word.setState(2);
		//word.setWord(3);
		launch(args);
	}
}
