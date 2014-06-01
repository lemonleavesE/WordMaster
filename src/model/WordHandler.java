package model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Observable;
import java.util.Observer;

import config.ConfRW;
import controller.Lexicon;
import controller.Word;

/*每当被监听的Word发生改变时调用，主要用来修改用户的user.conf文件*/

public class WordHandler implements Observer
{
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
	private volatile static WordHandler instance = null; 

	  public static WordHandler getInstance() { 
	    if (instance == null) { 
	      synchronized (WordHandler.class) { 
	        if(instance == null) { 
	          instance = new WordHandler(); 
	        } 
	      } 
	    } 
	    return instance; 
	} 
	  
	public void update(Observable word, Object arg1) 
	{
		// TODO Auto-generated method stub
		/*TO　BE　DONE　
		 * 根据Word修改txt文件，使用randomAccess.
		 * */
		if(word instanceof Word)
		{    
			if(arg1.equals("state"))
			{
				try {
					RandomAccessFile readerConf = ConfRW.getInstance().getConf();
					readerConf.seek(((Word) word).getEntry()+8);
					readerConf.writeInt(((Word) word).getState());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        } 
	}
	
	public boolean chooseWord(String type) throws IOException
	{
		RandomAccessFile readerConf = ConfRW.getInstance().getConf();
		
		if(type.equals("0"))
		{
			readerConf.seek(Lexicon.getInstance().getEntryWord());
			Word.getInstance().setWord(readerConf.readLong(), readerConf.readInt(), readerConf.readUTF(), readerConf.readUTF());
			Word.getInstance().setChinese(Word.getInstance().getChinese());
			
			return true;
		}
		else if(type.equals("1"))
		{
			readerConf.seek(Lexicon.getInstance().getEntryLastWord());
			Word.getInstance().setWord(readerConf.readLong(), readerConf.readInt(), readerConf.readUTF(), readerConf.readUTF());
			Word.getInstance().setChinese(Word.getInstance().getChinese());
			
			return true;
		}
		return false;
	}
}
