package viewer;
	
import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.Word;


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


	public Scene scene;
	
	
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
            if(arg1.equals("chinese"))
            {
            	
            }
            
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
