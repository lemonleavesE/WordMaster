package model;

import java.io.IOException;
import java.io.RandomAccessFile;

import config.ConfRW;
import controller.Lexicon;

public class LexiconHandler 
{
	/*java的单例模式，确保整个应用程序中只有一个Viewer实例*/
	private volatile static LexiconHandler instance = null; 

	  public static LexiconHandler getInstance() { 
	    if (instance == null) { 
	      synchronized (LexiconHandler.class) { 
	        if(instance == null) { 
	          instance = new LexiconHandler(); 
	        } 
	      } 
	    } 
	    return instance; 
	}
	 
	public boolean chooseLexicon(String type) throws IOException
	{
		RandomAccessFile readerConf = ConfRW.getInstance().getConf();
		readerConf.seek(0);
		
		long boundry = readerConf.readLong();
		long tempEntry = 0;
		String tempType = "";
		while(readerConf.getFilePointer()<boundry)
		{
				tempEntry = readerConf.readLong();
				tempType = readerConf.readUTF();
				
				if(tempType.equals(type))
				{
					Lexicon.getInstance().setEntryLexicon(tempEntry);
					Lexicon.getInstance().setType(tempType);
					Lexicon.getInstance().setCountTotal(readerConf.readInt());
					Lexicon.getInstance().setEntryWord(readerConf.readLong());
					Lexicon.getInstance().setEntryLastWord(readerConf.readLong());
					Lexicon.getInstance().setCountRecited(readerConf.readInt());
					Lexicon.getInstance().setCountRight(readerConf.readInt());
					return true;
				}
				else
				{
					readerConf.skipBytes(28);
				}
		}
		
		return false;
	}
}
