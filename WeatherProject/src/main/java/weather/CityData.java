package main.java.weather;
/**
 * City Data class to store information of the different cities entered by the user
 * @author Team 20
 */

public class CityData{

	/* Instance Variables */
	private String cityName;
	private int cityID;
	private String countryCode;
	private float longitude;
	private float latitude;
	private float updateTime;

	/* Constructor */
	public CityData (String cityName){
		this.cityName = cityName;
	}

	/*Getters*/

	/**
	 * getCityName gets the city name that the user had entered
	 * @return cityName
	 */

	public String getCityName()
	{
		return cityName;
	}

	/**
	 * getCityID gets the ID of the city
	 * @return cityID
	 */
	public int getCityID()
	{
		return cityID;
	}

	/**
	 * getCountryCode gets the country code
	 * @return countryCode
	 */
	public String getCountryCode()
	{
		return countryCode;
	}

	/**
	 * getLongitude gets the Longitude
	 * @return longitude
	 */
	public float getLongitude()
	{
		return longitude;
	}

	/**
	 * getLatitude gets the latitude
	 * @return latitude
	 */
	public float getLatitude()
	{
		return latitude;
	}

	/**
	 * update method updates the city Data with the new data
	 * @return CityData 
	 */
	public CityData update()
	{
		return this;
	}

	/**
	 * getUpdateTime gets the updated time
	 * @return updateTime
	 */
	public float getUpdateTime() throws NoDataFoundException
	{
		if (updateTime == 0) throw new NoDataFoundException("no previous update");
		return updateTime;
	}
}

