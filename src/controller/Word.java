package controller;

import java.util.Observable;

import model.TxtHandler;
import viewer.Viewer;

/*Word object�ı�����ֻҪ��
 * entry: ��ǰ�����word��entry 
 * english��word��Ӣ������
 * chinese��word����������
 * state: ��ǰ�����word��״̬��16���ƣ�
 * */

public class Word extends Observable
{
	private Integer entry;
	private String english;    
	private String chinese;
	private Integer state;
	
	 public Word(int entry, String english, String chinese, int state) 
	 {
		 this.chinese = chinese;
		 this.english = english;
		 this.entry = entry;
		 this.state = state;  
		 
		 this.addObserver(new TxtHandler());
		 this.addObserver(new Viewer());
	 }    
	 
	 public Integer getEntry() 
	 {    
		 this.notifyObservers("entry");
	     return this.entry;    
	 }
	 
	 public String getEnglish() 
	 {    
		 this.notifyObservers("english");
	     return this.english;    
	 }
	 
	 public String getChinese()
	 {
		 this.notifyObservers("chinese");
		 return this.chinese;
	 }
	 
	 public Integer getState()
	 {
		 this.notifyObservers("state");
		 return this.state;
	 }
	 
	 public void setEntry(int entry)
	 {
		 this.entry = entry;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers("entry");
	 }
	 
	 public void setEnglish(String english)
	 {
		 this.english = english;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers("english");
	 }
	 
	 public void setChinese(String chinese)
	 {
		 this.chinese = chinese;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers("chinese");
	 }
	 
	 public void setState(Integer state)
	 {
		 
		 this.state = state;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers("state");
	 }
}
