package main.lib;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import main.systemobjects.ConfigWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class ReadPageSource {
	
	public WebElement FindElementByHint(String pageSource, String hint) throws ParserConfigurationException, SAXException, IOException
	{
		
		List<WebElement> list = ConfigWebDriver.driver.findElements(By.name("UIAButton"));
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(pageSource);
		doc.getDocumentElement().normalize();
		
		NodeList nList = doc.getElementsByTagName("UIAButton");
		
		for (int temp = 0; temp < list.size(); temp++)
		{
			 
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			Element eElement = (Element) nNode;
			System.out.println("hint : " + eElement.getAttribute("hint"));
			if(hint==eElement.getAttribute("hint"))
			{
				
			}
		}
		
		return null;
	}

}
