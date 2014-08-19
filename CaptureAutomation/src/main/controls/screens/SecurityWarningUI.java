package main.controls.screens;

import main.controls.ControlEvent;

public class SecurityWarningUI {

	public boolean isSecurityWarningDisplayed()
	{
		String secWarning = "Security Warning!";
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(secWarning);
	}
	
	public boolean isSecurityWarningMsgDisplayed()
	{
		String secWarning = "The server certificate is not from a trusted authority. Do you want to continue?";
		ControlEvent event = new ControlEvent();
		return event.ReadLableText(secWarning);
	}
	
	public void TapDetails()
	{
		ControlEvent event = new ControlEvent();
		event.TapTableCell("Details");
		event.WaitFor(2);
	}
}
