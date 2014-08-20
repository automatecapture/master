package main.lib;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;

public class ReadFromResources {
	
	private String platformConfigFile = "src/main/resources/PlatformConfiguration.xml";
	private String globalResourcesFile = "src/main/resources/GlobalResources.xml";
	private String stringResourcesFile = "src/main/resources/StringResources.xml";
	private String testDataFile = "src/main/resources/testData.xml";
	
	  public String getProperty( String propName)
	  {
		  System.out.println(propName);
	 
	    	Properties prop = new Properties();
	    	InputStream input = null;
	    	String propValue = "";
	    	try {
	 
	    		String filename = "globalxpath.properties";
	  
	    		
	    		//	input = getClass().getClassLoader().getResourceAsStream(filename);
	    		input =new FileInputStream("./resources/"+filename);
	   
	    		
	    		prop.load(input);
	   
	    		propValue = prop.getProperty(propName);
	    		 
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        } finally{
	        	if(input!=null){
	        		try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        	}
	        	
	        }
	    	return propValue;
	    }
	
	public String GetPlatformInfo(String nodeName)
	{
		String nodeText=new String();
		try
        {
            File fXmlFile = new File(platformConfigFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            Node mainNode = doc.getElementsByTagName("root").item(0);
            Element element = (Element) mainNode;
            nodeText = element.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        catch(Exception exp)
        {
            System.out.println("GetPlatformInfo" + exp.toString());
        }
		System.out.println("Node Text :GetPlatformInfo : " + nodeText);
        return nodeText;
	}
	
	public String GetNodeValue(String screenName, String nodeName, String filePath)
    {
		
        String nodeText=new String();
        try
        {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            
            Node mainNode = doc.getElementsByTagName(screenName).item(0);
            Element element = (Element) mainNode;
            nodeText = element.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        catch(Exception exp)
        {
            System.out.println("GetNodeValue" + exp.toString());
        }
        System.out.println("Node Text :GetNodeValue : " + nodeText);
        return nodeText;
    }
	
    public String GetNodeValue(String screenName, String nodeName)
    {
    	return GetNodeValue(screenName, nodeName, globalResourcesFile);
    }
    
    public String getString(String screenName, String nodeName)
    {
    	return GetNodeValue(screenName, nodeName, stringResourcesFile);
    }
    
    public String getTestData(String screenName, String nodeName)
    {
    	return GetNodeValue(screenName, nodeName, testDataFile);
    }
    
    public String getDefaultConnectionURL(boolean isUnsecure)
    {
    	String prefix = (isUnsecure==true) ? "http" : "https";
    	String protocal = getTestData("url", "ip");
    	String port = (isUnsecure==true) ? getTestData("url","httpPort") : getTestData("url","httpsPort");
    	String suffix = getTestData("url","suffix");
    	return String.format("{0}://{1}:{2}/{3}", prefix, protocal, port, suffix);
    }
    
}
