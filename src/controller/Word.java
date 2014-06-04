package controller;

import java.util.Observable;

import model.WordHandler;
import viewer.Test;
import viewer.Viewer;

/*Word object�ı�����ֻҪ��
 * entry: ��ǰ�����word��entry 
 * english��word��Ӣ������
 * chinese��word����������
 * state: ��ǰ�����word��״̬��16���ƣ�
 * */

public class Word extends Observable
{
	private long entry;
	private String english;    
	private String chinese;
	private Integer state;
	
	/*java�ĵ���ģʽ��ȷ������Ӧ����ֻ��һ��ʵ��*/
	private volatile static Word instance = null; 

	public static Word getInstance() { 
	   if (instance == null) { 
	     synchronized (Word.class) { 
	        if(instance == null) { 
	          instance = new Word(-1,-1,"",""); 
	        } 
	      } 
	    } 
	    return instance; 
	 } 
	 
	
	public Word(long entry, int state, String english, String chinese) 
	{
		this.chinese = chinese;
		this.english = english;
		this.entry = entry;
		this.state = state;  
		 
		this.addObserver(WordHandler.getInstance());
		this.addObserver(Test.getInstance());
	 }    
	 public void setWord(long entry, int state, String english, String chinese) 
	{
		this.chinese = chinese;
		this.english = english;
		this.entry = entry;
		this.state = state;  
	}
	 
	 public long getEntry() 
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
	 
	 public void setEntry(long entry)
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
