package controller;


/*
 * ��Ҫ��һЩǰ̨�ͺ�̨���õĺ���
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
