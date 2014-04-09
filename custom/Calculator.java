package custom;

import java.util.Properties;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculator
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		if(commandParameters.length<1)
		{
			scriptParameters.put("Error", "Missing parameter in command. Usage: Calculator Expression");
			return false;
		}
		try
		{
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			String foo = commandParameters[0];
			String res = (engine.eval("("+foo+").toString()")).toString();
			scriptParameters.put("CalculatorResult", res);
			return true;
		}
		catch (Exception e)
		{
			scriptParameters.put("Error", "Failed to evaluate expression");
		}
		return false;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/calculator";
	}
}
