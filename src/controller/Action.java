package controller;

import viewer.Viewer;
import model.TxtHandler;

/*
 * 主要是一些前台和后台调用的函数
 * 
 * 
 * */
public class Action 
{
	Lexicon lexicon;
	
	/*初始化Action,type 为词库类别，如a*/
	public Action(String type)
	{
		Word word = new Word(0, "", "", 0);
		lexicon = new Lexicon(0, 0, 0, 0, 0, word);
		
		word.addObserver(new TxtHandler());
		word.addObserver(new Viewer());
	}
	
	/*其他的action*/
}
