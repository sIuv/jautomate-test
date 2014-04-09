package custom;

import jautomate.CSVReader;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class CompareData
{
	public Boolean executeCommand(String[] commandParameters, Properties scriptParameters)
	{
		if(commandParameters.length<2)
		{
			scriptParameters.put("Error", "Missing parameter in command. Usage: CompareData FilePath1 FilePath2");
			return false;
		}

		String filename1=commandParameters[0];
		String filename2=commandParameters[1];
		CSVReader csvReader1;
		CSVReader csvReader2;
		try
		{
			csvReader1 = new CSVReader(filename1);
			csvReader2 = new CSVReader(filename2);
		}
		catch (IOException e)
		{
			return false;
		}
		Properties csvParameters1=null;
		Properties csvParameters2=null;
		int lineNo=0;
		while (csvReader1.hasNext() || csvReader2.hasNext())
		{
			lineNo++;
			try
			{
				if (csvReader1.hasNext() && csvReader2.hasNext())
				{
					csvParameters1 = csvReader1.next();
					csvParameters2 = csvReader2.next();
					if(!propertiesEquals(csvParameters1, csvParameters2))
					{
						scriptParameters.put("Error", "Difference found in line: "+lineNo);
						return false;
					}
				}
				else
				{
					// One of the files is shorter
					scriptParameters.put("Error", "Data files are not of equal size");
					return false;
				}
			}
			catch (Exception ex)
			{
				return false;
			}
		}
		return true;
	}

	private boolean propertiesEquals(Properties properties1, Properties properties2)
	{
		for (Enumeration propertyNames = properties1.propertyNames(); propertyNames.hasMoreElements();)
		{
			String key = (String)propertyNames.nextElement();
			if(!properties2.containsKey(key))
			{
				// Does not exist
				return false;
			}
			else
			{
				String oldValue=properties2.getProperty(key, "");
				String newValue=properties1.getProperty(key, "");
				if(!oldValue.equals(newValue))
				{
					// Value is different
					return false;
				}
			}
		}
		return true;
	}
	
	public String getHelp()
	{
		return "http://jautomate.com/2014/03/03/comparedata";
	}
}

