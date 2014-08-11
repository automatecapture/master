package main.controls;

import java.util.List;
import main.lib.ControlUtility;
import main.systemobjects.ConfigWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ControlEvent extends ControlUtility{
	
	public enum ElementType
	{
		Button, StaticText, TextField, Switch
	}
	
	public enum ElementExists
	{
		Displayed, Enabled, Selected
	}
	
	private boolean ElementExists(String elementName, ElementExists exists, ElementType types)
	{
		boolean result = false;
		try
		{
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
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
	
	public boolean SwitchBtnExists(String elementName, ElementExists exists)
	{
		return ElementExists(elementName, exists, ElementType.Switch);
	}
	
	public boolean TapButton(String elementName)
	{
		try
		{
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
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
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
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
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(name));
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
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
			System.out.println(listOfElements.size());
			for(int i=0; i<listOfElements.size(); i++)
			{
				if( listOfElements.get(i).getTagName().contains(ElementType.StaticText.toString()))
				{
					return listOfElements.get(i).isDisplayed();
				}
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
			List<WebElement> listOfElements = ConfigWebDriver.driver.findElements(By.name(elementName));
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
	
	public boolean WriteTextField(String elementName, String text)
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
				if( listOfElements.get(i).getTagName().contains(ElementType.TextField.toString()))
				{
					TypeText(listOfElements.get(i), text);
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
	
	public void WaitFor(int second)
	{
		Delay(second * 1000);
	}
	
}
