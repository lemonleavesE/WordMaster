package controller;


/*
 * ��Ҫ��һЩǰ̨�ͺ�̨���õĺ���
 * 
 * 
 * */
public class Action 
{
	/*java�ĵ���ģʽ��ȷ������Ӧ�ó�����ֻ��һ��lexiconʵ��*/
	private volatile static Action instance = null; 

	  public static Action getInstance() { 
	    if (instance == null) { 
	      synchronized (Action.class) { 
	        if(instance == null) { 
	          instance = new Action(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	
	//���������Ѿ������ĵ��ʵĸ���
	private static int count = 0;
	//����ϣ�����ĵ��ʵĸ���
	private static int countTotal = 0;
	//���α��Եĵ��ʵĸ���
	private static int countCorrect = 0;
	
	/*��ʹ�õķ���*/
	public void chooseLexicon(String type)
	{
		System.out.println("hi!");
	}
}
