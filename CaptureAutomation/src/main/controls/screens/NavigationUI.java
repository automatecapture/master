package main.controls.screens;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import main.lib.PageSource;
import org.xml.sax.SAXException;

public class NavigationUI {

	public void TapOnBackButton() throws Exception
	{
		PageSource readPage = new PageSource();
		readPage.tapElementByAttr("hint", "Up");
	}
	
}
