package main.controls.screens;

import main.controls.ControlEvent;
import main.lib.ControlUtility;
import main.lib.ElementNotFoundException;

public class ContextMenuUI extends ControlUtility {
	
	public enum ModuleToSelect
	{
		OfflineLogin, ConnProfile, LogSettings
	}
	
	public boolean isNavBarTitle(String expectedTitle) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		try
		{
			return event.ReadLableText(expectedTitle);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void TapOnRightContextMenu() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapRightContext("User Menu");
	}
	
	public void TapOptionFromRightContextMenu(ModuleToSelect module) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		switch(module)
		{
		case OfflineLogin: event.TapRightContext("Log in Offline");
			break;
		case ConnProfile: event.TapRightContext("Connection Profiles");
			break;
		case LogSettings: event.TapRightContext("Log Settings");
			break;
		}
	}
	
}
