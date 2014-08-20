package main.lib;

@SuppressWarnings("serial")
public class ElementNotFoundException extends Exception
{
	private String message;
	public ElementNotFoundException(String message)
	{
		this.message = message;
	}
	public String toString()
	{ 
		return ("Element not found : "+message) ;
	}
}
