package main.lib;

import java.util.List;

import main.systemobjects.ConfigWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageSource extends ControlUtility {
	
	public void tapElementByAttr(String attr, String attrValue) throws Exception
	{
		System.out.println(ConfigWebDriver.driver.getPageSource());
		List<WebElement> list = ConfigWebDriver.driver.findElements(By.name(""));
		System.out.println("Elements : " + list.size());
		if(list.size()==0)
		{
			throw new Exception();
		}
		for(int i=0; i<list.size(); i++)
		{
			WebElement el = list.get(i);
			System.out.println("attrs : " + el.getAttribute(attr));
			if(el.getAttribute(attr).equals(attrValue) && el.getTagName().contains("Button"))
			{
				System.out.println("If");
				Tap(el);
			}
			else
			{
				System.out.println("Else");
			}
		}
		
		return;
	}
	
	public void disConnect() throws InterruptedException
	{
		System.out.println(ConfigWebDriver.driver.getPageSource());
		List<WebElement> list = ConfigWebDriver.driver.findElements(By.name(""));
		System.out.println("Elements : " + list.size());
		for(int i=0; i<list.size(); i++)
		{
			WebElement el = list.get(i);
			System.out.println("attrs : " + el.getAttribute("hint"));
			if(el.getAttribute("hint").equals("Disconnect") && el.getTagName().contains("Button"))
			{
				System.out.println("If");
				Tap(el);
			}
			else
			{
				System.out.println("Else");
			}
		}
		return;
	}
	
	
}
