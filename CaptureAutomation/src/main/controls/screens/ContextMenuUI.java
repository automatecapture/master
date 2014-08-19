package main.controls.screens;

import main.controls.ControlEvent;
import main.lib.ControlUtility;

public class ContextMenuUI extends ControlUtility {
	
	public enum ModuleToSelect
	{
		OfflineLogin, ConnProfile, LogSettings
	}
	
	public boolean isNavBarTitle(String expectedTitle)
	{
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(expectedTitle);
	}
	
	public void TapOnRightContextMenu()
	{
		ControlEvent event = new ControlEvent();
		event.TapRightContext("User Menu");
	}
	
	public void TapOptionFromRightContextMenu(ModuleToSelect module)
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
