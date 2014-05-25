package model;

import java.util.Observable;
import java.util.Observer;

import controller.Word;

/*每当被监听的Word发生改变时调用，主要用来修改用户的user.conf文件*/

public class TxtHandler implements Observer
{

	public void update(Observable word, Object arg1) 
	{
		// TODO Auto-generated method stub
		/*TO　BE　DONE　
		 * 根据Word修改txt文件，使用randomAccess.
		 * */
		if(word instanceof Word)
		{    
			
             System.out.println("SomeThing changed:"+arg1.toString());
        } 
	} 

}
