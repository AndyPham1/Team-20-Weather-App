package weather;
/**
 * About WeatherData: WeatherData accesses the OpenWeatherMap API server based on the link it provides. The basic construct
 * of the URL is already defined and the changes needed to access the different cities/countries can be manipulated based
 * on the reference value from WeatherFrame (or user directed). By retrieval of the first city, the coordinates are saved
 * into the CurrentWeather class defined within this class and are then used to access the short term and long term weather data.
 * <p/>
 * How-to: Please refer to the Main method to see how to get the data for each attribute.
 */

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * WeatherData class contains the weather data 
 * @author Team 20
 */

public class WeatherData {

    public CurrentWeather currentWeather = new CurrentWeather(); // Initialized to keep current units
    public ShortTermWeather[] shortTermWeather;
    public LongTermWeather[] longTermWeather;
    public MarsWeather mw;
    private WeatherValue wv;
    private ShortTermWeatherValue st;
    private LongTermWeatherValue lt;
    public MarsWeatherValue marsWeather;
    private Boolean unitFlag = false;


    public class CurrentWeather {
        /* Instance Variables */
        private double windSpeed;
        private double windDirectionDegrees;
        private String windDirectionString;
        private double airPressure;
        private double humidity;
        private double temperature;
        private double minTemp;
        private double maxTemp;
        private String lastUpdatedTime;
        private String currentCity;
        private String countryCode;
        private String sunrise;
        private String sunset;
        private String description;
        private String icon;
        private String unit;

        /**
         * changeWind is a simple method to change from degrees format (given by the fetch) to a string
         */
        private void changeWind() {
            final double ANGLE_CHANGE_DEGREE = 22.5;
            String[] cardinalWind = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};

            int wind = (int) ((currentWeather.windDirectionDegrees + 11.25) / ANGLE_CHANGE_DEGREE);
            currentWeather.windDirectionString = cardinalWind[wind % 16];
        }

        /**
         * changePressure is a simple method to change from hPA to kPA
         */
        private void changePressure() {
            currentWeather.airPressure /= 10;
        }

        /**
         * changeSun changes the sunrise and sunset
         */
        private void changeSun() {
            String sunriseDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date((Long.parseLong(currentWeather.sunrise) * 1000)));
            String sunsetDate = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date((Long.parseLong(currentWeather.sunset) * 1000)));
            int length = sunriseDate.length();
            sunriseDate = sunriseDate.substring(length - 9, length - 3).toString();
            sunsetDate = sunsetDate.substring(length - 9, length - 3).toString();
            StringBuilder sbSunrise = new StringBuilder(sunriseDate);
            StringBuilder sbSunset = new StringBuilder(sunsetDate);
            currentWeather.sunrise = sbSunrise.toString();
            currentWeather.sunset = sbSunset.toString();
        }

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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }

        public void setUnits(String unit) {
            this.unit = unit;
        }

        public String getUnits() {
            return unit;
        }
    }

    public class ShortTermWeather {
        private double temperature;
        private String condition;
        private String icon;
        private String unit;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    public class LongTermWeather {
        private double temperature, min, max;
        private String condition;
        private String icon;
        private String unit;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIcon() {
            return icon;
        }
    }

    public class MarsWeatherValue {
        public float temperatureMax;
        public float temperatureMin;
        public float airpressure;
        public String humidity;
        public String windSpeed;
        public String windDirection;
        public String skyCondition;
        private String unit;

        public String getWindSpeed() {
            return windSpeed;
        }

        public float getTemperatureMax() {
            return temperatureMax;
        }

        public float getAirpressure() {
            return airpressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public float getTemperatureMin() {
            return temperatureMin;
        }

        public void setTemperatureMin(float temperatureMin) {
            this.temperatureMin = temperatureMin;
        }

        public String getWindDirection() {
            return windDirection;
        }

        public String getSkyCondition() {
            return skyCondition;
        }

        public void setTemperatureMax(float max_temp) {
            this.temperatureMax = max_temp;
        }

        public void setAirpressure(float airpressure) {
            this.airpressure = airpressure;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public void setWindSpeed(String windSpeed) {
            this.windSpeed = windSpeed;
        }

        public void setWindDirection(String windDirection) {
            this.windDirection = windDirection;
        }

        public void setSkyCondition(String skyCondition) {
            this.skyCondition = skyCondition;
        }

        public void setUnits(String unit) {
            this.unit = unit;
        }

        public String getUnits() {
            return unit;
        }
    }

    /*
     * Constructor for WeatherData class.
     * Initializes the instance variables with the first fetch-data from the source
     */
    public WeatherData(String city, String countryCode) {
        getWeather(city, countryCode);
        currentWeather.countryCode = countryCode;
    }



	/* Methods */

    /**
     * update will return a list of WeatherData elements that updates the data by fetching it from the source
     * @return WeatherData
     */
    public WeatherData update() throws IOException {
        this.getWeather(currentWeather.currentCity, currentWeather.countryCode);
        return this;
    }

    /**
     * getWeather opens up the OpenWeatherMap API and retrieves given information that we wish to acquire
     * @param city the city, countryCode the country code as a string
     */
    private void getWeather(String city, String countryCode) {

        String urlCurrent = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + countryCode;

        try {
            String jsonData = readUrl(urlCurrent);
            Gson gsonCurrent = new Gson();
            wv = gsonCurrent.fromJson(jsonData, WeatherValue.class);
            retrieveCurrentWeather();

            //Get coordinates for current location for use in short term and long term forecasting
            double lat, lon;
            lat = wv.getCoord().getLat();
            lon = wv.getCoord().getLon();


            //build the url for short term api using the lon/lat coordinates from initial current
            String urlShortTerm = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon;
            jsonData = readUrl(urlShortTerm);
            Gson gsonShortTerm = new Gson();
            st = gsonShortTerm.fromJson(jsonData, ShortTermWeatherValue.class);
            jsonData = readUrl(urlShortTerm);
            retrieveShortTermWeather();

            //build the url for mars weather api from lastest rover report
            String urlMarsWeather = "http://marsweather.ingenology.com/v1/latest/.json";
            jsonData = readUrl(urlMarsWeather);
            Gson gsonMars = new Gson();
            mw = gsonMars.fromJson(jsonData, MarsWeather.class);
            MarsWeatherRetrieveData();

            //build the url for long term api using the lon/lat coordinates from initial current
            String urlLongTerm = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + lat + "&lon=" + lon + "&cnt=5&mode=json";
            jsonData = readUrl(urlLongTerm);
            Gson gsonLongTerm = new Gson();
            lt = gsonLongTerm.fromJson(jsonData, LongTermWeatherValue.class);

            retrieveLongTermWeather();

            // Sets default units
            if (unitFlag == false) {
                currentWeather.setUnits("celsius");
                unitFlag = true;
            }

            // Changes units to match when refreshed
            if(currentWeather.getUnits().equals("fahrenheit")) {
                changeTemperatureUnits("kelvin", "fahrenheit");
            } else {
                changeTemperatureUnits("kelvin", "celsius");
            }

            currentWeather.changeWind();
            currentWeather.changePressure();
            currentWeather.changeSun();
            /*
			String test="";
			test = wv.getWeather().get(0).getMain();
			System.out.println("test: " + test);
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
     * @param currentUnit is the unit to be changed from, newUnit is the unit to change into
     */
    public void changeTemperatureUnits(String currentUnit, String newUnit) {
        Unit temp_1 = new Unit(currentWeather.temperature, currentUnit);
        Unit unit_Min = new Unit(currentWeather.minTemp, currentUnit);
        Unit unit_Max = new Unit(currentWeather.maxTemp, currentUnit);
        temp_1.changeUnits(newUnit);
        unit_Min.changeUnits(newUnit);
        unit_Max.changeUnits(newUnit);
        currentWeather.temperature = temp_1.temperature;
        currentWeather.minTemp = unit_Min.temperature;
        currentWeather.maxTemp = unit_Max.temperature;
        currentWeather.setUnits(newUnit); // Marks current weather units for changing

        Unit tempShortTerm = null;
        for (int i = 0; i < shortTermWeather.length; i++) {
            tempShortTerm = new Unit(shortTermWeather[i].temperature, currentUnit);
            tempShortTerm.changeUnits(newUnit);
            shortTermWeather[i].setTemperature(tempShortTerm.temperature);
        }

        Unit tempLongTerm = null;
        Unit tempLongTermMax = null;
        Unit tempLongTermMin = null;
        for (int i = 0; i < longTermWeather.length; i++) {
            tempLongTerm = new Unit(longTermWeather[i].temperature, currentUnit);
            tempLongTermMax = new Unit(longTermWeather[i].getMax(), currentUnit);
            tempLongTermMin = new Unit(longTermWeather[i].getMin(), currentUnit);
            tempLongTerm.changeUnits(newUnit);
            tempLongTermMax.changeUnits(newUnit);
            tempLongTermMin.changeUnits(newUnit);
            longTermWeather[i].setTemperature(tempLongTerm.temperature);
            longTermWeather[i].setMax(tempLongTermMax.temperature);
            longTermWeather[i].setMin(tempLongTermMin.temperature);
        }
    }

    /**
     * getTime retrieves the current time and then parsed into just the hour and minute
     * @return String return the timeString
     */
    private String getTime() {
        currentWeather.lastUpdatedTime = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
        String timeString = "";
        char[] timeArray = currentWeather.lastUpdatedTime.toCharArray();
        String hour = "" + timeArray[0] + timeArray[1];
        String minute = "" + timeArray[2] + timeArray[2];
        timeString = hour + ":" + minute;
        return timeString;
    }

    public static void main(String[] args) {
        WeatherData wd = new WeatherData("Toronto", "CA");
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Current city: " + wd.getCurrentWeather().currentCity);
        System.out.println("Current temp: " + df.format(wd.getCurrentWeather().temperature));
        for (int i = 0; i < 8; i++) {
            System.out.println("Short Term temp hour[" + i * 3 + "]: " + df.format(wd.shortTermWeather[i].getTemperature()));
        }
        for (int j = 0; j < 5; j++) {
            System.out.println("Long term temp day[" + j + "]: " + df.format(wd.longTermWeather[j].getTemperature()));
        }
        System.out.println("Mars Weather: " + wd.getWeatherMars().getTemperatureMax());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getTemperatureMin());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getAirpressure());
        System.out.println("Mars Weather: " + wd.getWeatherMars().getSkyCondition());
    }

    /**
     * All three methods retrieves the information to be displayed in the basic template, short term and long term
     */
    private void retrieveCurrentWeather() {
        currentWeather.setTemperature(wv.getMain().getTemp());
        currentWeather.setMaxTemp(wv.getMain().getTemp_max());
        currentWeather.setMinTemp(wv.getMain().getTemp_min());
        currentWeather.setHumidity(wv.getMain().getHumidity());
        currentWeather.setAirPressure(wv.getMain().getPressure());
        currentWeather.setWindSpeed(wv.getWind().getSpeed());
        currentWeather.setWindDirectionDegrees(wv.getWind().getDeg());
        currentWeather.setCurrentCity(wv.getName());
        currentWeather.setCountryCode(wv.getSys().getCountry());
        currentWeather.setSunrise(wv.getSys().getSunrise());
        currentWeather.setSunset(wv.getSys().getSunset());
        currentWeather.setLastUpdatedTime(getTime());
        currentWeather.setDescription(wv.getWeather().get(0).getDescription());
        currentWeather.setIcon(wv.getWeather().get(0).getIcon());
    }

    private void retrieveShortTermWeather() {
        int numOf3HourIntervals = 24 / 3;
        shortTermWeather = new ShortTermWeather[numOf3HourIntervals];
        for (int j = 0; j < numOf3HourIntervals; j++) {
            shortTermWeather[j] = new ShortTermWeather();
        }
        for (int i = 0; i < numOf3HourIntervals; i++) {
            shortTermWeather[i].setTemperature(st.getList().get(i).getMain().getTemp());
            shortTermWeather[i].setCondition(st.getList().get(i).getWeather().get(0).getMain());
            shortTermWeather[i].setIcon(st.getList().get(i).getWeather().get(0).getIcon());
        }

    }

    private void retrieveLongTermWeather() {
        int numOfDays = 5;
        longTermWeather = new LongTermWeather[numOfDays];
        for (int j = 0; j < numOfDays; j++) {
            longTermWeather[j] = new LongTermWeather();
        }
        for (int i = 0; i < numOfDays; i++) {
            longTermWeather[i].setTemperature(lt.getList().get(i).getTemp().getDay());
            longTermWeather[i].setCondition(lt.getList().get(i).getWeather().get(0).getMain());
            longTermWeather[i].setMin(lt.getList().get(i).getTemp().getMin());
            longTermWeather[i].setMax(lt.getList().get(i).getTemp().getMax());
            longTermWeather[i].setIcon(lt.getList().get(i).getWeather().get(0).getIcon());
        }
    }

    public void MarsWeatherRetrieveData() {
        marsWeather = new MarsWeatherValue();
        marsWeather.setAirpressure(mw.getReport().getPressure());
        marsWeather.setHumidity(mw.getReport().getAbs_humidity());
        marsWeather.setSkyCondition(mw.getReport().getAtmo_opacity());
        marsWeather.setTemperatureMax(mw.getReport().max_temp);
        marsWeather.setTemperatureMin(mw.getReport().min_temp);
        marsWeather.setWindDirection(mw.getReport().getWind_direction());
        marsWeather.setWindSpeed(mw.getReport().getWind());
    }

    /***********************************************************************************************
     *
     * ***********************************GETTERS AND SETTERS****************************************
     *
     ************************************************************************************************/


    /**************************************************************************************************
     *
     * Getters and Setters
     *
     *************************************************************************************************/
    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public ShortTermWeather[] getShortTermWeather() {
        return shortTermWeather;
    }

    public void setShortTermWeather(ShortTermWeather[] shortTermWeather) {
        this.shortTermWeather = shortTermWeather;
    }

    public LongTermWeather[] getLongTermWeather() {
        return longTermWeather;
    }

    public void setLongTermWeather(LongTermWeather[] longTermWeather) {
        this.longTermWeather = longTermWeather;
    }

    public MarsWeatherValue getWeatherMars() {
        return marsWeather;
    }

    public void setWeatherMars(MarsWeatherValue weatherMars) {
        this.marsWeather = weatherMars;
    }

    public MarsWeather getMw() {
        return mw;
    }

    public void setMw(MarsWeather mw) {
        this.mw = mw;
    }

}

