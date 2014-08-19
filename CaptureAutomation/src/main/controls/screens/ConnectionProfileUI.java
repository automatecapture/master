package main.controls.screens;

import main.controls.*;
import main.controls.ControlEvent.ElementExists;

public class ConnectionProfileUI {

	public boolean isNoConnProfileErrorDisplayed(String errorText)
	{
		// String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ControlEvent event=new ControlEvent();
		event.WaitFor(5);
		return event.ReadLableText(errorText);
	}
	
	public boolean DoesCreateButtonExists()
	{
		ControlEvent event = new ControlEvent();
		return event.ButtonExists("Create", ElementExists.Displayed);
	}
	
	public void TapOnCreateButton()
	{
		ControlEvent event = new ControlEvent();
		event.TapLable("Create");
	}

	public void TypeServerNameInCreateProfile(String serverName)
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(2);
		event.WriteTextField("Profile name:", serverName);
	}
	
	public void TypeURLInCreateProfile(String serverURL)
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Server URL:", serverURL);
	}
	
	public void TapOnCreateProfileDoneBtn()
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(1);
		event.TapLable("Done");
		event.WaitFor(1);
	}
	
	public void TapOnCreateProfileCancelBtn()
	{
		ControlEvent event = new ControlEvent();
		event.TapLable("Cancel");
	}
	
	public boolean isProfileSetErrorDisplayed(String errorText)
	{
		ControlEvent event=new ControlEvent();
		event.WaitFor(2);
		return event.ReadLableText(errorText);
	}
	
	public void TapOnConnectionProfile(String profileName)
	{
		ControlEvent event=new ControlEvent();
		event.TapLable(profileName);
		event.WaitFor(2);
	}
	
	// Update
	public void TypeServerNameInUpdateProfile(String serverName)
	{
		TypeServerNameInCreateProfile(serverName);
	}
	
	public void TypeURLInUpdateProfile(String serverURL)
	{
		TypeURLInCreateProfile(serverURL);
	}
	
	public void TapOnUpdateProfileDoneBtn()
	{
		TapOnCreateProfileDoneBtn();
	}
	
	public void TapOnUpdateProfileCancelBtn()
	{
		TapOnCreateProfileCancelBtn();
	}
	// EndOFUpDate

	
	
	/*
	public int GetCountOfConnProfilesInList()
	{
		// TODO ...
		return 0;
	}
	
	
	public void SelectConnProfileByName(String connProfileName)
	{
		
	}
	
	public void TapOnEditOnConnProfileByName(String connProfileName)
	{
		
	}
	
	public void TapOnDeleteOnConnProfileByName(String connProfileName)
	{
		
	}
	
	public String GetURLDisplayedInConnProfile(String connProfileName)
	{
		return null;
	}
	*/
}
