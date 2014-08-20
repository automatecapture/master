package main.controls.screens;

import main.controls.ControlEvent;
import main.controls.ControlEvent.ElementExists;
import main.lib.ControlUtility;
import main.lib.ElementNotFoundException;

public class LoginUI extends ControlUtility {
	
	public boolean isLoginErrorDisplayed(String errorText) throws Exception
	{
		ControlEvent event = new ControlEvent();
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
	
	public String GetUserName() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		return event.ReadTextField("User name:");
	}
	
	public boolean isUserNameExists() throws ElementNotFoundException
	{
		ControlEvent event = new ControlEvent();

		try
		{
			return event.TextFieldExists("User name:", ElementExists.Displayed);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void SetUserName(String username) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("User name:", username, false);
	}
	
	public boolean IsPasswordEmpty() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		
		try
		{
			String password =  event.ReadTextField("Password:");
			return password.equals("Password") ? true : false;
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void SetPassword(String password) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Password:", password, false);
	}
	
	public void ClickOnConnectButton() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapButton("Connect");
	}
}
