package controller;

import viewer.Viewer;
import model.TxtHandler;

/*
 * ��Ҫ��һЩǰ̨�ͺ�̨���õĺ���
 * 
 * 
 * */
public class Action 
{
	Lexicon lexicon;
	
	/*��ʼ��Action,type Ϊ�ʿ������a*/
	public Action(String type)
	{
		Word word = new Word(0, "", "", 0);
		lexicon = new Lexicon(0, 0, 0, 0, 0, word);
		
		word.addObserver(new TxtHandler());
		word.addObserver(new Viewer());
	}
	
	/*������action*/
}
