package weather;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.gson.*;

/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */

public class WeatherData {

	/* Instance Variables */
	private double windSpeed;
	private double windDirectionDegrees;
	private String windDirectionString; 
	private double airPressure;
	private double humidity;
	private	double temperature;
	private double minTemp;
	private double maxTemp;
	private String lastUpdatedTime;
	private String currentCity;
	private String countryCode;
	private String sunrise;
	private String sunset;
	private WeatherValue wv; 
	
	/*
	 * Constructor for WeatherData class.
	 * Initializes the instance variables with the first fetch-data from the source 
	 */
	public WeatherData(String city, String countryCode){
		getWeather(city, countryCode);
		this.countryCode = countryCode;
	}
	
	/* Methods */
	
	/**
	 * update will return a list of WeatherData elements that updates the data by fetching it from the source 
	 * @return WeatherData 
	 */
	public WeatherData update() throws IOException
	{
		return this;
	}

	/**
	 * getWeather opens up the OpenWeatherMap API and retrieves given information that we wish to acquire
	 * @param city the city, countryCode the country code as a string
	 */
	private void getWeather(String city, String countryCode)
	{

		String urlSkeleton = "http://api.openweathermap.org/data/2.5/weather?q=";
		String fullURL = urlSkeleton + city + "," + countryCode; 
		try {
			String jsonData = readUrl(fullURL);
			Gson gson = new Gson();
			wv = gson.fromJson(jsonData, WeatherValue.class);
			
			//DecimalFormat df = new DecimalFormat("#");	//change to 1 decimal 

			setTemperature(wv.getMain().getTemp());
			setMaxTemp(wv.getMain().getTemp_max());
			setMinTemp(wv.getMain().getTemp_min());
			setHumidity(wv.getMain().getHumidity());
			setAirPressure(wv.getMain().getPressure());
			setWindSpeed(wv.getWind().getSpeed());
			setWindDirectionDegrees(wv.getWind().getDeg());
			setCurrentCity(wv.getName());
			setCountryCode(wv.getSys().getCountry());
			setSunrise(wv.getSys().getSunrise());
			setSunset(wv.getSys().getSunset());
			
			setLastUpdatedTime(getTime());

			changeTemperatureUnits("kelvin", "celsius"); changeWind(); changePressure(); changeSun();
			/*
			DecimalFormat df = new DecimalFormat("#.##");
			System.out.println("Current Weather for [" + currentCity +"]");
			System.out.println("\nTemperature : " + df.format(temperature) + "\'C");
			System.out.println("MaxTemperature/MinTemperature: " + df.format(maxTemp) + "/" + df.format(minTemp) + "\'C");
			System.out.println("Humidity: " + df.format(humidity) + " %"); 
			System.out.println("Air Pressure: " + df.format(airPressure) + " kPa");
			System.out.println("Wind is at: " + df.format(windSpeed) + "km/h " + windDirectionString);
			System.out.println("\nLast updated : " + lastUpdatedTime);
			*/
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Helper method to read the URL as a String and make a request to the server to read the contents of the page
	 * @param urlString is the String that links to the json file
	 * @return String 
	 */
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
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
	 * @return String return the timeString
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

	/**
	 * changePressure is a simple method to change from hPA to kPA
	 */
	private void changePressure()
	{
		this.airPressure /= 10;
	}
	
	/**
	 * changeSun changes the sunrise and sunset 
	 */
	private void changeSun()
	{
		String sunriseDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date ((Long.parseLong(sunrise) *1000)));
		String sunsetDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date ((Long.parseLong(sunset)*1000)));
		int length = sunriseDate.length();
		sunriseDate = sunriseDate.substring(length - 9, length-3).toString();
		sunsetDate = sunsetDate.substring(length - 9, length-3).toString();
		StringBuilder sbSunrise = new StringBuilder(sunriseDate);
		StringBuilder sbSunset = new StringBuilder(sunsetDate);
		sunrise = sbSunrise.toString();
		sunset = sbSunset.toString();
	}
	
	/*
	public static void main(String[] args)
	{
		WeatherData wd = new WeatherData("Toronto", "CA");
	}
	*/
	
	
	
	/***********************************************************************************************
	 * 
	 * ***********************************GETTERS AND SETTERS****************************************
	 * 
	 ************************************************************************************************/
	
	
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

	public String getCurrentCity() {
		return currentCity;
	}

	public String getCountryCode() {
		return countryCode;
	}
	
	public String getSunset() {
		return sunset;
	}
	
	public String getSunrise() {
		return sunrise;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public void setWindDirectionDegrees(double windDirectionDegrees) {
		this.windDirectionDegrees = windDirectionDegrees;
	}

	public void setWindDirectionString(String windDirectionString) {
		this.windDirectionString = windDirectionString;
	}

	public void setAirPressure(double airPressure) {
		this.airPressure = airPressure;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
}

