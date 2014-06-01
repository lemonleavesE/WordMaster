package viewer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class EventHandler implements Initializable {
	@FXML
	private AnchorPane main_page;
	@FXML
	private AnchorPane LexiconInfo;
	@FXML
	private AnchorPane ReciteSetting;
	@FXML
	private AnchorPane Reciting;
	@FXML
	private ChoiceBox<String> LexiconSelection;
	@FXML
	private Label LexiconName;
	@FXML
	private Label TotalCnt;
	@FXML
	private Label RecitedCnt;
	@FXML
	private Label RightCnt;
	@FXML
	private Label WrongCnt;
	@FXML
	private Label Accuracy;
	@FXML  
	private void ReturnMain(ActionEvent event){
		this.LexiconInfo.setVisible(false);
		this.main_page.setVisible(true);
	}
	
	@FXML  
	private void ReadLexiconInfo(ActionEvent event){
		
		this.LexiconName.setText(this.LexiconSelection.getValue());
		
		System.out.println("readlexiconinfo");
		this.LexiconInfo.setVisible(true);
		this.main_page.setVisible(false);
		
	}
	
	/*词库选择数据绑定*/
	public void LexiconDataBindling(){
		ObservableList <String> lexicons = FXCollections.observableArrayList();
		for(int i = 0; i < 26; i++){
			char c = (char) ('a' + i);
			lexicons.add(c+"词库");	
		}
		this.LexiconSelection.setItems(lexicons);
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.main_page.setVisible(true);
		this.LexiconInfo.setVisible(false);
		this.ReciteSetting.setVisible(false);
		this.Reciting.setVisible(false);
		LexiconDataBindling();
		
	}	 
}
