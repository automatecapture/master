package main.lib;

import main.systemobjects.ConfigWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ControlUtility
{
	protected WebElement FindElementByXPath(String xPath) throws InterruptedException
	{
		WebElement element = null;
		System.out.println("XPath : " + xPath);
		for(int i=0; i<5; i++)
		{
			try
			{
				element = ConfigWebDriver.driver.findElement(By.xpath(xPath));
				if(element.isEnabled()==false)
				{
					Delay(1000);
					continue;
				}
			}
			catch (Exception ex)
			{
				System.out.println("FindElementByXPath " + ex.toString());
				Thread.sleep(1000);
			}
		}
		return element;
	}
	

	protected void Tap(WebElement element) throws InterruptedException
	{
		for(int i=0; i<5; i++)
		{
			try
			{
				element.click();
				return;
			}
			catch (Exception ex)
			{
				System.out.println("Tap: " + ex.toString());
				Delay(1000);
			}
		}
	}
	
	protected void ClearTextField(WebElement element)
	{
		element.click();
		Delay(1);
		String text = element.getText();
		System.out.println(text.length());
		for(int i=0; i<text.length()+1; i++)
		{
			try
			{
				element.sendKeys("\b");
			}
			catch (Exception ex)
			{
				System.out.println("TypeText: " + ex.toString());
				Delay(1000);
			}
		}
	}
	
	protected void TypeText(WebElement element, String text, boolean shouldClear)
	{
		for(int i=0; i<5; i++)
		{
			try
			{
				if(shouldClear)
				{
					ClearTextField(element);
				}
				element.click();
				element.sendKeys(text);
				return;
			}
			catch (Exception ex)
			{
				System.out.println("TypeText: " + ex.toString());
				Delay(1000);
			}
		}
	}
	
	protected void Delay(int milisec)
	{
		try
		{
			Thread.sleep(milisec);
		}
		catch(Exception excp)
		{
			System.out.print(excp.toString());
		}
	}
}
