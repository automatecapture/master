package main.controls.screens;

import main.controls.ControlEvent;

public class LogSettingsUI {

	private String xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASwitch[1]";
	private String noLogError = "No log files available. Enable logging to create application log files.";
	private String invalidEmailError = "The email address is invalid. Enter a valid email address.";
	
	public boolean isLoggingON()
	{
		ControlEvent event = new ControlEvent();
		event.WaitFor(3);
		String result = event.SwitchBtnExists(xpath);
		return result.equals("1");
	}
	
	public void switchLoggingBtn()
	{
		ControlEvent event = new ControlEvent();
		event.TapSwitch(xpath);
	}
	
	public String GetEmailText()
	{
		ControlEvent event = new ControlEvent();
		return event.ReadTextField("Email Address:");
	}
	
	public void SetEmailText(String email)
	{
		ControlEvent event = new ControlEvent();
		event.WriteTextField("Email Address:", email);
		event.WaitFor(2);
	}
	
	public void TapSendEmail()
	{
		ControlEvent event = new ControlEvent();
		event.TapButton("Send");
	}
	
	public boolean isNoLogFileError()
	{
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(noLogError);
	}
	
	public boolean isInvalidEmailError()
	{
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(invalidEmailError);
	}
	
}
