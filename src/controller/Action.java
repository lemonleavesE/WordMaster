package controller;

import java.io.IOException;
import java.util.List;

import model.LexiconHandler;
import model.WordHandler;


/*
 * ��Ҫ��һЩǰ̨�ͺ�̨���õĺ���
 *public boolean chooseLexicon(String type)��
 *-ѡ��˴ʿ⣬typeΪ����Ĵʿ��������ƣ�
 *-�����Ƿ�ѡ��ɹ���
 *
 
 <--���޸�-->
 *public int setNum(int num)
 *-ѡ���еĵ��ʸ���,num Ϊ�������Ŀ
 *-ret: ������Ŀ�������ʿ�ʣ�൥�� return 0,
 *		else return �ʿ�ʣ�൥����
  <--���޸�-->

 *public boolean chooseWord(String type)
 *-ѡ����ʼ���еĵ��ʣ�typeΪ���0ΪĬ�ϵ�һ����1Ϊ�ϴα��еģ�typeҲ�����ǵ��ʵ�Ӣ��
 *	0	-Ĭ����ʼ����
 *	1	-�ϴα����ĵط�
 *	���ʵ�Ӣ��	-�ض����ʣ�typeΪ����
 *-�����Ƿ�ɹ���
 * 
 * public int nextWord(String english)
 * -ѡ����һ������,englishΪ��ǰ���ʵı��н��
 * -ret: 	1	-�����ˣ���ѡ�������һ������
 * 			2	-�����ˣ�������������
 *			3 	-�����ˣ�����û��ѡ����һ������
 *			-1 	-�����ˣ���ѡ����һ������
 *			-2	-�����ˣ���������
 *			-3	-�����ˣ�����û��ѡ����һ������
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
	//ѡ��˴ʿ⣬typeΪ����Ĵʿ��������ƣ�
	public boolean chooseLexicon(String type) throws IOException
	{
		return LexiconHandler.getInstance().chooseLexicon(type);
	}
	
	//ѡ���еĵ��ʸ���,num Ϊ�������Ŀ
	public boolean setNum(int num)
	{
		if(Lexicon.getInstance().getCountTotal()>=num)
		{
			countTotal = num;
			count = 0;
			countCorrect = 0;
			return true;
		}
		return false;
	}
	
	//ѡ����ʼ���еĵ���
	//	0	-Ĭ����ʼ����
	//	1	-�ϴα����ĵط�
	//	���ʵ�Ӣ��	-�ض����ʣ�typeΪ����
	public boolean chooseWord(String type) throws IOException
	{
		return WordHandler.getInstance().chooseWord(type);
	}
	
	//ѡ����һ������
	//ret: 	1	-�����ˣ���ѡ�������һ������
	//		2	-�����ˣ�������������
	//		3 	-�����ˣ�����û��ѡ����һ������
	//		-1 	-�����ˣ���ѡ����һ������
	//		-2	-�����ˣ���������
	//		-3	-�����ˣ�����û��ѡ����һ������
	public int nextWord(String english) throws IOException
	{
		int ret = 0;
		count++;
		if(Word.getInstance().getEnglish().equals(english))
		{
			Word.getInstance().setState(2);
			countCorrect++;
			ret = 1;
		}
		else
		{
			Word.getInstance().setState(1);
			ret = -1;
		}
		
		if(count==countTotal)
		{
			ret *= 2;
			return ret;
		}
		
		ret = WordHandler.getInstance().chooseWord("3")?ret:ret*3;

		return ret;
	}
	
	//��ȡ��ǰ�ʿ��ͳ����Ϣ
	//�����ض���ʽ��String
	public String getLexiconInfo()
	{
		return Lexicon.getInstance().getType()+""+Lexicon.getInstance().getCountTotal()+""+Lexicon.getInstance().getCountRecited()+""+Lexicon.getInstance().getCountRight();
	}
	
	public List<String> getLexiconsInfo()
	{
		return null;
	}
	
	//��ȡ�ϴα��еĵ��ʵ���Ϣ
	public String getLastWord() throws IOException
	{
		return WordHandler.getInstance().getLastWord();
		
	}
}
