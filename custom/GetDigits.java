package custom;

import java.util.Properties;

public class GetDigits
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		if(commandParameters.length<1)
		{
			scriptParameters.put("Error", "Missing parameter in command. Usage: GetDigits CharsAndDigits");
			return false;
		}

		String text=commandParameters[0];
		String digits="";
		for(int i=0; i<text.length(); i++)
		{
			char c=text.charAt(i);
			if(Character.isDigit(c))
			{
				digits+=c;
			}
		}
		scriptParameters.put("Digits", digits);
		return true;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/getdigits";
	}
}
