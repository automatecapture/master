package main.controls.screens;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import main.controls.ControlEvent;
import main.lib.ControlUtility;
import main.lib.ElementNotFoundException;
import main.lib.PageSource;

public class UserMenuUI extends ControlUtility {

	
	
	public UserMenuUI()
	{
		
	}
	
	public boolean CheckIfModuleExists(String moduleName)
	{
		return true;
	}
	
	public void TapOnUserMenu() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapRightContext("User Menu");
	}
	
	public void TapModuleByName(String moduleName)
	{
		
	}
	
	public void TapOnDisconnect() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	{
		PageSource readPage = new PageSource();
		readPage.disConnect();
	}
	
	public void TapOnOfflinePinSetup()
	{
		
	}
}
