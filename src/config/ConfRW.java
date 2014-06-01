package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ConfRW
{
	/*java的单例模式，确保整个应用程序中只有一个lexicon实例*/
	private volatile static ConfRW instance = null; 

	public static ConfRW getInstance() throws FileNotFoundException { 
	    if (instance == null) { 
	      synchronized (ConfRW.class) { 
	        if(instance == null) { 
	          instance = new ConfRW(); 
	        } 
	      } 
	    } 
	    return instance; 
	}
	
	private File confFile = new File("user.conf");
	private RandomAccessFile readerConf;
	
	public ConfRW() throws FileNotFoundException
	{
		readerConf = new RandomAccessFile(confFile,"rw");
	}
	
	public RandomAccessFile getConf() throws FileNotFoundException
	{
		return readerConf;
	}
}
