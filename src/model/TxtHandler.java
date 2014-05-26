package model;

import java.util.Observable;
import java.util.Observer;

import controller.Lexicon;
import controller.Word;

/*每当被监听的Word发生改变时调用，主要用来修改用户的user.conf文件*/

public class TxtHandler implements Observer
{
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
	private volatile static TxtHandler instance = null; 

	  public static TxtHandler getInstance() { 
	    if (instance == null) { 
	      synchronized (TxtHandler.class) { 
	        if(instance == null) { 
	          instance = new TxtHandler(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	  
	public void update(Observable word, Object arg1) 
	{
		// TODO Auto-generated method stub
		/*TO　BE　DONE　
		 * 根据Word修改txt文件，使用randomAccess.
		 * */
		if(word instanceof Word)
		{    
			
             System.out.println("SomeThing changed:"+":"+arg1.toString());
        } 
	} 

}
