package controller;


/*
 * ��Ҫ��һЩǰ̨�ͺ�̨���õĺ���
 * 
 * 
 * */
public class Action 
{
	/*word��lexicon����*/
	private static Word word = Word.getInstance();
	private static Lexicon lexicon = Lexicon.getInstance();
	
	/*��ʹ�õķ���*/
	public static void setChinese(String chinese)
	{
		word.setChinese(chinese);
	}
}
