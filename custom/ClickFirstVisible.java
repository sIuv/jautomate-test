package custom;

import jautomate.ScriptRunner;

import java.awt.image.BufferedImage;
import java.util.Properties;

public class ClickFirstVisible
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		ScriptRunner scriptRunner=new ScriptRunner();
		for(String commandParameter:commandParameters)
		{
			BufferedImage image=scriptRunner.loadImage(commandParameter);
			if(image!=null)
			{
				if(scriptRunner.mouseMove(image))
				{
					// Moved to that image
					scriptRunner.mouseLeftClick();
					return true;
				}
			}
			else
			{
				scriptParameters.put("Error", "Failed to load image");
				return false;
			}
		}
		// No image found
		return false;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/clickfirstvisible";
	}
}
