/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */

public class WeatherData extends Unit{

	/* Instance Variables */
	//private double temperature;
	private double windSpeed;
	private double windDirection;
	private double airPressure;
	private double humidity;
	private int skyConditionID;
	//private double minTemp;
	//private double maxTemp;
	private double sunRise;
	private double sunSet;
	private	double temperature;
	private double minTemp;
	private double maxTemp;
	
	/*
	 * Constructor for WeatherData class.
	 * Initializes the instance variables with the first fetch-data from the source 
	 
	public WeatherData(){
		
	}*/
	
	/*
	 * this class returns a list of WeatherData elements that updates the data by fetching it from the source 
	 */
	public WeatherData update()
	{
		return this;
	}

	/* Methods */

	/**
	 * changeTemperature method changes the temperature
	 * @param fromUnit is the unit to be changed from, toUnit is the unit to change into 
	 */
	public void changeTemperatureUnit(String currentUnit, String newUnit)
	{
		Unit temp_1 = new Unit(temperature, currentUnit);
		Unit unit_Min = new Unit(minTemp, currentUnit);
		Unit unit_Max = new Unit(maxTemp, currentUnit);
		temp_1.changeUnits(newUnit);
		unit_Min.changeUnits(newUnit);
		unit_Max.changeUnits(newUnit);
		temperature = temp_1.temperature;
		minTemp = unit_Min.temperature;
		maxTemp = unit_Max.temperature;
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
	
	
	
}

