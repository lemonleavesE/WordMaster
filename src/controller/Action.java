package controller;


/*
 * 主要是一些前台和后台调用的函数
 * 
 * 
 * */
public class Action 
{
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
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
	
	//计数器，已经背过的单词的个数
	private static int count = 0;
	//本次希望背的单词的个数
	private static int countTotal = 0;
	//本次背对的单词的个数
	private static int countCorrect = 0;
	
	/*供使用的方法*/
	public void chooseLexicon(String type)
	{
		System.out.println("hi!");
	}
}
