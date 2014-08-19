package main.controls.screens;

import main.controls.ControlEvent;
import main.controls.ControlEvent.ElementExists;
import main.lib.ControlUtility;

public class LoginUI extends ControlUtility {
	
	public boolean isLoginErrorDisplayed(String errorText) throws Exception
	{
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(errorText);
	}
	
	public String GetUserName()
	{
		ControlEvent event = new ControlEvent();
		return event.ReadTextField("User name:");
	}
	
	public boolean isUserNameExists()
	{
		ControlEvent event = new ControlEvent();
		return event.TextFieldExists("User name:", ElementExists.Displayed);
	}
	
	public void SetUserName(String username) throws InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("User name:", username, false);
	}
	
	public boolean IsPasswordEmpty()
	{
		ControlEvent event = new ControlEvent();
		String password =  event.ReadTextField("Password:");
		return password.equals("Password") ? true : false;
	}
	
	public void SetPassword(String password) throws InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Password:", password, false);
	}
	
	public void ClickOnConnectButton() throws InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapButton("Connect");
	}
}
