package model;

import java.util.Observable;
import java.util.Observer;

import controller.Lexicon;
import controller.Word;

/*ÿ����������Word�����ı�ʱ���ã���Ҫ�����޸��û���user.conf�ļ�*/

public class WordHandler implements Observer
{
	/*java�ĵ���ģʽ��ȷ������Ӧ�ó�����ֻ��һ��lexiconʵ��*/
	private volatile static WordHandler instance = null; 

	  public static WordHandler getInstance() { 
	    if (instance == null) { 
	      synchronized (WordHandler.class) { 
	        if(instance == null) { 
	          instance = new WordHandler(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	  
	public void update(Observable word, Object arg1) 
	{
		// TODO Auto-generated method stub
		/*TO��BE��DONE��
		 * ����Word�޸�txt�ļ���ʹ��randomAccess.
		 * */
		if(word instanceof Word)
		{    
			
             System.out.println("SomeThing changed:"+":"+arg1.toString());
        } 
	} 

}
