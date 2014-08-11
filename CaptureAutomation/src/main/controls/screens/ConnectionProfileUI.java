package main.controls.screens;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import main.controls.*;
import main.controls.ControlEvent.ElementExists;
import main.lib.ControlUtility;
import main.systemobjects.ConfigWebDriver;

public class ConnectionProfileUI {

	public boolean isNoConnProfileErrorDisplayed(String errorText)
	{
		// String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ControlEvent event=new ControlEvent();
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
		event.WaitFor(3);
		System.out.println("_____ JS _____");
		((JavascriptExecutor)ConfigWebDriver.driver).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 294.0); put("y", 328.0); }});
		event.TapLable("Done");
	}
	
	public void TapOnCreateProfileCancelBtn()
	{
		ControlEvent event = new ControlEvent();
		event.TapLable("Cancel");
	}
	
	public boolean isProfileSetErrorDisplayed(String errorText)
	{
		//String errorText = "A profile name and server URL is required.";
		ControlEvent event=new ControlEvent();
		return event.ReadLableText(errorText);
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
	
	public void TapOnBackButton()
	{
		System.out.println(ConfigWebDriver.driver.getPageSource());
	}
	
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
