package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ConfGenerator 
{
	@SuppressWarnings("rawtypes")
	public void generateConfig() throws IOException
	{
		File confFile = new File("user.conf");
			
		if(!confFile.exists())
		{
			confFile.createNewFile();
		}
		
		BufferedReader readerDict = new BufferedReader(new FileReader("dictionary.txt"));
		RandomAccessFile readerConf = new RandomAccessFile(confFile,"rw");
		
		String lineTemp="";
	
		//读取dictionary.txt，为配置词库做准备
		Map<String,Integer> lexiconConf = new HashMap<String,Integer>(); 
		Map<String,Long> lexiconTemp = new HashMap<String,Long>(); 
		
		String type = "";
		int count = 0;
		
		while((lineTemp = readerDict.readLine())!=null)
		{
			type = lineTemp.substring(0, 1);
			count = lexiconConf.containsKey(type)?count++:1;
			
			lexiconConf.put(type,count);
		} 
		readerDict.close();
		
		
		readerConf.seek(0);
		
		//写词库和词语配置信息的分割点
		readerConf.writeLong(0);
		//写入词库信息
		Iterator iter = lexiconConf.entrySet().iterator();
		while (iter.hasNext())
		{
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			
			//词库配置入口
			readerConf.writeLong(readerConf.getFilePointer());
			//词库类别
			readerConf.writeUTF((String) key);
			//词库含有的单词个数
			readerConf.writeInt((Integer) val);
			//词库入口
			lexiconTemp.put((String) key,readerConf.getFilePointer());
			readerConf.writeLong(0);
			//词库上次背到单词的入口
			readerConf.writeLong(0);
			//词库已经背的单词个数
			readerConf.writeInt(0);
			//词库背对的单词的个数
			readerConf.writeInt(0);
			
		}
		
		long tempPoint = readerConf.getFilePointer(); 
		readerConf.seek(0);
		readerConf.writeLong(tempPoint);
		
		//开始写词语信息
		readerConf.seek(tempPoint);
		readerDict = new BufferedReader(new FileReader("dictionary.txt"));
		while((lineTemp = readerDict.readLine())!=null)
		{
			String[] info = lineTemp.split("   ");
			
			if(info.length!=2)
			{
				continue;
			}
			
			if(lexiconTemp.containsKey(info[0].substring(0,1)))
			{
				tempPoint = readerConf.getFilePointer();
				readerConf.seek(lexiconTemp.get(info[0].substring(0,1)));
				//词库写入入口
				readerConf.writeLong(tempPoint);
				readerConf.writeLong(tempPoint);
				
				//返回当前词语
				readerConf.seek(tempPoint);
				lexiconTemp.keySet().remove(info[0].substring(0,1));
			}
			
			//写入entry
			readerConf.writeLong(readerConf.getFilePointer());
			//写入中文释义
			readerConf.writeUTF(info[0]);
			//写入英文释义
			readerConf.writeUTF(info[1]);
			//写入状态
			readerConf.writeInt(0);
		} 
		
		/*test
		readerConf.seek(0);
		long temp = readerConf.readLong();
		while(readerConf.getFilePointer()<temp)
		{
			System.out.print(readerConf.readLong()+"-");
			System.out.print(readerConf.readUTF()+"-");
			System.out.print(readerConf.readInt()+"-");
			System.out.print(readerConf.readLong()+"-");
			System.out.print(readerConf.readLong()+"-");
			System.out.print(readerConf.readInt()+"-");
			System.out.println(readerConf.readInt());
		}
		while(readerConf.getFilePointer()<readerConf.length())
		{
			System.out.print(readerConf.readLong()+"-");
			System.out.print(readerConf.readUTF()+"-");
			System.out.print(readerConf.readUTF()+"-");
			System.out.println(readerConf.readInt());
		}
		*/
		readerConf.close();
		readerDict.close();
	}
}
