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
public void addCity() throws NoCityFoundException
{ 
	
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
 * 
 */
public void removeCity() throws NoCityFoundException
{
	
}

/**
 * removeAll removes all the cities
 */
public void removeAll()
{
	cityCollection = null;
}

}
