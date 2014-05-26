package model;

import java.util.Observable;
import java.util.Observer;

import controller.Lexicon;
import controller.Word;

/*ÿ����������Word�����ı�ʱ���ã���Ҫ�����޸��û���user.conf�ļ�*/

public class TxtHandler implements Observer
{
	/*java�ĵ���ģʽ��ȷ������Ӧ�ó�����ֻ��һ��lexiconʵ��*/
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
		/*TO��BE��DONE��
		 * ����Word�޸�txt�ļ���ʹ��randomAccess.
		 * */
		if(word instanceof Word)
		{    
			
             System.out.println("SomeThing changed:"+":"+arg1.toString());
        } 
	} 

}
