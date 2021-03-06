package main.controls;

//import java.util.HashMap;
import java.util.List;

import main.lib.ControlUtility;
import main.lib.ElementNotFoundException;
import main.systemobjects.ConfigWebDriver;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//import io.appium.java_client.*;

public class ControlEvent extends ControlUtility{
	
	public enum ElementType
	{
		Button, StaticText, TextField, Switch, TableCell
	}
	
	public enum ElementExists
	{
		Displayed, Enabled, Selected
	}
	
	private void CheckForNoElementException(int elementNumber, String elementInfo) throws ElementNotFoundException
	{
		if(elementNumber<1)
		{
			throw new ElementNotFoundException(elementInfo);
		}
	}
	
	private List<WebElement> FindMobileElements(String elementName) throws ElementNotFoundException
	{
		List<WebElement> listOfElements = null;
		for(int i=0; i<5; i++)
		{
			listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
			CheckForNoElementException(listOfElements.size(), elementName);
			if(listOfElements.size()>0)
			{
				break;
			}
			WaitFor(1);
		}
		return listOfElements;
	}

	private boolean ElementExists(String elementName, ElementExists exists, ElementType types) throws ElementNotFoundException
	{
		boolean result = false;
			List<WebElement> listOfElements = FindMobileElements(elementName);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(types.toString()))
				{
					switch(exists)
					{
					case Displayed: result = listOfElements.get(i).isDisplayed();
						break;
					case Enabled: result = listOfElements.get(i).isEnabled();
						break;
					case Selected: result = listOfElements.get(i).isSelected();
						break;
					}
					break;
				}
			}
		
		return result;
	}
	
	public boolean LableExists(String elementName, ElementExists exists) throws ElementNotFoundException
	{
		return ElementExists(elementName, exists, ElementType.StaticText);
	}
	
	public boolean ButtonExists(String elementName, ElementExists exists) throws ElementNotFoundException
	{
		return ElementExists(elementName, exists, ElementType.Button);
	}
	
	public boolean TextFieldExists(String elementName, ElementExists exists) throws ElementNotFoundException
	{
		return ElementExists(elementName, exists, ElementType.TextField);
	}
	
	public String SwitchBtnExists(String xpath) throws ElementNotFoundException
	{
		String val = "0";

			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.xpath(xpath));
			CheckForNoElementException(listOfElements.size(),xpath);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.Switch.toString()))
				{
					val = listOfElements.get(i).getAttribute("value");
					break;
				}
			}

		return val;
	}
	
	public boolean TapSwitch(String xpath) throws ElementNotFoundException, InterruptedException
	{

			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.xpath(xpath));
			CheckForNoElementException(listOfElements.size(),xpath);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.Switch.toString()))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}

		return true;
	}
	
	public boolean TapTableCell(String elementName) throws ElementNotFoundException, InterruptedException
	{
			List<WebElement> listOfElements = FindMobileElements(elementName);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.TableCell.toString()))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}
		WaitFor(4);
		return true;
	}
	
	public boolean TapButton(String elementName) throws ElementNotFoundException, InterruptedException
	{
			List<WebElement> listOfElements = FindMobileElements(elementName);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.Button.toString()))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}

		WaitFor(4);
		return true;
	}
	
	public boolean TapLable(String elementName) throws ElementNotFoundException, InterruptedException
	{

			WaitFor(2);
			List<WebElement> listOfElements = FindMobileElements(elementName);
			System.out.println(listOfElements.size());
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.StaticText.toString()))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}

		return true;
	}
	
	public boolean TapRightContext(String name) throws ElementNotFoundException, InterruptedException
	{

			List<WebElement> listOfElements = FindMobileElements(name);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains("UIAElement"))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}

		return true;
	}
	
	public boolean ReadLableText(String elementName) throws ElementNotFoundException, InterruptedException
	{

			System.out.println(elementName);
			List<WebElement> listOfElements = FindMobileElements(elementName);
			System.out.println(listOfElements.size());
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.StaticText.toString()))
				{
					return listOfElements.get(i).isDisplayed();
				}
				WaitFor(1);
			}

		return false;
	}
	
	public String ReadTextField(String elementName) throws ElementNotFoundException
	{
		String text = null;

			List<WebElement> listOfElements = FindMobileElements(elementName);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.TextField.toString()))
				{
					text = listOfElements.get(i).getText();
					break;
				}
			}

		return text;
	}
	
	public boolean WriteTextField(String elementName, String text, boolean shouldClear) throws ElementNotFoundException, InterruptedException
	{

			System.out.println(ElementType.TextField.toString());
			List<WebElement> listOfElements = null ;
			int listSize = 0;
			for(int j=0; j<5; j++)
			{
				listOfElements = ConfigWebDriver.driver.findElements(By.id(elementName));
				listSize = listOfElements.size();
				System.out.println(listSize);
				if(listSize>0)
					break;
				WaitFor(1);
			}
			
			CheckForNoElementException(listSize, elementName);
			
			for(int i=0; i<listSize; i++)
			{
				WebElement el = listOfElements.get(i);
				if( el.getTagName().contains(ElementType.TextField.toString()))
				{
					TypeText(listOfElements.get(i), text, shouldClear);
					TapOnDoneKey();
					return true;
				}
			}

		return false;
	}
	
	public boolean WriteTextField(String elementName, String text) throws ElementNotFoundException, InterruptedException
	{
		return WriteTextField(elementName, text, true);
	}
	
	public void TapOnDoneKey() throws ElementNotFoundException, InterruptedException
	{
		System.out.println("TapOnDoneKey");

		//ConfigWebDriver.driver.getKeyboard().pressKey("Done");
		// ((JavascriptExecutor)ConfigWebDriver.driver).executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 294.0); put("y", 328.0); }});
		TapButton("Done");
	}
	
	public void WaitFor(int second)
	{
		Delay(second * 1000);
	}
	
}
