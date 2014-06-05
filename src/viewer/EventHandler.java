package viewer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import config.ConfRW;
import controller.*;
import javafx.collections.*;
import javafx.event.Event;
import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class EventHandler implements Initializable,Observer
{
	private static Stage  newAlertDialog ;  
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
	private Label MemoryWord;//上次背诵到的单词显示
	@FXML  
	private TextField StartEntry;//起始单词输入框
	@FXML
	private TextField ReciteNum;//背诵个数设置框
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
	private Label EngWord;
	@FXML 
	private TextField EngInput;
	@FXML
	private Group ErrorHint;
	@FXML
	private Group RecitingGroup;
	@FXML
	private AnchorPane ShowMessageDialog;
	@FXML
	private Label AlertMessage;
	
	@FXML  
	private void ReturnMain(Event event){
		this.ShowMainPage();
	}
	
	/*查看词库信息*/
	@FXML  
	private void ReadLexiconInfo(Event event) throws IOException{
		String type = this.LexiconSelection.getValue().substring(0, 1);
		if(Action.getInstance().chooseLexicon(type)){
			Lexicon l = Lexicon.getInstance();
			int wrong = l.getCountRecited() - l.getCountRight();
			double acc = (double)l.getCountRight()/l.getCountTotal();
			this.LexiconName.setText(l.getType()+"词库");
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
	
	/*选择词库后进入背诵设置页面*/
	@FXML
	private void EnterResiteSettingMode(Event event) throws IOException{
		if(Action.getInstance().chooseLexicon(this.LexiconSelection.getValue().substring(0, 1))){
			this.MemoryWord.setText(Action.getInstance().getLastWord());
			this.main_page.setVisible(false);
			this.ReciteSetting.setVisible(true);
		}		
	}
	
	/*开始背诵*/
	@FXML
	private void StartReciting(Event event) throws IOException{
		if(this.myToggleGroup.getSelectedToggle() == null){
			this.ShowAlertDialog("你怎么不选起始方式:(");
		}else{
			Action.getInstance().setNum(Integer.parseInt(this.ReciteNum.getText()));
			Toggle t = this.myToggleGroup.getSelectedToggle();
			Object o = t.getUserData();
			
			if(o.toString().equals("2")){//自定义起始单词
				if(Action.getInstance().chooseWord(this.StartEntry.getText())){
					this.ChMean.setText(Word.getInstance().getChinese());
					this.EngWord.setText(Word.getInstance().getEnglish());
					this.ReciteSetting.setVisible(false);
					this.Reciting.setVisible(true);
				}else{
					this.ShowAlertDialog("自定义起始单词失败了:(木有在词库里找到这个单词诶");
				}
			}else{
				if(Action.getInstance().chooseWord(o.toString())){
					this.ChMean.setText(Word.getInstance().getChinese());
					this.EngWord.setText(Word.getInstance().getEnglish());
					this.ReciteSetting.setVisible(false);
					this.Reciting.setVisible(true);
				}else{
					this.ShowAlertDialog("初始化单词背诵失败了:(");
				}		
			}	
			
		}
		
			
	}
	
	/*下一个单词背诵*/
	@FXML
	private void NextWord(Event event) throws IOException{
		int flag = Action.getInstance().nextWord(this.EngInput.getText());
		
		
		if(flag < 0){//出错，显示提示信息
		
					this.RecitingGroup.setDisable(true);
					this.ErrorHint.setVisible(true);
			
		}else{
			switch(flag){
				case 1:

				case 2: 
				
				case 3:
			}
			this.ChMean.setText(Word.getInstance().getChinese());
			this.EngWord.setText(Word.getInstance().getEnglish());
			this.EngInput.setText("");
			//this.ReciteSetting.setVisible(false);
			
	
			
		}
	}
	
	/*提示错误后继续背诵*/
	@FXML
	public void ContinueReciting(Event event){
		this.ErrorHint.setVisible(false);
		this.ChMean.setText(Word.getInstance().getChinese());
		this.EngWord.setText(Word.getInstance().getEnglish());
		this.EngInput.setText("");
		this.RecitingGroup.setDisable(false);
	}
	
	
	 @FXML
	 private void OnAlertOKClick(Event event) {
		 this.HideAlertDialog();
	 }
	
	 
	 public void ShowAlertDialog(String message){
		 this.ReciteSetting.setDisable(true);
		 this.AlertMessage.setText(message);
		 this.ShowMessageDialog.setVisible(true);
	 }
	 
	 public void HideAlertDialog(){
		 this.ShowMessageDialog.setVisible(false);
		 this.ReciteSetting.setDisable(false);
	 }
	
	
	/*词库选择数据绑定*/
	public void LexiconDataBinding(){
		ObservableList <String> lexicons = FXCollections.observableArrayList();
		for(int i = 0; i < 26; i++){
			char c = (char) ('a' + i);
			lexicons.add(c+"词库");	
		}
		this.LexiconSelection.setItems(lexicons);
	}
	
	
	/*设定RadioButton*/
	public void RadioButtonSetting(){
		this.rb0.setUserData("0");
		this.rb1.setUserData("1");
		this.rb2.setUserData("2");
	}
	
	public void ShowMainPage(){
		this.main_page.setVisible(true);
		this.LexiconInfo.setVisible(false);
		this.ReciteSetting.setVisible(false);
		this.Reciting.setVisible(false);
		this.ShowMessageDialog.setVisible(false);
	}
	
	


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LexiconDataBinding();
		RadioButtonSetting();
		this.ShowMainPage();
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		/*if(arg0 instanceof Word){
			if(arg1.equals("chinese"))
			{
				System.out.println("chinese update");
				this.ChMean.setText(Word.getInstance().getChinese());
				
			}
		}*//*else if(arg0 instanceof Lexicon){
			System.out.println("chinese update");
			this.ChMean.setText(Word.getInstance().getChinese());
		}*/
		
	}	 
}
