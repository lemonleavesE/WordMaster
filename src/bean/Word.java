package bean;

import java.util.Observable;

/*Word bean�ı�����ֻҪ��
 * user: ��ǰ��¼��user 
 * word����ǰ�����word (��Ӧdictionary�е���ڣ�Ҳ����byte��Ŀ)
 * property����ǰ�����word��Ӧ�������ļ�(��Ӧuser.conf�е���ڣ�Ҳ����byte��Ŀ)
 * state: ��ǰ�����word��״̬��16���ƣ�
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
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers(user);
	 }
	 
	 public void setWord(Integer word)
	 {
		 this.word = word;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers(word);
	 }
	 
	 public void setProperty(Integer property)
	 {
		 this.property = property;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers(property);
	 }
	 
	 public void setState(Integer state)
	 {
		 this.state = state;
		 
		 /*����observable��״̬Ϊ�Ѿ��ı�*/
		 this.setChanged();
		 this.notifyObservers(state);
	 }
}
