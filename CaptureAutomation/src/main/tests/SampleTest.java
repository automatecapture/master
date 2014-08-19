package main.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import main.systemobjects.*;
import main.controls.ControlEvent;
import main.controls.screens.ConnectionProfileUI;
import main.controls.screens.ContextMenuUI;
import main.controls.screens.ContextMenuUI.ModuleToSelect;
import main.controls.screens.LogSettingsUI;
import main.controls.screens.LoginUI;
import main.controls.screens.NavigationUI;
import main.controls.screens.SecurityWarningUI;
import main.controls.screens.UserMenuUI;

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
	public void blankProfileCreateTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TapOnCreateProfileDoneBtn();
		
		String errProfile = "A profile name and server URL is required.";
		assertEquals("Inavlid string", true, connProfile.isProfileSetErrorDisplayed(errProfile));
	}
	
	@Test
	public void emptyURLProfileCreateTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TapOnCreateProfileDoneBtn();
		
		String errProfile = "A server URL is required.";
		assertEquals("Inavlid string", true, connProfile.isProfileSetErrorDisplayed(errProfile));
	}
	
	@Test
	public void emptyNameProfileCreateTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TypeURLInCreateProfile("temp");
		connProfile.TapOnCreateProfileDoneBtn();

		String errProfile = "A profile name is required.";
		assertEquals("Inavlid string", true, connProfile.isProfileSetErrorDisplayed(errProfile));
	}
	
	@Test
	public void invalidServerURLTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("abcd");
		connProfile.TapOnCreateProfileDoneBtn();
		
		String errProfile = "The URL you entered is invalid. Enter a valid server URL.";
		assertEquals("Inavlid string", true, connProfile.isProfileSetErrorDisplayed(errProfile));
	}
	
	@Test
	public void cancelProfileCreate() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("abcd");
		connProfile.TapOnCreateProfileDoneBtn();
		
		String errProfile = "The URL you entered is invalid. Enter a valid server URL.";
		assertEquals("Inavlid string", true, connProfile.isProfileSetErrorDisplayed(errProfile));
		
		connProfile.TapOnCreateProfileCancelBtn();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
	}
	
	@Test
	public void noCredentialsTest() throws Exception
	{
		String errorText = "A username is required.";
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.ClickOnConnectButton();
		boolean isError = login.isLoginErrorDisplayed(errorText);
		assertEquals("Login credential improper error", true, isError);
	}
	
	@Test
	public void noUserNameTest() throws Exception
	{
		String errorText = "A username is required.";
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.ClickOnConnectButton();
		boolean isError = login.isLoginErrorDisplayed(errorText);
		assertEquals("Login credential improper error", true, isError);
	}
	
	@Test
	public void noPasswordTest() throws Exception
	{
		String errorText = "A password is required.";
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.SetUserName("sampleInvalidUserName");
		login.ClickOnConnectButton();
		boolean isError = login.isLoginErrorDisplayed(errorText);
		assertEquals("Login credential improper error", true, isError);
	}
	
	@Test
	public void loginTest() throws Exception
	{
		
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		connProfile.TapOnCreateButton();
		
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("http://10.195.6.203:8080/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));

		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.SetUserName("test1");
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		UserMenuUI menu = new UserMenuUI();
		menu.TapOnUserMenu();
		menu.TapOnDisconnect();
		
		assertEquals("Login screen not displated", true, login.isUserNameExists());
	}
	
	@Test
	public void lastSuccessfulUserNameTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		connProfile.TapOnCreateButton();
		
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("http://10.195.6.203:8080/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));

		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		
		String userName = "test1";
		
		login.SetUserName(userName);
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		ControlEvent event = new ControlEvent();
		event.WaitFor(1);
		
		UserMenuUI menu = new UserMenuUI();
		menu.TapOnUserMenu();
		menu.TapOnDisconnect();
		
		event.WaitFor(4);
		assertEquals("Login screen not displated", true, login.isUserNameExists());
		assertEquals("Last successful username is not displayed", userName, login.GetUserName());
	}
	
	
	@Test
	public void firstCharUserNameTest() throws Exception
	{
		String username = "sampleusername";
		username = username.toLowerCase();
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		LoginUI login = new LoginUI();
		login.SetUserName(username);
		
		assertEquals("Incorrect user name", username, login.GetUserName());
	}
	
	@Test
	public void defaultUserNameStringTest() throws Exception
	{
		String username = "User name";
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		LoginUI login = new LoginUI();
		
		assertEquals("Incorrect user name", username, login.GetUserName());
	}
	
	@Test
	public void defaultPasswordStringTest() throws Exception
	{
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		LoginUI login = new LoginUI();
		
		assertEquals("Incorrect user name", true, login.IsPasswordEmpty());
	}
	
	@Test
	public void emptyCredentialAtStartTest() throws Exception
	{
		String username = "User name";
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		LoginUI login = new LoginUI();
		
		assertEquals("Incorrect user name", username, login.GetUserName());
		assertEquals("Incorrect user name", true, login.IsPasswordEmpty());
	}
	
	@Test
	public void profileSpecificUsernameTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		String con1 = "temp1", con2="temp2", url = "http://10.195.6.203:8080/integrationserver";
		String con1uname = "test1", con2uname = "test2";
		
		// Create con1 profile
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile(con1);
		connProfile.TypeURLInCreateProfile(url);
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		//Create con2 profile
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile(con2);
		connProfile.TypeURLInCreateProfile(url);
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		// Go to login
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		// Login with con1
		LoginUI login = new LoginUI();
		login.SetUserName(con1uname);
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		// Disconnect
		UserMenuUI menu = new UserMenuUI();
		menu.TapOnUserMenu();
		menu.TapOnDisconnect();
		ControlEvent event = new ControlEvent();
		event.WaitFor(4);
		assertEquals("Login screen not displated", true, login.isUserNameExists());
		assertEquals("Last successful username is not displayed", con1uname, login.GetUserName());
		
		event.TapOnDoneKey();
		
		// Go to Conn profile
		ContextMenuUI contextMenu = new ContextMenuUI();
		contextMenu.TapOnRightContextMenu();
		contextMenu.TapOptionFromRightContextMenu(ModuleToSelect.ConnProfile);
		
		// Select con2
		System.out.println("Tapping on con2");
		connProfile.TapOnConnectionProfile(con2);
		
		// Go to login
		navbar.TapOnBackButton();
		
		// Verify empty user name
		String defaultUsername = "User name";
		assertEquals("Incorrect user name", defaultUsername, login.GetUserName());
		
		login.SetUserName(con2uname);
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		// Disconnect
		menu.TapOnUserMenu();
		menu.TapOnDisconnect();
		
		event.WaitFor(4);
		assertEquals("Login screen not displated", true, login.isUserNameExists());
		assertEquals("Last successful username is not displayed", con2uname, login.GetUserName());
		
		event.TapOnDoneKey();
		
		// Switch to con1
		contextMenu.TapOnRightContextMenu();
		contextMenu.TapOptionFromRightContextMenu(ModuleToSelect.ConnProfile);
		
		// Select con1
		connProfile.TapOnConnectionProfile(con1);
		
		// Go to login
		navbar.TapOnBackButton();
		assertEquals("Last successful username is not displayed", con1uname, login.GetUserName());
	}
	
	@Test
	public void defaultLogSettingTest() throws Exception
	{
		ContextMenuUI menu= new ContextMenuUI();
		menu.TapOnRightContextMenu();
		menu.TapOptionFromRightContextMenu(ModuleToSelect.LogSettings);
		
		LogSettingsUI log = new LogSettingsUI();
		assertEquals("Error", false, log.isLoggingON());
		assertEquals("Error", "", log.GetEmailText());
		
		log.switchLoggingBtn();
		
		assertEquals("Error", true, log.isLoggingON());
		assertEquals("Error", "", log.GetEmailText());
	}
	
	@Test
	public void noLogFileErrorTest() throws Exception
	{
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		ControlEvent event = new ControlEvent();
		event.TapOnDoneKey();
		
		ContextMenuUI menu= new ContextMenuUI();
		menu.TapOnRightContextMenu();
		menu.TapOptionFromRightContextMenu(ModuleToSelect.LogSettings);
		
		LogSettingsUI log = new LogSettingsUI();
		log.TapSendEmail();
		
		assertEquals("Error in messgae", true, log.isNoLogFileError());
	}
	
	@Test
	public void invalidEmailTest() throws Exception
	{
		/*
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		ControlEvent event = new ControlEvent();
		event.TapOnDoneKey();
		*/

		ContextMenuUI menu= new ContextMenuUI();
		menu.TapOnRightContextMenu();
		menu.TapOptionFromRightContextMenu(ModuleToSelect.LogSettings);
		
		String []emails = {"abcd", "12334", "abd.com", "abc@bcd@efg"};
		
		LogSettingsUI log = new LogSettingsUI();
		
		for(int i=0; i<emails.length; i++)
		{
			System.out.println(emails[i]);
			log.SetEmailText(emails[i]);
			assertEquals("Error in messgae", true, log.isInvalidEmailError());
		}
	}
	
	@Test
	public void httpsTest() throws Exception
	{
		String errorText = "The application requires a connection profile to log in. Tap \"Create\" to add a connection profile.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		assertEquals("Error screen not proper", true, connProfile.isNoConnProfileErrorDisplayed(errorText));
		
		connProfile.TapOnCreateButton();
		
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("https://10.195.6.203:8443/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		assertEquals("Error screen not proper", false, connProfile.isNoConnProfileErrorDisplayed(errorText));

		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.SetUserName("test1");
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		SecurityWarningUI sec = new SecurityWarningUI();
		assertEquals("Error not displayed", true, sec.isSecurityWarningDisplayed());
		assertEquals("Error not displayed", true, sec.isSecurityWarningMsgDisplayed());
		
		
		// TODO
		sec.TapDetails();
		
	}
	
	@Test
	public void invalidHttpsConnTest() throws Exception
	{
		String errorText = "Secure connection with the server failed. Verify the connection settings and try again. If the problem persists, contact your administrator.";
		ConnectionProfileUI connProfile = new ConnectionProfileUI();
		connProfile.TapOnCreateButton();
		connProfile.TypeServerNameInCreateProfile("temp");
		connProfile.TypeURLInCreateProfile("https://10.195.6.203:8080/integrationserver");
		connProfile.TapOnCreateProfileDoneBtn();
		
		NavigationUI navbar = new NavigationUI();
		navbar.TapOnBackButton();
		
		LoginUI login = new LoginUI();
		login.SetUserName("test1");
		login.SetPassword("abcd");
		login.ClickOnConnectButton();
		
		assertEquals("Error not displayed", true, login.isLoginErrorDisplayed(errorText));
	}
}
