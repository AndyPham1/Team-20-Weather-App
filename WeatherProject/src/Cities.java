
/**
 * Cities class
 * @author Team 20
 */

public class Cities {

/* Instance Variables */
//Probably change the data structure later as improvement are made.
private CityData[] cityCollection;
private float updateTime;

/* Constructor */
public Cities(CityData[] cityCollection) {
	cityCollection = null;
}

/* Methods */

/**
 * getUpdateTime 
 * @return updateTime
 */
public float getUpdateTime() throws NoDataFoundException
{
	if(updateTime == 0) throw new NoDataFoundException("No previous update");
	return updateTime;
}

/**
 * addCity
 */
public Boolean addCity(CityData city) throws NoCityFoundException
{   
	Boolean check = false;
	
	if (city == null) {
		throw new NoCityFoundException("No City Entered");
	}
	
	for (int i = 0; i < cityCollection.length; i++){
		if (cityCollection[i] == null){
			cityCollection[i] = city;
			check = true;
			break;
		}
	}
	
	return check;
}

/**
 * addCityinBoxRegion 
 */
public void addCityinBoxRegion() throws NoCityFoundException
{
	
}

/**
 * addCityinCircleRegion
 * 
 */
public void addCityinCircleRegion() throws NoCityFoundException
{
	
}

/** 
 * changeCity 
 * @return CityData
 */
public CityData changeCity() throws NoCityFoundException
{
	
}

/** 
 * removeCity method removes the current city
 * @param newCityCollection 
 * 
 */
public void removeCity(String cityName) throws NoCityFoundException
{
		for (int i=0; i<cityCollection.length; i++) {
			if (cityCollection[i].getCityName().equals(cityName)) {   
				cityCollection[i]=null;
			}
			if (i == cityCollection.length-1) {
				throw new NoCityFoundException("The city was not found");
			}
		} 
	
}

/**
 * removeAll removes all the cities
 */
public void removeAll()
{
	for (int i = 0; i < cityCollection.length; i++){
		cityCollection[i] = null;
	}
}

}
