/**Team 20**/

public class WeatherData{
	
private float temperature;
private float windSpeed;
private float windDirection;
private float airPressure;
private float humidity;
private int skyConditionID;
private float minTemp;
private float maxTemp;
private float sunRise;
private float sunSet;

public WeatherData update()
{
	return this;
}

/**change temperature**/
public void changeTemperature(String unit1, String unit2)
{
	temperature = convertTemperature(unit1,unit2,temperature);
	minTemp = convertTemperature(unit1,unit2,minTemp);
	maxTemp = convertTemperature(unit1,unit2,maxTemp);
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

