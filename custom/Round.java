package custom;

import java.util.Properties;

public class Round
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		if(commandParameters.length<2)
		{
			scriptParameters.put("Error", "Missing parameter in command. Usage: Round Value NoDecimals");
			return false;
		}

		String param=commandParameters[0];
		String noDecimals=commandParameters[1];
		String result=String.format("%."+noDecimals+"f", Double.parseDouble(param));
		String replaced=result.replace(',', '.');
		scriptParameters.put("Result", replaced);
		return true;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/round";
	}
}
