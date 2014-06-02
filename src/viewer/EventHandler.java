package viewer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Group;
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
	private Label MemoryWord;//�ϴα��е��ĵ�����ʾ
	@FXML  
	private TextField StartEntry;//��ʼ���������
	@FXML
	private TextField ReciteNum;//���и������ÿ�
	@FXML
	private ToggleGroup myToggleGroup;
	@FXML
	private RadioButton rb0;
	@FXML
	private RadioButton rb1;
	@FXML
	private RadioButton rb2;
	@FXML
	private Label ChMean;
	@FXML 
	private TextField EngInput;
	@FXML
	private Group ErrorHint;
	@FXML
	private Label EngWord;
	
	@FXML  
	private void ReturnMain(ActionEvent event){
		this.LexiconInfo.setVisible(false);
		this.main_page.setVisible(true);
	}
	
	/*�鿴�ʿ���Ϣ*/
	@FXML  
	private void ReadLexiconInfo(ActionEvent event) throws IOException{
		String type = this.LexiconSelection.getValue().substring(0, 1);
		if(Action.getInstance().chooseLexicon(type)){
			Lexicon l = Lexicon.getInstance();
			int wrong = l.getCountTotal() - l.getCountRight();
			double acc = (double)l.getCountRight()/l.getCountTotal();
			this.LexiconName.setText(l.getType()+"�ʿ�");
			this.TotalCnt.setText(l.getCountTotal()+"");
			this.RightCnt.setText(l.getCountRight()+"");
			this.WrongCnt.setText(wrong+"");
			this.RecitedCnt.setText(l.getCountRecited()+"");
			this.Accuracy.setText(acc+"");
			//System.out.println("readlexiconinfo");
			this.LexiconInfo.setVisible(true);
			this.main_page.setVisible(false);
		}		
		
	}
	
	/*ѡ��ʿ����뱳������ҳ��*/
	@FXML
	private void EnterResiteSettingMode(ActionEvent event) throws IOException{
		if(Action.getInstance().chooseLexicon(this.LexiconSelection.getValue().substring(0, 1))){
			this.MemoryWord.setText(Lexicon.getInstance().getEntryLexicon()+"");
			this.main_page.setVisible(false);
			this.ReciteSetting.setVisible(true);
		}		
	}
	
	/*��ʼ����*/
	@FXML
	private void StartReciting(ActionEvent event) throws IOException{
		Action.getInstance().setNum(Integer.parseInt(this.ReciteNum.getText()));
		Toggle t = this.myToggleGroup.getSelectedToggle();
		Object o = t.getUserData();
		//ObservableMap<Object, Object> om = t.getProperties();
		
		System.out.println(o.toString());
		if(o.toString().equals("2")){//�Զ�����ʼ����
			if(Action.getInstance().chooseWord(this.StartEntry.getText())){
				
			}
		}else{
			if(Action.getInstance().chooseWord(o.toString())){
				this.ChMean.setText(Word.getInstance().getChinese());
				this.ReciteSetting.setVisible(false);
				this.Reciting.setVisible(true);
			}			
		}		
	}
	
	/*��һ�����ʱ���*/
	@FXML
	private void NextWord(ActionEvent event) throws IOException{
		int flag = Action.getInstance().nextWord(this.EngInput.getText());
		if(flag < 0){//������ʾ��ʾ��Ϣ
			this.EngWord.setText(Word.getInstance().getEnglish());
			this.ErrorHint.setVisible(true);
		}
	}
	
	/*�ʿ�ѡ�����ݰ�*/
	public void LexiconDataBinding(){
		ObservableList <String> lexicons = FXCollections.observableArrayList();
		for(int i = 0; i < 26; i++){
			char c = (char) ('a' + i);
			lexicons.add(c+"�ʿ�");	
		}
		this.LexiconSelection.setItems(lexicons);
	}
	
	/*�趨RadioButton*/
	public void RadioButtonSetting(){
		this.rb0.setUserData("0");
		this.rb1.setUserData("1");
		this.rb2.setUserData("2");
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LexiconDataBinding();
		RadioButtonSetting();
		this.main_page.setVisible(true);
		this.LexiconInfo.setVisible(false);
		this.ReciteSetting.setVisible(false);
		this.Reciting.setVisible(false);
		
		
	}	 
}
