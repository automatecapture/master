package main.controls.screens;

import main.controls.ControlEvent;
import main.lib.ElementNotFoundException;

public class SecurityWarningUI {

	public boolean isSecurityWarningDisplayed() throws ElementNotFoundException, InterruptedException
	{
		String secWarning = "Security Warning!";
		ControlEvent event = new ControlEvent();
		
		try
		{
			return event.ReadLableText(secWarning);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean isSecurityWarningMsgDisplayed() throws ElementNotFoundException, InterruptedException
	{
		String secWarning = "The server certificate is not from a trusted authority. Do you want to continue?";
		ControlEvent event = new ControlEvent();
		
		try
		{
			return event.ReadLableText(secWarning);
		}
		catch(ElementNotFoundException ex)
		{
			System.out.println(ex);
			return false;
		}
	}
	
	public void TapDetails() throws ElementNotFoundException, InterruptedException
	{
		ControlEvent event = new ControlEvent();
		event.TapTableCell("Details");
		event.WaitFor(2);
	}
}
