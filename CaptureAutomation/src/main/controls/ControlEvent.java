package main.controls;

//import java.util.HashMap;
import java.util.List;

import main.lib.ControlUtility;
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
	
	private List<WebElement> FindMobileElements(String elementName)
	{
		List<WebElement> listOfElements = null;
		for(int i=0; i<5; i++)
		{
			listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
			if(listOfElements.size()>0)
			{
				break;
			}
			WaitFor(1);
		}
		return listOfElements;
	}
	
	private boolean ElementExists(String elementName, ElementExists exists, ElementType types)
	{
		boolean result = false;
		try
		{
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return result;
	}
	
	public boolean LableExists(String elementName, ElementExists exists)
	{
		return ElementExists(elementName, exists, ElementType.StaticText);
	}
	
	public boolean ButtonExists(String elementName, ElementExists exists)
	{
		return ElementExists(elementName, exists, ElementType.Button);
	}
	
	public boolean TextFieldExists(String elementName, ElementExists exists)
	{
		return ElementExists(elementName, exists, ElementType.TextField);
	}
	
	public String SwitchBtnExists(String xpath)
	{
		String val = "0";
		try
		{
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.xpath(xpath));
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.Switch.toString()))
				{
					val = listOfElements.get(i).getAttribute("value");
					break;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return val;
	}
	
	public boolean TapSwitch(String xpath)
	{
		try
		{
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.xpath(xpath));
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.Switch.toString()))
				{
					Tap(listOfElements.get(i));
					break;
				}
				WaitFor(1);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return false;
		}
		return true;
	}
	
	public boolean TapTableCell(String elementName)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return false;
		}
		WaitFor(4);
		return true;
	}
	
	public boolean TapButton(String elementName)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return false;
		}
		WaitFor(4);
		return true;
	}
	
	public boolean TapLable(String elementName)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return false;
		}
		return true;
	}
	
	public boolean TapRightContext(String name)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
			return false;
		}
		return true;
	}
	
	public boolean ReadLableText(String elementName)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public String ReadTextField(String elementName)
	{
		String text = null;
		try
		{
			List<WebElement> listOfElements = FindMobileElements(elementName);
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.TextField.toString()))
				{
					text = listOfElements.get(i).getText();
					break;
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return text;
	}
	
	public boolean WriteTextField(String elementName, String text, boolean shouldClear)
	{
		try
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
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		return false;
	}
	
	public boolean WriteTextField(String elementName, String text)
	{
		return WriteTextField(elementName, text, true);
	}
	
	public void TapOnDoneKey()
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
