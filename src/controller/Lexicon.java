package controller;

import java.util.Observable;

/*Lexicon object的变量，只要有
 * entryLexicon：词库入口
 * type:词库类别
 * countTotal:词库的单词个数
 * entryWord:词库中第一个单词入口
 * entryLastWord:上一次背到的单词的入口（默认为第一个单词）
 * countRecited:已经背过的单词的个数
 * countRight：已经背对的单词的个数
 * countWrong：被错的单词个数
 * accuracy：正确率
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
	
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
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
