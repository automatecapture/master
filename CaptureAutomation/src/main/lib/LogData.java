package main.lib;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Timestamp;

public class LogData {

	public static void Log(String message)
	{
		try
		{
	          File file = new File("LogFile.txt");
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          String timeStamp = GetTimeStamp();
	          output.write(timeStamp + " : " + message);
	          output.close();
	    }
		catch ( Exception e )
		{
	           e.printStackTrace();
	    }
	}

	private static String GetTimeStamp()
	{
		java.util.Date date= new java.util.Date();
		return new Timestamp(date.getTime()).toString();
	}
}
