package controller;


/*
 * 主要是一些前台和后台调用的函数
 * 
 * 
 * */
public class Action 
{
	static Word word = new Word(0, "", "", 0);
	Lexicon lexicon = new Lexicon(0, 0, 0, 0, 0, word);
	
	public static void setChinese(String chinese)
	{
		word.setChinese(chinese);
	}
}
