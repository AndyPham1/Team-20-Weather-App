/**Team 20**/

public class ShortTermForecastData{

private String[] forecastTimeList;
private float[] shortTermTemperature;
private int[] shortTermSkyConditionID;

public ShortTermForecastData(){
	forecastTimeList = null;
	shortTermTemperature = null;
	shortTermSkyConditionID = null;
}

public ShortTermForecastData update()
{
	return this;
}

/**change temperature**/
public void changeTemperature(String unit1, String unit2) throws NoDataFoundException
{	
	if(shortTermTemperature == null) throw new NoDataFoundException("No data");
	
	for(int i = 0; i < shortTermTemperature.length ; i++)
	{
			shortTermTemperature[i] = convertTemperature(unit1,unit2,shortTermTemperature[i]);
	}
}

/**converts temperature**/
private float convertTemperature(String unit1, String unit2, float temp)
{
	if(unit1.equals("kelvin") && unit2.equals("celsius"))
	{
		temp = (float) (temp - 273.15);
		return temp;
	}
	else if(unit1.equals("celsius") && unit2.equals("kelvin")) 
	{
		temp = (float) (temp + 273.15);
		return temp;
	}
	else if(unit1.equals("kelvin") && unit2.equals("fahrenheit")) 
	{
		temp = ((float) ((temp - 273.0)*(9.0/5.0) + 32.0));
		return temp;
	}
	else if(unit1.equals("fahrenheit") && unit2.equals("kelvin"))
	{
		temp =  (float) ((temp - 32.0)*(5.0/9.0) + 273.0);
		return temp;
	}
	else if(unit1.equals("fahrenheit") && unit2.equals("celsius"))
	{
		temp =(float) ((temp-32.0)*(5.0/9.0));
		return temp;
	}
	else
	{
		temp = (float)((9.0/5.0)*temp + 32.0);
		return temp;
	}
}

}
