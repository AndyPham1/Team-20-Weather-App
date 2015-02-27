/**Team 20**/

public class CityData{

String cityName;
int cityID;
String countryCode;
float longitude;
float latitude;
float updateTime;

/**getters**/
public String getCityName()
{
	return cityName;
}

public int getCityID()
{
	return cityID;
}

public float getCountryCode()
{
	return longitude;
}

public float getLonfitutde()
{
	return longitude;
}

public float getLatitude()
{
	return latitude;
}

public CityData update()
{
	return this;
}

public float getUpdateTime() throws NoDataFoundException
{
	if (updateTime == 0) throw new NoDataFoundException("no previous update");
	return updateTime;
}
}

