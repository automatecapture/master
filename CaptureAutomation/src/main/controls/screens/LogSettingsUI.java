package main.controls.screens;

import main.controls.ControlEvent;
import main.lib.ElementNotFoundException;

public class LogSettingsUI {

	private String xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASwitch[1]";
	private String noLogError = "No log files available. Enable logging to create application log files.";
	private String invalidEmailError = "The email address is invalid. Enter a valid email address.";
	
	public boolean isLoggingON() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(3);
		try
		{
			String result = event.SwitchBtnExists(xpath);
			return result.equals("1");
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void switchLoggingBtn() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapSwitch(xpath);
	}
	
	public String GetEmailText() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		return event.ReadTextField("Email Address:");
	}
	
	public void SetEmailText(String email) throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Email Address:", email);
		event.WaitFor(2);
	}
	
	public void TapSendEmail() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapButton("Send");
	}
	
	public boolean isNoLogFileError() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		try
		{
			return event.ReadLableText(noLogError);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean isInvalidEmailError() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		try
		{
			return event.ReadLableText(invalidEmailError);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
}
