package controller;

/*Lexicon object的变量，只要有
 * entry：在数据库中的入口
 * countTotal:词库的单词个数
 * countExcept:当前用户选择的个数
 * countLeft:剩余背诵的个数
 * countRight:正确背诵的个数
 * Word:当前背诵的单词对象
 * 
 * */

public class Lexicon 
{
	private Integer entry;
	private Integer countTotal;
	private Integer countExcept;
	private Integer countLeft;
	private Integer countRight;
	
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
	private volatile static Lexicon instance = null; 

	  public static Lexicon getInstance() { 
	    if (instance == null) { 
	      synchronized (Lexicon.class) { 
	        if(instance == null) { 
	          instance = new Lexicon(-1,-1,-1,-1,-1); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	  
	public Lexicon(int entry, int countTotal, int countExcept, int countLeft, int countRight)
	{
		this.entry = entry;
		this.countExcept =  countExcept;
		this.countLeft = countLeft;
		this.countTotal =  countTotal;
	}
	
	public void setEntry(int entry)
	{
		this.entry = entry;
	}
	
	public void setCountTotal(int countTotal)
	{
		this.countTotal = countTotal;
	}
	
	public void setCountExcept(int countExcept)
	{
		this.countExcept = countExcept;
	}
	
	public void setCountLeft(int countLeft)
	{
		this.countLeft = countLeft;
	}
	
	public void setCountRight(int countRight)
	{
		this.countRight = countRight;
	}
	
	public Integer getEntry()
	{
		return this.entry;
	}
	
	public Integer getCountTotal()
	{
		return this.countTotal;
	}
	
	public Integer getCountExcept()
	{
		return this.countExcept;
	}
	
	public Integer getCountLeft()
	{
		return this.countLeft;
	}
	
	public Integer getCountRight()
	{
		return this.countRight;
	}
}
