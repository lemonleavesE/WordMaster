package model;

import java.util.Observable;
import java.util.Observer;

import controller.Word;

/*ÿ����������Word�����ı�ʱ���ã���Ҫ�����޸��û���user.conf�ļ�*/

public class TxtHandler implements Observer
{

	public void update(Observable word, Object arg1) 
	{
		// TODO Auto-generated method stub
		/*TO��BE��DONE��
		 * ����Word�޸�txt�ļ���ʹ��randomAccess.
		 * */
		if(word instanceof Word)
		{    
			
             System.out.println("SomeThing changed:"+arg1.toString());
        } 
	} 

}
