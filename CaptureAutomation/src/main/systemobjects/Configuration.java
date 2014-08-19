package main.systemobjects;

import io.appium.java_client.AppiumDriver;

import java.net.URL;


import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;


public class Configuration {
	//RemoteWebDriver driver;
	public void Setup()
	{
		SystemSettings settings = new SystemSettings();
	
		
		/* For Android-one_4.1.2 - 4.4.;
		 * File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../apps/ApiDemos/bin");
        File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("app-package", "com.example.android.apis");
        capabilities.setCapability("app-activity", ".ApiDemos");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        */
		try
		{
			System.out.println("Here");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("device", "iPhone Simulator");
			//cap.setCapability("takesScreenshot", true);
			cap.setCapability("version", "4.1.2");
			cap.setCapability("newCommandTimeout", settings.GetTimeOut());
			cap.setCapability("app", settings.GetBinaryPath());
		 
			 System.out.println(settings.GetURL());
			 
				//ConfigWebDriver.driver = new RemoteWebDriver(new URL(settings.GetURL()), cap);
			 
			 ConfigWebDriver.driver = new AppiumDriver(new URL(settings.GetURL()), cap);
			 
			 ConfigWebDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 
			 System.out.println("Driver " + ConfigWebDriver.driver.toString());
				Thread.sleep(1000);
				System.out.println("Server started");
		}
		catch(Exception excp)
		{
			System.out.println("Appium start failed : " + excp.toString());
		}
		
	}
	
	public void CleanUp() throws Exception
	{
		try
		{
			Thread.sleep(1000);
			ConfigWebDriver.driver.quit();
		}
		catch(Exception excp)
		{
			System.out.println("Cleanup error : " + excp.toString());
		}
	}
}
