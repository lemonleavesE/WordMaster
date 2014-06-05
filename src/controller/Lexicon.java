package controller;

import java.util.Observable;

/*Lexicon object�ı�����ֻҪ��
 * entryLexicon���ʿ����
 * type:�ʿ����
 * countTotal:�ʿ�ĵ��ʸ���
 * entryWord:�ʿ��е�һ���������
 * entryLastWord:��һ�α����ĵ��ʵ���ڣ�Ĭ��Ϊ��һ�����ʣ�
 * countRecited:�Ѿ������ĵ��ʵĸ���
 * countRight���Ѿ����Եĵ��ʵĸ���
 * countWrong������ĵ��ʸ���
 * accuracy����ȷ��
 * 
 * */

public class Lexicon extends Observable
{
	private long entryLexicon;
	private String type;
	private Integer countTotal;
	private long entryWord;
	private long entryLastWord;
	private Integer countRecited;
	private Integer countRight;
	
	/*java�ĵ���ģʽ��ȷ������Ӧ�ó�����ֻ��һ��lexiconʵ��*/
	private volatile static Lexicon instance = null; 

	  public static Lexicon getInstance() { 
	    if (instance == null) { 
	      synchronized (Lexicon.class) { 
	        if(instance == null) { 
	          instance = new Lexicon(-1,"", -1,-1,-1,-1, -1); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	  
	public Lexicon(long entryLexicon, String type, int countTotal,long entryWord, long entryLastWord, int countRecited, int countRight)
	{
		this.countRecited = countRecited;
		this.countRight =  countRight;
		this.countTotal = countTotal;
		this.entryLastWord = entryLastWord;
		this.entryLexicon = entryLexicon;
		this.entryWord = entryWord;
		this.type = type;
	}
	
	public void setCountRecited(int count)
	{
		this.countRecited = count;
	}
	
	public void setCountRight(int count)
	{
		this.countRight = count;
	}
	
	public void setCountTotal(int count)
	{
		this.countTotal = count;
	}
	
	public void setEntryLastWord(long entry)
	{
		this.entryLastWord = entry;
	}
	
	public void setEntryLexicon(long entry)
	{
		this.entryLexicon = entry;
	}
	
	public void setEntryWord(long entry)
	{
		this.entryWord = entry;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public int getCountTotal()
	{
		return this.countTotal;	
	}
	
	public int getCountRecited()
	{
		return this.countRecited;	
	}
	
	public int getCountRight()
	{
		return this.countRight;	
	}
	
	public long getEntryLexicon()
	{
		return this.entryLexicon;
	}
	
	public long getEntryLastWord()
	{
		return this.entryLastWord;
	}
	
	public long getEntryWord()
	{
		return this.entryWord;
	}
	
	public String getType()
	{
		return this.type;
	}
}
