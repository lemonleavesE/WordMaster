package controller;

import java.util.Observable;

import model.WordHandler;
import viewer.Test;
import viewer.Viewer;

/*Word object的变量，只要有
 * entry: 当前处理的word的entry 
 * english：word的英文释义
 * chinese：word的中文释义
 * state: 当前处理的word的状态（16进制）
 * */

public class Word extends Observable
{
	private long entry;
	private String english;    
	private String chinese;
	private Integer state;
	
	/*java的单例模式，确保整个应用中只有一个实例*/
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
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers("entry");
	 }
	 
	 public void setEnglish(String english)
	 {
		 this.english = english;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers("english");
	 }
	 
	 public void setChinese(String chinese)
	 {
		 this.chinese = chinese;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers("chinese");
	 }
	 
	 public void setState(Integer state)
	 {
		 
		 this.state = state;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers("state");
	 }
}
