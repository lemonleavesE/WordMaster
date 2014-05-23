package bean;

import java.util.Observable;

/*Word bean的变量，只要有
 * user: 当前登录的user 
 * word：当前处理的word (对应dictionary中的入口，也就是byte数目)
 * property：当前处理的word对应到配置文件(对应user.conf中的入口，也就是byte数目)
 * state: 当前处理的word的状态（16进制）
 * */

public class Word extends Observable
{
	private String user;    
	private Integer word;
	private Integer property;
	private Integer state;
	 
	 public Word(String user, int word, int property, int state) 
	 {
		 this.user = user;
		 this.word = word;
		 this.property = property;
		 this.state = state;    
	 }    
	 
	 public String getUser() 
	 {    
		 this.notifyObservers(this.user);
	     return user;    
	 }
	 
	 public Integer getWord() 
	 {    
		 this.notifyObservers(this.word);
	     return this.word;    
	 }
	 
	 public Integer getProperty()
	 {
		 this.notifyObservers(this.property);
		 return this.property;
	 }
	 
	 public Integer getState()
	 {
		 this.notifyObservers(this.state);
		 return this.state;
	 }
	 
	 public void setUser(String user)
	 {
		 this.user = user;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers(user);
	 }
	 
	 public void setWord(Integer word)
	 {
		 this.word = word;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers(word);
	 }
	 
	 public void setProperty(Integer property)
	 {
		 this.property = property;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers(property);
	 }
	 
	 public void setState(Integer state)
	 {
		 this.state = state;
		 
		 /*设置observable的状态为已经改变*/
		 this.setChanged();
		 this.notifyObservers(state);
	 }
}
