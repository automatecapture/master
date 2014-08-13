package main.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import main.lib.ReadFromResources;
import main.systemobjects.*;
import main.controls.screens.ConnectionProfileUI;

@SuppressWarnings("nls")
public class SampleTest //extends SystemTestCase4
{
	private Configuration config;
	
	public SampleTest()
	{
		config = new Configuration();
	}
	
	@Before
	public void setup() throws Exception {
		System.out.print("In Setup\n");
		config.Setup();
	}
	
	@After
	public void tearDown() throws Exception {
		config.CleanUp();
	}
	
	@Test
	public void setupProfileTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("http://10.195.6.203:8080/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));
	}
	
	@Test
	public void loginTest() throws Exception
	{
		
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		/*
		connProfile.TapOnCreateButton();
		System.out.println("Name");
		
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("http://10.195.6.203:8080/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));
		*/
		connProfile.TapOnBackButton();
		
		
		
	}
	
	@Test
	public void propTest()
	{
		System.out.println(new ReadFromResources().getProperty("navigateToLoginScreen"));
	}
}
