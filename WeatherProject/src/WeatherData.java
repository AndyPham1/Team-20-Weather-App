import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.CurrentWeather.Wind;
import net.aksingh.owmjapis.OpenWeatherMap;

/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */

public class WeatherData {

	/* Instance Variables */
	//private double temperature;
	private double windSpeed;
	private double windDegree;
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
	private String lastUpdatedTime;
	
	/*
	 * Constructor for WeatherData class.
	 * Initializes the instance variables with the first fetch-data from the source 
	 */
	public WeatherData(){
		this.lastUpdatedTime = getTime();
		getWeather();
	}
	
	/*
	 * this class returns a list of WeatherData elements that updates the data by fetching it from the source 
	 */
	public WeatherData update() throws IOException
	{
		return this;
	}
	
	private void getWeather()
	{
		try {
			OpenWeatherMap owm = new OpenWeatherMap("");

			CurrentWeather cwd = owm.currentWeatherByCityName("London");
			if (cwd.isValid()) {

	            // checking if city name is available
				
	            if (cwd.hasCityName()) {
	                //printing city name from the retrieved data
	                System.out.println("City: " + cwd.getCityName());
	            }

	            // checking if max. temp. and min. temp. is available
	            if (cwd.getMainInstance().hasMaxTemperature() && cwd.getMainInstance().hasMinTemperature()
	            		&&  cwd.getMainInstance().hasPressure() && cwd.getMainInstance().hasHumidity() 
	            		&& cwd.getMainInstance().hasTemperature() && cwd.getWindInstance().hasWindSpeed()
	            		&& cwd.getWindInstance().hasWindDegree()) {
	                // printing the max./min. temperature
	            	this.maxTemp = cwd.getMainInstance().getMaxTemperature();
	            	this.minTemp = cwd.getMainInstance().getMinTemperature();
	                System.out.println("Temperature: " + maxTemp + "/" + minTemp + "\'F");
	                
	                this.airPressure = cwd.getMainInstance().getPressure();
	                this.humidity = cwd.getMainInstance().getHumidity();
	                this.temperature = cwd.getMainInstance().getTemperature();
	                System.out.println("Current Temperature is : " + temperature);
	                System.out.println("Humidity: " + humidity +"\nAir Pressure: " + airPressure);
	                
	                this.windSpeed = cwd.getWindInstance().getWindSpeed();
	                this.windDegree = cwd.getWindInstance().getWindDegree();
	                System.out.println("Wind is at: " + windSpeed + "km/h\nWind Degree at: " + windDegree);
	                
	            }
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* Methods */

	/**
	 * changeTemperature method changes the temperature
	 * @param fromUnit is the unit to be changed from, toUnit is the unit to change into 
	 */
	public void changeTemperatureUnits(String currentUnit, String newUnit)
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
	private String getTime()
	{
		this.lastUpdatedTime = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		String timeString="";
		char[] timeArray = this.lastUpdatedTime.toCharArray();
		String hour = ""+timeArray[0]+timeArray[1];
		String minute = ""+timeArray[2]+timeArray[2];
		timeString = hour + ":" + minute;
		return timeString;
	}
	public static void main(String[] args)
	{
		WeatherData wd = new WeatherData();
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

