package controller;

import java.io.IOException;
import java.util.List;

import model.LexiconHandler;
import model.WordHandler;


/*
 * 主要是一些前台和后台调用的函数
 *public boolean chooseLexicon(String type)：
 *-选择此词库，type为输入的词库的类别（名称）
 *-返回是否选择成功。
 *
 
 <--有修改-->
 *public int setNum(int num)
 *-选择背诵的单词个数,num 为输入的数目
 *-ret: 输入数目不超过词库剩余单词 return 0,
 *		else return 词库剩余单词数
  <--有修改-->

 *public boolean chooseWord(String type)
 *-选择起始背诵的单词，type为类别：0为默认第一个，1为上次背诵的，type也可以是单词的英文
 *	0	-默认起始单词
 *	1	-上次背到的地方
 *	单词的英文	-特定单词，type为单词
 *-返回是否成功。
 * 
 * public int nextWord(String english)
 * -选择下一个单词,english为当前单词的背诵结果
 * -ret: 	1	-背对了，且选择好了另一个单词
 * 			2	-背对了，但是上限满了
 *			3 	-背对了，但是没有选好下一个单词
 *			-1 	-背错了，且选好另一个单词
 *			-2	-背错了，上限满了
 *			-3	-背错了，而且没有选好下一个单词
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
	//选择此词库，type为输入的词库的类别（名称）
	public boolean chooseLexicon(String type) throws IOException
	{
		return LexiconHandler.getInstance().chooseLexicon(type);
	}
	
	//选择背诵的单词个数,num 为输入的数目
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
	
	//选择起始背诵的单词
	//	0	-默认起始单词
	//	1	-上次背到的地方
	//	单词的英文	-特定单词，type为单词
	public boolean chooseWord(String type) throws IOException
	{
		return WordHandler.getInstance().chooseWord(type);
	}
	
	//选择下一个单词
	//ret: 	1	-背对了，且选择好了另一个单词
	//		2	-背对了，但是上限满了
	//		3 	-背对了，但是没有选好下一个单词
	//		-1 	-背错了，且选好另一个单词
	//		-2	-背错了，上限满了
	//		-3	-背错了，而且没有选好下一个单词
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
	
	//获取当前词库的统计信息
	//返回特定格式的String
	public String getLexiconInfo()
	{
		return Lexicon.getInstance().getType()+""+Lexicon.getInstance().getCountTotal()+""+Lexicon.getInstance().getCountRecited()+""+Lexicon.getInstance().getCountRight();
	}
	
	public List<String> getLexiconsInfo()
	{
		return null;
	}
	
	//获取上次背诵的单词的信息
	public String getLastWord() throws IOException
	{
		return WordHandler.getInstance().getLastWord();
		
	}
}
