package custom;

import java.util.Properties;

public class Add
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		int sum=0;
		for(String commandParameter:commandParameters)
		{
			try
			{
				int value=Integer.parseInt(commandParameter);
				sum+=value;
			}
			catch(NumberFormatException e)
			{
				scriptParameters.put("Error", "Provide integer values only");
				return false;
			}
		}
		scriptParameters.put("Response", ""+sum);
		return true;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/add";
	}
}
