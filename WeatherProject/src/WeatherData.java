import java.io.IOException;
import java.text.DecimalFormat;
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
	private double windDirectionDegrees;
	private String windDirectionString; 
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
	private Unit currentUnit;
	
	/*
	 * Constructor for WeatherData class.
	 * Initializes the instance variables with the first fetch-data from the source 
	 */
	public WeatherData(){
		getWeather();
	}
	
	/*
	 * this class returns a list of WeatherData elements that updates the data by fetching it from the source 
	 */
	public WeatherData update() throws IOException
	{
		return this;
	}
	
	/* ===========================================METHODS===================================================*/

	/**
	 * getWeather opens up the OpenWeatherMap API and retrieves given information that we wish to acquire
	 */
	private void getWeather()
	{
		try {
			OpenWeatherMap owm = new OpenWeatherMap("");
			//CurrentWeather cwd = owm.currentWeatherByCityName("London");//to methods of currentWeatherByCityName, one is with Country, one without, London, ON 
			//needs to be specified with Canada because default is the London in Great Britain  
			CurrentWeather cwd = owm.currentWeatherByCityName("London", "CA"); 
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
	            	
	            	//retrieving specs 
	            	
	            	this.temperature = cwd.getMainInstance().getTemperature();   
	            	currentUnit = new Unit(this.temperature, "fahrenheit");
	            	this.maxTemp = cwd.getMainInstance().getMaxTemperature();
	            	this.minTemp = cwd.getMainInstance().getMinTemperature();
	                this.airPressure = cwd.getMainInstance().getPressure();
	                this.humidity = cwd.getMainInstance().getHumidity();
	                this.windSpeed = cwd.getWindInstance().getWindSpeed();
	                this.windDirectionDegrees = cwd.getWindInstance().getWindDegree();
	                this.lastUpdatedTime = cwd.getDateTime().toGMTString();

	                //changes to specs 
	            	changeTemperatureUnits("fahrenheit", "celsius"); changeWind(); changePressure();
	                
	                // printing specs
	                DecimalFormat df = new DecimalFormat("#.##");
	                System.out.println("Current Temperature is : " + df.format(temperature) + "\'C");
	                System.out.println("MaxTemperature/MinTemperature: " + df.format(maxTemp) + "/" + df.format(minTemp) + "\'C");
	                System.out.println("Humidity: " + df.format(humidity) + " %"); 
	                System.out.println("Air Pressure: " + df.format(airPressure) + " kPa");
	                System.out.println("Wind is at: " + df.format(windSpeed) + "km/h " + windDirectionString);
	                System.out.println("\nLast updated : " + lastUpdatedTime);
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
	
	/**
	 * getTime retrieves the current time and then parsed into just the hour and minute
	 */
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
	
	/**
	 * changeWind is a simple method to change from degrees format (given by the fetch) to a string
	 */
	private void changeWind()
	{
		final double ANGLE_CHANGE_DEGREE = 22.5; 
		String[] cardinalWind = {"N","NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
		
		int wind = (int) ((windDirectionDegrees + 11.25)/ANGLE_CHANGE_DEGREE);
		windDirectionString = cardinalWind[wind%16];
	}
	
	/*
	 * changePressure is a simple method to change from hPA to kPA
	 */
	private void changePressure()
	{
		this.airPressure /= 10;
	}
	public static void main(String[] args)
	{
		WeatherData wd = new WeatherData();
	}
}

