package main.controls.screens;

import main.lib.PageSource;

public class NavigationUI {

	public void TapOnBackButton() throws Exception
	{
		PageSource readPage = new PageSource();
		readPage.tapElementByAttr("hint", "Up");
	}
	
}
