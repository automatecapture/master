package main.controls.screens;

import main.controls.*;
import main.controls.ControlEvent.ElementExists;
import main.lib.ElementNotFoundException;

public class ConnectionProfileUI {

	public boolean isNoConnProfileErrorDisplayed(String errorText) throws InterruptedException
	{
		
		ControlEvent event=new ControlEvent();
		event.WaitFor(5);
		try
		{
			return event.ReadLableText(errorText);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean DoesCreateButtonExists() throws ElementNotFoundException
	{
		ControlEvent event = new ControlEvent();
		try
		{
			return event.ButtonExists("Create", ElementExists.Displayed);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void TapOnCreateButton() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapLable("Create");
	}

	public void TypeServerNameInCreateProfile(String serverName) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(2);
		event.WriteTextField("Profile name:", serverName);
	}
	
	public void TypeURLInCreateProfile(String serverURL) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Server URL:", serverURL);
	}
	
	public void TapOnCreateProfileDoneBtn() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(1);
		event.TapLable("Done");
		event.WaitFor(1);
	}
	
	public void TapOnCreateProfileCancelBtn() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapLable("Cancel");
	}
	
	public boolean isProfileSetErrorDisplayed(String errorText) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event=new ControlEvent();
		event.WaitFor(2);
		return event.ReadLableText(errorText);
	}
	
	public void TapOnConnectionProfile(String profileName) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event=new ControlEvent();
		event.TapLable(profileName);
		event.WaitFor(2);
	}
	
	// Update
	public void TypeServerNameInUpdateProfile(String serverName) throws ElementNotFoundException, InterruptedException
	{
		TypeServerNameInCreateProfile(serverName);
	}
	
	public void TypeURLInUpdateProfile(String serverURL) throws ElementNotFoundException, InterruptedException
	{
		TypeURLInCreateProfile(serverURL);
	}
	
	public void TapOnUpdateProfileDoneBtn() throws ElementNotFoundException, InterruptedException
	{
		TapOnCreateProfileDoneBtn();
	}
	
	public void TapOnUpdateProfileCancelBtn() throws ElementNotFoundException, InterruptedException
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
