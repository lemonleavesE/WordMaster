package controller;


/*
 * 主要是一些前台和后台调用的函数
 * 
 * 
 * */
public class Action 
{
	/*word和lexicon对象*/
	private static Word word = Word.getInstance();
	private static Lexicon lexicon = Lexicon.getInstance();
	
	/*供使用的方法*/
	public static void setChinese(String chinese)
	{
		word.setChinese(chinese);
	}
}
