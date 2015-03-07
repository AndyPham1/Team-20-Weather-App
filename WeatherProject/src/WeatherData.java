import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	//private int skyConditionID;
	//private double sunRise;
	//private double sunSet;
	private	double temperature;
	private double minTemp;
	private double maxTemp;
	private String lastUpdatedTime;
	private String currentCity;
	private String countryCode;
	private double sunrise;
	private double sunset;
	//private Unit currentUnit;

	/*
	 * Constructor for WeatherData class.
	 * Initializes the instance variables with the first fetch-data from the source 
	 */
	public WeatherData(String city, String countryCode){
		getWeather(city, countryCode);
		this.countryCode = countryCode;
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
	private void getWeather(String city, String countryCode)
	{
		String urlSkeleton = "http://api.openweathermap.org/data/2.5/weather?q=";
		String fullURL = urlSkeleton + city + "," + countryCode; 
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {
			WeatherVals myMainValues = mapper.readValue(new URL(fullURL), WeatherVals.class);
			//System.out.println(myMainValues.getMain().toString());
			//System.out.println(myMainValues.getWind().toString());
			temperature = myMainValues.getMain().getTemp();
			maxTemp = myMainValues.getMain().getTemp_max();
			minTemp = myMainValues.getMain().getTemp_min();
			humidity = myMainValues.getMain().getHumidity();
			airPressure = myMainValues.getMain().getPressure();
			windSpeed = myMainValues.getWind().getSpeed();
			windDirectionDegrees = myMainValues.getWind().getDeg();
			lastUpdatedTime = getTime();
			currentCity = myMainValues.getName();
			countryCode = myMainValues.getSys().getCountry();
			sunrise = myMainValues.getSys().getSunrise();
			sunset = myMainValues.getSys().getSunset();
			changeTemperatureUnits("kelvin", "celsius"); changeWind(); changePressure();
			
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println("Current Weather for [" + currentCity +"]");
			System.out.println("\nTemperature : " + df.format(temperature) + "\'C");
			System.out.println("MaxTemperature/MinTemperature: " + df.format(maxTemp) + "/" + df.format(minTemp) + "\'C");
			System.out.println("Humidity: " + df.format(humidity) + " %"); 
			System.out.println("Air Pressure: " + df.format(airPressure) + " kPa");
			System.out.println("Wind is at: " + df.format(windSpeed) + "km/h " + windDirectionString);
			System.out.println("\nLast updated : " + lastUpdatedTime);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
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
		WeatherData wd = new WeatherData("Toronto", "CA");
	}
	
	public double getWindSpeed() {
		return windSpeed;
	}

	public double getWindDirectionDegrees() {
		return windDirectionDegrees;
	}

	public String getWindDirectionString() {
		return windDirectionString;
	}

	public double getAirPressure() {
		return airPressure;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	
	public String getCurrrentCity() {
		return currentCity;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	public double getSunset() {
		return sunset;
	}
	
	public double getSunrise() {
		return sunrise;
	}
	
}

