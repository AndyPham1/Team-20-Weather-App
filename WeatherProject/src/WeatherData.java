/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */

public class WeatherData{

	/* Instance Variables */
	private double temperature;
	private double windSpeed;
	private double windDirection;
	private double airPressure;
	private double humidity;
	private int skyConditionID;
	private double minTemp;
	private double maxTemp;
	private double sunRise;
	private double sunSet;
	private static final String KELVIN_UNIT = "kelvin";
	private static final String CELSIUS_UNIT = "celsius";
	private static final String FAHRENHEIT_UNIT = "fahrenheit";
	private static final double KELVIN_CONSTANT = 273.15;

	/* Constructor */
	public WeatherData update()
	{
		return this;
	}

	/* Methods */

	/**
	 * changeTemperature method changes the temperature
	 * @param fromUnit is the first unit, toUnit is the second unit
	 */
	public void changeTemperature(String fromUnit, String toUnit)
	{
		temperature = convertTemperature(fromUnit,toUnit,temperature);
		minTemp = convertTemperature(fromUnit,toUnit,minTemp);
		maxTemp = convertTemperature(fromUnit,toUnit,maxTemp);
	}
	
	/*================================================================================================================
	public static void main(String[] args)
	{
		String k = "kelvin";
		String c = "celsius";
		String f = "fahrenheit";
		double temp = 1;
		double newTemp = convertTemperature(k,c,temp);
		System.out.println("k -> c:\t" + newTemp);
		temp=1;
		newTemp = convertTemperature(c,k,temp);
		System.out.println("c -> k:\t" + newTemp);
		temp=1;
		newTemp = convertTemperature(k,f,temp);
		System.out.println("k -> f:\t" + newTemp);
		temp=1;
		newTemp = convertTemperature(f,k,temp);
		System.out.println("f -> k:\t" + newTemp);
		temp=1;
		newTemp = convertTemperature(f,c,temp);
		System.out.println("f -> c:\t" + newTemp);
		temp=1;
		newTemp = convertTemperature(c,f,temp);
		System.out.println("c -> f:\t" + newTemp);
		
	}
	================================================================================================================*/
	
	
	/**
	 * convertTemperature converts the temperature from celsius, kelvin or fahrenheit to its corresponding temperature
	 * @param fromUnit,toUnit,temp 
	 * @return temp the temperature that has been converted
	 */
	private static double convertTemperature(String fromUnit, String toUnit, double temp)
	{
		if(kelvinToCelsius(fromUnit, toUnit))
			temp=K_to_C(temp);
		else if(celsiusToKelvin(fromUnit, toUnit)) 
			temp=C_to_K(temp);
		else if(kelvinToFahrenheit(fromUnit, toUnit)) 
		{
			temp=K_to_C(temp);
			temp=C_to_F(temp);}
		else if(fahrenheitToKelvin(fromUnit, toUnit))
		{
			temp=F_to_C(temp);
			temp=C_to_K(temp);
		}
		else if(fahrenheitToCelsius(fromUnit, toUnit))
			temp=F_to_C(temp);
		else if(celsiusToFahrenheit(fromUnit, toUnit)) //celsiusToFahrenheit 
			temp=C_to_F(temp);
		
		return temp;
	}
	
	private static boolean kelvinToCelsius(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(KELVIN_UNIT) && toUnit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	private static double K_to_C(double temp)
	{
		temp = temp - KELVIN_CONSTANT;
		return temp;
	}
	private static boolean celsiusToKelvin(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(CELSIUS_UNIT) && toUnit.equals(KELVIN_UNIT)) 
			return true;
		else
			return false;
	}
	private static double C_to_K(double temp)
	{
		temp = temp + KELVIN_CONSTANT;
		return temp;
	}
	private static boolean kelvinToFahrenheit(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(KELVIN_UNIT) && toUnit.equals(FAHRENHEIT_UNIT)) 
			return true;
		else
			return false;
	}
	private static boolean fahrenheitToKelvin(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(FAHRENHEIT_UNIT) && toUnit.equals(KELVIN_UNIT))
			return true;
		else
			return false;
	}
	private static boolean fahrenheitToCelsius(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(FAHRENHEIT_UNIT) && toUnit.equals(CELSIUS_UNIT))
			return true;
		else
			return false;
	}
	private static double F_to_C(double temp)
	{
		temp = (temp - 32.0)/(9.0/5.0);
		return temp;
	}
	private static boolean celsiusToFahrenheit(String fromUnit, String toUnit)
	{
		if(fromUnit.equals(CELSIUS_UNIT) && toUnit.equals(FAHRENHEIT_UNIT))
			return true;
		else
			return false;
	}
	private static double C_to_F(double temp)
	{
		temp = temp * (9.0/5.0) + 32.0;
		return temp;
	}
}

