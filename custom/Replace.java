package custom;

import java.util.Properties;

public class Replace
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		if(commandParameters.length<3)
		{
			scriptParameters.put("Error", "Missing parameter in command. Usage: Replace Text From To");
			return false;
		}

		String text=commandParameters[0];
		String from=commandParameters[1];
		String to=commandParameters[2];
		String replaced=text.replace(from, to);
		scriptParameters.put("Replaced", replaced);
		return true;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/replace";
	}
}
