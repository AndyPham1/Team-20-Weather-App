/**Team 20**/

public class Cities {

//Probably change the data structure later as improvement are made.
private CityData[] cityCollection;
private float updateTime;

public float getUpdateTime() throws NoDataFoundException
{
	if(updateTime == 0) throw new NoDataFoundException("No previous update");
	return updateTime;
}

public void addCity() throws NoCityFoundException
{ 
	
}

public void addCityinBoxRegion() throws NoCityFoundException
{
	
}

public void addCityinCircleRegion() throws NoCityFoundException
{
	
}

public CityData changeCity() throws NoCityFoundException
{
	
}

public void removeCity() throws NoCityFoundException
{
	
}

public void removeAll()
{
	cityCollection = null;
}

}
